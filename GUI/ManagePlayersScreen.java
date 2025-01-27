package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import League.League;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagePlayersScreen {

	private JFrame frame;
	private League league;

	/**
	 * Constructs an ManagePlayersScreen that is responsible for opening CreatePlayerScreen, DeletePlayerScreen, AffiliatePlayerScreen, or RemovePlayerScreen
	 * @param league, the League object that ManagePlayersScreen passes on
	 */
	public ManagePlayersScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialise() {
		
		//Initialises the admin's version of the Manage player JFrame
		frame = new JFrame("Manage player screen (Admin)");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("What would you like to do?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(75, 30, 282, 25);
		frame.getContentPane().add(lblNewLabel);
		
		//Create player button
		JButton createPlayerButton = new JButton("Create player");
		createPlayerButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new CreatePlayerScreen(league);
			}
		});
		createPlayerButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		createPlayerButton.setBounds(85, 75, 117, 29);
		frame.getContentPane().add(createPlayerButton);
		
		//Delete player button
		JButton deletePlayerButton = new JButton("Delete player");
		deletePlayerButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new DeletePlayerScreen(league);
			}
		});
		deletePlayerButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		deletePlayerButton.setBounds(225, 75, 117, 29);
		frame.getContentPane().add(deletePlayerButton);
		
		//Affiliate player button
		JButton affiliatePlayerButton = new JButton("Affiliate player");
		affiliatePlayerButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new AffiliatePlayerScreen(league);
			}
		});
		affiliatePlayerButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		affiliatePlayerButton.setBounds(85, 116, 117, 29);
		frame.getContentPane().add(affiliatePlayerButton);
		
		//Remove player button
		JButton removePlayerButton = new JButton("Remove player");
		removePlayerButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new RemovePlayerScreen(league);
			}
		});
		removePlayerButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		removePlayerButton.setBounds(225, 116, 117, 29);
		frame.getContentPane().add(removePlayerButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		backButton.setBounds(6, 237, 61, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}

}
