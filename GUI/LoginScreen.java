package GUI;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import League.League;

public class LoginScreen {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JLabel messageLabel;
	private League league;

	/**
	 * Constructs an LoginScreen that handles the process of authenticating an administrative user
	 * @param league
	 */
	public LoginScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialise() {
		
		//Initialise the login screen JFrame
		frame = new JFrame("Login screen");
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Login title at the top of the screen
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(175, 19, 95, 25);
		frame.getContentPane().add(lblNewLabel);
		
		//Username text field
		usernameField = new JTextField();
		usernameField.setText("Username");
		usernameField.setBounds(155, 69, 130, 26);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		//Login button
		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				handleLogin();
			}
		});
		loginButton.setBounds(175, 174, 95, 25);
		frame.getContentPane().add(loginButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setBounds(6, 237, 68, 29);
		frame.getContentPane().add(backButton);
		
		messageLabel = new JLabel("");
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setBounds(104, 147, 234, 25);
		frame.getContentPane().add(messageLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(155, 109, 130, 26);
		frame.getContentPane().add(passwordField);
		
		
		frame.setVisible(true);
	}
	
	/**
	 * This method is responsible for authenticating a user trying to login as an administrative user, by comparing the details entered, to the details stored
	 */
	private void handleLogin() {
		
		//Admin login details
		String adminUsername = "AdminUsername";
		String adminPassword = "AdminPassword";
		
		
		//Entered login details
		String usernameEntered = usernameField.getText();
		String passwordEntered = new String(passwordField.getPassword());
		
		//Checks details entered by user
		if ((usernameEntered.equals(adminUsername)) && (passwordEntered.equals(adminPassword))) {
			messageLabel.setText("Admin login successfull"); //Message which appears if the correct details have been entered
			openAdminFrame();
		}
		
		else {
			messageLabel.setText("Incorrect details, please try again"); //Error message which appears if incorrect details have been entered
		}
		
	}
	
	//Opens the Admin screen
	private void openAdminFrame() {
		new AdminScreen(league); 
	}
	
}
