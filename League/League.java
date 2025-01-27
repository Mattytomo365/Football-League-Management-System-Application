/**
 * 
 */
package League;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Acts the core domain object in this application, represents the League, associated with teams, players, matches, coaches, referees, unaffiliated players, and team managers
 */
public class League {
	private ArrayList<Team> teams;
	private ArrayList<Match> matches;
	private ArrayList<Player> players;
	private ArrayList <Coach> coaches;
	private ArrayList <Referee> referees;
	private ArrayList <Player> unaffiliatedPlayers;
	private ArrayList <TeamManager> teamManagers;
	
    /**
     * Constructs a League object with teams, matches, players etc. recieved from the text file in the Data class
     * 
     * @param teams, the teams in the league
     * @param matches, matches recorded between the league's in the current season
     * @param players, the players assigned to the teams in the league
     * @param coaches, the coaches that coach the players, assinged to a team
     * @param referees, referees in the league
     * @param unaffiliated players, players with no team in the league
     * @param team managers, team managers that manage a single team present in the league
     */
	public League(ArrayList<Team> teams, ArrayList<Match> matches, ArrayList<Player> players, ArrayList<Coach> coaches, ArrayList<Referee> referees, ArrayList <Player> unaffiliatedPlayers, ArrayList <TeamManager> teamManagers) {
		this.teams = teams;
		this.matches= matches;
		this.players = players;
		this.coaches = coaches;
		this.referees = referees;
		this.unaffiliatedPlayers = unaffiliatedPlayers;
		this.teamManagers = teamManagers;
	}
	
	/**
	 * This method is responsible for calculating and returning a detailed string containing certain statistics of the League like top scorer, total goals scored etc.
	 * @return a formatted string with detailed information about the League's statistics
	 */
	public String getLeagueStatistics() {
	    //Initialising all of the variables in the method
		int leagueGoals = 0;
	    int leagueAssists = 0;
	    int leagueCards = 0;
	    Player leagueTopScorer = null;
	    int highestGoals = 0;

	    for (Team team : getTeams()) { //Cycles through every team in the League
	    	
	        int teamGoals = 0;
	        int teamAssists = 0;
	        int teamCards = 0;
	        Player teamTopScorer = null;
	        int teamHighestGoals = 0;

	        for (Player player : team.getPlayers()) { //Nested for loop, cycles through the players in the current team being viewed
	        	
	            teamGoals += player.getGoalsScored(); //Sums up all goals, assists, and cards from each player for each team and calculating team totals
	            teamAssists += player.getAssists();
	            teamCards += player.getCards();

	            if (player.getGoalsScored() > teamHighestGoals) { //If the players total number of goals scored is higher than the value currently being stored in teamHighestGoals
	            	
	                teamHighestGoals = player.getGoalsScored();
	                teamTopScorer = player;
	            }
	        }

	        team.setTopScorer(teamTopScorer); //Setting top scorer for each team cyclyed through
	        leagueGoals += teamGoals;
	        leagueAssists += teamAssists;
	        leagueCards += teamCards;

	        //Update league's top scorer if this team's top scorer has more goals
	        if (teamTopScorer != null && teamTopScorer.getGoalsScored() > highestGoals) {
	        	
	            highestGoals = teamTopScorer.getGoalsScored();
	            leagueTopScorer = teamTopScorer;
	        }
	    }

	    //Check if a league top scorer exists
	    if (leagueTopScorer == null) {
	        throw new IllegalStateException("No players in the league have scored goals.");
	    }

	    //Building the statistics string
	    StringBuilder details = new StringBuilder();
	    details.append("Top scorer: ").append(leagueTopScorer.getName()).append(" (").append(leagueTopScorer.getGoalsScored()).append(" goals)").append("\n");
	    details.append("\n");
	    details.append("LEAGUE TOTALS").append("\n");
	    details.append("\n");
	    details.append("Total number of goals: ").append(leagueGoals).append("\n");
	    details.append("\n");
	    details.append("Total number of assists: ").append(leagueAssists).append("\n");
	    details.append("\n");
	    details.append("Total number of cards: ").append(leagueCards).append("\n");

	    return details.toString();
	}
	
	//Finds team using name
	private Team findTeamByName(String name, ArrayList<Team> teams) {
	    for (Team team : teams) {
	        if (team.getName().equals(name)) {
	            return team;
	        }
	    }
	    return null; //Return null if player not found
	}
	/** 
	* This method is responsible for creating a team, using the details entered into the text fields on the createTeamScreen
	*/
	public void createTeam(String teamNameEntered, String homeGroundNameEntered, int capacityEntered) {
		String teamName = teamNameEntered;
		String homeGroundName = homeGroundNameEntered;
		int capacity = capacityEntered;
		
		if (findTeamByName(teamName, getTeams()) != null) {
			System.err.println("Team already exists" + teamName);
		}
		
		else {
			Team newTeam = new Team(teamName); //CREATES NEW TEAM
			newTeam.setWins(0); //New teams dont have any wins, draws, or losses
			newTeam.setDraws(0);
			newTeam.setLosses(0);
			Stadium newStadium = new Stadium(homeGroundName); //Creates new stadium
			newStadium.setCapacity(capacity);
			newTeam.setHomeGround(newStadium);
			
			teams.add(newTeam); //Adds new team to the league's list of teams
		}
		
		/**	
		* TO ADD PLAYERS, USE AFFILIATE PLAYER SCREEN
		* TO ADD COACHES, USE CREATE COACH SCREEN
		* TO ADD TEAM MANAGER, USE CREATE TEAM MANAGER SCREEN
		 */
		
		
		//Initialise the Data class, and ensures League's state is mirrored in it
		Data data = new Data();
		data.setTeams(teams);
		data.setMatches(matches);
		data.setPlayers(players);
		data.setCoaches(coaches);
		data.setReferees(referees);
		data.setUnaffiliatedPlayers(unaffiliatedPlayers);
		data.setTeamManagers(teamManagers);
		
		
		//Save the data in the file specified
		String filePath = ("/Users/matthewtomlinson/Library/CloudStorage/OneDrive-Personal/University Year 2/Course work/OOP_CW1/src/LeagueData.txt");
		data.saveData(filePath);
	}	
	
	/** 
	* This method is responsible for creating a player, using the details entered into the text fields on the createPlayerScreen
	*/
	public void createPlayer(String nameEntered, String employmentStatusEntered, String positionEntered, int totalGoalsEntered, int totalAssistsEntered, int totalCardsEntered, String preferredFormationEntered, int payEntered) {
		String name = nameEntered;
		String employmentStatus = employmentStatusEntered;
		String position = positionEntered;
		int totalGoals = totalGoalsEntered;
		int totalAssists = totalAssistsEntered;
		int totalCards = totalCardsEntered;
		String preferredFormation = preferredFormationEntered;
		int pay = payEntered;
		
		//CREATES NEW UNAFFILIATED PLAYER
		Player newUnaffiliatedPlayer = new Player(name);
		newUnaffiliatedPlayer.setEmploymentStatus(employmentStatus);
		newUnaffiliatedPlayer.setPosition(position);
		newUnaffiliatedPlayer.setGoalsScored(totalGoals);
		newUnaffiliatedPlayer.setAssists(totalAssists);
		newUnaffiliatedPlayer.setCards(totalCards);
		newUnaffiliatedPlayer.setPay(pay);
		newUnaffiliatedPlayer.setPreferredFormation(preferredFormation);
		
		unaffiliatedPlayers.add(newUnaffiliatedPlayer);
		
		//Initialise the Data class, and ensures League's state is mirrored in it
		Data data = new Data();
		data.setTeams(teams);
		data.setMatches(matches);
		data.setPlayers(players);
		data.setCoaches(coaches);
		data.setReferees(referees);
		data.setUnaffiliatedPlayers(unaffiliatedPlayers);
		data.setTeamManagers(teamManagers);
		
		
		//Save the data in the file specified
		String filePath = ("/Users/matthewtomlinson/Library/CloudStorage/OneDrive-Personal/University Year 2/Course work/OOP_CW1/src/LeagueData.txt");
		data.saveData(filePath);
	}
	
	/** 
	* This method is responsible for creating a team manager, using the details entered into the text fields on the createTeamManagerScreen
	*/
	public void createTeamManager(String nameEntered, Team selectedTeam) {
		String name = nameEntered;
		Team team = selectedTeam;
		
		//CREATES NEW TEAM MANAGER
		TeamManager newTeamManager = new TeamManager(name);
		newTeamManager.setTeam(team); //Assigns the new team manager to the team selected
		selectedTeam.setTeamManager(newTeamManager);
		
		teamManagers.add(newTeamManager); //Adds the new team manager to the league's list of team managers
		
		//Initialise the Data class, and ensures League's state is mirrored in it
		Data data = new Data();
		data.setTeams(teams);
		data.setMatches(matches);
		data.setPlayers(players);
		data.setCoaches(coaches);
		data.setReferees(referees);
		data.setUnaffiliatedPlayers(unaffiliatedPlayers);
		data.setTeamManagers(teamManagers);
		
		//Save the data in the file specified
		String filePath = ("/Users/matthewtomlinson/Library/CloudStorage/OneDrive-Personal/University Year 2/Course work/OOP_CW1/src/LeagueData.txt");
		data.saveData(filePath);
	}
	
	/** 
	* This method is responsible for creating a coach, using the details entered into the text fields on the createCoachScreen
	*/
	public void createCoach(String nameEntered, String employmentStatusEntered, String teamNameEntered, int payEntered) {
		//Storing details passed into the method from CreateCoachScreen
		String name = nameEntered;
		String employmentStatus = employmentStatusEntered;
		String teamName = teamNameEntered;
		int pay = payEntered;
		
		Team team = findTeamByName(teamName, teams);
		
		//Error handling
		if (team == null) {
			System.err.println("Team not found: " + teamName);
		}
		
		//CREATES NEW COACH
		Coach newCoach = new Coach(name);
		newCoach.setEmploymentStatus(employmentStatus); //Setting all attributes
		newCoach.setTeam(team);
		newCoach.setPay(pay);
		
		coaches.add(newCoach); //Adding team to league's team list
		team.addCoach(newCoach); //Adding coach to the team's coach list
		
		//Initialise the Data class, and ensures League's state is mirrored in it
		Data data = new Data();
		data.setTeams(teams);
		data.setMatches(matches);
		data.setPlayers(players);
		data.setCoaches(coaches);
		data.setReferees(referees);
		data.setUnaffiliatedPlayers(unaffiliatedPlayers);
		data.setTeamManagers(teamManagers);
		
		
		//Save the data in the file specified
		String filePath = ("/Users/matthewtomlinson/Library/CloudStorage/OneDrive-Personal/University Year 2/Course work/OOP_CW1/src/LeagueData.txt");
		data.saveData(filePath);
	}
	
	/** 
	* This method is responsible for creating a referee, using the details entered into the text fields on the createRefereeScreen
	*/
	public void createReferee(String nameEntered, String employmentStatusEntered, int payEntered) {
		//Storing data passed into method from CreateRefereeScreen
		String name = nameEntered;
		String employmentStatus = employmentStatusEntered;
		int pay = payEntered;
		
		//CREATES NEW REFEREE
		Referee newReferee = new Referee(name);
		newReferee.setEmploymentStatus(employmentStatus);
		newReferee.setPay(pay);
		
		referees.add(newReferee);
		
		//Initialise the Data class, and ensures League's state is mirrored in it
		Data data = new Data();
		data.setTeams(teams);
		data.setMatches(matches);
		data.setPlayers(players);
		data.setCoaches(coaches);
		data.setReferees(referees);
		data.setUnaffiliatedPlayers(unaffiliatedPlayers);
		data.setTeamManagers(teamManagers);
		
		
		//Save the data in the file specified
		String filePath = ("/Users/matthewtomlinson/Library/CloudStorage/OneDrive-Personal/University Year 2/Course work/OOP_CW1/src/LeagueData.txt");
		data.saveData(filePath);
	}
	
	
	/** 
	* This method is responsible for affiliating a player, using the player and team selected from the dropdowns on the affiliatePlayerScreen
	*/
	public void affiliatePlayer(Player selectedPlayer, Team selectedTeam) {
		Player player = selectedPlayer;
		Team team = selectedTeam;
		
		team.addPlayer(player); //Adds selected player to selected team
		unaffiliatedPlayers.remove(player); //Now that the player is affiliated, they are removed from the unaffiliated list
		players.add(player); //Newly affiliated player is added to the players list
		
		//Initialise the Data class, and ensures League's state is mirrored in it
		Data data = new Data();
		data.setTeams(teams);
		data.setMatches(matches);
		data.setPlayers(players);
		data.setCoaches(coaches);
		data.setReferees(referees);
		data.setUnaffiliatedPlayers(unaffiliatedPlayers);
		data.setTeamManagers(teamManagers);
		
		
		//Save the data in the file specified
		String filePath = ("/Users/matthewtomlinson/Library/CloudStorage/OneDrive-Personal/University Year 2/Course work/OOP_CW1/src/LeagueData.txt");
		data.saveData(filePath);
		
	}

	/** 
	* This method is responsible for removing a player, using the player selected from the drop down on the removePlayerScreen
	*/
	public void removePlayer(Player player) {
		Player selectedPlayer = player; //Gets player selected from dropdown on RemovePlayerScreen
		
	    //Remove the player from their team
	    for (Team team : teams) {
	        if (team.getPlayers().contains(selectedPlayer)) {
	            team.getPlayers().remove(selectedPlayer); //Removes selected player from team's list of players
	            break; //Exit the loop after finding and removing the player
	        }
	    }
	    
	    unaffiliatedPlayers.add(selectedPlayer); //Adds removed player to league's unaffiliated players list
	    
		//Initialise the Data class, and ensures League's state is mirrored in it
		Data data = new Data();
		data.setTeams(teams);
		data.setMatches(matches);
		data.setPlayers(players);
		data.setCoaches(coaches);
		data.setReferees(referees);
		data.setUnaffiliatedPlayers(unaffiliatedPlayers);
		data.setTeamManagers(teamManagers);
		
		
		//Save the data in the file specified
		String filePath = ("/Users/matthewtomlinson/Library/CloudStorage/OneDrive-Personal/University Year 2/Course work/OOP_CW1/src/LeagueData.txt");
		data.saveData(filePath);
		
	}
	
	/** 
	* This method is responsible for deleting a team, using the team selected from the dropdown on the deleteTeamScreen
	*/
	public void deleteTeam(Team team) {
		Team selectedTeam = team;
		
		if (!selectedTeam.getPlayers().isEmpty()) {
		    //Uses an iterator to avoid ConcurrentModificationException
		    Iterator<Player> iterator = selectedTeam.getPlayers().iterator();
		    while (iterator.hasNext()) {
		        Player player = iterator.next();
		        iterator.remove(); //Removes player from team's list of players
		        players.remove(player); //Removes player from league's global list of players
		        unaffiliatedPlayers.add(player); //Adds player to unaffiliated players list
		    }
		}
		
		teams.remove(selectedTeam); //Removes selected team from league's list of teams
		
		//Initialise the Data class, and ensures League's state is mirrored in it
		Data data = new Data();
		data.setTeams(teams);
		data.setMatches(matches);
		data.setPlayers(players);
		data.setCoaches(coaches);
		data.setReferees(referees);
		data.setUnaffiliatedPlayers(unaffiliatedPlayers);
		data.setTeamManagers(teamManagers);
		
		
		//Save the data in the file specified
		String filePath = ("/Users/matthewtomlinson/Library/CloudStorage/OneDrive-Personal/University Year 2/Course work/OOP_CW1/src/LeagueData.txt");
		data.saveData(filePath);
	}
	
	/** 
	* This method is responsible for deleting a player, using the player selected from the dropdown on the deletePlayerScreen
	*/
	public void deletePlayer(Player player) {
	    Player selectedPlayer = player; //Gets player selected from dropdown on DeletePlayerScreen

	    //Remove the player from their team
	    for (Team team : teams) {
	        if (team.getPlayers().contains(selectedPlayer)) {
	            team.getPlayers().remove(selectedPlayer); //Removes selected player from team's list of players
	            break; //Exit the loop after finding and removing the player
	        }
	    }
	    
	    players.remove(selectedPlayer); //Removes selected player from league's list of players
	    
		//Initialise the Data class, and ensures League's state is mirrored in it
		Data data = new Data();
		data.setTeams(teams);
		data.setMatches(matches);
		data.setPlayers(players);
		data.setCoaches(coaches);
		data.setReferees(referees);
		data.setUnaffiliatedPlayers(unaffiliatedPlayers);
		data.setTeamManagers(teamManagers);
		
		
		//Save the data in the file specified
		String filePath = ("/Users/matthewtomlinson/Library/CloudStorage/OneDrive-Personal/University Year 2/Course work/OOP_CW1/src/LeagueData.txt");
		data.saveData(filePath);
	}
	
	/** 
	* This method is responsible for deleting a team manager, using the team manager selected from the dropdown on the deleteTeamManagerScreen
	*/
	public void deleteTeamManager(TeamManager teamManager) {	
		TeamManager selectedTeamManager = teamManager; //Gets team manager selected from dropdown on DeleteTeamManagerScreen
		
	    //Remove the team manager from their team
	    for (Team team : teams) {
	        if (team.getTeamManager() == selectedTeamManager) {
	            team.setTeamManager(null); //Removes selected team manager from team
	            break; //Exit the loop after finding and removing the player
	        }
	    }
	    
	    teamManagers.remove(selectedTeamManager); //Removes selected team manager from league's list of team managers
	    
		//Initialise the Data class, and ensures League's state is mirrored in it
		Data data = new Data();
		data.setTeams(teams);
		data.setMatches(matches);
		data.setPlayers(players);
		data.setCoaches(coaches);
		data.setReferees(referees);
		data.setUnaffiliatedPlayers(unaffiliatedPlayers);
		data.setTeamManagers(teamManagers);
		
		
		//Save the data in the file specified
		String filePath = ("/Users/matthewtomlinson/Library/CloudStorage/OneDrive-Personal/University Year 2/Course work/OOP_CW1/src/LeagueData.txt");
		data.saveData(filePath);
	}
	
	/** 
	* This method is responsible for deleting a coach, using the coach selected from the dropdown on the deleteCoachScreen
	*/
	public void deleteCoach(Coach coach) {		
		Coach selectedCoach = coach; //Gets coach selected from the dropdown on the DeleteCoachScreen
		
	    //Remove the coach from their team
	    for (Team team : teams) {
	        if (team.getPlayers().contains(selectedCoach)) {
	            team.getPlayers().remove(selectedCoach); //Removes selected coach from team's list of coaches
	            break; //Exit the loop after finding and removing the coach
	        }
	    }
		
		coaches.remove(selectedCoach); //Removes the coach selected from the dropdown from the league's list of coaches
		
		//Initialise the Data class, and ensures League's state is mirrored in it
		Data data = new Data();
		data.setTeams(teams);
		data.setMatches(matches);
		data.setPlayers(players);
		data.setCoaches(coaches);
		data.setReferees(referees);
		data.setUnaffiliatedPlayers(unaffiliatedPlayers);
		data.setTeamManagers(teamManagers);
		
		//Save the data in the file specified
		String filePath = ("/Users/matthewtomlinson/Library/CloudStorage/OneDrive-Personal/University Year 2/Course work/OOP_CW1/src/LeagueData.txt");
		data.saveData(filePath);
	}
	
	/** 
	* This method is responsible for deleting a referee, using the referee selected from the dropdown on the deleteRefereeScreen
	*/
	public void deleteReferee(Referee referee) {
		Referee selectedReferee = referee; //Gets referee selected from the dropdown on DeleteRefereeScreen
		
		referees.remove(selectedReferee); //Removes referee from the league's list of referees
		
		//Initialise the Data class, and ensures League's state is mirrored in it
		Data data = new Data();
		data.setTeams(teams);
		data.setMatches(matches);
		data.setPlayers(players);
		data.setCoaches(coaches);
		data.setReferees(referees);
		data.setUnaffiliatedPlayers(unaffiliatedPlayers);
		data.setTeamManagers(teamManagers);
		
		
		//Save the data in the file specified
		String filePath = ("/Users/matthewtomlinson/Library/CloudStorage/OneDrive-Personal/University Year 2/Course work/OOP_CW1/src/LeagueData.txt");
		data.saveData(filePath);
	}

	
	/** 
	* These methods are responsible for getting specified attributes of the League class
	*/
	public ArrayList<Team> getTeams() {
		return teams;
	}

	public ArrayList<Match> getMatches() {
		return matches;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}


	public ArrayList <Coach> getCoaches() {
		return coaches;
	}


	public ArrayList <Referee> getReferees() {
		return referees;
	}
	
	public ArrayList <Player> getUnaffiliatedPlayers(){
		return unaffiliatedPlayers;
	}
	
	public ArrayList <TeamManager> getTeamManagers(){
		return teamManagers;
	}





	
	
	
	
}
