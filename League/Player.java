package League;

/**
 * Represents a singular Player in the league, inluding details such as their name, employment status, position, amount of goals, assists, and cards dealt, preferred formation, and pay 
 */
public class Player extends Person {
	private String position;
	private int goalsScored;
	private int assists;
	private int cards;
	private String preferredFormation;
	private int pay;
	
	/**
	 * Constructs the Player object with the specified name, Player inherits the attributes name, and employmentStatus from its parent Person class along with their getter and setter methods
	 * 
	 * @param name, the Player's name
	 */
	public Player(String name) {
		this.name = name;
	}
	
	/** 
	* This method is responsible for returning a detailed string representation of a Player, including all relevant details like position, goals, assists, cards, and preferred formation 
	* @return a formatted string with detailed information about the Player
	*/
	public String getPlayerDetails(Player player) {
		StringBuilder details = new StringBuilder();
		/** 
		* Appending name, position, total goals, total assists, total cards, preferred formation
		*/
		details.append("Name: ").append(player.getName()).append("\n");
		details.append("\n");
		details.append("Position: ").append(player.getPosition()).append("\n");
		details.append("\n");
		String goalsScoredString = Integer.toString(player.getGoalsScored()); //Converting the integer of total goals to a string so it can be appended to the string
		details.append("Goals Scored: ").append(goalsScoredString).append("\n");
		details.append("\n");
		String assistsString = Integer.toString(player.getAssists());
		details.append("Assists: ").append(assistsString).append("\n");
		details.append("\n");
		String cardsString = Integer.toString(player.getCards());
		details.append("Cards: ").append(cardsString).append("\n");
		details.append("\n");
		details.append("Preferred Formation: ").append(player.getPreferredFormation()).append("\n");
		
		return details.toString();
	}
	
	/** 
	* This method is responsible for incrementing the Player's goals scored by 1
	*/
	public void addGoal() {
		goalsScored++;
	}
	
	/** 
	* This method is responsible for incrementing the Player's assists by 1
	*/
	public void addAssist() {
		assists++;
	}
	
	/** 
	* This method is responsible for incrementing the Player's cards dealt by 1
	*/
	public void addCard() {
		cards++;
	}
	
	/** 
	* These methods are responsible for getting and setting specified attributes of the Player class
	*/
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}

	public int getGoalsScored() {
		return goalsScored;
	}

	public void setGoalsScored(int goalsScored) {
		this.goalsScored = goalsScored;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getCards() {
		return cards;
	}

	public void setCards(int cards) {
		this.cards = cards;
	}

	public String getPreferredFormation() {
		return preferredFormation;
	}

	public void setPreferredFormation(String preferredFormation) {
		this.preferredFormation = preferredFormation;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}
	
	
}
