package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import League.League;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageRefereesScreen {

	private JFrame frame;
	private League league;

	/**
	 * Constructs an ManageRefereesScreen that is responsible for opening CreateRefereeScreen or DeleteRefereeScreen
	 * @param league, the League object that ManageRefereesScreen passes on
	 */
	public ManageRefereesScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialise() {
		
		//Intialises the Manage referees JFrame
		frame = new JFrame("Manage referees screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("What would you like to do?");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(84, 32, 283, 31);
		frame.getContentPane().add(lblNewLabel);
		
		//Create referee button
		JButton createRefereeButton = new JButton("Create referee");
		createRefereeButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new CreateRefereeScreen(league);
			}
		});
		createRefereeButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		createRefereeButton.setBounds(94, 75, 117, 29);
		frame.getContentPane().add(createRefereeButton);
		
		//Delete referee button
		JButton deleteRefereeButton = new JButton("Delete referee");
		deleteRefereeButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new DeleteRefereeScreen(league);
			}
		});
		deleteRefereeButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		deleteRefereeButton.setBounds(228, 74, 117, 29);
		frame.getContentPane().add(deleteRefereeButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		backButton.setBounds(0, 237, 66, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}

}
