package ProjetoMetci.allocator;

import java.util.ArrayList;
import java.util.HashMap;

import ProjetoMetci.elements.ComputeServer;
import ProjetoMetci.elements.VM;

public class FirstFitAlgorithm implements IAllocatorAlgorithm {

    public VM allocateVM(HashMap<Integer, ComputeServer> computers, VM vm){
    	ArrayList<ComputeServer> servers = new ArrayList<ComputeServer>(computers.values());
        for(ComputeServer computer : servers){
            if(vm.getPower().compareTo(computer.getRemainingPower() )< 0){
                computer.allocatePower(vm.getPower());
                vm.setComputerID(computer.getID());

                return vm;
            } 
        }
        return null;
    }

}