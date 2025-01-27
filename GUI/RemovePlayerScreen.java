package GUI;
import javax.swing.JFrame;
import League.League;
import League.Player;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Accounts.Admin;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemovePlayerScreen {

	private JFrame frame;
	private League league;
	private JComboBox<String> playerDropdown;

	/**
	 * Constructs RemovePlayerScreen
	 * @param league, the League object that RemovePlayerScreen uses for the drop down, and also passes on
	 */
	public RemovePlayerScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialise() {
		//Initialises the Remove Player JFrame
		frame = new JFrame("Remove player screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("Remove Player");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(137, 31, 170, 41);
		frame.getContentPane().add(lblNewLabel);
		
		//Drop down that displays all the affiliated players
		playerDropdown = new JComboBox<String>();
		
		if (league.getPlayers().isEmpty()) {
			playerDropdown.addItem("No players available");
		}
		
		else {
			for (Player player : league.getPlayers()) {
				playerDropdown.addItem(player.getName());
			}
		}
		playerDropdown.setBounds(156, 97, 131, 27);
		frame.getContentPane().add(playerDropdown);
		
		//Remove player button
		JButton removeButton = new JButton("Remove");
		
		removeButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = playerDropdown.getSelectedIndex(); //Gets player selected from the player dropdown
				Player player = league.getPlayers().get(selectedIndex);
				Admin admin = new Admin(league);
				admin.removePlayer(player);
			}
		});
		removeButton.setBounds(156, 153, 131, 29);
		frame.getContentPane().add(removeButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setBounds(0, 237, 69, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}
	
}
