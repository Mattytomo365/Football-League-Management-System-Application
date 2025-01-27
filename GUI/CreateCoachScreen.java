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

public class CreateCoachScreen {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtEmploymentStatus;
	private JTextField txtTeam;
	private JTextField txtPay;
	private League league;

	/**
	 * Constructs CreateCoachScreen
	 * @param league, the League object that CreateCoachScreen passes on
	 */
	public CreateCoachScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialises the graphical user interface components of the screen
	 */
	private void initialise() {
		
		//Initialises the Create coach JFrame
		frame = new JFrame("Create coach screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("Create Coach");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(128, 23, 181, 36);
		frame.getContentPane().add(lblNewLabel);
		
		//Text box allowing the admin to enter the name of the new coach
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(67, 71, 130, 26);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		//Text box allowing the admin to enter the employment status of the new coach
		txtEmploymentStatus = new JTextField();
		txtEmploymentStatus.setText("Employment Status");
		txtEmploymentStatus.setBounds(215, 71, 136, 26);
		frame.getContentPane().add(txtEmploymentStatus);
		txtEmploymentStatus.setColumns(10);
		
		//Text box allowing the admin to enter the team of the new coach
		txtTeam = new JTextField();
		txtTeam.setText("Team");
		txtTeam.setBounds(67, 109, 130, 26);
		frame.getContentPane().add(txtTeam);
		txtTeam.setColumns(10);
		
		//Text box allowing the admin to enter the pay of the new coach
		txtPay = new JTextField();
		txtPay.setText("Pay");
		txtPay.setBounds(215, 109, 136, 26);
		frame.getContentPane().add(txtPay);
		txtPay.setColumns(10);
		
		//Add coach button
		JButton addCoachButton = new JButton("Add Coach");
		addCoachButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Retrieves text entered into the text fields
					 */
					String name = txtName.getText();
					String employmentStatus = txtEmploymentStatus.getText();
					String teamName = txtTeam.getText();
					String payInput = txtPay.getText();
					
			        // Input Validation
			        if (name.isEmpty() || employmentStatus.isEmpty() || teamName.isEmpty() || payInput.isEmpty()) {
			            JOptionPane.showMessageDialog(frame, "All fields must be filled.", "Input Error", JOptionPane.ERROR_MESSAGE);
			            return;
			        }
			        
		            // Validate that the name only contains letters and spaces
		            if (!name.matches("[a-zA-Z ]+")) {
		                JOptionPane.showMessageDialog(frame, "Name must contain only letters and spaces.", "Input Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }
			        
			        int pay = Integer.parseInt(payInput);
			        
			        if (pay < 0) {
			            JOptionPane.showMessageDialog(frame, "Pay must be a positive value.", "Input Error", JOptionPane.ERROR_MESSAGE);
			            return;
			        }
					Admin admin = new Admin(league); //Created new Admin object, passing in the League object
					admin.createCoach(name, employmentStatus, teamName, pay); //Calls the createCoach() method in the Admin class, passing in the details entered in the text fields
			    } 
				
				catch (NumberFormatException ex) {
			        JOptionPane.showMessageDialog(frame, "Pay must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
			    } 
				
				catch (Exception ex) {
			        JOptionPane.showMessageDialog(frame, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			    }

			}
		});
		addCoachButton.setBounds(147, 153, 117, 29);
		frame.getContentPane().add(addCoachButton);
		
		//Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		backButton.setBounds(0, 237, 57, 29);
		frame.getContentPane().add(backButton);
		
		frame.setVisible(true);
	}
	
	
}
