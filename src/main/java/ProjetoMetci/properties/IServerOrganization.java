package ProjetoMetci.properties;

import ProjetoMetci.elements.ComputeServer;

import java.util.ArrayList;

/**
 * Represents the organization of computers used by the cloud.
 */
public interface IServerOrganization {

    ArrayList<ComputeServer> startServers(int serverCount);
}
