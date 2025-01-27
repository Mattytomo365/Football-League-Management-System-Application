package Main;
import javax.swing.SwingUtilities;
import GUI.ViewerScreen;
import League.Data;
import League.League;


/**
 * The Main class serves as the entry point for the application. 
 * It initializes Data, loads data from the text file and sets up the League by passing the loaded data into it, and launches the GUI.
 */
public class Main {
	
	public static void main(String[] args) {
		
		// Initialise the Data class
		Data data = new Data();
		
		// Load the data from the file specified
		String filePath = ("/Users/matthewtomlinson/Library/CloudStorage/OneDrive-Personal/University Year 2/Course work/OOP_CW1/src/LeagueData.txt");
		data.loadData(filePath);
		
		// Initialise the League with the data gathered from the text file
		League league = new League(data.getTeams(), data.getMatches(), data.getPlayers(), data.getCoaches(), data.getReferees(), data.getUnaffiliatedPlayers(), data.getTeamManagers());
		
		//Setting up GUI, launching the ViewerScreen as the starting page, passing the newly created League object into its constructor
		SwingUtilities.invokeLater(() -> new ViewerScreen(league));
		
		
	}

}
