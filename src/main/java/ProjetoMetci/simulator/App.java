package ProjetoMetci.simulator;

import java.io.IOException;

import ProjetoMetci.allocator.BestFitAlgorithm;
import ProjetoMetci.allocator.FirstFitAlgorithm;
import ProjetoMetci.allocator.IAllocatorAlgorithm;
import ProjetoMetci.allocator.WorstFitAlgorithm;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
//    	"C:\\Users\\Igor\\Desktop\\tasktest.txt"
    	IAllocatorAlgorithm algorithm;
    	String filePath = args[0];
    	int serverCount = Integer.parseInt(args[1]);
    	boolean homogeneousOrganization = Boolean.parseBoolean(args[2]);
   		algorithm = new FirstFitAlgorithm();
    	if (args[3].equals("1")){
    		algorithm = new BestFitAlgorithm();	
    	}
    	if (args[3].equals("2")){
    		algorithm = new WorstFitAlgorithm();	
    	}
    	
    	boolean hasFailure = Boolean.parseBoolean(args[4]);
    	
        Simulator sim = new Simulator(filePath, serverCount, homogeneousOrganization, algorithm, hasFailure);
        try {
			sim.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
