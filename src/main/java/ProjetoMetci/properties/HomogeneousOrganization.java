package ProjetoMetci.properties;

import ProjetoMetci.elements.ComputerServer;

import java.util.ArrayList;

public class HomogeneousOrganization implements IServerOrganization {

	public ArrayList<ComputerServer> startServers(int serverCount) {
		ArrayList<ComputerServer> serverList = new ArrayList<ComputerServer>();
		
		for (int i = 0; i < serverCount; i++) {
			ComputerServer server = new ComputerServer(i, 7150.0/serverCount, 1024.0);
			
			serverList.add(server);
		}

		return serverList;
	}
}
