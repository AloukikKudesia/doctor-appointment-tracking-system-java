package doctorappointment.manager;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import doctorappointment.dbinfo.DBConnection;

public class DeleteDoctorDetails extends JFrame implements ActionListener,KeyListener {

	private JPanel contentPane;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteDoctorDetails frame = new DeleteDoctorDetails();
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
	public DeleteDoctorDetails() {
		setTitle("Delete Doctor Details");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DoctorId");
		lblNewLabel.setForeground(new Color(128, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(44, 13, 67, 14);
		contentPane.add(lblNewLabel);

		txtid = new JTextField();
		txtid.setFont(new Font("Verdana", Font.BOLD, 13));
		txtid.setForeground(Color.GREEN);
		txtid.setBounds(200, 9, 98, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNewButton.setBounds(222, 89, 89, 42);
		btnNewButton.addActionListener(this);
		btnNewButton.addKeyListener(this);
		contentPane.add(btnNewButton);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode==10) {
			deleteDoctorDetails();
		
	}
	}
	public void deleteDoctorDetails() {
		String DoctorId = txtid.getText().trim(); //String method->to remove leading and trailing
		if(DoctorId.length()==0) {
			JOptionPane.showMessageDialog(this,"Please provide Doctor Id");
		}
		else {
			int choice = JOptionPane.showConfirmDialog(this,"Do you Wish To delete"+DoctorId+"doctorId");
			
			if(choice==0) {
				Connection con = DBConnection.openConnection();
				PreparedStatement ps = null;
				String deleteQuery = "delete from doctor_details where DoctorId=?";
				try {
					ps = con.prepareStatement(deleteQuery);
					ps.setString(1,DoctorId);
					int result = ps.executeUpdate();
					if(result>0) {
						JOptionPane.showMessageDialog(this,DoctorId+"Doctor Details Deleted Successfully");
					}
					else {
						JOptionPane.showMessageDialog(this,DoctorId + "Does not exists in the records "," No data found error ",JOptionPane.ERROR_MESSAGE);
					}
					
				}
			catch(SQLException se) {
				se.printStackTrace();
			}
				finally {
					try {
						
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

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		deleteDoctorDetails(); 
		}

}
