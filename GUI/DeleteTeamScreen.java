package GUI;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Accounts.Admin;
import League.League;
import League.Team;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteTeamScreen {

	private JFrame frame;
	private JComboBox<String> teamDropdown;
	private League league;

	/**
	 * Constructs DeleteTeamScreen
	 * @param league, the League object that DeleteTeamScreen uses for the drop down, and also passes on
	 */
	public DeleteTeamScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialises the graphical user interface components of the screen
	 */ 
	private void initialise() {
		
		//Initialises the Delete team JFrame
		frame = new JFrame("Delete team screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("Delete Team");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(130, 21, 170, 41);
		frame.getContentPane().add(lblNewLabel);
		
		//Drop down listing all teams in the league
		teamDropdown = new JComboBox<String>();
		
		if (league.getTeams().isEmpty()) {
			teamDropdown.addItem("No teams available");
		}
		
		else {
			for (Team team : league.getTeams()) {
				teamDropdown.addItem(team.getName());
			}
		}
		teamDropdown.setBounds(160, 74, 117, 27);
		frame.getContentPane().add(teamDropdown);
		
		//Delete button
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = teamDropdown.getSelectedIndex(); //Gets seleced team from team dropdown
				Team team = league.getTeams().get(selectedIndex);
				Admin admin = new Admin(league);
				admin.deleteTeam(team); //Calls deleteTeam method in Admin class
			}
		});
		deleteButton.setBounds(160, 116, 117, 29);
		frame.getContentPane().add(deleteButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setBounds(0, 237, 58, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}
	

}
