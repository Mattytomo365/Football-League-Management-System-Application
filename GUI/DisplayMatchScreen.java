package GUI;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTextArea;
import League.Match;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayMatchScreen {

	private JFrame frame;

	/**
	 * Constructs DisplayMatchScreen that displays the specified match
	 * @param match, the Match object that DisplayMatchScreen can display
	 */
	public DisplayMatchScreen(Match match) {
		initialise(match);
	}

	/**
	 * Initialise the contents of the frame.
	 * Passes in the Match object
	 */
	private void initialise(Match match) {
		
		//Initialises the DisplayMatchScreen JFrame
		frame = new JFrame("Match Details");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("Match Details");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(143, 18, 155, 31);
		frame.getContentPane().add(lblNewLabel);
		
		 //Text area that displays the match details
		JTextArea matchDetailsArea = new JTextArea();
		matchDetailsArea.setBounds(83, 69, 270, 169);
		frame.getContentPane().add(matchDetailsArea);
		
		matchDetailsArea.setEditable(false); //Ensures the text field is read-only
		matchDetailsArea.setText(match.getMatchDetails(match)); //Populate match details by calling the getMatchDetails() method in the Match class and passing in the match selected
		
		JScrollPane scrollPane = new JScrollPane(matchDetailsArea); //Allows user to scroll through the displayed match details
		scrollPane.setBounds(83, 69, 270, 169);
		frame.getContentPane().add(scrollPane);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); //closes current frame
			}
		});
		backButton.setBounds(6, 237, 75, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}
	
}
