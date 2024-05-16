package doctorappointment.manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import doctorappointment.gui.AllDoctors;
import doctorappointment.gui.DateWiseAppointment;
import doctorappointment.gui.DoctorIdWiseAppointment;
import doctorappointment.gui.LoginFrame;
import doctorappointment.manager.DoctorDetails;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class ManagerFrame extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerFrame frame = new ManagerFrame();
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
	public ManagerFrame() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 491);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manager Frame");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(275, 185, 178, 59);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 178, 22);
		contentPane.add(menuBar);
		
		JMenu mnDoctorDetails = new JMenu("Doctor Details");
		mnDoctorDetails.setForeground(new Color(0, 128, 0));
		mnDoctorDetails.setFont(new Font("Arial Unicode MS", Font.BOLD, 15));
		menuBar.add(mnDoctorDetails);
		
		JMenuItem mn_addDoctorDetails = new JMenuItem("ADD");
		mn_addDoctorDetails.setIcon(new ImageIcon(ManagerFrame.class.getResource("/doctorappointment/images/ADD.png")));
		mn_addDoctorDetails.setFont(new Font("Verdana", Font.BOLD, 13));
		mn_addDoctorDetails.setForeground(new Color(128, 64, 64));
		mn_addDoctorDetails.addActionListener(this);
		mnDoctorDetails.add(mn_addDoctorDetails);
		
		JMenuItem mn_updateDoctorDetails = new JMenuItem("UPDATE");
		mn_updateDoctorDetails.setIcon(new ImageIcon(ManagerFrame.class.getResource("/doctorappointment/images/UPDATE.png")));
		mn_updateDoctorDetails.setForeground(new Color(128, 0, 255));
		mn_updateDoctorDetails.setFont(new Font("Verdana", Font.BOLD, 13));
		mn_updateDoctorDetails.addActionListener(this);
		mnDoctorDetails.add(mn_updateDoctorDetails);
		
		JMenuItem mn_deleteDoctorDetails = new JMenuItem("DELETE");
		mn_deleteDoctorDetails.setIcon(new ImageIcon(ManagerFrame.class.getResource("/doctorappointment/images/DELETE.png")));
		mn_deleteDoctorDetails.setForeground(new Color(128, 0, 64));
		mn_deleteDoctorDetails.setFont(new Font("Verdana", Font.BOLD, 12));
		mn_deleteDoctorDetails.addActionListener(this);
		mnDoctorDetails.add(mn_deleteDoctorDetails);
		
		JMenu mnReport = new JMenu("Report");
		mnReport.setForeground(new Color(0, 128, 255));
		mnReport.setFont(new Font("Arial Unicode MS", Font.BOLD, 15));
		menuBar.add(mnReport);
		
		JMenuItem mnDoctor = new JMenuItem("All Doctors");
		mnDoctor.setForeground(Color.RED);
		mnDoctor.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnDoctor.addActionListener(this);
		mnReport.add(mnDoctor);
		
		JMenuItem mnDoctorIdWiseAppointment = new JMenuItem("DoctorIdWise Appointment");
		mnDoctorIdWiseAppointment.setForeground(new Color(204, 102, 255));
		mnDoctorIdWiseAppointment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnDoctorIdWiseAppointment.addActionListener(this);
		mnReport.add(mnDoctorIdWiseAppointment);
		
		JMenuItem mnDateWiseAppointment = new JMenuItem("DateWise Appointment");
		mnDateWiseAppointment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnDateWiseAppointment.addActionListener(this);
		mnReport.add(mnDateWiseAppointment);
	}

	
	public void actionPerformed(ActionEvent e) {
		String caption = e.getActionCommand();
		switch (caption) {
		case "ADD":
			DoctorDetails frame = new DoctorDetails();
			frame.setVisible(true);
			break;
			
		case "UPDATE":
			UpdateDoctorDetails frame1 = new UpdateDoctorDetails();
			frame1.setVisible(true);
			break;
			
		case "DELETE":
			DeleteDoctorDetails frame2 = new DeleteDoctorDetails();
			frame2.setVisible(true);
			break;
			
		case "All Doctors":
			AllDoctors frame3 = new AllDoctors();
			frame3.setVisible(true);
			break;
			
		case "DoctorIdWise Appointment":
			DoctorIdWiseAppointment frame4 = new DoctorIdWiseAppointment();
			frame4.setVisible(true);
			break;
			
		case "DateWise Appointment":
			DateWiseAppointment frame5 = new DateWiseAppointment();
			frame5.setVisible(true);
			break;
		
	}
}
}