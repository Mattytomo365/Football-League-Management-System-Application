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

public class CreateRefereeScreen {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtEmploymentStatus;
	private JTextField txtPay;
	private League league;

	/**
	 * Constructs CreateRefereeScreen 
	 * @param league, the League object that CreateRefereeScreen passes on
	 */
	public CreateRefereeScreen(League league) {
		this.league = league;
		initialise();
	}

	/**
	 * Initialises the graphical user interface components of the screen
	 */
	private void initialise() {
		
		//Initialises the Create referees JFrame
		frame = new JFrame("Create referee screen");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title at the top of the screen
		JLabel lblNewLabel = new JLabel("Create Referee");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(142, 30, 154, 34);
		frame.getContentPane().add(lblNewLabel);
		
		//Text box allowing the admin to enter the name of the referee
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(82, 76, 130, 26);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		//Text box allowing the admin to enter the employment status of the referee
		txtEmploymentStatus = new JTextField();
		txtEmploymentStatus.setText("Employment Status");
		txtEmploymentStatus.setBounds(224, 76, 135, 26);
		frame.getContentPane().add(txtEmploymentStatus);
		txtEmploymentStatus.setColumns(10);
		
		//Text box allowing the admin to enter the pay of the referee
		txtPay = new JTextField();
		txtPay.setText("Pay");
		txtPay.setBounds(82, 114, 130, 26);
		frame.getContentPane().add(txtPay);
		txtPay.setColumns(10);
		
		//Add referee button
		JButton addRefereeButton = new JButton("Add Referee");
		addRefereeButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					//Getting text entered into text fields and assigning them
					String name = txtName.getText();
					String employmentStatus = txtEmploymentStatus.getText();
					String payInput = txtPay.getText();
					
			        // Input Validation
			        if (name.isEmpty() || employmentStatus.isEmpty() || payInput.isEmpty()) {
			            JOptionPane.showMessageDialog(frame, "All fields must be filled.", "Input Error", JOptionPane.ERROR_MESSAGE);
			            return;
			        }
			        
		            // Validate that the name only contains letters and spaces
		            if (!name.matches("[a-zA-Z ]+")) {
		                JOptionPane.showMessageDialog(frame, "Name must contain only letters and spaces.", "Input Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }
		            
		         // Validate that necessary fields only contain only numbers
		            if (!payInput.matches("\\d+")) { // Ensures pay contains only digits
		                JOptionPane.showMessageDialog(frame, "Pay must contain only numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }

			        int pay = Integer.parseInt(payInput);
			        
			        if (pay < 0) {
			            JOptionPane.showMessageDialog(frame, "Pay must be a positive value.", "Input Error", JOptionPane.ERROR_MESSAGE);
			            return;
			        }

					Admin admin = new Admin(league);
					admin.createReferee(name, employmentStatus, pay);
		    } 
				
			catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(frame, "Pay must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
		    } 
			
			catch (Exception ex) {
		        JOptionPane.showMessageDialog(frame, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		    }
				

			}
		});
		addRefereeButton.setBounds(234, 114, 117, 29);
		frame.getContentPane().add(addRefereeButton);
		
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
