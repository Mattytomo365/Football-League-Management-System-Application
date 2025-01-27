package GUI;
import javax.swing.JFrame;

import League.League;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeagueStatisticsScreen {

	private JFrame frame;
	private League league;


	/**
	 * Constructs LeagueStatisticsScreen that displays the certain details of the League object passed in
	 * @param league, the League object that LeagueStatisticsScreen can display
	 */
	public LeagueStatisticsScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialise() {
		
		//Initialises the League statistics JFrame
		frame = new JFrame("League statistics screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("League Statistics");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(119, 23, 210, 50);
		frame.getContentPane().add(lblNewLabel);
		
		//Text area allowing the league statistics to be displayed to the user
		JTextArea leagueStatistics = new JTextArea();
		leagueStatistics.setBounds(83, 69, 270, 169);
		frame.getContentPane().add(leagueStatistics);
		
		leagueStatistics.setEditable(false); //Ensures the text area is read-only
		leagueStatistics.setText(league.getLeagueStatistics());
		
		JScrollPane scrollPane = new JScrollPane(leagueStatistics); //Allows user to scroll
		scrollPane.setBounds(83, 69, 270, 169);
		frame.getContentPane().add(scrollPane);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setBounds(6, 237, 55, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}
}
