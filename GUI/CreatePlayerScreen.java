package GUI;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Accounts.Admin;
import League.League;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreatePlayerScreen {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtEmploymentStatus;
	private JTextField txtPosition;
	private JTextField txtTotalGoals;
	private JTextField txtTotalAssists;
	private JTextField txtTotalCards;
	private JTextField txtPreferredFormation;
	private JTextField txtPay;
	private League league;

	/**
	 * Constructs CreatePlayerScreen 
	 * @param league, the League object that CreatePlayerScreen passes on
	 */
	public CreatePlayerScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialises the graphical user interface components of the screen
	 */
	private void initialise() {
		
		//Initialises the Create player JFrame
		frame = new JFrame("Create player screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("Create Player");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(135, 26, 173, 37);
		frame.getContentPane().add(lblNewLabel);
		
		//Text box allowing the admin to enter the name of the new player
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(81, 64, 130, 26);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		//Text box allowing the admin to enter the employment status of the new player
		txtEmploymentStatus = new JTextField();
		txtEmploymentStatus.setText("Employment Status");
		txtEmploymentStatus.setBounds(223, 64, 137, 26);
		frame.getContentPane().add(txtEmploymentStatus);
		txtEmploymentStatus.setColumns(10);
		
		//Text box allowing the admin to enter the position of the new player
		txtPosition = new JTextField();
		txtPosition.setText("Position");
		txtPosition.setBounds(81, 102, 130, 26);
		frame.getContentPane().add(txtPosition);
		txtPosition.setColumns(10);
		
		//Text box allowing the admin to enter the total goals of the new player
		txtTotalGoals = new JTextField();
		txtTotalGoals.setText("Total Goals");
		txtTotalGoals.setBounds(81, 140, 130, 26);
		frame.getContentPane().add(txtTotalGoals);
		txtTotalGoals.setColumns(10);
		
		//Text box allowing the admin to enter the total assists of the new player
		txtTotalAssists = new JTextField();
		txtTotalAssists.setText("Total Assists");
		txtTotalAssists.setBounds(223, 102, 137, 26);
		frame.getContentPane().add(txtTotalAssists);
		txtTotalAssists.setColumns(10);
		
		//Text box allowing the admin to enter the total cards of the new player
		txtTotalCards = new JTextField();
		txtTotalCards.setText("Total Cards");
		txtTotalCards.setBounds(223, 140, 130, 26);
		frame.getContentPane().add(txtTotalCards);
		txtTotalCards.setColumns(10);
		
		//Text box allowing the admin to enter the preferred formation of the new player
		txtPreferredFormation = new JTextField();
		txtPreferredFormation.setText("Preferred Formation");
		txtPreferredFormation.setBounds(223, 178, 137, 26);
		frame.getContentPane().add(txtPreferredFormation);
		txtPreferredFormation.setColumns(10);
		
		//Text box allowing the admin to enter the pay of the new player
		txtPay = new JTextField();
		txtPay.setText("Pay");
		txtPay.setBounds(81, 178, 130, 26);
		frame.getContentPane().add(txtPay);
		txtPay.setColumns(10);
		
		//Add player button
		JButton addPlayerButton = new JButton("Add Player");
		addPlayerButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					/**
					 * Retrieves text entered into the text fields
					 */
					String name = txtName.getText(); 
					String employmentStatus = txtEmploymentStatus.getText(); 
					String position = txtPosition.getText();
					String goals = txtTotalGoals.getText();
					String assists = txtTotalAssists.getText();
					String cards = txtTotalCards.getText();
					String payInput = txtPay.getText();
					String preferredFormation = txtPreferredFormation.getText();
					
			        // Input Validation
			        if (name.isEmpty() || employmentStatus.isEmpty() || position.isEmpty() || goals.isEmpty() || assists.isEmpty() || cards.isEmpty() || payInput.isEmpty() || preferredFormation.isEmpty()) {
			            JOptionPane.showMessageDialog(frame, "All fields must be filled.", "Input Error", JOptionPane.ERROR_MESSAGE);
			            return;
			        }
					
		            // Validate that necessary fields only contains letters and spaces
		            if (!name.matches("[a-zA-Z ]+") || !employmentStatus.matches("[a-zA-Z ]+") || !position.matches("[a-zA-Z ]+") || !preferredFormation.matches("[a-zA-Z ]+")) {
		                JOptionPane.showMessageDialog(frame, "Invalid details.", "Input Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }
		            
		         // Validate that necessary fields only contain only numbers
		            if (!payInput.matches("\\d+") || !goals.matches("\\d+") || !assists.matches("\\d+") || !cards.matches("\\d+")) { // Ensures pay contains only digits
		                JOptionPane.showMessageDialog(frame, "Invalid details.", "Input Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }
		            
			        int pay = Integer.parseInt(payInput);
			        
			        if (pay < 0) {
			            JOptionPane.showMessageDialog(frame, "Pay must be a positive value.", "Input Error", JOptionPane.ERROR_MESSAGE);
			            return;
			        }
					int totalGoals = Integer.parseInt(txtTotalGoals.getText());
					int totalAssists = Integer.parseInt(txtTotalAssists.getText());
					int totalCards = Integer.parseInt(txtTotalCards.getText());
					Admin admin = new Admin(league); //Creates a new Admin object, passing in the League object
					admin.createPlayer(name, employmentStatus, position, totalGoals, totalAssists, totalCards, preferredFormation, pay); 
					/**
					 * Calls the createPlayer() method in the Admin class, passing in what is entered in the text fields
					 */
			    } 
				
				catch (NumberFormatException ex) {
			        JOptionPane.showMessageDialog(frame, "Pay must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
			    } 
				
				catch (Exception ex) {
			        JOptionPane.showMessageDialog(frame, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			    }
				
				


			}
		});
		addPlayerButton.setBounds(166, 216, 117, 29);
		frame.getContentPane().add(addPlayerButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setBounds(0, 237, 55, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}

}
