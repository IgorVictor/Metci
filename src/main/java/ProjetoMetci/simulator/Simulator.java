package ProjetoMetci.simulator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ProjetoMetci.allocator.IAllocatorAlgorithm;
import ProjetoMetci.allocator.VMAllocator;
import ProjetoMetci.elements.Cloud;
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
	boolean hasFailure;
	
	
    public Simulator(String filePath, int serverCount, boolean homogeneousOrganization, IAllocatorAlgorithm algorithm, boolean hasFailure){
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
        this.hasFailure = hasFailure;
    }
    
    public void start() throws IOException {
    	VMAllocator vmA = VMAllocator.getInstance();
    	vmA.setAllocatorAlgorithm(this.algorithm);
    	vmA.setCloud(this.cloud);
    	vmA.setHasFailure(this.hasFailure);
    	
    	FileInputStream input = new FileInputStream(this.filePath);
    	InputStreamReader fis = new InputStreamReader(input);

		BufferedReader bis = new BufferedReader(fis);
		String currentLine = null;
		int lineCount = 1;
		while ((currentLine = bis.readLine())!= null) {
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
		
		String resultString = vmA.getServiceNegation() + " " + vmA.getMaxFragmentation().getProcessor() + " " +
		vmA.getMaxFragmentation().getRam() + " " + vmA.getNumberOfFailedServers();
		
		FileOutputStream output = new FileOutputStream(this.filePath + ".results");
    	OutputStreamWriter osw = new OutputStreamWriter(output);

		BufferedWriter biw = new BufferedWriter(osw);
		biw.append(resultString);
		biw.close();
		
    }
    
    public long currentTimeFromFile (String currentLine) {
    	String[] pieces = currentLine.split(" ");
    	return Long.parseLong(pieces[0]);
    }
}
