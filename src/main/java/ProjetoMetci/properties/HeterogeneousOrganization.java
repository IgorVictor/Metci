package ProjetoMetci.properties;

import ProjetoMetci.elements.ComputeServer;

import java.util.HashMap;

public class HeterogeneousOrganization implements IServerOrganization{

	public HashMap<Integer, ComputeServer> startServers(int serverCount) {
		HashMap<Integer, ComputeServer> serverList = new HashMap<Integer, ComputeServer>();
		
		for (int i = 0; i < serverCount/7; i++) {
			ComputeServer server = new ComputeServer(i, 3575.0/(serverCount/7), 3575.0/(serverCount/7));
			
			serverList.put(server.getID(), server);
		}
		for (int i = serverCount/7; i < 3*serverCount/7; i++) {
			ComputeServer server = new ComputeServer(i, 1787.5/(2*serverCount/7), 1787.5/(2*serverCount/7));
			
			serverList.put(server.getID(), server);
		}
		for (int i = 3*serverCount/7; i < serverCount; i++) {
			ComputeServer server = new ComputeServer(i, 1787.5/(4*serverCount/7), 1787.5/(4*serverCount/7));
			
			serverList.put(server.getID(), server);
		}

		return serverList;
	}
}
