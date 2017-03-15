package ProjetoMetci.allocator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import ProjetoMetci.elements.Cloud;
import ProjetoMetci.elements.ComputeServer;
import ProjetoMetci.elements.Fragment;
import ProjetoMetci.elements.NodePower;
import ProjetoMetci.elements.VM;

/**
 * Class responsible to allocate VMs on the computers configured on this simulator.
 */
public class VMAllocator {

    private static VMAllocator instance;

    public int serviceNegation;
    Long actualTime = new Long(0);
    Long lastCheck = new Long(0);
    
    ArrayList<Fragment> fragmentation;
    
    /**
     * Get unique instance of VMAllocator, or a new one if didn't created.
     * @return unique instance of VMAllocator, or a new one if didn't created.
     */
    public static synchronized VMAllocator getInstance(){
        if(instance == null){
            instance = new VMAllocator();
        }
        return instance;
    }

    private Cloud cloud;
    private PriorityQueue<VM> vms;
    private IAllocatorAlgorithm allocatorAlgorithm;

    /**
     * Normal constructor.
     */
    private VMAllocator(){
        this.setAllocatorAlgorithm(new FirstFitAlgorithm());
        this.serviceNegation = 0;
        this.fragmentation = new ArrayList<Fragment>();
    }

    /**
     * Set allocator algorithm to use when allocating VMs.
     * @param allocatorAlgorithm the allocator algorithm to use when allocating VMs.
     */
    public void setAllocatorAlgorithm(IAllocatorAlgorithm allocatorAlgorithm){
        this.allocatorAlgorithm = allocatorAlgorithm;
    }

    /**
     * Set the list of computers to allocate VMs.
     * @param cloud the cloud target of allocation.
     */
    public void setCloud(Cloud cloud){
        this.cloud = cloud;
        this.vms = new PriorityQueue<VM>();
    }

    /**
     * Allocate a new VM on the computers.
     * @param actualTime the actual time on servers.
     * @param vm the vm to allocate.
     */
    public void allocate(long actualTime, VM vm){
    	this.actualTime = actualTime;
        this.deallocateOldVMs(this.actualTime);

        // Note: on allocateVM, we'll call the allocatePower on the computer selected.
        VM allocatedVM = this.allocatorAlgorithm.allocateVM(this.cloud.getServerList(), vm);
        checkFragmentation();
        if (allocatedVM != null){
        	this.vms.add(allocatedVM);
        } else {
        	serviceNegation++;
        }
    }

    private void checkFragmentation() {
    	double wastedRam = 0;
    	double wastedCpu = 0;
    	for (ComputeServer server : this.cloud.getServerList()) {
    		if (server.isFull()) {
    			wastedRam += server.getRemainingPower().getRam();
    			wastedCpu += server.getRemainingPower().getProcessor();
    		}
    		if (server.getRemainingPower().compareTo(new NodePower(0.002, 0.002)) < 0 ) {
    			server.isFull();
    		};
    	}
    	if (wastedCpu != 0 || wastedRam != 0) {
    	NodePower wastedPower = new NodePower(wastedCpu, wastedRam);
    	long timeElapse = this.actualTime - this.lastCheck;
    	Fragment fragment = new Fragment(timeElapse, wastedPower);
    	this.fragmentation.add(fragment);
    	}
    	this.lastCheck = actualTime;
    }

	/**
     * Deallocate VMs that has finished their work.
     * @param actualTime the actual time on the servers.
     */
    private void deallocateOldVMs(long actualTime){
        while (true){
            VM oldestVM = this.vms.peek();

            // Stop if there isn't any VM to deallocate.
            if (oldestVM != null && oldestVM.isFinished(actualTime)){
                this.vms.poll();

                // Free space on computer that the VM was.
                ComputeServer cs = this.findComputer(oldestVM.getComputerID());
                cs.deallocatePower(oldestVM.getPower());
            } else {
                break;
            }
        }
    }

    /**
     * Find computer into list of computers using its ID.
     * @param computerID the ID of the computer searched.
     * @return the computer found of null, if don't exist.
     */
    private ComputeServer findComputer(int computerID){
        return this.cloud.getServerList().get(computerID);
    }
    
    public int getServiceNegation() {
    	return this.serviceNegation;
    }
    
    public NodePower getRemainingCloudPower() {
    	double cpu = 0;
    	double ram = 0;
    	for (ComputeServer server : this.cloud.getServerList()) {
    		cpu += server.getRemainingPower().getProcessor();
    		ram += server.getRemainingPower().getRam();
    	}
    	return new NodePower(cpu, ram);
    }
}
