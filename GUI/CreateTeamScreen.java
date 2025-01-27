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

public class CreateTeamScreen {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtHomeGround;
	private League league;
	private JTextField txtCapacity;


	/**
	 * Constructs CreateTeamScreen 
	 * @param league, the League object that CreateTeamScreen passes on
	 */
	public CreateTeamScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialise() {
		
		//Initialises the Create team JFrame
		frame = new JFrame("Create team screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("Create Team");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(123, 21, 200, 32);
		frame.getContentPane().add(lblNewLabel);
		
		//Text box allowing the admin to enter the new team's name
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(60, 76, 130, 26);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		//Text box allowing the admin to enter the home ground of the new team
		txtHomeGround = new JTextField();
		txtHomeGround.setText("Home Ground");
		txtHomeGround.setBounds(235, 76, 130, 26);
		frame.getContentPane().add(txtHomeGround);
		txtHomeGround.setColumns(10);
		
		//Text box allowing the admim to enter the home ground capacity of the new team
		txtCapacity = new JTextField();
		txtCapacity.setText("Capacity");
		txtCapacity.setBounds(60, 130, 130, 26);
		frame.getContentPane().add(txtCapacity);
		txtCapacity.setColumns(10);
		
		//Add team button
		JButton addTeamButton = new JButton("Add Team");
		addTeamButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					String teamName = txtName.getText();
					String homeGroundName = txtHomeGround.getText();
					String capacityInput = txtCapacity.getText();
					
			        // Input Validation
			        if (teamName.isEmpty() || homeGroundName.isEmpty() || capacityInput.isEmpty()) {
			            JOptionPane.showMessageDialog(frame, "All fields must be filled.", "Input Error", JOptionPane.ERROR_MESSAGE);
			            return;
			        }
			        
		            // Validate that necessary fields only contains letters and spaces
		            if (!teamName.matches("[a-zA-Z ]+") || !homeGroundName.matches("[a-zA-Z ]+")) {
		                JOptionPane.showMessageDialog(frame, "Invalid details.", "Input Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }
		            
		            // Validate that necessary fields only contain only numbers
		            if (!capacityInput.matches("\\d+")) { // Ensures pay contains only digits
		                JOptionPane.showMessageDialog(frame, "Invalid details.", "Input Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }

			        int capacity = Integer.parseInt(capacityInput);
			        
			        if (capacity < 0) {
			            JOptionPane.showMessageDialog(frame, "Capacity must be a positive value.", "Input Error", JOptionPane.ERROR_MESSAGE);
			            return;
			        }
					
					Admin admin = new Admin(league); //Creating new Admin object, passing the League object into its constructor
					admin.createTeam(teamName, homeGroundName, capacity); //Calling the createTeam() method in the Admin class
				}
				
		     
				catch (NumberFormatException ex) {
			        JOptionPane.showMessageDialog(frame, "Capacity must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
			    } 
				
				catch (Exception ex) {
			        JOptionPane.showMessageDialog(frame, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			    }
		
			}});
		addTeamButton.setBounds(235, 130, 117, 29);
		frame.getContentPane().add(addTeamButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setBounds(0, 237, 59, 29);
		frame.getContentPane().add(backButton);
		

		
		frame.setVisible(true);
	}
	
	
}
