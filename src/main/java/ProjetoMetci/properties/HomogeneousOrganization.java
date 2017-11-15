package ProjetoMetci.properties;

import ProjetoMetci.elements.ComputeServer;

import java.util.HashMap;

public class HomogeneousOrganization implements IServerOrganization {

	public HashMap<Integer, ComputeServer> startServers(int serverCount) {
		HashMap<Integer, ComputeServer> serverList = new HashMap<Integer, ComputeServer>();
		
		for (int i = 0; i < serverCount; i++) {
			ComputeServer server = new ComputeServer(i, 7150.0/serverCount, 7150.0/serverCount);
			
			serverList.put(server.getID(), server);
		}

		return serverList;
	}
}
