package doctorappointment.receptionist;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

import doctorappointment.dbinfo.DBConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.SystemColor;

public class PatientDetails extends JFrame implements ActionListener,KeyListener {

	private JPanel contentPane;
	private JDateChooser dc;
	private JTextField txtappointmentNo;
	private JComboBox<String> cmbdoctorId;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField txtpatientName;
	private JTextField txtage;
	private JTextField txtphoneNumber;
	private JTextField txtproblem;
	private JTextField txtpatientVisitStatus;
    private JRadioButton rdphone,rdmanual;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientDetails frame = new PatientDetails();
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
	public PatientDetails() {
		setTitle("Patient_Appointment");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 743, 506);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		dc = new JDateChooser();
		dc.setDateFormatString("yyyy-MM-dd");
		dc.setBounds(202, 11, 263, 20);
		contentPane.add(dc);

		JLabel lblNewLabel = new JLabel("Appointmentdate");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		dc.add(lblNewLabel, BorderLayout.WEST);

		JLabel lblNewLabel_1 = new JLabel("AppointmentNo");
		lblNewLabel_1.setForeground(new Color(139, 69, 19));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(202, 42, 123, 20);
		contentPane.add(lblNewLabel_1);

		txtappointmentNo = new JTextField();
		txtappointmentNo.setBounds(331, 42, 134, 21);
		txtappointmentNo.addKeyListener(this);
		contentPane.add(txtappointmentNo);
		txtappointmentNo.setColumns(10);

		cmbdoctorId = new JComboBox();
		cmbdoctorId.setBackground(new Color(255, 105, 180));
		cmbdoctorId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cmbdoctorId.setModel(new DefaultComboBoxModel(new String[] { "Select DoctorId" }));
		cmbdoctorId.setBounds(202, 73, 124, 22);
		fillCombo();
		contentPane.add(cmbdoctorId);

		lblNewLabel_2 = new JLabel("PatientName");
		lblNewLabel_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(202, 118, 123, 14);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setForeground(new Color(255, 0, 128));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(202, 145, 46, 26);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("PhoneNumber");
		lblNewLabel_4.setForeground(SystemColor.desktop);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(202, 182, 96, 14);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Problem");
		lblNewLabel_5.setForeground(new Color(64, 64, 64));
		lblNewLabel_5.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_5.setBounds(194, 226, 86, 32);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("AppointmentMode");
		lblNewLabel_6.setForeground(new Color(138, 43, 226));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_6.setBounds(202, 292, 123, 20);
		contentPane.add(lblNewLabel_6);

		 rdphone = new JRadioButton("Phone");
		rdphone.setForeground(new Color(128, 0, 128));
		rdphone.setFont(new Font("Verdana", Font.BOLD, 13));
		rdphone.setBounds(362, 290, 109, 23);
		contentPane.add(rdphone);

		 rdmanual = new JRadioButton("Manual");
		rdmanual.setForeground(new Color(210, 105, 30));
		rdmanual.setFont(new Font("Verdana", Font.BOLD, 13));
		rdmanual.setBounds(555, 292, 109, 23);
		contentPane.add(rdmanual);

		JLabel lblNewLabel_7 = new JLabel("PatientVisitStatus");
		lblNewLabel_7.setForeground(new Color(210, 105, 30));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_7.setBounds(202, 342, 123, 14);
		contentPane.add(lblNewLabel_7);

		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(329, 397, 125, 45);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);

		txtpatientName = new JTextField();
		txtpatientName.setBounds(331, 116, 134, 20);
		txtpatientName.addKeyListener(this);
		contentPane.add(txtpatientName);
		txtpatientName.setColumns(10);

		txtage = new JTextField();
		txtage.setBounds(331, 149, 86, 20);
		txtage.addKeyListener(this);
		contentPane.add(txtage);
		txtage.setColumns(10);

		txtphoneNumber = new JTextField();
		txtphoneNumber.setBounds(331, 180, 134, 20);
		txtphoneNumber.addKeyListener(this);
		contentPane.add(txtphoneNumber);
		txtphoneNumber.setColumns(10);

		txtproblem = new JTextField();
		txtproblem.setBounds(331, 224, 263, 45);
		txtproblem.addKeyListener(this);
		contentPane.add(txtproblem);
		txtproblem.setColumns(10);

		txtpatientVisitStatus = new JTextField();
		txtpatientVisitStatus.setBounds(368, 340, 86, 20);
		txtpatientVisitStatus.addKeyListener(this);
		contentPane.add(txtpatientVisitStatus);
		txtpatientVisitStatus.setColumns(10);

	}

	public void fillCombo() {
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectQuery = "select DoctorId from doctor_details";
		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while (rs.next() == true) {
				String DoctorId = rs.getString("DoctorId");
				cmbdoctorId.addItem(DoctorId);
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
		java.util.Date ad = dc.getDate();	
    String AppointmentNo=txtappointmentNo.getText();
    String PatientName=txtpatientName.getText();
    String Age=txtage.getText();
	String PhoneNumber =txtphoneNumber.getText();
	String Problem=txtproblem.getText();
	String PatientVisitStatus=txtpatientVisitStatus.getText();
	String DoctorId = (String) cmbdoctorId.getSelectedItem();
	String AMD = lblNewLabel_6.getText();
	
	if(rdphone.isSelected()==true)
		AMD = rdphone.getText();
	if(rdmanual.isSelected()==true)
		AMD = rdmanual.getText(); 
		
	
	
		if(PatientName.isEmpty()||PatientVisitStatus.isEmpty()||AppointmentNo.isEmpty()||PhoneNumber.isEmpty()||Problem.isEmpty()||Age.isEmpty())
						{
			JOptionPane.showMessageDialog(this, "Please provide patient name,phone number,age,appointment date,appointment no,patient visit status,problem");
						}
						else 
						{   long adt = ad.getTime();
						    java.sql.Date adDate = new java.sql.Date(adt);
						    
							java.util.Date d=new java.util.Date();
							long dt=d.getTime();
							java.sql.Date sqlDate=new java.sql.Date(dt);
							Connection con=DBConnection.openConnection();
							PreparedStatement ps=null;
		String insertQuery="insert into patient_details(Date,AppointmentDate,AppointmentNo,DoctorId,PatientName,Age,PhoneNumber,Problem,AppointmentMode,PatientVisitStatus)values(?,?,?,?,?,?,?,?,?,?)";
							try {
							ps=con.prepareStatement(insertQuery);
							ps.setDate(1,sqlDate);
							ps.setDate(2,adDate);
							ps.setInt(3,Integer.parseInt(AppointmentNo));
							ps.setString(4,DoctorId);
							ps.setString(5, PatientName);
							ps.setString(6,Age);
							ps.setString(7,PhoneNumber);
							ps.setString(8,Problem);
							ps.setString(9,AMD);
							ps.setString(10, PatientVisitStatus);
							
						int result=ps.executeUpdate();
						if(result>0)
							JOptionPane.showMessageDialog(this,"Patient added suceesfully");
						txtpatientName.setText("");
						txtphoneNumber.setText("");
						txtappointmentNo.setText("");
						txtproblem.setText("");
						txtage.setText("");
						txtpatientVisitStatus.setText("");
						}
							catch(SQLException se)
							{
								se.printStackTrace();
							}
							finally {
								try {
									if(ps!=null)
										ps.close();
									if(con!=null)
										con.close();
								}
								catch(SQLException se) {
									se.printStackTrace();
								}
							}
					}		
			}

			@Override
			public void keyTyped(KeyEvent e) {

				char c=e.getKeyChar();
				if(e.getSource()==txtpatientName) 
				{
					if(!(Character.isAlphabetic(c) ||c==KeyEvent.VK_BACK_SPACE))
					{
						e.consume();
			JOptionPane.showMessageDialog(this,"only alphabets are allowed","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if(e.getSource()==txtproblem) 
				{
					if(!(Character.isAlphabetic(c) ||c==KeyEvent.VK_BACK_SPACE))
					{
						e.consume();
			JOptionPane.showMessageDialog(this,"only alphabets are allowed","Error",JOptionPane.ERROR_MESSAGE);
					}
				}

				
				if(e.getSource()==txtpatientVisitStatus) 
				{
					if(!(Character.isAlphabetic(c) ||c==KeyEvent.VK_BACK_SPACE))
					{
						e.consume();
			JOptionPane.showMessageDialog(this,"only alphabets are allowed","Error",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				if(e.getSource()==txtappointmentNo) 
				{
					if(!(Character.isDigit(c)||c==KeyEvent.VK_BACK_SPACE))
					{
						e.consume();
			JOptionPane.showMessageDialog(this,"only digits are allowed","Error",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				if(e.getSource()==txtphoneNumber) 
				{
					if(!(Character.isDigit(c)||c==KeyEvent.VK_BACK_SPACE))
					{
						e.consume();
			JOptionPane.showMessageDialog(this,"only digits are allowed","Error",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				if(e.getSource()==txtage) 
				{
					if(!(Character.isDigit(c)||c==KeyEvent.VK_BACK_SPACE))
					{
						e.consume();
			JOptionPane.showMessageDialog(this,"only digits are allowed","Error",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		
}

	
