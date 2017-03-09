package ProjetoMetci.simulator;

import ProjetoMetci.elements.Cloud;
import ProjetoMetci.properties.HomogeneousOrganization;

/**
 * Represents our simulator, that will allocate VM on a cloud.
 */
public class Simulator {

    public void start(String filePath, int serverCount){
        Cloud cloud = (new Cloud())
                .setOrganization(new HomogeneousOrganization());

        cloud.start(serverCount);
    }
}
