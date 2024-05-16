package doctorappointment.receptionist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import doctorappointment.dbinfo.DBConnection;

import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Patient_FeedBack extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtphone;
	private JTextField txtDname;
	private JTextField txtFeedBack;
	private JDateChooser dateChooser;
private JRadioButton rbd1,rbd2,rbd3,rbd4,rbd5; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_FeedBack frame = new Patient_FeedBack();
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
	public Patient_FeedBack() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 745, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Patient_name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(201, 69, 137, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Patient_phone");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(201, 124, 133, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DoctorName");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(187, 178, 151, 38);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("FeedBack");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(187, 227, 137, 47);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ratings");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(187, 267, 133, 38);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Date");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(197, 304, 114, 43);
		contentPane.add(lblNewLabel_6);
		
		txtname = new JTextField();
		txtname.setBounds(430, 81, 108, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtphone = new JTextField();
		txtphone.setBounds(430, 136, 108, 20);
		contentPane.add(txtphone);
		txtphone.addActionListener(this);
		txtphone.setColumns(10);
		
		txtDname = new JTextField();
		txtDname.setBounds(430, 190, 108, 20);
		contentPane.add(txtDname);
		txtDname.setColumns(10);
		
		txtFeedBack = new JTextField();
		txtFeedBack.setBounds(430, 243, 108, 20);
		contentPane.add(txtFeedBack);
		txtFeedBack.setColumns(10);
		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(430, 317, 108, 20);
		contentPane.add(dateChooser);
		
		 rbd1 = new JRadioButton("1 ");
		rbd1.setBounds(432, 278, 35, 23);
		contentPane.add(rbd1);
		
		 rbd2 = new JRadioButton("2");
		rbd2.setBounds(493, 278, 41, 23);
		contentPane.add(rbd2);
		
		 rbd3 = new JRadioButton("3");
		rbd3.setBounds(549, 278, 41, 23);
		contentPane.add(rbd3);
		
		 rbd4 = new JRadioButton("4");
		rbd4.setBounds(617, 278, 41, 23);
		contentPane.add(rbd4);
		
	 rbd5 = new JRadioButton("5");
		rbd5.setBounds(679, 278, 48, 23);
		contentPane.add(rbd5);
		
		JLabel lblNewLabel_7 = new JLabel("Patient_FeedBack");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(258, 11, 236, 36);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(306, 342, 108, 46);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		String Patient_name=txtname.getText();
		String Patient_phone=txtphone.getText()	;
		String DoctorName=txtDname.getText();
		String FeedBack=txtFeedBack.getText();
		String Ratings="";
		
		if(rbd1.isSelected()==true)
		   Ratings=rbd1.getText();
		if(rbd2.isSelected()==true)
			Ratings=rbd2.getText();
		if(rbd3.isSelected()==true)
			Ratings=rbd3.getText();
		if(rbd4.isSelected()==true)
			Ratings=rbd4.getText();
		if(rbd5.isSelected()==true)
			Ratings=rbd5.getText();
		
	 
	  if(Patient_name.isEmpty()||Patient_phone.isEmpty()||DoctorName.isEmpty()||FeedBack.isEmpty()||Ratings.isEmpty())
	
	{
		JOptionPane.showMessageDialog(this, "Please provide Patient_name,Patient_phone,DoctorName,FeedBack");
	}
	else
	{
		
		 if(Patient_phone.length()!=10)
		
		 { 
			 JOptionPane.showMessageDialog(this, "phone number must be of 10 digit"); 
		 
		 }
		 java.util.Date d=new java.util.Date();
			long dt=d.getTime();
			java.sql.Date sqlDate=new java.sql.Date(dt);
		Connection con=DBConnection.openConnection();
		PreparedStatement ps=null;
	String insertQuery="insert into patient_feedback(Patient_name,Patient_phone,DoctorName,FeedBack,Ratings,Date)values(?,?,?,?,?,?)";
	try
	{
		ps=con.prepareStatement(insertQuery);
		ps.setString(1,Patient_name);
		ps.setString(2,Patient_phone);
		ps.setString(3, DoctorName);
		ps.setString(4,FeedBack );
		ps.setString(5, Ratings);
		ps.setDate(6, sqlDate);
		
		int result=ps.executeUpdate();
		if(result>0)
			JOptionPane.showMessageDialog(this, "Details Added");
		txtname.setText("");
		txtphone.setText("");
		txtDname.setText("");
		txtFeedBack.setText("");
		rbd1.setText("");
		rbd2.setText("");
		rbd3.setText("");
		rbd4.setText("");
		rbd5.setText("");
		
		

	}
	
	catch(SQLException se) {
JOptionPane.showMessageDialog(this, "Doctor details already exists","Duplicate value error",JOptionPane.ERROR_MESSAGE);
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

}
