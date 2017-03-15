package ProjetoMetci.simulator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import ProjetoMetci.allocator.IAllocatorAlgorithm;
import ProjetoMetci.allocator.VMAllocator;
import ProjetoMetci.elements.Cloud;
import ProjetoMetci.elements.Fragment;
import ProjetoMetci.elements.VM;
import ProjetoMetci.properties.HeterogeneousOrganization;
import ProjetoMetci.properties.HomogeneousOrganization;

/**
 * Represents our simulator, that will allocate VM on a cloud.
 */
public class Simulator {

	String filePath;
	Cloud cloud;
	IAllocatorAlgorithm algorithm;
	
    public Simulator(String filePath, int serverCount, boolean homogeneousOrganization, IAllocatorAlgorithm algorithm){
        if (homogeneousOrganization){
    	this.cloud = (new Cloud())
                .setOrganization(new HomogeneousOrganization());

        cloud.start(serverCount);
        }else {
        	this.cloud = (new Cloud())
                    .setOrganization(new HeterogeneousOrganization());

            cloud.start(serverCount);
        }
        this.filePath = filePath;
        this.algorithm = algorithm;
    }
    
    public void start() throws IOException {
    	VMAllocator vmA = VMAllocator.getInstance();
    	vmA.setAllocatorAlgorithm(this.algorithm);
    	vmA.setCloud(this.cloud);
    	
    	FileInputStream input = new FileInputStream(this.filePath);
    	InputStreamReader fis = new InputStreamReader(input);

		BufferedReader bis = new BufferedReader(fis);
		String currentLine = null;
		int lineCount = 1;
		while ((currentLine = bis.readLine())!= null) {
			System.out.println(lineCount);
			VM vm = new VM(currentLine);
			vmA.allocate(currentTimeFromFile(currentLine), vm);
			lineCount++;
		}
		bis.close();
		System.out.println("Negação " + vmA.getServiceNegation());
		System.out.println("Remaning cpu " +vmA.getRemainingCloudPower().getProcessor());
		System.out.println("Remaning ram " +vmA.getRemainingCloudPower().getRam());
		int fragCount = 0;
		System.out.println("biggest fragment was "  + vmA.getMaxFragmentation());
    }
    
    public long currentTimeFromFile (String currentLine) {
    	String[] pieces = currentLine.split(" ");
    	return Long.parseLong(pieces[0]);
    }
}
