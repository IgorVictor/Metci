package ProjetoMetci.metci;

import java.util.ArrayList;
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

    private ArrayList<ComputerServer> computers;
    private PriorityQueue<VirtualMachine> vms;
    private IAllocatorAlgorithm allocatorAlgorithm;

    /**
     * Normal constructor.
     */
    private VMAllocator(){}

    /**
     * Set allocator algorithm to use when allocating VMs.
     * @param allocator the allocator algorithm to use when allocating VMs.
     */
    public void setAllocatorAlgorithm(IAllocatorAlgorithm allocatorAlgorithm){
        this.allocatorAlgorithm = allocatorAlgorithm;
    }

    /**
     * Set the list of computers to allocate VMs.
     * @param computers the list of computers target of allocation.
     */
    public void setComputers(ArrayList<ComputerServer> computers){
        this.computers = computers;
        this.vms = new PriorityQueue<VirtualMachine>();
    }

    /**
     * Allocate a new VM on the computers.
     * @param actualTime the actual time on servers.
     * @param vm the vm to allocate.
     */
    public void allocate(long actualTime, VirtualMachine vm){
        this.deallocateOldVMs(actualTime);

        // Note: on allocateVM, we'll call the allocatePower on the computer selected.
        VirtualMachine allocatedVM = this.allocatorAlgorithm.allocateVM(this.computers, vm);
        this.vms.add(allocatedVM);
    }

    /**
     * Deallocate VMs that has finished their work.
     * @param actualTime the actual time on the servers.
     */
    private void deallocateOldVMs(long actualTime){
        while (true){
            VirtualMachine oldestVM = this.vms.peek();

            // Stop if there isn't any VM to deallocate.
            if (oldestVM != null && oldestVM.isFinished(actualTime)){
                this.vms.poll();

                // Free space on computer that the VM was.
                ComputerServer cs = this.findComputer(oldestVM.getComputerID());
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
    private ComputerServer findComputer(int computerID){
        return this.computers.get(computerID);
    }
}
