package doctorappointment.receptionist;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import doctorappointment.dbinfo.DBConnection;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PatientSearch extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblpatientName, lblage, lblphoneNumber, lblproblem;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientSearch frame = new PatientSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PatientSearch() {
		setTitle("Patient Search");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 734, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 204));
		panel.setBounds(118, 37, 569, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Serial Number");
		lblNewLabel.setBounds(10, 11, 165, 20);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.BOLD, 13));
		textField.setBounds(204, 13, 86, 20);
		panel.add(textField);
		textField.addKeyListener(this);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setForeground(new Color(0, 0, 51));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(427, 12, 89, 23);
		btnNewButton.addActionListener(this);
		btnNewButton.addKeyListener(this);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("PatientName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(118, 118, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		lblpatientName = new JLabel("");
		lblpatientName.setBounds(314, 120, 88, 14);
		contentPane.add(lblpatientName);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(118, 177, 46, 17);
		contentPane.add(lblNewLabel_2);
		
		 lblage = new JLabel("");
		lblage.setBounds(283, 180, 46, 14);
		contentPane.add(lblage);
		
		JLabel lblNewLabel_3 = new JLabel("PhoneNumber");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(118, 239, 108, 14);
		contentPane.add(lblNewLabel_3);
		
		 lblphoneNumber = new JLabel("");
		lblphoneNumber.setBounds(297, 241, 88, 14);
		contentPane.add(lblphoneNumber);
		
		JLabel lblNewLabel_4 = new JLabel("Problem");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(118, 294, 67, 14);
		contentPane.add(lblNewLabel_4);
		
		 lblproblem = new JLabel("");
		lblproblem.setBounds(316, 296, 108, 14);
		contentPane.add(lblproblem);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(104, 101, 489, 249);
		contentPane.add(panel_1);
	}
	
	public void searchStudent() {
		String SerialNumber = textField.getText();
		if (SerialNumber.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please enter serial number", "Fields empty",
					JOptionPane.ERROR_MESSAGE);
		} else {
			Connection con = DBConnection.openConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String selectQuery = "select * from patient_details where Serial_Number=?";
			try {
				ps = con.prepareStatement(selectQuery);
				ps.setInt(1, Integer.parseInt(SerialNumber));
				rs = ps.executeQuery();
				if (rs.next()) {
					String cpatientName = rs.getString("PatientName");
					String cage = rs.getString("Age");
					String cphoneNumber = rs.getString("PhoneNumber");
					String cproblem = rs.getString("Problem");
					
					lblpatientName.setText(cpatientName);
					lblage.setText(cage);
					lblphoneNumber.setText(cphoneNumber);
					lblproblem.setText(cproblem);
					
				} else {
					JOptionPane.showMessageDialog(this, "No such serial number exists");
				}

			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				try {

					if (ps != null)
						ps.close();
					if (rs != null)
						rs.close();
					if (con != null)
						con.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();

		if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_ENTER)) {
			e.consume();
			JOptionPane.showMessageDialog(this, "Only numeric values are allowed", "Data Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == 10) {
			searchStudent();
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		searchStudent();
		
	}
}
