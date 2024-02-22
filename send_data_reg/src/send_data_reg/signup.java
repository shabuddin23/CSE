package send_data_reg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class signup {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	private JPasswordField p1;
	private JPasswordField p2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup window = new signup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 891, 558);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(81, 139, 88, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPassword.setBounds(81, 239, 137, 35);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(479, 139, 88, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPassword_1.setBounds(479, 239, 137, 35);
		frame.getContentPane().add(lblPassword_1);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		t1.setBounds(235, 139, 187, 35);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		t2.setColumns(10);
		t2.setBounds(627, 139, 187, 35);
		frame.getContentPane().add(t2);
		
		p1 = new JPasswordField();
		p1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		p1.setBounds(235, 239, 187, 35);
		frame.getContentPane().add(p1);
		
		p2 = new JPasswordField();
		p2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		p2.setBounds(626, 239, 187, 35);
		frame.getContentPane().add(p2);
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=t1.getText();
				String pswd=p1.getText();
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse","root","mrec");
					
					PreparedStatement stn=con.prepareStatement("select name,password from user where name=? and password=?");					
					stn.setString(1,user);
					stn.setString(2,pswd);
					ResultSet rs=stn.executeQuery();
					if(rs.next())
					{
						JOptionPane.showMessageDialog(btnNewButton, "Valid details\nLogin Done!!!");
						
					}
					else {
					JOptionPane.showMessageDialog(btnNewButton, "Invalid name (or) password");
					}
				} catch (SQLException e1) {
		
					e1.printStackTrace();
				}
			
				
			}
			
		});
		btnNewButton.setToolTipText("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(165, 370, 161, 54);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name1=t2.getText();
				String pswd1=p2.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cse","root","mrec");
					String g="insert into user values('"+name1+"','"+pswd1+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(g);
					JOptionPane.showMessageDialog(btnNewButton,  " sign up Done !!!");
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnSignUp.setToolTipText("Register");
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnSignUp.setBounds(566, 370, 161, 54);
		frame.getContentPane().add(btnSignUp);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 39));
		lblNewLabel_1.setBounds(179, 25, 123, 54);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sign up");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 39));
		lblNewLabel_1_1.setBounds(566, 25, 161, 54);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		
	}
}
