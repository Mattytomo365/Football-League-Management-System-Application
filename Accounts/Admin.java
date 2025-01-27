
package Accounts;
import League.Team;
import League.TeamManager;
import League.Coach;
import League.League;
import League.Player;
import League.Referee;


public class Admin {
	private League league;
	
	/**
	 * Constructs an Admin object that manages the specified League
	 * @param league, the League object that Admin can manage
	 */
	public Admin(League league) {
		this.league = league; //references league object, allowing this class to make modifications to League
	}
	
	/**
	 * Responsible for invoking the createTeam() method in the League class, passing the same parameters through
	 */
	public void createTeam(String teamNameEntered, String homeGroundNameEntered, int capacityEntered) {
		league.createTeam(teamNameEntered, homeGroundNameEntered, capacityEntered); //calls league's createTeam method
	}	
	
	/**
	 * Responsible for invoking the createPlayer() method in the League class, passing the same parameters through
	 */
	public void createPlayer(String nameEntered, String employmentStatusEntered, String positionEntered, int totalGoalsEntered, int totalAssistsEntered, int totalCardsEntered, String preferredFormationEntered, int payEntered) {
		league.createPlayer(nameEntered, employmentStatusEntered, positionEntered, totalGoalsEntered, totalAssistsEntered, totalCardsEntered, preferredFormationEntered, payEntered); //calls league's createPlayer method
	}
	
	/**
	 * Responsible for invoking the createTeamManager() method in the League class, passing the same parameters through
	 */
	public void createTeamManager(String nameEntered, Team selectedTeam) {
		league.createTeamManager(nameEntered, selectedTeam); //calls league's createTeamManager method
	}
	
	/**
	 * Responsible for invoking the createCoach() method in the League class, passing the same parameters through
	 */
	public void createCoach(String nameEntered, String employmentStatusEntered, String teamNameEntered, int payEntered) {
		league.createCoach(nameEntered, employmentStatusEntered, teamNameEntered, payEntered); //calls league's createCoach method
	}
	
	/**
	 * Responsible for invoking the createReferee() method in the League class, passing the same parameters through
	 */
	public void createReferee(String nameEntered, String employmentStatusEntered, int payEntered) {
		league.createReferee(nameEntered, employmentStatusEntered, payEntered); //calls league's createReferee method
	}
	
	/**
	 * Responsible for invoking the affiliatePlayer() method in the League class, passing the same parameters through
	 */
	public void affiliatePlayer(Player selectedPlayer, Team selectedTeam) {
		league.affiliatePlayer(selectedPlayer, selectedTeam); //calls league's affiliatePlayer method
	}

	/**
	 * Responsible for invoking the removePlayer() method in the League class, passing the same parameters through
	 */
	public void removePlayer(Player player) {
		league.removePlayer(player); //calls league's removePlayer method
	}
	
	/**
	 * Responsible for invoking the deleteTeam() method in the League class, passing the same parameters through
	 */
	public void deleteTeam(Team team) {
		league.deleteTeam(team); //calls league's deleteTeam method
	}
	
	/**
	 * Responsible for invoking the deletePlayer() method in the League class, passing the same parameters through
	 */
	public void deletePlayer(Player player) {
		league.deletePlayer(player); //calls league's deletePlayer method
	}
	
	/**
	 * Responsible for invoking the deleteTeamManager() method in the League class, passing the same parameters through
	 */
	public void deleteTeamManager(TeamManager teamManager) {	
		league.deleteTeamManager(teamManager); //calls league's deleteTeamManager method
	}
	
	/**
	 * Responsible for invoking the deleteCoach() method in the League class, passing the same parameters through
	 */
	public void deleteCoach(Coach coach) {		
		league.deleteCoach(coach); //calls league's deleteCoach method
	}
	
	/**
	 * Responsible for invoking the deleteReferee() method in the League class, passing the same parameters through
	 */
	public void deleteReferee(Referee referee) {
		league.deleteReferee(referee); //calls league's deleteReferee method
	}

}
