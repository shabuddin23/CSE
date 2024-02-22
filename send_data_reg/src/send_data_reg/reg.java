package send_data_reg;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class reg {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reg window = new reg();
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
	public reg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 64));
		frame.setBounds(100, 100, 742, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 30));
		lblNewLabel.setBounds(256, 11, 178, 80);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(149, 122, 113, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(149, 215, 113, 50);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Marks");
		lblNewLabel_1_2.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblNewLabel_1_2.setBounds(149, 303, 142, 50);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		t1.setBounds(369, 115, 204, 44);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		t2.setColumns(10);
		t2.setBounds(369, 200, 204, 44);
		frame.getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		t3.setColumns(10);
		t3.setBounds(369, 293, 204, 44);
		frame.getContentPane().add(t3);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String i=t1.getText();
				String name=t2.getText();
				String m=t3.getText();
				int id=Integer.parseInt(i);
				int marks=Integer.parseInt(m);
				 try {
					 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cse","root","mrec");
						String g="insert into student values('"+id+"','"+name+"','"+marks+"')";
						Statement sta=con.createStatement();
						sta.executeUpdate(g);
						con.close();
						JOptionPane.showMessageDialog(btnNewButton, "Registration Done !!!");
						
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(289, 429, 148, 58);
		frame.getContentPane().add(btnNewButton);
	}
}
