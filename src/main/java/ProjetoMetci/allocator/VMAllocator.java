package ProjetoMetci.allocator;

import ProjetoMetci.elements.Cloud;
import ProjetoMetci.elements.ComputeServer;
import ProjetoMetci.elements.VM;

import java.util.PriorityQueue;

/**
 * Class responsible to allocate VMs on the computers configured on this simulator.
 */
public class VMAllocator {

    private static VMAllocator instance;

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
        this.deallocateOldVMs(actualTime);

        // Note: on allocateVM, we'll call the allocatePower on the computer selected.
        VM allocatedVM = this.allocatorAlgorithm.allocateVM(this.cloud.getServerList(), vm);
        this.vms.add(allocatedVM);
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
}
