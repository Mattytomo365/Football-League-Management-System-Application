package GUI;
import javax.swing.JFrame;


import League.League;
import League.Team;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class LeagueTableScreen {

	private JFrame frame;
	private League league;
	private JTable table;

	/**
	 * Constructs LeagueTableScreen that displays the certain details of the League object passed in
	 * @param league, the League object that LeagueTableScreen can display
	 */
	public LeagueTableScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialise() {
		
		//Initialises the League table JFrame
		frame = new JFrame("League table screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("League Table");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(127, 10, 186, 41);
		frame.getContentPane().add(lblNewLabel);
		
		//Table that displays the league table
		String[] columnNames = { "Posititon", "Team", "Played", "Wins", "Draws", "Losses" };
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);
		table.setBounds(49, 63, 348, 157);
		frame.getContentPane().add(table);
		
		//Populate league table
		populateTable(tableModel);
		
        // Add the table inside a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(49, 63, 348, 157);
        frame.getContentPane().add(scrollPane);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setBounds(0, 240, 59, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}
	
	/**
	 * This method is responsible for populating the league table by retrieving certain details from the League object, sorting, then displaying them in a table model provided
	 */
	private void populateTable(DefaultTableModel tableModel) {
		List<Team> teams = league.getTeams(); //Gathers a list of all the Teams currently stored in the League object
		
		//Sorts the positions in the league table based of each team's number of wins
		teams.sort((t1, t2) -> Integer.compare(t2.getWins(), t1.getWins()));
		
		int position = 1;
		
		for (Team team : teams) {
			int played = team.getWins() + team.getDraws() + team.getLosses();
			
            // Add each team's data as a row in the table
            tableModel.addRow(new Object[] {
                position++, // Position in the league
                team.getName(), // Team name
                played, // Matches played
                team.getWins(), // Wins
                team.getDraws(), // Draws
                team.getLosses(), // Losses
            });
		}
		
		
	}
}
