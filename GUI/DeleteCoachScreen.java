package GUI;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Accounts.Admin;
import League.Coach;
import League.League;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteCoachScreen {

	private JFrame frame;
	private JComboBox<String> coachDropdown;
	private League league;

	/**
	 * Constructs DeleteCoachScreen
	 * @param league, the League object that DeleteCoachScreen uses for the drop down, and also passes on
	 */
	public DeleteCoachScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialises the graphical user interface components of the screen
	 */
	private void initialise() {
		
		//Initialises the Delete coach JFrame
		frame = new JFrame("Delete coach screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("Delete Coach");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(143, 29, 153, 31);
		frame.getContentPane().add(lblNewLabel);
		
		//Drop down displaying all the coaches in the league
		coachDropdown = new JComboBox<String>();
		
		if (league.getCoaches().isEmpty()) {
			coachDropdown.addItem("No coaches available");
		}
		
		else {
			for (Coach coach : league.getCoaches()) {
				coachDropdown.addItem(coach.getName());
			}
		}
		coachDropdown.setBounds(168, 72, 113, 27);
		frame.getContentPane().add(coachDropdown);
		
		//Delete button
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = coachDropdown.getSelectedIndex();
				Coach coach = league.getCoaches().get(selectedIndex); //Gets coach selected from the coach dropdown
				Admin admin = new Admin(league);
				admin.deleteCoach(coach); //Calls deleteCoach method from Admin class
			}
		});
		deleteButton.setBounds(164, 111, 117, 29);
		frame.getContentPane().add(deleteButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setBounds(6, 237, 61, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}

}
