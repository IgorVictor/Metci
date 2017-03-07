package ProjetoMetci.metci;

import java.util.ArrayList;

public class HomogeneousController {

	public void start(String filePath) {
		ArrayList<ComputerServer> serverList = new ArrayList<ComputerServer>();
		
		for (int i = 0; i < 16; i++) {
			ComputerServer server = new ComputerServer(Integer.toString(i), 446.875, 1024.0);
			
			serverList.add(server);
		}
		
		
	}
	
}
