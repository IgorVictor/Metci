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
import ProjetoMetci.elements.VM;
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
                    .setOrganization(new HomogeneousOrganization());

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
		while ((currentLine = bis.readLine())!= null) {
			VM vm = new VM(currentLine);
			vmA.allocate(currentTimeFromFile(currentLine), vm);
		}
		bis.close();
    }
    
    public long currentTimeFromFile (String currentLine) {
    	String[] pieces = currentLine.split(" ");
    	return Long.parseLong(pieces[0]);
    }
}
