package League;

/**
 * Represents a single Referee in the league, including details such as name, employment status, and pay
 */
public class Referee extends Person {
	private int pay;
	
	/**
	 * Constructs the Referee object with the specified name, Referee inherits the attributes name, and employmentStatus from its parent Person class along with their getter and setter methods
	 * 
	 * @param name, the Referee's name
	 */
	public Referee(String name) {
		this.name = name;
	}

	/** 
	* These methods are responsible for getting and setting the pay attribute of the Referee class
	*/
	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}
}
