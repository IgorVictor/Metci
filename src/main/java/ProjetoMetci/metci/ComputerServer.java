package ProjetoMetci.metci;

import java.lang.Comparable;

public class ComputerServer implements Comparable<ComputerServer>{

	private int id;
	private double processor;
	private double ram;
	private double currentProcessor;
	private double currentRam;
	private double currentHd;


	public ComputerServer (int id, double processor, double ram) {
		this.id = id;
		this.processor = processor;
		this.ram = ram;
		this.currentProcessor = 0;
		this.currentRam = 0;
	}

	public void allocatePower(NodePower power) {
		this.currentProcessor += power.getProcessor();
		this.currentRam += power.getRam();
	}

	public int getID() {
	    return this.id;
    }

	public NodePower getRemainingAssets() {
		return new NodePower(this.processor - this.currentProcessor,
				this.ram - this.currentRam);
	}

	public void deallocatePower(NodePower power) {
		this.currentProcessor -= power.getProcessor();
		this.currentRam -= power.getRam();
	}

	public int compareTo(ComputerServer other){
	    return ((NodePower) this.getRemainingAssets()).compareTo((NodePower) other.getRemainingAssets());
    }
}
