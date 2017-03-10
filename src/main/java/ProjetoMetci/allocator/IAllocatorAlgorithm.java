package ProjetoMetci.allocator;

import ProjetoMetci.elements.ComputeServer;
import ProjetoMetci.elements.VirtualMachine;

import java.util.ArrayList;

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
    VirtualMachine allocateVM(ArrayList<ComputeServer> computers, VirtualMachine vm);
}