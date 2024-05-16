package doctorappointment.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import doctorappointment.gui.LoginFrame;
import doctorappointment.gui.SplashScreen;

public class SplashScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
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
	public SplashScreen() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		loadFrame();
		
		JLabel lblNewLabel = new JLabel("Doctor Appointment Tracking System");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setBounds(153, 45, 395, 40);
		contentPane.add(lblNewLabel);
		
		ImageIcon ic = new ImageIcon(LoginFrame.class.getResource("/doctorappointment/images/WALLPAPER1.jpg"));
		Image i2 = ic.getImage().getScaledInstance(727,444,Image.SCALE_DEFAULT);
		ImageIcon ic1 =new ImageIcon(i2);
		
		JLabel lblbgimage = new JLabel("");
		lblbgimage.setBounds(0, 0, 727, 444);
		lblbgimage.setIcon(ic1);
		contentPane.add(lblbgimage);
	}
	public void loadFrame() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(3000);
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
					SplashScreen.this.dispose();
				}
				catch(InterruptedException ie) {
					ie.printStackTrace();
				}
				
			}
		}
		);
		t.start();
	}
}
