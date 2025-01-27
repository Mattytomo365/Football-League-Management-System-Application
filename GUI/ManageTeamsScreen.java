package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import League.League;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageTeamsScreen {

	private JFrame frame;
	private League league;

	/**
	 * Constructs an ManageTeamsScreen that is responsible for opening CreateTeamScreen or DeleteTeamScreen
	 * @param league, the League object that ManageTeamsScreen passes on
	 */
	public ManageTeamsScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialise() {
		
		//Initialises the Manage teams JFrame
		frame = new JFrame("Manage teams screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("What would you like to do?");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(78, 17, 289, 41);
		frame.getContentPane().add(lblNewLabel);
		
		//Create team button
		JButton createTeamButton = new JButton("Create team");
		createTeamButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new CreateTeamScreen(league);
			}
		});
		createTeamButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		createTeamButton.setBounds(88, 70, 117, 29);
		frame.getContentPane().add(createTeamButton);
		
		//Delete team button
		JButton deleteTeamButton = new JButton("Delete team");
		deleteTeamButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new DeleteTeamScreen(league);
			}
		});
		deleteTeamButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		deleteTeamButton.setBounds(227, 69, 117, 29);
		frame.getContentPane().add(deleteTeamButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		backButton.setBounds(6, 237, 68, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}

}
