package ProjetoMetci.properties;

import ProjetoMetci.elements.ComputerServer;

import java.util.ArrayList;

public class HeterogeneousOrganization implements IServerOrganization{

	public ArrayList<ComputerServer> startServers(int serverCount) {
		ArrayList<ComputerServer> serverList = new ArrayList<ComputerServer>();
		
		for (int i = 0; i < serverCount/7; i++) {
			ComputerServer server = new ComputerServer(i, 3575.0/(serverCount/7), 1024.0);
			
			serverList.add(server);
		}
		for (int i = serverCount/7; i < 3*serverCount/7; i++) {
			ComputerServer server = new ComputerServer(i, 1787.5/(2*serverCount/7), 512.0);
			
			serverList.add(server);
		}
		for (int i = 3*serverCount/7; i < serverCount; i++) {
			ComputerServer server = new ComputerServer(i, 1787.5/(4*serverCount/7), 256.0);
			
			serverList.add(server);
		}

		return serverList;
	}
}
