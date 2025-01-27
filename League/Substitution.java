/**
 * 
 */
package League;

/**
 * Represents a single Substitution in a match, associated with two players, the player in and the player out
 */
public class Substitution {
	private Player playerOut;
	private Player playerIn;
	
	/**
	 * Constructs the Substitution object with the specified player in and player out
	 * 
	 * @param playerOut, the Player who is replaced during the match
	 * @param playerIn, the Player who is substituted in during the match
	 */
	public Substitution(Player playerOut, Player playerIn) {
		this.playerOut = playerOut;
		this.playerIn = playerIn;
	}
	
	/** 
	* These methods are responsible for getting and setting specified attributes of the Substitution class
	*/
	public Player getPlayerOut() {
		return playerOut;
	}
	
	public void setPlayerOut(Player playerOut) {
		this.playerOut = playerOut;
	}

	public Player getPlayerIn() {
		return playerIn;
	}

	public void setPlayerIn(Player playerIn) {
		this.playerIn = playerIn;
	}
	
	
}
