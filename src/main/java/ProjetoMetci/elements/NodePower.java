package ProjetoMetci.elements;

import javax.xml.soap.Node;
import java.lang.Comparable;

/**
 * Class containing power metrics for Computer and VM, for ordering purposes.
 */
public class NodePower implements Comparable<NodePower>{

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

	/**
	 * Calculate sum of this and other NodePower returning the result.
	 * @param other the other NodePower to sum with this object.
	 * @return the result of the sum.
	 */
	public NodePower plus(NodePower other){
		NodePower result = new NodePower(0, 0);
		result.setRam(this.getRam() + other.getRam());
		result.setProcessor(this.getProcessor() + other.getProcessor());
		return result;
	}

	/**
	 * Update this object with the sum of itself and another NodePower. returning the result.
	 * @param other the other NodePower to sum with this object.
	 * @return the result of the sum.
	 */
	public NodePower add(NodePower other){
		this.setRam(this.getRam() + other.getRam());
		this.setProcessor(this.getProcessor() + other.getProcessor());
		return this;
	}

	/**
	 * Calculate subtraction of this and other NodePower returning the result.
	 * @param other the other NodePower to subtract with this object.
	 * @return the result of the sum.
	 */
	public NodePower minus(NodePower other){
		NodePower result = new NodePower(0, 0);
		result.setRam(this.getRam() - other.getRam());
		result.setProcessor(this.getProcessor() - other.getProcessor());
		return result;
	}

	/**
	 * Update this object with the subtraction of itself and another NodePower. returning the result.
	 * @param other the other NodePower to subtraction with this object.
	 * @return the result of the sum.
	 */
	public NodePower subtract(NodePower other){
		this.setRam(this.getRam() - other.getRam());
		this.setProcessor(this.getProcessor() - other.getProcessor());
		return this;
	}

	public int compareTo(NodePower other){
	    if(this.ram > other.ram || this.processor > other.processor){
	        return 1;
        } else if (this.ram == other.ram && this.processor == other.processor) {
	        return 0;
        } else {
	        return -1;
        }
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
