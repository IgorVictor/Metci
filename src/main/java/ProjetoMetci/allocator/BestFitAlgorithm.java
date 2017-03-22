package ProjetoMetci.allocator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import ProjetoMetci.elements.ComputeServer;
import ProjetoMetci.elements.VM;

public class BestFitAlgorithm implements IAllocatorAlgorithm {

    @SuppressWarnings("Duplicates")
    public VM allocateVM(HashMap<Integer, ComputeServer> computers, VM vm){
        ArrayList<ComputeServer> servers = new ArrayList<ComputeServer>(computers.values());
     // Sorting
        Collections.sort(servers, new Comparator<ComputeServer>() {
                public int compare(ComputeServer server2, ComputeServer server1)
                {
                    return  server1.compareTo(server2);
                }
            });
        
        
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