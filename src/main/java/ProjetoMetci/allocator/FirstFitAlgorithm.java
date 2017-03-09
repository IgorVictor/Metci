package ProjetoMetci.allocator;

import ProjetoMetci.elements.ComputerServer;
import ProjetoMetci.elements.VirtualMachine;

import java.util.ArrayList;

public class FirstFitAlgorithm implements IAllocatorAlgorithm {

    public VirtualMachine allocateVM(ArrayList<ComputerServer> computers, VirtualMachine vm){
        for(ComputerServer computer : computers){
            if(vm.getPower().compareTo(computer.getRemainingAssets() )< 0){
                computer.allocatePower(vm.getPower());
                vm.setComputerID(computer.getID());

                return vm;
            }
        }
        return null;
    }

}