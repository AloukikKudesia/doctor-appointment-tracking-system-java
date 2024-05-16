package doctorappointment.manager;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import doctorappointment.dbinfo.DBConnection;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

public class UpdateDoctorDetails extends JFrame implements ActionListener,ItemListener {

	private JPanel contentPane;
	private JComboBox<String>cmbdoctorId;
	private JTextField txtFname;
	private JTextField txtMname;
	private JTextField txtLname;
	private JTextField txtaddress;
	private JTextField txtemail;
	private JTextField txtgender;
	private JTextField txtphonenumber;
	private JTextField txttiming;
	private JTextField txtqualification;
	private JTextField txtfield;
	private JTextField txtexperience;
	private JCheckBox chkmonday, chktuesday, chkwednesday, chkthursday, chkfriday, chksaturday, chksunday;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDoctorDetails frame = new UpdateDoctorDetails();
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
	public UpdateDoctorDetails() {
		setTitle("Update Doctor Details");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 751, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 255, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 cmbdoctorId = new JComboBox();
		cmbdoctorId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cmbdoctorId.addItemListener(this);
		cmbdoctorId.setModel(new DefaultComboBoxModel(new String[] {"Select DoctorId"}));
		cmbdoctorId.setBounds(258, 11, 124, 22);
		fillCombo();
		contentPane.add(cmbdoctorId);
		
		JLabel lblNewLabel_1 = new JLabel("FirstName");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(44, 46, 67, 14);
		contentPane.add(lblNewLabel_1);

		txtFname = new JTextField();
		txtFname.setFont(new Font("Verdana", Font.BOLD, 13));
		txtFname.setForeground(Color.MAGENTA);
		txtFname.setBounds(200, 40, 98, 20);
		contentPane.add(txtFname);
		txtFname.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("MiddleName");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(44, 83, 78, 14);
		contentPane.add(lblNewLabel_2);

		txtMname = new JTextField();
		txtMname.setForeground(Color.RED);
		txtMname.setFont(new Font("Arial Black", Font.BOLD, 12));
		txtMname.setBounds(200, 77, 98, 20);
		contentPane.add(txtMname);
		txtMname.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("LastName");
		lblNewLabel_3.setForeground(new Color(0, 64, 0));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(44, 116, 78, 14);
		contentPane.add(lblNewLabel_3);

		txtLname = new JTextField();
        txtLname.setForeground(new Color(255, 128, 128));
		txtLname.setFont(new Font("Arial Black", Font.BOLD, 12));
		txtLname.setBounds(200, 110, 98, 20);
		contentPane.add(txtLname);
		txtLname.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setForeground(new Color(128, 0, 64));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(44, 156, 78, 14);
		contentPane.add(lblNewLabel_4);

		txtaddress = new JTextField();
		txtaddress.setFont(new Font("Arial", Font.BOLD, 12));
		txtaddress.setBounds(200, 150, 98, 20);
		contentPane.add(txtaddress);
		txtaddress.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setForeground(new Color(128, 64, 0));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_5.setBounds(44, 198, 78, 14);
		contentPane.add(lblNewLabel_5);

		txtemail = new JTextField();
		txtemail.setFont(new Font("Cambria", Font.BOLD, 12));
		txtemail.setForeground(Color.GRAY);
		txtemail.setBounds(200, 192, 98, 20);
		contentPane.add(txtemail);
		txtemail.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Gender");
		lblNewLabel_6.setForeground(new Color(128, 128, 192));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_6.setBounds(44, 229, 78, 14);
		contentPane.add(lblNewLabel_6);

		txtgender = new JTextField();
		txtgender.setFont(new Font("Verdana", Font.BOLD, 12));
		txtgender.setBounds(200, 223, 98, 20);
		contentPane.add(txtgender);
		txtgender.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("PhoneNumber");
		lblNewLabel_7.setForeground(new Color(0, 128, 0));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_7.setBounds(24, 266, 98, 14);
		contentPane.add(lblNewLabel_7);

		txtphonenumber = new JTextField();
		txtphonenumber.setFont(new Font("Verdana", Font.BOLD, 12));
		txtphonenumber.setBounds(200, 260, 98, 20);
		contentPane.add(txtphonenumber);
		txtphonenumber.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Days");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_8.setBounds(44, 299, 46, 14);
		contentPane.add(lblNewLabel_8);

		chkmonday = new JCheckBox("Monday");
		chkmonday.setFont(new Font("Verdana", Font.BOLD, 12));
		chkmonday.setBounds(90, 295, 67, 23);
		contentPane.add(chkmonday);

		chktuesday = new JCheckBox("Tuesday");
		chktuesday.setFont(new Font("Verdana", Font.BOLD, 12));
		chktuesday.setBounds(159, 295, 67, 23);
		contentPane.add(chktuesday);

		chkwednesday = new JCheckBox("Wednesday");
		chkwednesday.setFont(new Font("Verdana", Font.BOLD, 12));
		chkwednesday.setBounds(228, 295, 70, 23);
		contentPane.add(chkwednesday);

		chkthursday = new JCheckBox("Thursday");
		chkthursday.setFont(new Font("Verdana", Font.BOLD, 12));
		chkthursday.setBounds(300, 295, 67, 23);
		contentPane.add(chkthursday);

		chkfriday = new JCheckBox("Friday");
		chkfriday.setFont(new Font("Verdana", Font.BOLD, 12));
		chkfriday.setBounds(369, 295, 55, 23);
		contentPane.add(chkfriday);

		chksaturday = new JCheckBox("Saturday");
		chksaturday.setFont(new Font("Verdana", Font.BOLD, 12));
		chksaturday.setBounds(433, 295, 61, 23);
		contentPane.add(chksaturday);

		chksunday = new JCheckBox("Sunday");
		chksunday.setFont(new Font("Verdana", Font.BOLD, 12));
		chksunday.setBounds(496, 295, 67, 23);
		contentPane.add(chksunday);

		JLabel lblNewLabel_9 = new JLabel("Timing");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_9.setBounds(44, 331, 46, 20);
		contentPane.add(lblNewLabel_9);

		txttiming = new JTextField();
		txttiming.setForeground(new Color(64, 0, 64));
		txttiming.setFont(new Font("Verdana", Font.BOLD, 12));
		txttiming.setBounds(200, 325, 98, 20);
		contentPane.add(txttiming);
		txttiming.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Qualification");
		lblNewLabel_10.setForeground(Color.ORANGE);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_10.setBounds(24, 362, 98, 14);
		contentPane.add(lblNewLabel_10);

		txtqualification = new JTextField();
		txtqualification.setForeground(Color.CYAN);
		txtqualification.setFont(new Font("Verdana", Font.BOLD, 12));
		txtqualification.setBounds(200, 356, 98, 20);
		contentPane.add(txtqualification);
		txtqualification.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Field");
		lblNewLabel_11.setForeground(new Color(0, 128, 128));
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_11.setBounds(44, 387, 46, 14);
		contentPane.add(lblNewLabel_11);

		txtfield = new JTextField();
        txtfield.setForeground(new Color(128, 128, 255));
		txtfield.setFont(new Font("Verdana", Font.BOLD, 12));
		txtfield.setBounds(200, 382, 98, 20);
		contentPane.add(txtfield);
		txtfield.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Experience");
		lblNewLabel_12.setForeground(new Color(128, 64, 0));
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_12.setBounds(44, 412, 78, 14);
		contentPane.add(lblNewLabel_12);

		txtexperience = new JTextField();
		txtexperience.setFont(new Font("Verdana", Font.BOLD, 12));
		txtexperience.setBounds(200, 407, 98, 20);
		contentPane.add(txtexperience);
		txtexperience.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton.setBounds(258, 427, 89, 34);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
	}

	private void fillCombo() {
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectQuery = "select DoctorId from doctor_details";
		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while(rs.next()==true) {
				String DoctorId = rs.getString("DoctorId");
				cmbdoctorId.addItem(DoctorId);
			}
		}
			
			catch(SQLException se) {
				se.printStackTrace();
			}
			finally {
				try {
					if(rs!=null)
						rs.close();
					if(ps!=null)
						ps.close();
					if(con!=null)
						con.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}
			}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String DoctorId = (String)cmbdoctorId.getSelectedItem();
		
		String FirstName = txtFname.getText();
	
		String LastName = txtLname.getText();

		String Address = txtaddress.getText();

		String Email = txtemail.getText();

		String Gender = txtgender.getText();

		String PhoneNumber = txtphonenumber.getText();

		String Days = "";
		if (chkmonday.isSelected()) {
			Days = Days + chkmonday.getText()+",";
		}
		if (chktuesday.isSelected()) {
			Days = Days + chktuesday.getText()+",";
		}
		if (chkwednesday.isSelected()) {
			Days = Days + chkwednesday.getText()+",";
		}
		if (chkthursday.isSelected()) {
			Days = Days + chkthursday.getText()+",";
		}
		if (chkfriday.isSelected()) {
			Days = Days + chkfriday.getText()+",";
		}
		if (chksaturday.isSelected()) {
			Days = Days + chksaturday.getText()+",";
		}
		if (chksunday.isSelected()) {
			Days = Days + chksunday.getText()+",";
		}

		String Timing = txttiming.getText();

		String Qualification = txtqualification.getText();

		String Field = txtfield.getText();

		String Experience = txtexperience.getText();
		
		if (FirstName.isEmpty() || LastName.isEmpty() || Address.isEmpty() || Email.isEmpty()|| Gender.isEmpty() || PhoneNumber.isEmpty() || Days.isEmpty() || Timing.isEmpty()|| Qualification.isEmpty() || Field.isEmpty() || Experience.isEmpty()||DoctorId.equalsIgnoreCase("Select DoctorId")) {
			JOptionPane.showMessageDialog(this,"Please provide firstName,lastName,address,email,gender,phoneNumber,days,timing,qualification,field and experience");
		} else {
			Connection con = DBConnection.openConnection();
			PreparedStatement ps = null;
			String updateQuery = "update doctor_details set FirstName=?,MiddleName=?,LastName=?,Address=?,Email=?,Gender=?,PhoneNumber=?,Days=?,Timing=?,Qualification=?,Field=?,Experience=? where DoctorId=?" ;

			try {

				ps = con.prepareStatement(updateQuery);
				
				ps.setString(1, FirstName);
				ps.setString(2, "");
				ps.setString(3, LastName);
				ps.setString(4, Address);
				ps.setString(5, Email);
				ps.setString(6, Gender);
				ps.setString(7, PhoneNumber);
				ps.setString(8, Days);
				ps.setString(9, Timing);
				ps.setString(10, Qualification);
				ps.setString(11, Field);
				ps.setString(12, Experience);
				ps.setString(13, DoctorId);

				int result = ps.executeUpdate();

				if (result > 0) {
					JOptionPane.showMessageDialog(this,DoctorId + "Doctor Details update successfully");
					

				}
			} catch (SQLException se) {
				
				se.printStackTrace();
			}

			finally {
				try {
					if (ps != null)
						ps.close();
					if (con != null)
						con.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		int state = e.getStateChange();
		if(state==1) {
			String DoctorId = (String)cmbdoctorId.getSelectedItem();
			if(DoctorId.equalsIgnoreCase("Select DoctorId")) {
				JOptionPane.showMessageDialog(this,"pls select valid doctorId");
			}
			else {
			Connection con = DBConnection.openConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String select_Query = "select* from doctor_details where DoctorId = ?";
			try {
				ps = con.prepareStatement(select_Query);
				ps.setString(1,DoctorId);
				rs= ps.executeQuery();
				rs.next();
				String cFirstName = rs.getString("FirstName");
				String cLastName = rs.getString("LastName");
				String cAddress = rs.getString("Address");
				String cEmail = rs.getString("Email");
				String cGender = rs.getString("Gender");
				String cPhoneNumber = rs.getString("PhoneNumber");
				String cTiming = rs.getString("Timing");
				String cQualification = rs.getString("Qualification");
				String cField = rs.getString("Field");
				String cExperience = rs.getString("Experience");
				txtFname.setText(cFirstName);
				txtLname.setText(cLastName);
				txtaddress.setText(cAddress);
				txtemail.setText(cEmail);
				txtgender.setText(cGender);
				txtphonenumber.setText(cPhoneNumber);
				txttiming.setText(cTiming);
				txtqualification.setText(cQualification);
				txtfield.setText(cField);
				txtexperience.setText(cExperience);
				
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			finally {
				try {
					if(rs!=null)
						rs.close();
					if(ps!=null)
						ps.close();
					if(con!=null)
						con.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}
			}
			
		
			
		}
		}
		
	}
}
