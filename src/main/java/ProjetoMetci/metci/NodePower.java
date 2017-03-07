package ProjetoMetci.metci;

public class NodePower {
	private long processor;
	private long ram;
	private long hd;

	public NodePower(long processor, long ram, long hd) {
		this.processor = processor;
		this.ram = ram;
		this.hd = hd;
	}

	public long getProcessor() {
		return processor;
	}

	public void setProcessor(long processor) {
		this.processor = processor;
	}

	public long getRam() {
		return ram;
	}

	public void setRam(long ram) {
		this.ram = ram;
	}

	public long getHd() {
		return hd;
	}

	public void setHd(long hd) {
		this.hd = hd;
	}
	
	
}
