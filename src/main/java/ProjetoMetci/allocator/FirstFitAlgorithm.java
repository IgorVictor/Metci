package ProjetoMetci.allocator;

import ProjetoMetci.elements.ComputeServer;
import ProjetoMetci.elements.VM;

import java.util.ArrayList;

public class FirstFitAlgorithm implements IAllocatorAlgorithm {

    public VM allocateVM(ArrayList<ComputeServer> computers, VM vm){
        for(ComputeServer computer : computers){
            if(vm.getPower().compareTo(computer.getRemainingPower() )< 0){
                computer.allocatePower(vm.getPower());
                vm.setComputerID(computer.getID());

                return vm;
            } 
        }
        return null;
    }

}