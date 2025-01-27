package League;
import java.util.ArrayList;
import java.io.*;

/**
 * Acts as an interface between the applciations objects (League, Team, Match etc.) and the applications text file (LeagueData.txt)
 */
public class Data {
	
	 private ArrayList<Team> teams;
	 private ArrayList<Match> matches;
	 private ArrayList<Player> players;
	 private ArrayList<Coach> coaches;
	 private ArrayList<Referee> referees;
	 private ArrayList<Goal> goals;
	 private ArrayList<Substitution> substitutions;
	 private ArrayList<Card> cards;
	 private ArrayList<Player> unaffiliatedPlayers;
	 private ArrayList<TeamManager> teamManagers;
	
		/**
		 * Once the constructor is called, all the lists of teams, matches, players etc. are initialised, allowing for them to be populated in the loadData() method
		 */
	 public Data() {
	        this.teams = new ArrayList<>();
	        this.matches = new ArrayList<>();;
	        this.players = new ArrayList<>();;
	        this.coaches = new ArrayList<>();;
	        this.referees = new ArrayList<>();;
	        this.unaffiliatedPlayers = new ArrayList<>();;
	        this.teamManagers = new ArrayList<>();;
	        this.goals = new ArrayList<>();
	        this.substitutions = new ArrayList<>();
	        this.cards = new ArrayList<>();
	    }
	 
	//Finds player using name
	private Player findPlayerByName(String name, ArrayList<Player> players) {
	    for (Player player : players) {
	        if (player.getName().equals(name)) {
	            return player;
	        }
	    }
	    return null; // Return null if player not found
	}
	
	//Finds team using name
	private Team findTeamByName(String name, ArrayList<Team> teams) {
	    for (Team team : teams) {
	        if (team.getName().equals(name)) {
	            return team;
	        }
	    }
	    return null; // Return null if player not found
	}
	
	/**
	 * This method is responsible for populating the array lists of this class, by reading the appropriate data from the specified text file (LeagueData.txt)
	 */
	public void loadData(String filePath) {
		
        // Exception handling
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			
			System.out.println("File reading started for: " + filePath);
            
			//Initialises all of the variables, setting the objects to null and the booleans to false
        	String line;
            boolean inTeamsSection = false;
            boolean inMatchesSection = false;
            boolean inCoachesSection = false;
            boolean inRefereesSection = false;
            boolean inUnaffiliatedSection = false;
            Team currentTeam = null;
            Match currentMatch = null;
            Player currentPlayer = null;
            Coach currentCoach = null;
            Referee currentReferee = null;
            Player currentUnaffiliatedPlayer = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                
                System.out.println("Read line: '" + line + "'");

                //Identifies which section of the text file is currently being read
                if (line.equals("TEAMS")) {
                	System.out.println("Line equals teams");
                    inTeamsSection = true;
                    inMatchesSection = false;
                    inCoachesSection = false;
                    inRefereesSection = false;
                    inUnaffiliatedSection = false;
                    continue;
                } 
                
                else if (line.equals("MATCHES")) {
                	System.out.println("Line equals matches");
                    inTeamsSection = false;
                    inMatchesSection = true;
                    inCoachesSection = false;
                    inRefereesSection = false;
                    inUnaffiliatedSection = false;
                    continue;
                }
                
                else if(line.equals("COACHES")) {
                	System.out.println("Line equals coaches");
                	inTeamsSection = false;
                	inMatchesSection = false;
                	inCoachesSection = true;
                	inRefereesSection = false;
                	inUnaffiliatedSection = false;
                	continue;
                }
                
                else if(line.equals("REFEREES")) {
                	System.out.println("Line equals referees");
                	inTeamsSection = false;
                	inMatchesSection = false;
                	inCoachesSection = false;
                	inRefereesSection = true;
                	inUnaffiliatedSection = false;
                	continue;
                }
                
                else if(line.equals("UNAFFILIATED PLAYERS")) {
                	System.out.println("Line equals unaffiliated players");
                	inTeamsSection = false;
                	inMatchesSection = false;
                	inCoachesSection = false;
                	inRefereesSection = false;
                	inUnaffiliatedSection = true;
                	continue;
                }

                //Processes and populates the team and player objects
                if (inTeamsSection) {
                	
                    if (line.startsWith("Team:")) {
                    	System.out.println("Processing line: " + line);
                        currentTeam = new Team(line.substring(6).trim()); //Retrieving the name from the line using the substring() method
                        teams.add(currentTeam); //Creating a new Team object with, passing in the name read to the constructor of the Team class
                    }
                    
                    else if(line.startsWith("Team Manager:")) {
                    	System.out.println("Processing line: " + line);
                    	TeamManager teamManager = new TeamManager(line.substring(14).trim());
                    	currentTeam.setTeamManager(teamManager);
                    	teamManager.setTeam(currentTeam);
                    	teamManagers.add(teamManager);
                    }
                    
                    else if (line.startsWith("Wins:")) {
                    	System.out.println("Processing line: " + line);
                    	String wins = line.substring(6).trim();
                    	currentTeam.setWins(Integer.parseInt(wins));
                    }
                    
                    else if (line.startsWith("Draws:")) {
                    	System.out.println("Processing line: " + line);
                    	String draws = line.substring(7).trim();
                    	currentTeam.setDraws(Integer.parseInt(draws));
                    }
                    
                    else if (line.startsWith("Losses:")) {
                    	System.out.println("Processing line: " + line);
                    	String losses = line.substring(8).trim();
                    	currentTeam.setLosses(Integer.parseInt(losses));
                    }
                    
                    else if(line.startsWith("Home Ground:")) {
                    	System.out.println("Processing line: " + line);
                    	String stadium = line.substring(12).trim();
                    	Stadium homeGround = new Stadium(stadium);
                    	currentTeam.setHomeGround(homeGround);
                    }
                    
                    else if (line.startsWith("Capacity:")) {
                    	System.out.println("Processing line: " + line);
                    	String capacity = line.substring(10).trim();
                    	int capacityValue = Integer.parseInt(capacity);
                    	currentTeam.getHomeGround().setCapacity(capacityValue);
                    }
                    
                    else if (line.startsWith("Player:")) {
                    	System.out.println("Processing line: " + line);
                    	currentPlayer = new Player(line.substring(8).trim());
                        currentTeam.addPlayer(currentPlayer);
                        players.add(currentPlayer);
                    }
                    
                    else if(line.startsWith("Position:")) {
                    	System.out.println("Processing line: " + line);
                    	currentPlayer.setPosition(line.substring(10).trim());
                    }
                    
                    else if(line.startsWith("Employment Status:")) {
                    	System.out.println("Processing line: " + line);
                    	currentPlayer.setEmploymentStatus(line.substring(19).trim());
                    }
                    
                    else if(line.startsWith("Pay:")) {
                    	System.out.println("Processing line: " + line);
                    	
                        try {
                            String[] parts = line.split(":"); //Picking out the pay value from the line using the split() function
                            if (parts.length == 2) {
                                String pay = parts[1].trim();
                                if (!pay.isEmpty()) {
                                    int payValue = Integer.parseInt(pay);
                                    System.out.println("Pay value parsed: " + pay);
                                    currentPlayer.setPay(payValue);
                                }
                                
                                else {
                                    System.out.println("Pay value is empty in line: " + line);
                                }
                            } 
                            
                            else {
                                System.out.println("Pay line is incorrectly formatted: " + line);
                            }
                            
                        } 
                        
                        catch (NumberFormatException e) {
                            System.out.println("Failed to parse Pay value. Line: " + line);
                        }                 	
                    }
                    
                    else if(line.startsWith("Preferred Formation:")) {
                    	System.out.println("Processing line: " + line);
                    	currentPlayer.setPreferredFormation(line.substring(20).trim());
                    }
                    
                    else if(line.startsWith("Goals:")) {
                    	System.out.println("Processing line: " + line);
                    	String goals = line.substring(6).trim();
                    	int goalsValue = Integer.parseInt(goals);
                    	currentPlayer.setGoalsScored(goalsValue);
                    }
                    
                    else if (line.startsWith("Assists:")) {
                    	System.out.println("Processing line: " + line);
                    	String assists = line.substring(8).trim();
                    	int assistsValue = Integer.parseInt(assists);
                    	currentPlayer.setAssists(assistsValue);
                    }
                    
                    else if (line.startsWith("Cards:")) {
                    	System.out.println("Processing line: " + line);
                    	String cards = line.substring(6).trim();
                    	int cardsValue = Integer.parseInt(cards);
                    	currentPlayer.setCards(cardsValue);
                    }
                }

                // Processes and populates match objects
                else if (inMatchesSection) {
                	
                    if (line.startsWith("Week Played:")) {
                    	System.out.println("Processing line: " + line);
                    	
                        currentMatch = new Match(line.substring(12).trim());
                        matches.add(currentMatch);
                    }
                    
                    else if (line.startsWith("Home Team:")) {
                    	System.out.println("Processing line: " + line);
                    	String homeTeamName = line.substring(10).trim();
                    	Team homeTeam = findTeamByName(homeTeamName, teams);
                    	
                    	if (homeTeam == null) { //If findTeamByName() returns null
                    		System.err.println("Error: Home team not found" + homeTeamName);
                    	}
                    	
                    	currentMatch.setHomeTeam(homeTeam);
                    }
                    
                    else if (line.startsWith("Away Team:")) {
                    	System.out.println("Processing line: " + line);
                    	String awayTeamName = line.substring(10).trim();
                    	Team awayTeam = findTeamByName(awayTeamName, teams);
                    	
                    	if (awayTeam == null) {
                    		System.err.println("Error: Away team not found" + awayTeam);
                    	}
                    	
                    	currentMatch.setAwayTeam(awayTeam);
                    }
                    
                    else if (line.startsWith("Score:")) {
                    	System.out.println("Processing line: " + line);
                    	currentMatch.setScore(line.substring(7).trim());
                    }
                    
                    else if(line.startsWith("Goal Scorers:")) {
                    	System.out.println("Processing line: " + line);
                    	
                    	ArrayList<Goal> goals = new ArrayList<>();
                    	
                    	while((line = reader.readLine()) != null && !line.trim().isEmpty()) {
                    		System.out.println("Reading goal line: " + line);
                            String[] parts = line.split(",");  
                            
                            if (parts.length >= 2) {
                                String scorerName = parts[0].trim();
                                String assistName = parts[1].trim();
                                Player scorer = findPlayerByName(scorerName, players);
                                Player assist = findPlayerByName(assistName, players);

                                if (scorer != null) {
                                    goals.add(new Goal(scorer, assist));
                                } 
                                
                                else {
                                    System.err.println("Scorer not found: " + scorerName);
                                }
                            } 
                            
                            else {
                                System.err.println("Invalid Goal Scorer format: " + line);
                            }
                    	}
                    	
                    	if ((currentMatch.getGoals()) != null) {
                    		
                        	currentMatch.getGoals().clear();
                    	}

                    	currentMatch.setGoals(goals);
                    	
                    }
                    
                    else if (line.startsWith("Substitutions:")) {
                    	System.out.println("Processing line: " + line);
                    	
                    	ArrayList<Substitution> substitutions = new ArrayList<>();
                    	
                    	while((line = reader.readLine()) != null && !line.trim().isEmpty()) {
                    		System.out.println("Reading substitution line: " + line);
                    		String[] parts = line.split(",");
                    		
                    		if (parts.length >= 2) {
                        		String playerInName = parts[0].trim();
                        		String playerOutName = parts[1].trim();
                        		Player playerIn = findPlayerByName(playerInName, players);
                        		Player playerOut = findPlayerByName(playerOutName, players);
                        		
                        		if (playerIn != null) {
                        			substitutions.add(new Substitution(playerIn, playerOut));
                        		}
                        		
                        		else {
                        			System.err.println("Player in not found: " + playerInName);
                        		}
                    		}
                    		
                    		else {
                    			System.err.println("Invalid Substitution format: " + line);
                    		}
                    	}
                    	
                    	if ((currentMatch.getSubstitutions()) != null) {
                    		
                        	currentMatch.getSubstitutions().clear();
                    	}
                    	

                    	currentMatch.setSubstitutions(substitutions);
                    	
                    }
                    
                    else if (line.startsWith("Cards:")) {
                    	System.out.println("Processing line: " + line);
                    	
                    	ArrayList<Card> cards = new ArrayList<>();
                    	
                    	while((line = reader.readLine()) != null && !line.trim().isEmpty()) {
                    		System.out.println("Reading card line" + line);
                    		String[] parts = line.split(",");
                    		
                    		if (parts.length >= 2) {
                        		String playerName = parts[0].trim();
                        		String cardType = parts[1].trim();
                        		Player player = findPlayerByName(playerName, players);
                        		
                        		if (player != null) {
                            		cards.add(new Card(player, cardType));
                        		}
                        		
                        		else {
                        			System.err.println("Player not found: " + playerName);
                        		}
                    		}
                    		
                    		else {
                    			System.err.println("Invalid Card format: " + line);
                    		}

                    	}
                    	
                    	if ((currentMatch.getCards()) != null) {
                    		
                        	currentMatch.getCards().clear();
                    	}
                    	
                    	currentMatch.setCards(cards);
                    	
                    }
                }
                
                //Processes and populates coach objects
                else if (inCoachesSection) {
                	
                	if(line.startsWith("Coach:")) {
                		System.out.println("Processing line: " + line);
                		currentCoach = new Coach(line.substring(6).trim());
                		coaches.add(currentCoach);                		              		
                	}
                	
                	else if(line.startsWith("Team:")) {
                		System.out.println("Processing line: " + line);
                		String teamName = line.substring(5).trim();
                		Team team = findTeamByName(teamName, teams);
                		currentCoach.setTeam(team);
                	}

                	else if(line.startsWith("Employment Status:")) {
                		System.out.println("Processing line: " + line);
                		currentCoach.setEmploymentStatus(line.substring(19).trim());              		
                	}
                	
                	else if(line.startsWith("Pay:")) {
                		System.out.println("Processing line: " + line);
                		String pay = line.substring(4).trim();
                		int payValue = Integer.parseInt(pay);
                		currentCoach.setPay(payValue);
                	}
                }
                
                //Processes and populates referee objects
                else if (inRefereesSection) {
                	
                	if(line.startsWith("Referee:")) {
                		System.out.println("Processing line: " + line);
                		currentReferee = new Referee(line.substring(9).trim());
                		referees.add(currentReferee);
                	}
                	
                	else if(line.startsWith("Employment Status:")) {
                		
                		if (currentReferee == null) {
                			System.err.println("Error : no current referee");
                		}
                		
                		else {
                    		System.out.println("Processing line: " + line);
                    		currentReferee.setEmploymentStatus(line.substring(19).trim());
                		}

                	}
                	
                	else if(line.startsWith("Pay:")) {
                		
                		if (currentReferee == null) {
                			System.err.println("Error : no current referee");
                		}
                		
                		else {
                    		System.out.println("Processing line: " + line);
                    		String pay = line.substring(4).trim();
                    		int payValue = Integer.parseInt(pay);
                    		currentReferee.setPay(payValue);

                		}

                	}
                }
                
                else if(inUnaffiliatedSection) {
                    if (line.startsWith("Player:")) {
                    	System.out.println("Processing line: " + line);
                    	currentUnaffiliatedPlayer = new Player(line.substring(8).trim());
                        unaffiliatedPlayers.add(currentUnaffiliatedPlayer);
                    }
                    
                    else if(line.startsWith("Position:")) {
                    	System.out.println("Processing line: " + line);
                    	currentUnaffiliatedPlayer.setPosition(line.substring(10).trim());
                    }
                    
                    else if(line.startsWith("Employment Status:")) {
                    	System.out.println("Processing line: " + line);
                    	currentUnaffiliatedPlayer.setEmploymentStatus(line.substring(19).trim());
                    }
                    
                    else if(line.startsWith("Pay:")) {
                    	System.out.println("Processing line: " + line);
                    	
                        try {
                            String[] parts = line.split(":");
                            if (parts.length == 2) {
                                String pay = parts[1].trim();
                                if (!pay.isEmpty()) {
                                    int payValue = Integer.parseInt(pay);
                                    System.out.println("Pay value parsed: " + pay);
                                    currentUnaffiliatedPlayer.setPay(payValue);
                                }
                                
                                else {
                                    System.out.println("Pay value is empty in line: " + line);
                                }
                            } 
                            
                            else {
                                System.out.println("Pay line is incorrectly formatted: " + line);
                            }
                            
                        } 
                        
                        catch (NumberFormatException e) {
                            System.out.println("Failed to parse Pay value. Line: " + line);
                        }                 	
                    }
                    
                    else if(line.startsWith("Preferred Formation:")) {
                    	System.out.println("Processing line: " + line);
                    	currentUnaffiliatedPlayer.setPreferredFormation(line.substring(20).trim());
                    }
                    
                    else if(line.startsWith("Goals:")) {
                    	System.out.println("Processing line: " + line);
                    	String goals = line.substring(6).trim();
                    	int goalsValue = Integer.parseInt(goals);
                    	currentUnaffiliatedPlayer.setGoalsScored(goalsValue);
                    }
                    
                    else if (line.startsWith("Assists:")) {
                    	System.out.println("Processing line: " + line);
                    	String assists = line.substring(8).trim();
                    	int assistsValue = Integer.parseInt(assists);
                    	currentUnaffiliatedPlayer.setAssists(assistsValue);
                    }
                    
                    else if (line.startsWith("Cards:")) {
                    	System.out.println("Processing line: " + line);
                    	String cards = line.substring(6).trim();
                    	int cardsValue = Integer.parseInt(cards);
                    	currentUnaffiliatedPlayer.setCards(cardsValue);
                    }
                	
                }
            }  
         }
	
        
        catch (IOException e) {
            System.err.println("Error reading data file: " + e.getMessage());
        }
	}
	
	// Saves the data from the applications objects into the text file
	public void saveData(String filePath) {
		
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            
        	// Populate team and player section
            writer.write("TEAMS\n");
            
            for (Team team : teams) {
                writer.write("Team: " + team.getName() + "\n");
                
                if ((team.getTeamManager() == null)){ //Newly created teams wont have an assigned team manager yet, prevents run-time error
                	writer.write("No team manager yet\n");
                }
                
                else {
                    writer.write("Team Manager: " + team.getTeamManager().getName() + "\n");
                }
                
                writer.write("Wins: " + team.getWins() + "\n");
                writer.write("Draws: " + team.getDraws() + "\n");
                writer.write("Losses: " + team.getLosses() + "\n");
                writer.write("Home Ground: " + team.getHomeGround().getName() + "\n");
                writer.write("Capacity: " + team.getHomeGround().getCapacity() + "\n");
                
                if (!(team.getPlayers().isEmpty())) { //New teams dont have players yet, preventing run-time error
                    for (Player player : team.getPlayers()) {
                        writer.write("\tPlayer: " + player.getName() + "\n");
                        writer.write("\tPosition: " + player.getPosition() + "\n");
                        writer.write("\tEmployment Status: " + player.getEmploymentStatus() + "\n");
                        writer.write("\tPay: " + player.getPay() + "\n");
                        writer.write("\tPreferred Formation: " + player.getPreferredFormation() + "\n");
                        writer.write("\tGoals: " + player.getGoalsScored() + "\n");
                        writer.write("\tAssists: " + player.getAssists() + "\n");
                        writer.write("\tCards: " + player.getCards() + "\n");
                        writer.write("\n");
                        
                    }

                }
                
                else {
                	writer.write("No players yet\n");
                }


                
                writer.write("\n");  // Separates the teams
            }

            // Populates matches section
            writer.write("MATCHES\n");
            
            for (Match match : matches) {
                writer.write("Week Played: " + match.getWeekPlayed() + "\n");
                writer.write("Home Team: " + match.getHomeTeam().getName() + "\n");
                writer.write("Away Team: " + match.getAwayTeam().getName() + "\n");
                writer.write("Score: " + match.getScore() + "\n");
                writer.write("Goal Scorers:\n");
                
                //Write goal scorers and assisters
                for (Goal goals : match.getGoals()) {
                	String scorer = goals.getScorer().getName();
                	Player assistPlayer = goals.getAssist();
                	
                	if ((assistPlayer != null)){
                		writer.write("\t" + scorer + ", " + assistPlayer.getName() + "\n");
                	}
                	
                	else {
                		writer.write("\t" + scorer + "No assister\n");
                	}
                }
                
                writer.write("\n");
                
                writer.write("Substitutions:\n");
                
                for (Substitution substitutions : match.getSubstitutions()) {
                	String playerIn = substitutions.getPlayerIn().getName();
                	String playerOut = substitutions.getPlayerOut().getName();
                	
                	writer.write("\t" + playerIn + ", " + playerOut + "\n");
                }
                
                writer.write("\n");
                
                writer.write("Cards:\n");
                
                for (Card cards : match.getCards()) {
                	String dealtPlayer = cards.getPlayer().getName();
                	String cardType = cards.getType();
                	
                	writer.write("\t" + dealtPlayer + ", " + cardType + "\n");
               }
                
                writer.write("\n");
 
            }
            
            // Populates coaches section
            writer.write("COACHES\n");
            
            for (Coach coach : coaches) {
            	writer.write("Coach: " + coach.getName() + "\n");
            	writer.write("Team: " + coach.getTeam().getName() + "\n");
            	writer.write("Employment Status: " + coach.getEmploymentStatus() + "\n");
            	writer.write("Pay: " + coach.getPay() + "\n");
            	writer.write("\n");
            }
            
            // Populates referees section
            writer.write("REFEREES\n");
            
            if (referees.isEmpty()) {
            	writer.write("No referees available\n");
            }
            
            else {
            	for (Referee referee : referees) {
            	    writer.write("Referee: " + referee.getName() + "\n");
            	    writer.write("Employment Status: " + referee.getEmploymentStatus() + "\n");
            	    writer.write("Pay: " + referee.getPay() + "\n");
            	    writer.write("\n");
            	}
            }
            
            writer.write("UNAFFILIATED PLAYERS\n");
            
            if (!getUnaffiliatedPlayers().isEmpty()) { //This section may be empty, preventing run-time error
                for (Player unaffiliatedPlayer : unaffiliatedPlayers) {
                    writer.write("Player: " + unaffiliatedPlayer.getName() + "\n");
                    writer.write("Position: " + unaffiliatedPlayer.getPosition() + "\n");
                    writer.write("Employment Status: " + unaffiliatedPlayer.getEmploymentStatus() + "\n");
                    writer.write("Pay: " + unaffiliatedPlayer.getPay() + "\n");
                    writer.write("Preferred Formation: " + unaffiliatedPlayer.getPreferredFormation() + "\n");
                    writer.write("Goals: " + unaffiliatedPlayer.getGoalsScored() + "\n");
                    writer.write("Assists: " + unaffiliatedPlayer.getAssists() + "\n");
                    writer.write("Cards: " + unaffiliatedPlayer.getCards() + "\n");
                    writer.write("\n");
                }
            }
            
            else {
            	writer.write("No unaffiliated players\n");
            }
        } 
        
        catch (IOException e) {
            System.err.println("Error writing data file: " + e.getMessage());
        }
		
	}
	/** 
	* These methods are responsible for getting specified attributes of the Data class
	*/
	public ArrayList<Team> getTeams(){
		return teams;
	}
	
	public ArrayList<Match> getMatches(){
		return matches;
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	public ArrayList<Coach> getCoaches(){
		return coaches;
	}
	
	public ArrayList<Referee> getReferees(){
		return referees;
	}
	
	public ArrayList<Goal> getGoals(){
		return goals;
	}
	
	public ArrayList<Substitution> getSubstitutions(){
		return substitutions;
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	public ArrayList<Player> getUnaffiliatedPlayers(){
		return unaffiliatedPlayers;
	}
	
	public ArrayList <TeamManager> getTeamManagers(){
		return teamManagers;
	}
	
	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	public void setMatches(ArrayList<Match> matches) {
		this.matches = matches;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public void setCoaches(ArrayList<Coach> coaches) {
		this.coaches = coaches;
	}
	
	public void setReferees(ArrayList<Referee> referees) {
		this.referees = referees;
	}
	
	public void setUnaffiliatedPlayers(ArrayList<Player> unaffiliatedPlayers) {
		this.unaffiliatedPlayers = unaffiliatedPlayers;
	}
	
	public void setTeamManagers(ArrayList<TeamManager> teamManagers) {
		this.teamManagers = teamManagers;
	}
	
}
