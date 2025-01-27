package League;

/**
 * Represents a singular team manager assigned to a team present in the league, including details such as name, team, and employment status
 */
public class TeamManager extends Person{
	private Team team;
	
	/**
	 * Constructs the TeamManager object with the specified name, TeamManager inherits the attributes name, and employmentStatus from its parent Person class along with their getter and setter methods
	 * 
	 * @param name, the TeamManager's name
	 */
	public TeamManager(String name) {
		this.name = name;
	}

	/** 
	* These methods are responsible for getting and setting the team attribute of the TeamManager class
	*/
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}

