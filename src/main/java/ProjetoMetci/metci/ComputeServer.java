package ProjetoMetci.metci;

public class ComputeServer {
	
	private String id;
	private long processors;
	private long ram;
	private long hd;
	private long currentProcessor;
	private long currentRam;
	private long currentHd;
	
	
	public ComputeServer (String id, long processors, long ram, long hd) {
		this.id = id;
		this.processors = processors;
		this.ram = ram;
		this.hd = hd;
		this.currentProcessor = 0;
		this.currentRam = 0;
		this.currentHd = 0;
	}
	
	public void Alocate (long processors, long ram, long hd) {
		this.currentProcessor += processors;
		this.currentRam += ram;
		this.currentHd += hd;
	}
	
	public NodePower getRemainingAssets() {
		return new NodePower(this.processors - this.currentProcessor, 
				this.ram - this.currentRam, 
				this.hd - this.currentHd);
	}
	
	public void deAlocate (long processors, long ram, long hd) {
		this.currentProcessor -= processors;
		this.currentRam -= ram;
		this.currentHd -= hd;
	}
}
