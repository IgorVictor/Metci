package ProjetoMetci.simulator;

import java.io.IOException;

import ProjetoMetci.allocator.FirstFitAlgorithm;
import ProjetoMetci.allocator.IAllocatorAlgorithm;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String filePath = "C:\\Users\\Igor\\Desktop\\minitrace.txt";
    	int serverCount = 1;
    	boolean homogeneousOrganization = true;
    	IAllocatorAlgorithm algorithm = new FirstFitAlgorithm();
        Simulator sim = new Simulator(filePath, serverCount, homogeneousOrganization, algorithm);
        try {
			sim.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
