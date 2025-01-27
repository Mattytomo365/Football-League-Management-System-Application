package GUI;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Accounts.Admin;
import League.League;
import League.Referee;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteRefereeScreen {

	private JFrame frame;
	private JComboBox<String> refereeDropdown;
	private League league;

	/**
	 * Constructs DeleteRefereeScreen
	 * @param league, the League object that DeleteRefereeScreen uses for the drop down, and also passes on
	 */
	public DeleteRefereeScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialises the graphical user interface components of the screen
	 */ 
	private void initialise() {
		
		//Initialises the Delete referee JFrame
		frame = new JFrame("Delete referee screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("Delete Referee");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(139, 23, 151, 36);
		frame.getContentPane().add(lblNewLabel);
		
		//Drop down displaying all the referees in the league
		refereeDropdown = new JComboBox<String>();
		
		if (league.getReferees().isEmpty()) {
			refereeDropdown.addItem("No referees available");
		}
		
		else {
			for (Referee referee : league.getReferees()) {
				refereeDropdown.addItem(referee.getName());
			}
		}
		refereeDropdown.setBounds(157, 71, 117, 27);
		frame.getContentPane().add(refereeDropdown);
		
		//Delete button
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = refereeDropdown.getSelectedIndex();
				Referee referee = league.getReferees().get(selectedIndex); //Gets selected referee from referee dropdown
				Admin admin = new Admin(league);
				admin.deleteReferee(referee); //Calls deleteReferee in Admin class, passing in the referee selected from the dropdown
			}
		});
		deleteButton.setBounds(157, 110, 119, 29);
		frame.getContentPane().add(deleteButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setBounds(0, 237, 64, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}
	


}
