package ProjetoMetci.metci;

public class NodePower {
	private double processor;
	private double ram;

	public NodePower(double processor, double ram) {
		this.processor = processor;
		this.ram = ram;
	}

	public double getProcessor() {
		return processor;
	}

	public void setProcessor(double processor) {
		this.processor = processor;
	}

	public double getRam() {
		return ram;
	}

	public void setRam(double ram) {
		this.ram = ram;
	}

}
