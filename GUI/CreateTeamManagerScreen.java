package GUI;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Accounts.Admin;
import League.League;
import League.Team;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CreateTeamManagerScreen {

	private JFrame frame;
	private JTextField txtName;
	private JComboBox<String> teamDropdown;
	private League league;
	private ArrayList<Team> noManagerTeam;

	/**
	 * Constructs CreateTeamManagerScreen
	 * @param league, the League object that CreateTeamManagerScreen passes on
	 * Initialises the Array list of Teams, named noManagerTeam
	 */
	public CreateTeamManagerScreen(League league) {
		this.league = league;
		this.noManagerTeam = new ArrayList<>();
		initialise();
	}

	/**
	 * Initialises the graphical user interface components of the screen
	 */
	private void initialise() {
		
		//Initialises the Create team manager JFrame
		frame = new JFrame("Create team manager screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("Create Team Manager");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(86, 18, 261, 48);
		frame.getContentPane().add(lblNewLabel);
		
		//Text box allowing the admin to enter the name of the new team manager
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(62, 90, 130, 26);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		//Drop down displaying all teams without a team manager
		teamDropdown = new JComboBox<String>();
		
		if (league.getTeams().isEmpty()) {
			teamDropdown.addItem("No teams available");
		}
		
		else {
			for (Team team : league.getTeams()) {
				if(team.getTeamManager() == null) { //Teams can only have 1 manager, so the dropdown will only display teams with no assinged manager
					teamDropdown.addItem(team.getName());
					noManagerTeam.add(team);
				}
			}
		}
		teamDropdown.setBounds(229, 91, 130, 27);
		frame.getContentPane().add(teamDropdown);
		
		//Create button
		JButton createButton = new JButton("Create");
		createButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					String name = txtName.getText();
					
			        // Input Validation
			        if (name.isEmpty()) {
			            JOptionPane.showMessageDialog(frame, "Name field must be filled.", "Input Error", JOptionPane.ERROR_MESSAGE);
			            return;
			        }
			        
		            // Validate that the name only contains letters and spaces
		            if (!name.matches("[a-zA-Z ]+")) {
		                JOptionPane.showMessageDialog(frame, "Name must contain only letters and spaces.", "Input Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }
		            
					int index = teamDropdown.getSelectedIndex();
					
					Team team = noManagerTeam.get(index);
					Admin admin = new Admin(league);
					admin.createTeamManager(name, team); //calling createTeamManager method in the Admin class
				
		    } 
				
			catch (Exception ex) {
		        JOptionPane.showMessageDialog(frame, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		    }

			}
		});
		createButton.setBounds(149, 141, 117, 29);
		frame.getContentPane().add(createButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setBounds(0, 237, 63, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}
}
