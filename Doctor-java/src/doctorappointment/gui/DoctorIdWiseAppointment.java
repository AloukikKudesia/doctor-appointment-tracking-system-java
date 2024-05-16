package doctorappointment.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;
import doctorappointment.dbinfo.DBConnection;

public class DoctorIdWiseAppointment extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox<String> cmbdoctorId;
	private JScrollPane scrollPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorIdWiseAppointment frame = new DoctorIdWiseAppointment();
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
	public DoctorIdWiseAppointment() {
		setTitle("Doctor Id Wise Appointment");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 728, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(48, 34, 441, 50);
		contentPane.add(panel);
		panel.setLayout(null);

		cmbdoctorId = new JComboBox();
		cmbdoctorId.setBackground(Color.ORANGE);
		cmbdoctorId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		cmbdoctorId.setModel(new DefaultComboBoxModel(new String[] { "Select Doctor Id" }));
		cmbdoctorId.setBounds(50, 13, 152, 31);
		
		panel.add(cmbdoctorId);

		JButton btngo = new JButton("GO");
		
		btngo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btngo.setBounds(277, 17, 89, 23);
		btngo.addActionListener(this);
		
		
		panel.add(btngo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 125, 661, 210);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(Color.CYAN);
		JTableHeader header = table.getTableHeader();
		header.setForeground(Color.GREEN);
		header.setFont(new Font("Arial", Font.PLAIN, 16));
		header.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(table);
		fillCombo();
	}

	public void populateTable() {
		String DoctorId = (String) cmbdoctorId.getSelectedItem();
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectQuery = "select * from patient_details where DoctorId=?";
		try {
			ps = con.prepareStatement(selectQuery);
			ps.setString(1, DoctorId);
			rs = ps.executeQuery();
			TableModel tableModel = DbUtils.resultSetToTableModel(rs);
			table.setModel(tableModel);
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
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		populateTable();
	}

}
