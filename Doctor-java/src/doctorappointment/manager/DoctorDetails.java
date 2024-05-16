package doctorappointment.manager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import doctorappointment.dbinfo.DBConnection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import doctorappointment.gui.LoginFrame;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;

public class DoctorDetails extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JTextField txtid;
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
					DoctorDetails frame = new DoctorDetails();
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
	public DoctorDetails() {
		setTitle("Doctor Details");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 747, 513);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("DoctorId");
		lblNewLabel.setForeground(new Color(128, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(44, 13, 67, 14);
		contentPane.add(lblNewLabel);

		txtid = new JTextField();
		txtid.addKeyListener(this);
		txtid.setFont(new Font("Verdana", Font.BOLD, 13));
		txtid.setForeground(Color.GREEN);
		txtid.setBounds(200, 9, 98, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("FirstName");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(44, 46, 67, 14);
		contentPane.add(lblNewLabel_1);

		txtFname = new JTextField();
		txtFname.addKeyListener(this);
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
		txtLname.addKeyListener(this);
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
		txtgender.addKeyListener(this);
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
		txtphonenumber.addKeyListener(this);
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
		txtfield.addKeyListener(this);
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
		txtexperience.addKeyListener(this);
		txtexperience.setFont(new Font("Verdana", Font.BOLD, 12));
		txtexperience.setBounds(200, 407, 98, 20);
		contentPane.add(txtexperience);
		txtexperience.setColumns(10);

		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setForeground(new Color(106, 90, 205));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(278, 438, 89, 31);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();

		if (e.getSource() == txtFname) {
			if (!((Character.isAlphabetic(c) || c == KeyEvent.VK_BACK_SPACE))) {
				e.consume();
				JOptionPane.showMessageDialog(this, "only alphabets are allowed", "Data Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == txtLname) {
			if (!((Character.isAlphabetic(c) || c == KeyEvent.VK_BACK_SPACE))) {
				e.consume();
				JOptionPane.showMessageDialog(this, "only alphabets are allowed", "Data Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == txtgender) {
			if (!((Character.isAlphabetic(c) || c == KeyEvent.VK_BACK_SPACE))) {
				e.consume();
				JOptionPane.showMessageDialog(this, "only alphabets are allowed", "Data Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == txtfield) {
			if (!((Character.isAlphabetic(c) || c == KeyEvent.VK_BACK_SPACE))) {
				e.consume();
				JOptionPane.showMessageDialog(this, "only alphabets are allowed", "Data Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == txtid) {
			if (!((Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE))) {
				e.consume();
				JOptionPane.showMessageDialog(this, "only Digits are allowed", "Data Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == txtphonenumber) {
			if (!((Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE))) {
				e.consume();
				JOptionPane.showMessageDialog(this, "only Digits are allowed", "Data Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == txtexperience) {
			if (!((Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE))) {
				e.consume();
				JOptionPane.showMessageDialog(this, "only Digits are allowed", "Data Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override

	public void actionPerformed(ActionEvent e) {
		String DoctorId = txtid.getText();

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

		if (DoctorId.isEmpty() || FirstName.isEmpty() || LastName.isEmpty() || Address.isEmpty() || Email.isEmpty()
				|| Gender.isEmpty() || PhoneNumber.isEmpty() || Days.isEmpty() || Timing.isEmpty()
				|| Qualification.isEmpty() || Field.isEmpty() || Experience.isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Please provide doctorId,firstName,lastName,address,email,gender,phoneNumber,days,timing,qualification,field and experience");
		} else {
			Connection con = DBConnection.openConnection();
			PreparedStatement ps = null;
			String insertQuery = "insert into doctor_details(DoctorId, FirstName, MiddleName, LastName, Address, Email, Gender, PhoneNumber, Days, Timing, Qualification, Field, Experience)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

			try {

				ps = con.prepareStatement(insertQuery);
				ps.setString(1, DoctorId);
				ps.setString(2, FirstName);
				ps.setString(3, "");
				ps.setString(4, LastName);
				ps.setString(5, Address);
				ps.setString(6, Email);
				ps.setString(7, Gender);
				ps.setString(8, PhoneNumber);
				ps.setString(9, Days);
				ps.setString(10, Timing);
				ps.setString(11, Qualification);
				ps.setString(12, Field);
				ps.setString(13, Experience);

				int result = ps.executeUpdate();

				if (result > 0) {
					JOptionPane.showMessageDialog(this, "DoctorDetails Added Successfully");
					txtid.setText("");
					txtFname.setText("");
					txtLname.setText("");
					txtaddress.setText("");
					txtemail.setText("");
					txtgender.setText("");
					txtphonenumber.setText("");
					chkmonday.setText("");
					chktuesday.setText("");
					chkwednesday.setText("");
					chkthursday.setText("");
					chkfriday.setText("");
					chksaturday.setText("");
					chksunday.setText("");
					txttiming.setText("");
					txtqualification.setText("");
					txtfield.setText("");
					txtexperience.setText("");

				}
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(this, DoctorId + " already exists ", " Duplicate value Error ",
						JOptionPane.ERROR_MESSAGE);
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
}
