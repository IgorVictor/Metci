package ProjetoMetci.metci;

import java.util.ArrayList;

public class HomogeneousController {

	public void start(String filePath, int serverCount) {
		ArrayList<ComputerServer> serverList = new ArrayList<ComputerServer>();
		
		for (int i = serverCount; i < 16; i++) {
			ComputerServer server = new ComputerServer(Integer.toString(i), 7150.0/serverCount, 1024.0);
			
			serverList.add(server);
		}
		
		
	}
	
}
