package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import League.League;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageCoachesScreen {

	private JFrame frame;
	private League league;
	
	/**
	 * Constructs an ManageCoachesScreen that is responsible for opening CreateCoachesScreen or DeleteCoachScreen
	 * @param league, the League object that ManageCoachesScreen passes on
	 */
	public ManageCoachesScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialise() {
		
		//Initialises the Manage coaches JFrame
		frame = new JFrame("Manage coaches screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("What would you like to do?");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(62, 24, 330, 46);
		frame.getContentPane().add(lblNewLabel);
		
		//Create coach button
		JButton createCoachButton = new JButton("Create coach");
		createCoachButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new CreateCoachScreen(league);
			}
		});
		createCoachButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		createCoachButton.setBounds(104, 82, 117, 29);
		frame.getContentPane().add(createCoachButton);
		
		//Delete coach button
		JButton deleteCoachButton = new JButton("Delete coach");
		deleteCoachButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new DeleteCoachScreen(league);
			}
		});
		deleteCoachButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		deleteCoachButton.setBounds(223, 81, 117, 29);
		frame.getContentPane().add(deleteCoachButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		backButton.setBounds(6, 237, 63, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}

}
