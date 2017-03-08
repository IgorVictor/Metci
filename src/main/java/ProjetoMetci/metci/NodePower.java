package ProjetoMetci.metci;

/**
 * Class containing power metrics for Computer and VM, for ordering purposes.
 */
public class NodePower {

	private double processor;
	private double ram;

	/**
	 * Create a new VM, practical use.
	 * @return new VM
	 */
	public static NodePower new(){
		return new NodePower();
	}

	/**
	 * Normal constructor.
	 */
	public NodePower() {}

	/**
	 * Normal constructor.
	 * @param processor the processor usage.
	 * @param ram the ram usage.
	 */
	public NodePower(double processor, double ram) {
		this.processor = processor;
		this.ram = ram;
	}

	/**
	 * Get the processor usage.
	 * @return processor usage.
	 */
	public double getProcessor() {
		return processor;
	}

	/**
	 * Set the processor usage.
	 * @param processor the processor usage.
	 * @return the NodePower itself for continuous setting.
	 */
	public NodePower setProcessor(double processor) {
		this.processor = processor;
		return this;
	}

	/**
	 * Get the ram usage.
	 * @return the ram usage.
	 */
	public double getRam() {
		return ram;
	}

	/**
	 * Set the ram usage.
	 * @param ram the ram usage.
	 * @return the NodePower itself for continuous setting.
	 */
	public NodePower setRam(double ram) {
		this.ram = ram;
		return this;
	}

}
