package doctorappointment.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import doctorappointment.manager.ManagerFrame;
import doctorappointment.receptionist.ReceptionistFrame;
import doctorappointment.gui.LoginFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame implements ActionListener 
{

	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField userpassword;
	private JLabel lblNewLabel_1;
	private final ButtonGroup roles = new ButtonGroup();
	private JRadioButton rdmanager,rdreceptionist; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 501);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERID");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(113, 83, 65, 14);
		contentPane.add(lblNewLabel);
		
		userid = new JTextField();
		userid.setFont(new Font("Arial Black", Font.PLAIN, 12));
		userid.setForeground(Color.BLUE);
		userid.setBounds(250, 80, 133, 20);
		contentPane.add(userid);
		userid.setColumns(10);
		
		 lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(92, 169, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(289, 346, 109, 43);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		 rdmanager = new JRadioButton("Manager");
		 roles.add(rdmanager);
		rdmanager.setBackground(Color.MAGENTA);
		rdmanager.setFont(new Font("Verdana", Font.BOLD, 14));
		rdmanager.setBounds(147, 256, 109, 23);
		contentPane.add(rdmanager);
		
		 rdreceptionist = new JRadioButton("Receptionist");
		 roles.add(rdreceptionist);
		rdreceptionist.setBackground(Color.PINK);
		rdreceptionist.setFont(new Font("Verdana", Font.BOLD, 14));
		rdreceptionist.setBounds(317, 258, 121, 23);
		contentPane.add(rdreceptionist);
		
		userpassword = new JPasswordField();
		userpassword.setForeground(Color.BLACK);
		userpassword.setFont(new Font("Times New Roman", Font.BOLD, 12));
		userpassword.setBounds(250, 167, 133, 20);
		contentPane.add(userpassword);
		
		ImageIcon ic = new ImageIcon(LoginFrame.class.getResource("/doctorappointment/images/hospital.jpg"));
		Image i2 = ic.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		ImageIcon ic1 =new ImageIcon(i2);
		
		JLabel lblimage = new JLabel("");
		lblimage.setIcon(ic1);
		lblimage.setBounds(474, 61, 200, 300);
		contentPane.add(lblimage);
	}

	
	public void actionPerformed(ActionEvent e) {
        String id = userid.getText(); 
		
		char[]pwd = userpassword.getPassword(); 
	 
		String password = String.valueOf(pwd);
		
		String userRole = "";
		if(rdmanager.isSelected()==true)
			userRole = rdmanager.getText();
		if(rdreceptionist.isSelected()==true)
			userRole = rdreceptionist.getText(); 
			
		if(id.isEmpty()||password.isEmpty()) 
		{
		JOptionPane.showMessageDialog(this,"Please provide ID and Password with Role");	
		}
		else {
			if(id.equalsIgnoreCase("unacademy")&& password.equals("Lucknow")&& userRole.equals("Manager")) 
			{
				
				
				ManagerFrame frame = new ManagerFrame();
				frame.setVisible(true);
				
				this.dispose();
			}
			else if(id.equalsIgnoreCase("shubh")&& password.equals("0721")&& userRole.equals("Receptionist")) 
			{
		
				
				ReceptionistFrame frame = new ReceptionistFrame();
				frame.setVisible(true);
				
				this.dispose(); 
			}
			else {
				JOptionPane.showMessageDialog(this,"Invalid credentials");
			}
		}
	
		
	}
}
