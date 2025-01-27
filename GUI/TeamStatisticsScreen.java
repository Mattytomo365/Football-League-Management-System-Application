package GUI;
import javax.swing.JFrame;
import League.Team;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeamStatisticsScreen {

	private JFrame frame;


	/**
	 * Constructs TeamStatisticsScreen that displays the certain details of the Team object passed in
	 * @param team, the Team object that TeamStatisticsScreen can display
	 */
	public TeamStatisticsScreen(Team team) {
		initialise(team);
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialise(Team team) {
		
		//Initialise the Team statistics JFrame
		frame = new JFrame("Team statistics screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("Team Statistics");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(120, 30, 199, 36);
		frame.getContentPane().add(lblNewLabel);
		
		//Text area displaying the statistics for the team selected
		JTextArea teamStatistics = new JTextArea();
		teamStatistics.setBounds(83, 69, 270, 169);
		frame.getContentPane().add(teamStatistics);
		
		teamStatistics.setEditable(false);
		teamStatistics.setText(team.getTeamStatistics(team)); //Populates the text area with what is returned from the getTeamStatistics() method in the Team class
		
		JScrollPane scrollPane = new JScrollPane(teamStatistics); //Allows user to scroll
		scrollPane.setBounds(83, 69, 270, 169);
		frame.getContentPane().add(scrollPane);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setBounds(0, 237, 59, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
		
	}
}
