package ProjetoMetci.metci;

/**
 * Class containing power metrics for Computer and VM, for ordering purposes.
 */
public class NodePower {

	private double processor;
	private double ram;

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

	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		if (!super.equals(object)) return false;

		NodePower nodePower = (NodePower) object;

		if (Double.compare(nodePower.processor, processor) != 0) return false;
		if (Double.compare(nodePower.ram, ram) != 0) return false;

		return true;
	}

	public int hashCode() {
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(processor);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ram);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
