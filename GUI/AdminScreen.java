package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import League.League;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminScreen {

	private JFrame frame;
	private League league;



	/**
	 * Constructs AdminScreen
	 * @param league, the League object that AdminScreen passes on
	 */
	public AdminScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialises the graphical user interface components of the screen
	 */
	private void initialise() {
		
		//Initialising the Admin screen JFrame
		frame = new JFrame("Admin screen");
		frame.setBounds(100, 100, 450, 300); //Set position and size of th frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set default close operation
		frame.getContentPane().setLayout(null); //Use absolute positioning for components
		
		//Welcome title at the top of the screen
		JLabel lblNewLabel = new JLabel("Welcome Admin");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20)); //Set font style and size
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER); //Centre align text
		lblNewLabel.setBounds(125, 16, 206, 32); //Set position and size
		frame.getContentPane().add(lblNewLabel);
		
		//Manage teams button
		JButton manageTeamsButton = new JButton("Manage teams");
		manageTeamsButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new ManageTeamsScreen(league); //Open ManageTeamsScreen, passing in the League object
			}
		});
		manageTeamsButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10)); //Set font size
		manageTeamsButton.setBounds(57, 61, 117, 29); //Set position and size
		frame.getContentPane().add(manageTeamsButton);
		
		//Manage players button
		JButton managePlayersButton = new JButton("Manage players");
		managePlayersButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new ManagePlayersScreen(league); //Open the ManagePlayersScreen, passing in the League object
			}
		});
		managePlayersButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10)); //Set font size
		managePlayersButton.setBounds(175, 61, 117, 29); //Set position and size
		frame.getContentPane().add(managePlayersButton);
		
		//Manage managers button
		JButton manageManagersButton = new JButton("Manage managers");
		manageManagersButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new ManageManagersScreen(league); //Open the ManageManagersScreen, passing in the League object
			}
		});
		manageManagersButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10)); //Set font size
		manageManagersButton.setBounds(293, 60, 117, 29); //Set position and size
		frame.getContentPane().add(manageManagersButton);
		
		//Manage coaches button
		JButton manageCoachesButton = new JButton("Manage coaches");
		manageCoachesButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new ManageCoachesScreen(league); //Open the ManageCoachesScreen, passing in the League object
			}
		});
		manageCoachesButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10)); //Set font size
		manageCoachesButton.setBounds(57, 111, 117, 29); //Set position and size
		frame.getContentPane().add(manageCoachesButton);
		
		//Manage referees button
		JButton manageRefereesButton = new JButton("Manage referees");
		manageRefereesButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new ManageRefereesScreen(league); //Open the ManageRefereesScreen, passing in the League object
			}
		});
		manageRefereesButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10)); //Set font size
		manageRefereesButton.setBounds(175, 110, 117, 29); //Set position and size
		frame.getContentPane().add(manageRefereesButton);
		
		//Record match button
		JButton recordMatchButton = new JButton("Record match");
		recordMatchButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new RecordMatchScreen(league); //Open the RecordMatchScreen, passing in the League object
			}
		});
		recordMatchButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10)); //Set font size
		recordMatchButton.setBounds(293, 110, 117, 29); //Set position and size
		frame.getContentPane().add(recordMatchButton);
		
		//Back button to return to previous screen
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); //Hide current frame
			}
		});
		backButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10)); //Set font size
		backButton.setBounds(6, 237, 63, 29); //Set position and size
		frame.getContentPane().add(backButton);
		
		//Make the frame visible after all components have been added
		frame.setVisible(true);
		
	}
}
