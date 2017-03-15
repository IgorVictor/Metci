package ProjetoMetci.simulator;

import ProjetoMetci.allocator.IAllocatorAlgorithm;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String filePath = "C:\\Users\\Igor\\Desktop\\task-eventstotruncate.txt";
    	int serverCount = 0;
    	boolean homogeneousOrganization = true;
    	IAllocatorAlgorithm algorithm = null;
        Simulator sim = new Simulator(filePath, serverCount, homogeneousOrganization, algorithm);
    }
}
