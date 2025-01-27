/**
 * 
 */
package League;
import java.util.ArrayList;

import java.util.List;

/**
 * Represents a single Team in the league, holding details such as its name, the players assigned to it, the coaches assigned to it, its home ground stadium etc.
 */
public class Team {
	private String name;
	private List<Player> players;
	private List<Coach> coaches;
	private Stadium homeGround;
	private TeamManager teamManager;
	private int wins;
	private int draws;
	private int losses;
	private Player topScorer;
	private Player topAssister;
	private Player topCards;
	
	/**
	 * Constructs the Team object with the specified name, the players and coaches array lists are also initialised when this constructor is called
	 * 
	 * @param name, the Team's name
	 */
	public Team(String name) {
		this.name = name;
		this.players = new ArrayList<>(); 
		this.coaches = new ArrayList<>();
	}
	
	/**
	 * This method is responsible for calculating and returning a detailed string containing certain statistics of the Team like top scorer, total goals scored etc.
	 * @return a formatted string with detailed information about the Team's statistics
	 */
	public String getTeamStatistics(Team team) {
		/**
		 * Initialises the method variables
		 */
		int teamTopGoals = 0;
		int teamTopAssists = 0;
		int teamTopCards = 0;
		int totalGoals = 0;
		int totalAssists = 0;
		int totalCards = 0;
		boolean noTopScorer = false;
		boolean noTopAssists = false;
		boolean noTopCards = false;
		
		for (Player player : team.getPlayers()) { //Cycles through all players in the Team
			
			if ((player.getGoalsScored()) > teamTopGoals) { //Gets player with most goals
				setTopScorer(player);
				teamTopGoals = player.getGoalsScored();
			}
			
			if ((player.getAssists()) > teamTopAssists) { //Gets player with most assist
				setTopAssister(player);
				teamTopAssists = player.getAssists();
			}
			
			if ((player.getCards()) > teamTopCards) { //Gets player with most cards dealt
				setTopCards(player);
				teamTopCards = player.getCards();
			}
			
			totalGoals += player.getGoalsScored(); //Setting team totals for goals, assists, and cards
			totalAssists += player.getAssists();
			totalCards += player.getCards();
			
		}
		
		if (team.getTopScorer() == null) { //Error handling, in case team doesnt have a player with the most goals, assists, or cards
			noTopScorer = true;
		}
		
		if (team.getTopAssister() == null) {
			noTopAssists = true;
		}
		
		if (team.getTopCards() == null) {
			noTopCards = true;
		}
		
		StringBuilder details = new StringBuilder(); //Building the string that will populate the text area in TeamStatisticsScreen
		/**
		 * Appending details like team name, wins, draws, losses etc. to the string that will be returned
		 */
		details.append("Team name: ").append(team.getName()).append("\n");
		details.append("\n");
		details.append("Wins: ").append(team.getWins()).append("\n");
		details.append("\n");
		details.append("Draws: ").append(team.getDraws()).append("\n");
		details.append("\n");
		details.append("Losses: ").append(team.getLosses()).append("\n");
		details.append("\n");
		details.append("Total goals: ").append(totalGoals).append("\n");
		details.append("\n");
		details.append("Total Assists: ").append(totalAssists).append("\n");
		details.append("\n");
		details.append("Total cards: ").append(totalCards).append("\n");
		details.append("\n");
		
		if (noTopScorer) { //Prevents run-time error if there is no player with the most goals
			details.append("No player with most goals").append("\n");
			details.append("\n");
		}
		
		else {
			details.append("Top scorer: ").append(team.getTopScorer().getName()).append(" (").append(team.getTopScorer().getGoalsScored()).append(" goals)").append("\n");
			details.append("\n");
		}
		
		if (noTopAssists) { //Prevents run-time error if there is no player with the most assists
			details.append("No player with most assists").append("\n");
			details.append("\n");
		}
		
		else {
			details.append("Top assister: ").append(team.getTopAssister().getName()).append(" (").append(team.getTopAssister().getAssists()).append(" assists)").append("\n");
			details.append("\n");
		}
		
		if (noTopCards) { //Prevents run-time error if there is no player with the most cards dealt
			details.append("No player with most cards").append("\n");
			details.append("\n");
		}
		
		else {
			details.append("Most cards dealt: ").append(team.getTopCards().getName()).append(" (").append(team.getTopCards().getCards()).append(" cards)").append("\n");
		}
		
		return details.toString();
	}
	
	/**
	 * This method is responsible for adding the player passed in, to the Team's list of players
	 */
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	/**
	 * This method is responsible for removing the player passed in, from the Team's list of players
	 */
	public void removePlayer(Player player) {
		players.remove(player);
	}
	
	/**
	 * This method is responsible for adding the coach passed in, to the Team's list of coaches
	 */
	public void addCoach(Coach coach) {
		coaches.add(coach);
	}
	
	/**
	 * This method is responsible for incrementing the Team's wins attribute by 1
	 */
	public void addWin() {
		wins++;
	}
	
	/**
	 * This method is responsible for incrementing the Team's draws attribute by 1
	 */
	public void addDraw() {
		draws++;
	}
	
	/**
	 * This method is responsible for incrementing the Team's losses attribute by 1
	 */
	public void addLoss() {
		losses++;
	}
	
	/** 
	* These methods are responsible for getting and setting specified attributes of the Team class
	*/
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Coach> getCoaches() {
		return coaches;
	}

	public void setCoaches(List<Coach> coaches) {
		this.coaches = coaches;
	}

	public Stadium getHomeGround() {
		return homeGround;
	}

	public void setHomeGround(Stadium homeGround) {
		this.homeGround = homeGround;
	}

	public TeamManager getTeamManager() {
		return teamManager;
	}

	public void setTeamManager(TeamManager teamManager) {
		this.teamManager = teamManager;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getDraws() {
		return draws;
	}

	public void setDraws(int draws) {
		this.draws = draws;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public Player getTopScorer() {
		return topScorer;
	}

	public void setTopScorer(Player topScorer) {
		this.topScorer = topScorer;
	}

	public Player getTopAssister() {
		return topAssister;
	}

	public void setTopAssister(Player topAssister) {
		this.topAssister = topAssister;
	}

	public Player getTopCards() {
		return topCards;
	}

	public void setTopCards(Player topCards) {
		this.topCards = topCards;
	}
	
	
}
