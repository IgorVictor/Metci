package ProjetoMetci.properties;

import ProjetoMetci.elements.ComputeServer;

import java.util.ArrayList;

public class HomogeneousOrganization implements IServerOrganization {

	public ArrayList<ComputeServer> startServers(int serverCount) {
		ArrayList<ComputeServer> serverList = new ArrayList<ComputeServer>();
		
		for (int i = 0; i < serverCount; i++) {
			ComputeServer server = new ComputeServer(i, 7150.0/serverCount, 7150.0/serverCount);
			
			serverList.add(server);
		}

		return serverList;
	}
}
