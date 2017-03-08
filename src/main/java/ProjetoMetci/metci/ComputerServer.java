package ProjetoMetci.metci;

public class ComputerServer {

	private String id;
	private double processor;
	private double ram;
	private double currentProcessor;
	private double currentRam;
	private double currentHd;


	public ComputerServer (String id, double processor, double ram) {
		this.id = id;
		this.processor = processor;
		this.ram = ram;
		this.currentProcessor = 0;
		this.currentRam = 0;
	}

	public void Alocate (double processor, double ram, double hd) {
		this.currentProcessor += processor;
		this.currentRam += ram;
	}

	public NodePower getRemainingAssets() {
		return new NodePower(this.processor - this.currentProcessor,
				this.ram - this.currentRam);
	}

	public void deAlocate (double processor, double ram, double hd) {
		this.currentProcessor -= processor;
		this.currentRam -= ram;
		this.currentHd -= hd;
	}
}
