package ProjetoMetci.properties;

import ProjetoMetci.elements.ComputerServer;

import java.util.ArrayList;

/**
 * Represents the organization of computers used by the cloud.
 */
public interface IServerOrganization {

    ArrayList<ComputerServer> startServers(int serverCount);
}
