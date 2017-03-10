package ProjetoMetci.allocator;

import ProjetoMetci.elements.ComputeServer;
import ProjetoMetci.elements.VirtualMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BestFitAlgorithm implements IAllocatorAlgorithm {

    @SuppressWarnings("Duplicates")
    public VirtualMachine allocateVM(ArrayList<ComputeServer> computers, VirtualMachine vm){
        ArrayList<ComputeServer> servers = new ArrayList<ComputeServer>(computers);
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