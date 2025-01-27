package GUI;
import javax.swing.JFrame;
import League.League;
import League.Player;
import League.Team;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Accounts.Admin;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AffiliatePlayerScreen {

	private JFrame frame;
	private League league;
	private JComboBox<String> unaffiliatedDropdown;
	private JComboBox<String> teamDropdown;


	/**
	 * Constructs AffiliatePlayerScreen that manages the specified League
	 * @param league, the League object that AffiliatePlayerScreen can manage
	 */
	public AffiliatePlayerScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialises the graphical user interface components of the screen
	 */
	private void initialise() {
		
		//Initialising the Affiliate Player JFrame
		frame = new JFrame("Affiliate player screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("Affiliate Player");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 29, 185, 35);
		frame.getContentPane().add(lblNewLabel);
		
		//Unaffiliated player dropdown
		unaffiliatedDropdown = new JComboBox<String>();
		
		if (league.getUnaffiliatedPlayers().isEmpty()) {
			unaffiliatedDropdown.addItem("No players available");
		}
		
		else {
			for (Player unaffiliatedPlayer : league.getUnaffiliatedPlayers()) {
				unaffiliatedDropdown.addItem(unaffiliatedPlayer.getName()); //Adds all unaffiliated players to dropdown
			}
		}
		unaffiliatedDropdown.setBounds(67, 91, 138, 27);
		frame.getContentPane().add(unaffiliatedDropdown);
		
		//Team dropdown
		teamDropdown = new JComboBox<String>();
		
		if (league.getTeams().isEmpty()) {
			teamDropdown.addItem("No teams available"); //Prevents run-time error
		}
		
		else {
			for (Team team : league.getTeams()) {
				teamDropdown.addItem(team.getName());
			}
		}
		teamDropdown.setBounds(217, 91, 138, 27);
		frame.getContentPane().add(teamDropdown);
		
		//Affiliate button
		JButton affiliateButton = new JButton("Affiliate");
		affiliateButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int playerIndex = unaffiliatedDropdown.getSelectedIndex();
				int teamIndex = teamDropdown.getSelectedIndex();
				
				Player player = league.getUnaffiliatedPlayers().get(playerIndex); //Retrieves selected unaffiliated player
				Team team = league.getTeams().get(teamIndex); //Retrieves selected team
				Admin admin = new Admin(league);
				admin.affiliatePlayer(player, team);
			}
		});
		affiliateButton.setBounds(156, 142, 117, 29);
		frame.getContentPane().add(affiliateButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		backButton.setBounds(6, 237, 65, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}
}
