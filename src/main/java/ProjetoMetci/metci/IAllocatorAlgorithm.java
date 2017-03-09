package ProjetoMetci.metci;

/**
 * Represents an algorithm to allocate VMs to computers.
 */
public interface IAllocatorAlgorithm {

    /**
     * Allocate a VM to a list of computers.
     * @param computers the list of computers to put VM.
     * @param vm the VM to insert on computers.
     * @return the VM allocated with info about where it was inserted.
     */
    public VirtualMachine allocateVM(ArrayList<ComputerServer> computers, VirtualMachine vm);
}