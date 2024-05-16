package doctorappointment.receptionist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import doctorappointment.gui.AllDoctors;
import doctorappointment.gui.DateWiseAppointment;
import doctorappointment.gui.DoctorIdWiseAppointment;
import doctorappointment.receptionist.*;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class ReceptionistFrame extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceptionistFrame frame = new ReceptionistFrame();
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
	public ReceptionistFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Receptionist Frame");
		lblNewLabel.setForeground(new Color(128, 0, 128));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(228, 123, 333, 157);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 217, 22);
		contentPane.add(menuBar);
		
		JMenu mnPatient = new JMenu("Patient");
		mnPatient.setForeground(new Color(128, 0, 0));
		mnPatient.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		menuBar.add(mnPatient);
		
		JMenuItem mn_addPatient = new JMenuItem("ADD");
		mn_addPatient.setForeground(new Color(255, 127, 80));
		mn_addPatient.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mn_addPatient.setIcon(new ImageIcon(ReceptionistFrame.class.getResource("/doctorappointment/images/ADD.png")));
		mn_addPatient.addActionListener(this);
		mnPatient.add(mn_addPatient);
		
		JMenuItem mn_updatePatient = new JMenuItem("UPDATE");
		mn_updatePatient.setIcon(new ImageIcon(ReceptionistFrame.class.getResource("/doctorappointment/images/UPDATE.png")));
		mn_updatePatient.setForeground(new Color(0, 128, 0));
		mn_updatePatient.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mn_updatePatient.addActionListener(this);
		mnPatient.add(mn_updatePatient);
		
		JMenuItem mn_searchPatient = new JMenuItem("SEARCH");
		mn_searchPatient.setIcon(new ImageIcon(ReceptionistFrame.class.getResource("/doctorappointment/images/SEARCH.png")));
		mn_searchPatient.setForeground(new Color(255, 0, 0));
		mn_searchPatient.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mn_searchPatient.addActionListener(this);
		mnPatient.add(mn_searchPatient);
		
		JMenu mnReport = new JMenu("Report");
		mnReport.setForeground(new Color(255, 51, 204));
		mnReport.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		menuBar.add(mnReport);
		
		JMenuItem mnDoctor = new JMenuItem("All Doctors");
		mnDoctor.setForeground(new Color(204, 204, 0));
		mnDoctor.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnDoctor.addActionListener(this);
		mnReport.add(mnDoctor);
		
		JMenuItem mnDoctorIdWiseAppointment = new JMenuItem("DoctorIdWise Appointment");
		mnDoctorIdWiseAppointment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnDoctorIdWiseAppointment.addActionListener(this);
		mnReport.add(mnDoctorIdWiseAppointment);
		
		JMenuItem mnDateWiseAppointment = new JMenuItem("DateWise Appointment");
		mnDateWiseAppointment.setForeground(new Color(128, 0, 64));
		mnDateWiseAppointment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnDateWiseAppointment.addActionListener(this);
		mnReport.add(mnDateWiseAppointment);
		
		JMenu mnPatientFeedback = new JMenu("Feedback");
		mnPatientFeedback.setForeground(new Color(0, 128, 255));
		mnPatientFeedback.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		menuBar.add(mnPatientFeedback);
		
		JMenuItem mnFeedback = new JMenuItem("PatientFeedback");
		mnFeedback.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnFeedback.addActionListener(this);
		mnPatientFeedback.add(mnFeedback);
	}

	
	public void actionPerformed(ActionEvent e) {
		String caption = e.getActionCommand();
		switch (caption) {
		case "ADD":
			PatientDetails frame = new PatientDetails();
			frame.setVisible(true);
			break;
			
		case "UPDATE":
			UpdatePatientStatus frame1 = new UpdatePatientStatus();
			frame1.setVisible(true);
			break;
			
		case "SEARCH":
			PatientSearch frame2 = new PatientSearch();
			frame2.setVisible(true);
				break;
				
		case "PatientFeedback":
			Patient_FeedBack frame3 = new Patient_FeedBack();
			frame3.setVisible(true);
				break;
				
		case "All Doctors":
			AllDoctors frame4 = new AllDoctors();
			frame4.setVisible(true);
			break;
			
		case "DoctorIdWise Appointment":
			DoctorIdWiseAppointment frame5 = new DoctorIdWiseAppointment();
			frame5.setVisible(true);
			break;
			
		case "DateWise Appointment":
			DateWiseAppointment frame6 = new DateWiseAppointment();
			frame6.setVisible(true);
			break;
}
}
}