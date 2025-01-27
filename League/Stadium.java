/**
 * 
 */
package League;

/**
 * Represents a single stadium that a team present in the league occupies, holds details such as name and capacity
 */
public class Stadium {
	private String name;
	private int capacity;

	/**
	 * Constructs the Stadium object with the specified name
	 * 
	 * @param name, the Stadium's name
	 */
	public Stadium(String name) {
		this.name = name;
	}
	
	/** 
	* These methods are responsible for getting and setting specified attributes of the Stadium class
	*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
