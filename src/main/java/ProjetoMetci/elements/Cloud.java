package ProjetoMetci.elements;

import ProjetoMetci.properties.HomogeneousOrganization;
import ProjetoMetci.properties.IServerOrganization;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that represents the set of computers, that can allocate
 * new VMs on it.
 */
public class Cloud {

    private HashMap<Integer, ComputeServer> serverList;
    private IServerOrganization serverOrganization;

    /**
     * Normal constructor.
     */
    public Cloud(){
        this.setOrganization(new HomogeneousOrganization());
    }

    /**
     * Set the organization of computers servers for this cloud.
     * @param organization the organization of computers servers for this cloud.
     * @return the cloud itself for continuous setting.
     */
    public Cloud setOrganization(IServerOrganization organization){
        this.serverOrganization = organization;
        return this;
    }

    /**
     * Get the list of computers servers on this cloud.
     * @return the list of computers servers on this cloud.
     */
    public HashMap<Integer, ComputeServer> getServerList(){
        return this.serverList;
    }

    /**
     * Set the list of computers servers on this cloud.
     * @param hashMap the list of computers servers on this cloud.
     * @return the cloud itself for continuous setting.
     */
    private Cloud setServerList(HashMap<Integer, ComputeServer> hashMap){
        this.serverList = hashMap;
        return this;
    }

    /**
     * Put the cloud on operation.
     * @param serverCount the number of computers to run on this cloud.
     */
    public void start(int serverCount){
        this.setServerList(
                this.serverOrganization.startServers(serverCount));
    }

}