package ProjetoMetci.elements;

/**
 * Class representing one computer server on the cloud.
 */
public class ComputeServer implements Comparable<ComputeServer>{

	private int id;
	private NodePower initialPower;
	private NodePower allocatedPower;
	private boolean full = false;

    /**
     * Creates the computer server.
     * @param id the id of the computer on the cloud.
     * @param processor the processor capacity of this computer.
     * @param ram the ram capacity of this computer.
     */
    public ComputeServer (int id, double processor, double ram) {
		this.setID(id);
		this.setInitialPower(new NodePower(processor, ram));
		this.setAllocatedPower(new NodePower(0, 0));
	}

    /**
     * Get the ID of this computer on the cloud.
     * @return the ID of this computer on the cloud.
     */
	public int getID() {
	    return this.id;
    }

    /**
     * Set the ID of this computer on the cloud.
     * @param id the ID of this computer on the cloud.
     * @return the computer server itself for continuous setting.
     */
    private ComputeServer setID(int id) {
        this.id = id;
        return  this;
    }

    /**
     * Get the initial power capacity of this computer.
     * @return the initial power capacity of this computer.
     */
    public NodePower getInitialPower(){
        return this.initialPower;
    }

    /**
     * Set the initial power capacity of this computer.
     * @param power the initial power capacity of this computer.
     * @return the computer server itself for continuous setting.
     */
    public ComputeServer setInitialPower(NodePower power){
        this.initialPower = power;
        return this;
    }

    /**
     * Get the allocated power on this computer for VMs usage.
     * @return the allocated power on this computer for VMs usage.
     */
    public NodePower getAllocatedPower(){
        return this.allocatedPower;
    }

    /**
     * Set the allocated power on this computer for VMs usage.
     * @param power the allocated power on this computer for VMs usage.
     * @return the computer server itself for continuous setting.
     */
    public ComputeServer setAllocatedPower(NodePower power){
        this.allocatedPower = power;
        return this;
    }

    /**
     * Allocate power on this computer for a VM.
     * @param power the power needed for some VM.
     */
    public void allocatePower(NodePower power) {
        this.getAllocatedPower().add(power);
    }

    /**
     * Get the power that still can be allocated on this computer.
     * @return the power that still can be allocated on this computer.
     */
	public NodePower getRemainingPower() {
		return this.getInitialPower().minus(this.getAllocatedPower());
	}

    /**
     * Deallocate power on this computer for another VM.
     * @param power the power needed for another VM.
     */
	public void deallocatePower(NodePower power) {
        this.getAllocatedPower().subtract(power);
        this.full = false;
	}

	/**
	 * set this server to full, meaning there is fragmentation
	 */
	public void setFull() {
		this.full = true;
	}
	
	/**
	 * returns true if the server is full, returns false otherwise
	 * @return
	 */
	public boolean isFull(){
		return this.full;
	}
	
	public int compareTo(ComputeServer other){
	    return this.getRemainingPower().compareTo(other.getRemainingPower());
    }
}
