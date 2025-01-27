/**
 * 
 */
package League;

import java.util.List;

/**
 * Represents a single Match played, including details such as week played, home team, away team, score, list of goals, list of substitutions, and list of cards
 */
public class Match {
	private String weekPlayed;
	private Team homeTeam;
	private Team awayTeam;
	private String score;
	private List<Goal> goals;
	private List<Substitution> substitutions;
	private List<Card> cards;
	
    /**
     * Constructs a Match object with a specified week played
     * 
     * @param weekPlayed, the week of the season in which the Match was played
     */
	public Match(String weekPlayed) {
		this.weekPlayed = weekPlayed;
	}
	/** 
	* This method is responsible for returning a detailed string representation of a Match, including all relevant details like week played, teams that played, score, goals etc.
	* @return a formatted string with detailed information about the Match
	*/
	public String getMatchDetails(Match match) {
		//Using StringBuilder to construct the match details string
		StringBuilder details = new StringBuilder();
		/** 
		* Appending week played, home team, away team, score, goals, substitutions, cards
		*/
		details.append("Week: ").append(match.getWeekPlayed()).append("\n");
		details.append(" \n");
		details.append("Home Team: ").append(match.getHomeTeam().getName()).append("\n");
		details.append(" \n");
		details.append("Away Team: ").append(match.getAwayTeam().getName()).append("\n");
		details.append(" \n");
		details.append("Score: ").append(match.getScore()).append("\n");
		details.append(" \n");
		
		details.append("Goals (scorer, assister):\n");
		
		for (Goal goal : match.getGoals()) {
			details.append("     ").append(goal.getScorer().getName());
			
			if(goal.getAssist() != null) {
				details.append(", ").append(goal.getAssist().getName());
			}
			
			details.append("\n");
		}
		
		details.append(" \n");
		
		details.append("Substitutions (player in, player out):\n");
		
		if (match.getSubstitutions() != null) {
			
			for (Substitution substitution : match.getSubstitutions()) {
				details.append("      Player in: ").append(substitution.getPlayerIn().getName());
				details.append(", Player out: ").append(substitution.getPlayerOut().getName());
			}
			
			details.append("\n");
			
		}
		
		details.append(" \n");
		
		details.append("Cards (player, card type):\n");
		
		if (match.getCards() != null) {
			for (Card card : match.getCards()) {
				details.append("     ").append(card.getPlayer().getName());
				details.append(", ").append(card.getType());
			}
			
			details.append("\n");
		}
		

		return details.toString();
	}

	/** 
	* These methods are responsible for getting and setting specified attributes of the Match class
	*/
	public String getWeekPlayed() {
		return weekPlayed;
	}

	public void setWeekPlayed(String weekPlayed) {
		this.weekPlayed = weekPlayed;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}
	
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public List<Goal>getGoals() {
		return goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

	public List<Substitution> getSubstitutions() {
		return substitutions;
	}

	public void setSubstitutions(List<Substitution> substitutions) {
		this.substitutions = substitutions;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}
