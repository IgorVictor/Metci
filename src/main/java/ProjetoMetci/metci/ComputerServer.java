package ProjetoMetci.metci;

public class ComputerServer {
	
	private String id;
	private double processors;
	private double ram;
	private double hd;
	private double currentProcessor;
	private double currentRam;
	private double currentHd;
	
	
	public ComputerServer (String id, double processors, double ram, double hd) {
		this.id = id;
		this.processors = processors;
		this.ram = ram;
		this.hd = hd;
		this.currentProcessor = 0;
		this.currentRam = 0;
		this.currentHd = 0;
	}
	
	public void Alocate (double processors, double ram, double hd) {
		this.currentProcessor += processors;
		this.currentRam += ram;
		this.currentHd += hd;
	}
	
	public NodePower getRemainingAssets() {
		return new NodePower(this.processors - this.currentProcessor, 
				this.ram - this.currentRam, 
				this.hd - this.currentHd);
	}
	
	public void deAlocate (double processors, double ram, double hd) {
		this.currentProcessor -= processors;
		this.currentRam -= ram;
		this.currentHd -= hd;
	}
}
