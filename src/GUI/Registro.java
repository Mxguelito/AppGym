package GUI;
import  DLL.LoginDAO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DLL.Login2;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setBackground(Color.RED);
		
		
		setSize(800,600);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 23, 42));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(30, 30, 30));
		lblNewLabel.setIcon(null);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 24));
		lblNewLabel.setBounds(497, 0, 277, 550);
		panel.add(lblNewLabel);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(44, 62, 80,200));
		panel_1.setBounds(283, 122, 221, 341);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(91, 11, 32, 32);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\img3.png"));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(20, 78, 103, 26);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(20, 166, 103, 26);
		panel_1.add(lblNewLabel_3);
		
		txtEmail = new JTextField();
		txtEmail.setBackground(new Color(240, 240, 240));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setBounds(20, 104, 184, 20);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBackground(new Color(240, 240, 240));
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPass.setBounds(20, 192, 184, 20);
		panel_1.add(txtPass);                    
		
		JButton botonLogin = new JButton("Login");
		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar();
			}
		});
		botonLogin.setForeground(new Color(255, 255, 255));
		botonLogin.setBackground(new Color(255, 115, 0));
		
		botonLogin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		botonLogin.setBounds(61, 223, 109, 32);
		botonLogin.setFocusPainted(false);
		botonLogin.setBorderPainted(false);
		
		panel_1.add(botonLogin);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBackground(new Color(233, 30, 99));
		panel_2.setBounds(61, 280, 109, 38);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\img4.png"));
		lblNewLabel_4.setBounds(59, -1, 34, 39);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Follow ");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_5.setBounds(20, 10, 39, 17);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\img5.png"));
		lblNewLabel_6.setBounds(339, 11, 107, 107);
		panel.add(lblNewLabel_6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0,50));
		panel_3.setBounds(293, 122, 240, 375);
		panel.add(panel_3);
		
	}
	public void validar() { 
		String email= txtEmail.getText();
		String pass= String.valueOf(txtPass.getPassword());
		
		//------------SI NO ESTA VACIO--------------------
		if (!"".equals(email) || !"".equals(pass)) {
			//----------------------------------------
			//-----INFORMACION------
			Login2 lg =new Login2();
			
			
			LoginDAO login =new LoginDAO();
			
			lg=login.log(email,pass);
			
			if (lg.getEmail()!=null&&lg.getPass()!=null) {
				
			Sistema sis =new Sistema();
			
			sis.setVisible(true);
			
			dispose();
			
			}else {
				JOptionPane.showMessageDialog(null,"Email o Contraseña Incorrecta...");
			}
			
			
		}
	}
}
