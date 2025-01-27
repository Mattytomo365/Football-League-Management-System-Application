package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import League.Match;
import League.Player;
import League.Team;
import League.League;

public class ViewerScreen {

	private JFrame frame;
	private League league;
	private JComboBox<String> matchDropdown;
	private JComboBox<String> playerDropdown;
	private JComboBox<String> teamDropdown;

	
	/**
	 * Constructs ViewerScreen
	 * @param league, the League object that ViewerScreen uses for its dropdowns and to pass on to other screens
	 */
	public ViewerScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialise() {
		
		//Initialising the Viewer screen JFrame
		frame = new JFrame("Viewer Screen");
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Welcome title at the top of the screen
		JLabel lblNewLabel = new JLabel("Welcome");
		
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(159, 30, 127, 39);
		frame.getContentPane().add(lblNewLabel);
		
		//Display table button
		JButton leagueTable = new JButton("Display League Table");
		leagueTable.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new LeagueTableScreen(league); //Opens the LeagueTableScreen, passing in the League object
			}
		});
		
		leagueTable.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		leagueTable.setBounds(92, 200, 117, 29);
		frame.getContentPane().add(leagueTable);
		
		//Match drop down box
		matchDropdown = new JComboBox<String>();
		
		if (league.getMatches().isEmpty()) {
			matchDropdown.addItem("No matches available");
		}
		
		else {
			for (Match match : league.getMatches()) {
				matchDropdown.addItem("Week " + match.getWeekPlayed() + ": " + match.getHomeTeam().getName() + " vs. " + match.getAwayTeam().getName());
			}
		}

		matchDropdown.setBounds(221, 81, 117, 27);
		frame.getContentPane().add(matchDropdown);
		
		//Display matches button
		JButton displayMatchButton = new JButton("Display match");
		
		displayMatchButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				openDisplayMatchFrame(); //Calls the openDisplayMatchFrame() method
			}
		});
		displayMatchButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		displayMatchButton.setBounds(221, 122, 117, 29);
		frame.getContentPane().add(displayMatchButton);
		
		//Player drop down box
		playerDropdown = new JComboBox<String>();
		
		if (league.getPlayers().isEmpty()) {
			playerDropdown.addItem("No players available");
		}
		
		else {
			for (Player player : league.getPlayers()) {
				playerDropdown.addItem(player.getName());
			}

		}
		playerDropdown.setBounds(92, 81, 117, 27);
		frame.getContentPane().add(playerDropdown);
		
		//Display player button
		JButton displayPlayerButton = new JButton("Display Assinged Player");
		
		displayPlayerButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				openDisplayPlayerFrame(); //Calls the openDisplayPlayerFrame() method
			}
		});
		
		displayPlayerButton.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		displayPlayerButton.setBounds(92, 122, 117, 29);
		frame.getContentPane().add(displayPlayerButton);
		
		//Login button
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new LoginScreen(league); //Opens the LoginScreen, passing in the League object
			}
		});
		loginButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		loginButton.setBounds(6, 6, 67, 29);
		frame.getContentPane().add(loginButton);
		
		//League statistics button
		JButton leagueStatsButton = new JButton("League Statistics");
		leagueStatsButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new LeagueStatisticsScreen(league); //Opens the LeagueStatisticsScreen, passing in the League object
			}
		});
		leagueStatsButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		leagueStatsButton.setBounds(92, 163, 117, 29);
		frame.getContentPane().add(leagueStatsButton);
		
		//Team statistics button
		JButton teamStatsButton = new JButton("Team Statistics");
		teamStatsButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				openTeamStatisticsFrame(); //Calls the openTeamStatisticsFrame() method
			}
		});
		teamStatsButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		teamStatsButton.setBounds(221, 200, 117, 29);
		frame.getContentPane().add(teamStatsButton);
		
		teamDropdown = new JComboBox<String>();
		
		if (league.getTeams().isEmpty()) {
			teamDropdown.addItem("No teams available");
		}
		
		else {
			for (Team team : league.getTeams()) {
				teamDropdown.addItem(team.getName());
			}
		}
		teamDropdown.setBounds(221, 163, 117, 27);
		frame.getContentPane().add(teamDropdown);
		
		//Combo box labels
		JLabel lblNewLabel_1 = new JLabel("Teams");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(231, 151, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Matches");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(231, 67, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Players");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(102, 66, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		

		
		frame.setVisible(true);
		

	}
	
	//Opens Display Match screen for the match selected
	private void openDisplayMatchFrame() {
		
		int selectedIndex = matchDropdown.getSelectedIndex();
		
		Match selectedMatch = league.getMatches().get(selectedIndex);
		new DisplayMatchScreen(selectedMatch);
	}
	
	//Opens Display Player screen for the player selected
	private void openDisplayPlayerFrame() {
		
		int selectedIndex = playerDropdown.getSelectedIndex();
		
		Player selectedPlayer = league.getPlayers().get(selectedIndex);
		new DisplayPlayerScreen(selectedPlayer);
	}
	 //Opens Team Statistcis Screen for the team selected
	private void openTeamStatisticsFrame() {
		int selectedIndex = teamDropdown.getSelectedIndex();
		
		Team selectedTeam = league.getTeams().get(selectedIndex);
		new TeamStatisticsScreen(selectedTeam);
		
	}
}
