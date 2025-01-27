package GUI;


import javax.swing.JFrame;
import League.League;
import League.TeamManager;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Accounts.Admin;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteTeamManagerScreen {

	private JFrame frame;
	private League league;
	private JComboBox <String> teamManagerDropdown;

	/**
	 * Constructs DeleteTeamManagerScreen
	 * @param league, the League object that DeleteTeamManagerScreen uses for the drop down, and also passes on
	 */
	public DeleteTeamManagerScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialises the graphical user interface components of the screen
	 */ 
	private void initialise() {
		
		//Initialises the Delete team manager JFrame
		frame = new JFrame("Delete team manager screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("Delete Team Manager");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(82, 17, 276, 48);
		frame.getContentPane().add(lblNewLabel);
		
		//Drop down displaying all team managers
		teamManagerDropdown = new JComboBox<String>();
		
		if (league.getTeamManagers().isEmpty()) {
			teamManagerDropdown.addItem("No team managers available");
		}
		
		else {
			for (TeamManager teamManager : league.getTeamManagers()) {
				teamManagerDropdown.addItem(teamManager.getName());
			}
		}
		teamManagerDropdown.setBounds(136, 90, 142, 27);
		frame.getContentPane().add(teamManagerDropdown);
		
		//Delete button
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = teamManagerDropdown.getSelectedIndex();
				TeamManager teamManager = league.getTeamManagers().get(selectedIndex); //Gets team manager selected from team manager dropdown
				Admin admin = new Admin(league);
				admin.deleteTeamManager(teamManager); //Calls deleteTeamManager method from Admin class
			}
		});
		deleteButton.setBounds(147, 129, 117, 29);
		frame.getContentPane().add(deleteButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setBounds(6, 237, 54, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}
	


}
