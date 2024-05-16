package doctorappointment.receptionist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import doctorappointment.dbinfo.DBConnection;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class UpdatePatientStatus extends JFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private JComboBox<String> cmbappointmentNo;
	private JTextField txtdoctorId;
	private JTextField txtpatientName;
	private JTextField txtage;
	private JTextField txtphoneNumber;
	private JTextField txtproblem;
	private JTextField txtappointmentMode;
	private JTextField txtpatientVisitStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePatientStatus frame = new UpdatePatientStatus();
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
	public UpdatePatientStatus() {
		setResizable(false);
		setTitle("Update Patient Status");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 724, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		cmbappointmentNo = new JComboBox();
		cmbappointmentNo.setBackground(new Color(255, 182, 193));
		cmbappointmentNo.addItemListener(this);
		cmbappointmentNo.setForeground(new Color(255, 0, 0));
		cmbappointmentNo.setFont(new Font("Verdana", Font.BOLD, 13));
		cmbappointmentNo.setModel(new DefaultComboBoxModel(new String[] { "Appointment No" }));
		cmbappointmentNo.setBounds(263, 11, 156, 22);
		fillCombo();
		contentPane.add(cmbappointmentNo);

		JLabel lblNewLabel_1 = new JLabel("DoctorId");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(149, 101, 69, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Patient Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(149, 126, 92, 30);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(149, 167, 46, 22);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Phone Number");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(149, 205, 105, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Problem");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(149, 240, 55, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Appointment Mode");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(149, 279, 129, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Patient Visit Status");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(149, 323, 129, 14);
		contentPane.add(lblNewLabel_7);

		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.setBackground(new Color(154, 205, 50));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNewButton.setBounds(263, 356, 129, 35);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);

		txtdoctorId = new JTextField();
		txtdoctorId.setBounds(306, 99, 86, 20);
		contentPane.add(txtdoctorId);
		txtdoctorId.setColumns(10);

		txtpatientName = new JTextField();
		txtpatientName.setBounds(306, 132, 98, 20);
		contentPane.add(txtpatientName);
		txtpatientName.setColumns(10);

		txtage = new JTextField();
		txtage.setBounds(306, 169, 86, 20);
		contentPane.add(txtage);
		txtage.setColumns(10);

		txtphoneNumber = new JTextField();
		txtphoneNumber.setBounds(306, 203, 98, 20);
		contentPane.add(txtphoneNumber);
		txtphoneNumber.setColumns(10);

		txtproblem = new JTextField();
		txtproblem.setBounds(306, 238, 113, 20);
		contentPane.add(txtproblem);
		txtproblem.setColumns(10);

		txtappointmentMode = new JTextField();
		txtappointmentMode.setBounds(306, 277, 86, 20);
		contentPane.add(txtappointmentMode);
		txtappointmentMode.setColumns(10);

		txtpatientVisitStatus = new JTextField();
		txtpatientVisitStatus.setBounds(306, 321, 86, 20);
		contentPane.add(txtpatientVisitStatus);
		txtpatientVisitStatus.setColumns(10);
	}

	public void fillCombo() {
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectQuery = "select AppointmentNo from patient_details";
		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while (rs.next() == true) {
				String AppointmentNo = rs.getString("AppointmentNo");
				cmbappointmentNo.addItem(AppointmentNo);
			}
		}

		catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String AppointmentNo = (String) cmbappointmentNo.getSelectedItem();
		String DoctorId = txtdoctorId.getText();
		String PatientName = txtpatientName.getText();
		String Age = txtage.getText();
		String PhoneNumber = txtphoneNumber.getText();
		String Problem = txtproblem.getText();
		String AppointmentMode = txtappointmentMode.getText();
		String PatientVisitStatus = txtpatientVisitStatus.getText();

		if (DoctorId.isEmpty() || PatientName.isEmpty() || Age.isEmpty() || PhoneNumber.isEmpty() || Problem.isEmpty()
				|| AppointmentMode.isEmpty() || PatientVisitStatus.isEmpty()
				|| AppointmentNo.equalsIgnoreCase("Appointment No")) {
			JOptionPane.showMessageDialog(this,
					"Please provide doctorId,PatientName,Age,phoneNumber,problem,appointmentMode,patientvisitstatus");
		} else {
			Connection con = DBConnection.openConnection();
			PreparedStatement ps = null;
			String updateQuery = "update patient_details set PatientVisitStatus=? where AppointmentNo=?";

			try {

				ps = con.prepareStatement(updateQuery);

				ps.setString(1, PatientVisitStatus);
				ps.setString(2, AppointmentNo);

				int result = ps.executeUpdate();

				if (result > 0) {
					JOptionPane.showMessageDialog(this, AppointmentNo + "Patient Details update successfully");

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
		if (state == 1) {
			String AppointmentNo = (String) cmbappointmentNo.getSelectedItem();
			if (AppointmentNo.equalsIgnoreCase("Appointment No")) {
				JOptionPane.showMessageDialog(this, "pls select valid appointment no");
			} else {
				Connection con = DBConnection.openConnection();
				PreparedStatement ps = null;
				ResultSet rs = null;
				String select_Query = "select* from patient_details where AppointmentNo = ?";
				try {
					ps = con.prepareStatement(select_Query);
					ps.setString(1, AppointmentNo);
					rs = ps.executeQuery();
					rs.next();
					String cDoctorId = rs.getString("DoctorId");
					String cPatientName = rs.getString("PatientName");
					String cAge = rs.getString("Age");
					String cPhoneNumber = rs.getString("PhoneNumber");
					String cProblem = rs.getString("Problem");
					String cAppointmentMode = rs.getString("AppointmentMode");
					String cPatientVisitStatus = rs.getString("PatientVisitStatus");

					txtdoctorId.setText(cDoctorId);
					txtpatientName.setText(cPatientName);
					txtage.setText(cAge);
					txtphoneNumber.setText(cPhoneNumber);
					txtproblem.setText(cProblem);
					txtappointmentMode.setText(cAppointmentMode);
					txtpatientVisitStatus.setText(cPatientVisitStatus);

				} catch (SQLException se) {
					se.printStackTrace();
				} finally {
					try {
						if (rs != null)
							rs.close();
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
}
