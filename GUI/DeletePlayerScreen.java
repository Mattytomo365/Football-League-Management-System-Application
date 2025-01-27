package GUI;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Accounts.Admin;
import League.League;
import League.Player;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeletePlayerScreen {

	private JFrame frame;
	private JComboBox<String> playerDropdown;
	private JButton deleteButton;
	private League league;

	/**
	 * Constructs DeletePlayerScreen
	 * @param league, the League object that DeletePlayerScreen uses for the drop down, and also passes on
	 */
	public DeletePlayerScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialises the graphical user interface components of the screen
	 */
	private void initialise() {
		
		//Initialises the Delete player JFrame
		frame = new JFrame("Delete player screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("Delete Player");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(128, 33, 175, 30);
		frame.getContentPane().add(lblNewLabel);
		
		//Drop down displaying all the players in the league
		playerDropdown = new JComboBox<String>();
		
		if (league.getPlayers().isEmpty()) {
			playerDropdown.addItem("No players available");
		}
		
		else {
			for (Player player : league.getPlayers()) {
				playerDropdown.addItem(player.getName());
			}
		}
		playerDropdown.setBounds(150, 75, 117, 27);
		frame.getContentPane().add(playerDropdown);
		
		//Delete button
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = playerDropdown.getSelectedIndex();
			    //Get the selected player from the dropdown
			    Player player = league.getPlayers().get(selectedIndex);
			    Admin admin = new Admin(league);
			    admin.deletePlayer(player); //Calls deletePlayer method in the Admin class, passing in the selected player from the dropdown
			}
		});
		deleteButton.setBounds(150, 112, 117, 29);
		frame.getContentPane().add(deleteButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setBounds(6, 237, 59, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}
	


}
