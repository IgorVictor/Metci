package ProjetoMetci.properties;

import ProjetoMetci.elements.ComputeServer;

import java.util.HashMap;

/**
 * Represents the organization of computers used by the cloud.
 */
public interface IServerOrganization {

    HashMap<Integer, ComputeServer> startServers(int serverCount);
}
