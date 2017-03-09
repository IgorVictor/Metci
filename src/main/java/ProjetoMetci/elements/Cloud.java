package ProjetoMetci.elements;

import ProjetoMetci.properties.HomogeneousOrganization;
import ProjetoMetci.properties.IServerOrganization;

import java.util.ArrayList;

/**
 * Class that represents the set of computers, that can allocate
 * new VMs on it.
 */
public class Cloud {

    private ArrayList<ComputerServer> serverList;
    private IServerOrganization serverOrganization;

    /**
     * Normal constructor.
     */
    public Cloud(){
        this.setOrganization(new HomogeneousOrganization());
    }

    public void setOrganization(IServerOrganization organization){
        this.serverOrganization = organization;
    }

    public ArrayList<ComputerServer> getServerList(){
        return this.serverList;
    }

    private void setServerList(ArrayList<ComputerServer> serverList){
        this.serverList = serverList;
    }

    public void start(int serverCount){
        this.setServerList(
                this.serverOrganization.startServers(serverCount));
    }

}
O