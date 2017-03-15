package ProjetoMetci.allocator;

import ProjetoMetci.elements.ComputeServer;
import ProjetoMetci.elements.VM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WorstFitAlgorithm implements IAllocatorAlgorithm {

    @SuppressWarnings("Duplicates")
    public VM allocateVM(ArrayList<ComputeServer> computers, VM vm){
        ArrayList<ComputeServer> servers = new ArrayList<ComputeServer>(computers);
        Collections.sort(servers, new Comparator<ComputeServer>() {
            public int compare(ComputeServer server2, ComputeServer server1)
            {
                return (-1) * server1.compareTo(server2);
            }
        });
    

        for(ComputeServer computer : servers){
            if(vm.getPower().compareTo(computer.getRemainingPower())< 0){
                computer.allocatePower(vm.getPower());
                vm.setComputerID(computer.getID());

                return vm;
            }
        }
        return null;
    }

}