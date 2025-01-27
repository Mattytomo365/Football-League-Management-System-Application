package League;

/**
 * Represents a Coach in a League, which is associated with the Team they coach. Including details such as name, employment status, team, and pay
 */
public class Coach extends Person {
	private Team team;
	private int pay;
	
    /**
     * Constructs a Coach object with a specified name, inherits name and employment status attributes along with their getter and setter methods from its parent Person class
     * 
     * @param name, the name of the Coach
     */
	public Coach(String name) {
		this.name = name;
	}

	/** 
	* These methods are responsible for getting and setting specified attributes of the Coach class
	*/
	public Team getTeam() {
		return team;
	}

	
	public void setTeam(Team team) {
		this.team = team;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}
}
