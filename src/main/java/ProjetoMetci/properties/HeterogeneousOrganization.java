package ProjetoMetci.properties;

import ProjetoMetci.elements.ComputeServer;

import java.util.ArrayList;

public class HeterogeneousOrganization implements IServerOrganization{

	public ArrayList<ComputeServer> startServers(int serverCount) {
		ArrayList<ComputeServer> serverList = new ArrayList<ComputeServer>();
		
		for (int i = 0; i < serverCount/7; i++) {
			ComputeServer server = new ComputeServer(i, 3575.0/(serverCount/7), 1024.0);
			
			serverList.add(server);
		}
		for (int i = serverCount/7; i < 3*serverCount/7; i++) {
			ComputeServer server = new ComputeServer(i, 1787.5/(2*serverCount/7), 512.0);
			
			serverList.add(server);
		}
		for (int i = 3*serverCount/7; i < serverCount; i++) {
			ComputeServer server = new ComputeServer(i, 1787.5/(4*serverCount/7), 256.0);
			
			serverList.add(server);
		}

		return serverList;
	}
}
