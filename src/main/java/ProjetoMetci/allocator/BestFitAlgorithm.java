package ProjetoMetci.allocator;

import ProjetoMetci.elements.ComputerServer;
import ProjetoMetci.elements.VirtualMachine;

import java.util.ArrayList;
import java.util.Comparator;

public class BestFitAlgorithm implements IAllocatorAlgorithm {

    @SuppressWarnings("Duplicates")
    public VirtualMachine allocateVM(ArrayList<ComputerServer> computers, VirtualMachine vm){
        ArrayList<ComputerServer> servers = new ArrayList<>(computers);
        servers.sort(Comparator.naturalOrder());

        for(ComputerServer computer : servers){
            if(vm.getPower().compareTo(computer.getRemainingPower() )< 0){
                computer.allocatePower(vm.getPower());
                vm.setComputerID(computer.getID());

                return vm;
            }
        }
        return null;
    }

}