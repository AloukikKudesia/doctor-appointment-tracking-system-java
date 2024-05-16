package doctorappointment.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;
import doctorappointment.dbinfo.DBConnection;

public class DateWiseAppointment extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateWiseAppointment frame = new DateWiseAppointment();
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
	private JDateChooser dc;
	private JTable table;
	
	public DateWiseAppointment() {
		setResizable(false);
		setTitle("Date-wise Appointment");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 743, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(81, 31, 468, 71);
		contentPane.add(panel);
		panel.setLayout(null);

		dc = new JDateChooser();
		dc.setBounds(42, 22, 232, 28);
		panel.add(dc);
		dc.setDateFormatString("yyyy-MM-dd");
		dc.setBackground(SystemColor.activeCaption);

		JLabel lblNewLabel = new JLabel("Select a date");
		lblNewLabel.setBackground(Color.RED);
		dc.add(lblNewLabel, BorderLayout.WEST);

		JButton btngo = new JButton("GO");
		btngo.setBounds(316, 22, 104, 28);
		panel.add(btngo);
		btngo.addActionListener(this);
		btngo.addKeyListener(this);
		btngo.setFont(new Font("Tahoma", Font.BOLD, 14));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 641, 264);
		contentPane.add(scrollPane);

		table = new JTable();
		
		JTableHeader header = table.getTableHeader();
		header.setForeground(Color.GREEN);
		header.setFont(new Font("Arial", Font.PLAIN, 16));
		header.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(table);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
        
		int keyCode = e.getKeyCode();
		
		if(keyCode==10) {
			populateTable();	
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		populateTable();
		
	}

	public void populateTable() {
		java.util.Date d = dc.getDate();
		if (d == null) {
			JOptionPane.showMessageDialog(this, "Please select a date");
		}
		
		else {
			long dt = d.getTime();
			java.sql.Date sqlDate = new java.sql.Date(dt);
			
			Connection con = DBConnection.openConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String selectQuery = "select * from patient_details where date=?";
			try {
				ps = con.prepareStatement(selectQuery);
				ps.setDate(1, sqlDate);
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
	}
}

