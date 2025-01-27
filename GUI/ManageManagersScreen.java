package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import League.League;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageManagersScreen {

	private JFrame frame;
	private League league;

	/**
	 * Constructs an ManageManagersScreen that is responsible for opening CreateTeamManagerScreen or DeleteTeamManagerScreen
	 * @param league, the League object that ManageManagersScreen passes on
	 */
	public ManageManagersScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialise() {
		
		//Initialises the Manage managers JFrame
		frame = new JFrame("Manage managers screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("What would you like to do?");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(96, 25, 264, 34);
		frame.getContentPane().add(lblNewLabel);
		
		//Create manager button
		JButton createManagerButton = new JButton("Create manager");
		createManagerButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new CreateTeamManagerScreen(league);
			}
		});
		createManagerButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		createManagerButton.setBounds(106, 71, 117, 29);
		frame.getContentPane().add(createManagerButton);
		
		//Delete manager button
		JButton deleteManagerButton = new JButton("Delete manager");
		deleteManagerButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new DeleteTeamManagerScreen(league);
			}
		});
		deleteManagerButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		deleteManagerButton.setBounds(235, 71, 117, 29);
		frame.getContentPane().add(deleteManagerButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		backButton.setBounds(6, 237, 62, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}

}
