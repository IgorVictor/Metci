package ProjetoMetci.elements;

public class Fragment {
	private Long time;
	private NodePower power;

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
