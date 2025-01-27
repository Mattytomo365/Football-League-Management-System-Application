package GUI;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import League.Card;
import League.Data;
import League.Goal;
import League.League;
import League.Match;
import League.Player;
import League.Substitution;
import League.Team;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RecordMatchScreen {

	private JFrame frame;
	private JTextField txtWeekPlayed;
	private JTextField txtHomeTeam;
	private JTextField txtAwayTeam;
	private JTextField txtScore;
	private JTextField txtScorers;
	private JTextField txtSubstitutions;
	private JTextField txtCards;
	private League league;

	/**
	 * Constructs RecordMatchScreen 
	 * @param league, the League object that RecordMatchScreen passes on
	 */
	public RecordMatchScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialise() {
		
		//Initialises the Record match JFrame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("Record Match");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(141, 26, 160, 25);
		frame.getContentPane().add(lblNewLabel);
		
		//Text box allowing admin and managers to enter the week which the match was played
		txtWeekPlayed = new JTextField();
		txtWeekPlayed.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtWeekPlayed.setText("Week played");
		txtWeekPlayed.setBounds(79, 63, 130, 26);
		frame.getContentPane().add(txtWeekPlayed);
		txtWeekPlayed.setColumns(10);
		
		//Text box allowing admin and managers to enter the home team of the match
		txtHomeTeam = new JTextField();
		txtHomeTeam.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtHomeTeam.setText("Home team");
		txtHomeTeam.setBounds(222, 63, 130, 26);
		frame.getContentPane().add(txtHomeTeam);
		txtHomeTeam.setColumns(10);
		
		//Text box allowing admin and managers to enter the away team of the match
		txtAwayTeam = new JTextField();
		txtAwayTeam.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtAwayTeam.setText("Away team");
		txtAwayTeam.setBounds(222, 101, 130, 26);
		frame.getContentPane().add(txtAwayTeam);
		txtAwayTeam.setColumns(10);
		
		//Text box allowing admin and managers to enter the score of the match
		txtScore = new JTextField();
		txtScore.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtScore.setText("Score");
		txtScore.setBounds(79, 101, 130, 26);
		frame.getContentPane().add(txtScore);
		txtScore.setColumns(10);
		
		//Text box allowing admin and managers to enter the scorers and assisters of the match
		txtScorers = new JTextField();
		txtScorers.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtScorers.setText("Scorers(Scorer, Assister)");
		txtScorers.setBounds(79, 139, 130, 26);
		frame.getContentPane().add(txtScorers);
		txtScorers.setColumns(10);
		
		//Text box allowing admin and managers to enter the substitutions of the match
		txtSubstitutions = new JTextField();
		txtSubstitutions.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtSubstitutions.setText("Substitutions(out,in)");
		txtSubstitutions.setBounds(222, 139, 130, 26);
		frame.getContentPane().add(txtSubstitutions);
		txtSubstitutions.setColumns(10);
		
		//Text box allowing admin and managers to enter the cards handed out in the match
		txtCards = new JTextField();
		txtCards.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtCards.setText("Cards(player,type)");
		txtCards.setBounds(79, 177, 130, 26);
		frame.getContentPane().add(txtCards);
		txtCards.setColumns(10);
		
		//Save button
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				matchValidation();
			}
		});
		saveButton.setBounds(222, 175, 117, 29);
		frame.getContentPane().add(saveButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		backButton.setBounds(6, 237, 75, 29);
		frame.getContentPane().add(backButton);
		
		JLabel lblNewLabel_1 = new JLabel("Please separate every goal, substitution and card with ;");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblNewLabel_1.setBounds(89, 215, 268, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		frame.setVisible(true);
	}
	
	//Finds player using name passed in
	private Player findPlayerByName(String name, ArrayList<Player> players) {
	    for (Player player : players) {
	        if (player.getName().toLowerCase().contains(name.toLowerCase())) { //Case-insensitive match
	            return player;
	        }
	    }
	    return null; //Return null if player not found
	}
	
	//Finds team using name passed in
	private Team findTeamByName(String name, ArrayList<Team> teams) {
	    for (Team team : teams) {
	        if (team.getName().equals(name)) {
	            return team;
	        }
	    }
	    return null; //Return null if player not found
	}
	
	/**
	 * This method is responsible for validating the details entered on the RecordMatchScreen
	 */
	private void matchValidation() {
		try {
			/**
			 * Gathers everything entered into the text fields
			 */
			String weekPlayed = txtWeekPlayed.getText();
			String homeTeamName = txtHomeTeam.getText();
			String awayTeamName = txtAwayTeam.getText();
			String score = txtScore.getText();
			String goal = txtScorers.getText();
			String substitution = txtSubstitutions.getText();
			String card = txtCards.getText();
			
	        // Input Validation
	        if (weekPlayed.isEmpty() || homeTeamName.isEmpty() || awayTeamName.isEmpty() || score.isEmpty()) {
	            JOptionPane.showMessageDialog(frame, "Week played, home team, away team, and score fields must be filled.", "Input Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
            // Validate that necessary fields only contains letters and spaces
            if (!weekPlayed.matches("[a-zA-Z ]+") || !homeTeamName.matches("[a-zA-Z ]+") || !awayTeamName.matches("[a-zA-Z ]+") || !goal.matches("[a-zA-Z ]+") || !substitution.matches("[a-zA-Z ]+")|| !card.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(frame, "Invalid details.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
			
			recordMatch(weekPlayed, homeTeamName, awayTeamName, score, goal, substitution, card);
		}
		
		catch (Exception ex) {
	        JOptionPane.showMessageDialog(frame, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	/**
	 * This method is responsible for creating a new Match, using the details entered in the text fields
	 */
	private void recordMatch(String weekPlayed, String homeTeamName, String awayTeamName, String score, String goal, String substitution, String card) {
	
		//Home and away team input validation
		if (findTeamByName(homeTeamName, league.getTeams()) == null) { //if the findTeamByName() method returns null, meaning no team is found with the name entered
			JOptionPane.showMessageDialog(frame, "Home team not found.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
		}

		
		if (findTeamByName(awayTeamName, league.getTeams()) == null) {
			JOptionPane.showMessageDialog(frame, "Away team not found.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
		}
		
		Team homeTeam = findTeamByName(homeTeamName, league.getTeams());
		Team awayTeam = findTeamByName(awayTeamName, league.getTeams());

		
		ArrayList<Goal> goals = new ArrayList<>();
		
		String[] goalPairs = goal.split(";"); //Splits each goal, assister pair by using the split() function
		
		for (String goalPair : goalPairs) {
			String[] scorerAssister = goalPair.split(", "); //Splits each individual goal into scorer and assister using the split() function
			
			if (scorerAssister.length >= 2) {
				String scorerName = scorerAssister[0].trim();
				String assisterName = scorerAssister[1].trim();
				
				Player scorer = findPlayerByName(scorerName, league.getPlayers()); //Finds the player in League's list of Players using the player's name
				scorer.addGoal(); //Increments goal count on player profile
				Player assister = findPlayerByName(assisterName, league.getPlayers());
				assister.addAssist(); //Increments assist count on player profile
				
				goals.add(new Goal(scorer, assister)); //Adding the goal, to the Array list of type Goal
			}
			
			else {
				System.err.println("Invalid Goal-Assist format: " + goalPair);		
				
			}
		}
		
		
		String[] substitutionsSplit = substitution.split(",");
		
		if ((substitutionsSplit.length % 2) != 0) {
			System.out.println("Invalid input, substitutions must have a player in and player out");
		}
		
		ArrayList<Substitution> substitutions = new ArrayList<>();
		
		String[] substitutionPairs = substitution.split(";");
		
		for (String substitutionPair : substitutionPairs) {
			String[] playerInPlayerOut = substitutionPair.split(", ");
			
			if (playerInPlayerOut.length >= 2) { //Ensuring that the substitution read doesnt have more than 2 parts
				String playerInName = playerInPlayerOut[0].trim();
				String playerOutName = playerInPlayerOut[1].trim();
				
				Player playerIn = findPlayerByName(playerInName, league.getPlayers()); //Matching player name to the list of Player's in League
				Player playerOut = findPlayerByName(playerOutName, league.getPlayers()); 
				
				if (playerIn != null) {
					substitutions.add(new Substitution(playerIn, playerOut)); //Adding substitution to Array list of type Substitution
				}
				
				else {
					System.err.println("Player in not found: " + playerInName);
				}
			}
			
			else {
				System.err.println("Invalid player in, player out format: " + substitutionPair);		
				
			}
		}
		
		ArrayList<Card> cards = new ArrayList<>();
		
		String[] cardPairs = card.split(";");
		
		for (String cardPair : cardPairs) {
			String[] playerCardType = cardPair.split(", ");
			
			if (playerCardType.length >= 2) {
				String dealtPlayerName = playerCardType[0].trim();
				String cardType = playerCardType[1].trim();
				
				Player dealtPlayer = findPlayerByName(dealtPlayerName, league.getPlayers());
				dealtPlayer.addCard(); //Increments card count on player profile
				
				cards.add(new Card(dealtPlayer, cardType));
			}
			
			else {
				System.err.println("Invalid player, card type format : " + cardPair);		
				
			}
		}
		
			String[] parts = score.split("-"); //Splits the score into the score of each team, using the split() function
			String homeScore = parts[0].trim();
			String awayScore = parts[1].trim();
			int homeScoreValue = Integer.parseInt(homeScore);
			int awayScoreValue = Integer.parseInt(awayScore);
			
			//Manages teams wins, draws, and losses depending on the score of the new match
			if (homeScoreValue > awayScoreValue) {
				homeTeam.addWin(); 
				awayTeam.addLoss();
			}
			
			else if (homeScoreValue < awayScoreValue) {
				awayTeam.addWin();
				homeTeam.addLoss();
			}
			
			else if (homeScoreValue == awayScoreValue) {
				homeTeam.addDraw();
				awayTeam.addDraw();
			}
			
			//CREATES NEW MATCH
			
			Match newMatch = new Match(weekPlayed);
			/**
			 * Sets the attributes of the new Match using the array lists and variables from earlier
			 */
			newMatch.setHomeTeam(homeTeam);
			newMatch.setAwayTeam(awayTeam);
			newMatch.setScore(score);
			newMatch.setGoals(goals);
			newMatch.setSubstitutions(substitutions);
			newMatch.setCards(cards);
			
			league.getMatches().add(newMatch); //Adds the new Match to League's list of matches
			
			//Initialise the Data class, and ensures League's state is mirrored in it
			Data data = new Data();
			data.setTeams(league.getTeams());
			data.setMatches(league.getMatches());
			data.setPlayers(league.getPlayers());
			data.setCoaches(league.getCoaches());
			data.setReferees(league.getReferees());
			data.setUnaffiliatedPlayers(league.getUnaffiliatedPlayers());
			data.setTeamManagers(league.getTeamManagers());
			
			
			//Save the data in the file specified
			String filePath = ("/Users/matthewtomlinson/Library/CloudStorage/OneDrive-Personal/University Year 2/Course work/OOP_CW1/src/LeagueData.txt");
			data.saveData(filePath);
			
		}
	}


