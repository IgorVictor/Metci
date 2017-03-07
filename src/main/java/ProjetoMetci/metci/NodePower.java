package ProjetoMetci.metci;

public class NodePower {
	private double processor;
	private double ram;
	private double hd;

	public NodePower(double processor, double ram, double hd) {
		this.processor = processor;
		this.ram = ram;
		this.hd = hd;
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

	public double getHd() {
		return hd;
	}

	public void setHd(double hd) {
		this.hd = hd;
	}
	
	
}
