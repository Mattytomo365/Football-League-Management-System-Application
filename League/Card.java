package League;

/**
 * Represents a Card in a League, which is associated with a player and has a specific type
 */
public class Card {
	private Player player;
	private String type;
	
    /**
     * Constructs a Card object with a specified player and card type
     * 
     * @param player, the player who received the card
     * @param type, the type of card (e.g., "Yellow", "Red")
     */
	public Card(Player player, String type) {
		this.player = player;
		this.type = type;
	}
	/** 
	* These methods are responsible for getting and setting specified attributes of the Card class
	*/
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
