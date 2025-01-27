/**
 * 
 */
package League;

/**
 * Represents a single Goal in a Match, associated with two players
 */
public class Goal {
	private Player scorer;
	private Player assist;
	/**
	 * Constructs the Goal object with the specified scorer and assister
	 * 
	 * @param scorer, the Player who scored the goal
	 * @param assist, the Player who assisted the goal
	 */
	public Goal(Player scorer, Player assist) {
		this.scorer = scorer;
		this.assist = assist;
	}
	
	/** 
	* These methods are responsible for getting and setting specified attributes of the Goal class
	*/
	public Player getScorer() {
		return scorer;
	}
	
	public void setScorer(Player scorer) {
		this.scorer = scorer;
	}
	
	public Player getAssist() {
		return assist;
	}
	
	public void setAssist(Player assist) {
		this.assist = assist;
	}
	
}
