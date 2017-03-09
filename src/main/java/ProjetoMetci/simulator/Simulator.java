package ProjetoMetci.simulator;

import ProjetoMetci.elements.Cloud;

/**
 * Represents our simulator, that will allocate VM on a cloud.
 */
public class Simulator {
    public void start(String filePath, int serverCount){
        Cloud cloud = new Cloud();

        cloud.start(serverCount);
    }
}
