package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import League.Player;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayPlayerScreen {

	private JFrame frame;

	/**
	 * Constructs DisplayPlayerScreen that displays the specified player
	 * @param player, the Player object that DisplayPlayerScreen can display
	 */
	public DisplayPlayerScreen(Player player) {
		initialise(player);
	}

	/**
	 * Initialise the contents of the frame
	 * Passes in the Player object
	 */
	private void initialise(Player player) {
		
		//Initialises the DisplayPlayerScreen JFrame
		frame = new JFrame("Display player screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("Player Profile");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(137, 24, 162, 33);
		frame.getContentPane().add(lblNewLabel);
		
		//Text area that displays the details of the player selected from the dropdown in ViewerScreen
		JTextArea playerProfileArea = new JTextArea();
		playerProfileArea.setBounds(83, 69, 270, 169);
		frame.getContentPane().add(playerProfileArea);
		
		playerProfileArea.setEditable(false); //Ensures the text field is read-only
		playerProfileArea.setText(player.getPlayerDetails(player)); //Calls the getPlayerDetails() method in the Player class, passing in the player selected
		
		JScrollPane scrollPane = new JScrollPane(playerProfileArea); //Allows user to scroll through the player profile
		scrollPane.setBounds(83, 69, 270, 169);
		frame.getContentPane().add(scrollPane);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setBounds(6, 237, 57, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}
}
