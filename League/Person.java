/**
 * 
 */
package League;

/**
 * Represents a singular Person in the league, this person is then extended into a Player, Coach, Referee, or Team Manager in the child classes
 */
public class Person {
	protected String name;
	protected String employmentStatus;
	
	public String getName() {
		return name;
	}

	/** 
	* These methods are responsible for getting and setting specified attributes of the Person class
	*/
	public void setName(String name) {
		this.name = name;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	
	
}
