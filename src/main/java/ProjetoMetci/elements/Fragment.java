package ProjetoMetci.elements;

public class Fragment {
	private Long time;
	private NodePower power;

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public NodePower getPower() {
		return power;
	}

	public void setPower(NodePower power) {
		this.power = power;
	}

	/**
	 * A Fragment is an amount of wasted power over a time
	 * @param time
	 * @param power
	 */
	public Fragment(Long time, NodePower power) {
		this.time = time;
		this.power = power;
	}
}
