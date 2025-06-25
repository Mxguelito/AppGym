package GUI;
import  DLL.LoginDAO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DLL.Conexion2;
import DLL.Login2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JComboBox;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputEmail;
	private JPasswordField txtPass;
	private JTextField inputNombreRegistro;
    private JComboBox comboBoxRegistro;
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
	
	//-------CONEXION--------
	Conexion2 cn = new Conexion2();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	//-----------------------
	public Registro() {
		
		UIManager.put("ComboBox.selectionBackground", new Color(52, 152, 219)); // FONDO CUANDO SELECCIONAS
		UIManager.put("ComboBox.selectionForeground", new Color(236, 240, 241)); // TEXTO BLANCO
		UIManager.put("ComboBox.background", new Color(44, 62, 80)); // FONDO BASE
		UIManager.put("ComboBox.foreground", new Color(236, 240, 241)); // TEXTO BASE 
		UIManager.put("ComboBox.border", BorderFactory.createLineBorder(new Color(41, 128, 185), 2));
		
		
		setBackground(new Color(10,20,40));
		
		
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
		lblNewLabel_2.setBounds(20, 54, 103, 26);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(20, 98, 103, 26);
		panel_1.add(lblNewLabel_3);
		
		inputEmail = new JTextField();
		inputEmail.setBackground(new Color(240, 240, 240));
		inputEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputEmail.setBounds(20, 79, 184, 20);
		panel_1.add(inputEmail);
		inputEmail.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBackground(new Color(240, 240, 240));
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPass.setBounds(20, 121, 184, 20);
		panel_1.add(txtPass);                    
		
		JButton botonLogin = new JButton("Continuar");
		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar();
			}
		});
		botonLogin.setForeground(new Color(255, 255, 255));
		botonLogin.setBackground(new Color(23, 150, 243));
		
		botonLogin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		botonLogin.setBounds(61, 249, 109, 32);
		botonLogin.setFocusPainted(false);
		botonLogin.setBorderPainted(false);
		
		panel_1.add(botonLogin);
		
		JPanel follow = new JPanel();
		follow.setForeground(Color.WHITE);
		follow.setBackground(new Color(244, 143, 177));
		follow.setBounds(61, 292, 109, 38);
		panel_1.add(follow);
		follow.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\img4.png"));
		lblNewLabel_4.setBounds(59, -1, 34, 39);
		follow.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Follow ");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_5.setBounds(20, 10, 39, 17);
		follow.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nombre");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_3_1.setBackground(Color.WHITE);
		lblNewLabel_3_1.setBounds(20, 139, 103, 26);
		panel_1.add(lblNewLabel_3_1);
		
		inputNombreRegistro = new JTextField();
		inputNombreRegistro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputNombreRegistro.setColumns(10);
		inputNombreRegistro.setBackground(UIManager.getColor("Button.background"));
		inputNombreRegistro.setBounds(20, 163, 184, 20);
		panel_1.add(inputNombreRegistro);
		
		JLabel lblNewLabel_2_1 = new JLabel("Identidad de acceso");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1.setBounds(20, 183, 150, 26);
		panel_1.add(lblNewLabel_2_1);
		
		
		 comboBoxRegistro = new JComboBox();
		
		 
		 comboBoxRegistro.addItem("Admin");
		 comboBoxRegistro.addItem("Entrenador");
		 comboBoxRegistro.addItem("Cliente");
		 comboBoxRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		 
		comboBoxRegistro.setBounds(20, 208, 150, 22);
		panel_1.add(comboBoxRegistro);
		
		
		
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
		String email= inputEmail.getText();
		String pass= String.valueOf(txtPass.getPassword());
		String nombre =inputNombreRegistro.getText();
		String tipo=comboBoxRegistro.getSelectedItem().toString();
		try {
			if (!"".equals(email) || !"".equals(pass)|| !"".equals(nombre)) {
				//----------------------------------------
				//-----INFORMACION------
				Login2 lg =new Login2();
				LoginDAO loginDAO =new LoginDAO();
		        //----------------------------------	
				lg.setNombre(nombre);
				lg.setEmail(email);
				lg.setPass(pass);
				lg.setTipo(tipo);
				String nombreUsuario=inputEmail.getText().trim();
				if (loginDAO.existeUsuario(nombreUsuario)) {
					JOptionPane.showMessageDialog(null, "Este usuario ya esta en uso...");
					Login iniciar =new Login();
					
					iniciar.setVisible(true);
					
					dispose();
					
					
					return;
					
				}
				 
				loginDAO.Registrar(lg);//ACA ESTA EL PROBLEMA---!!!!!!
	//---------------REGISTRADO---------------------------------			
			
				
				//--ABRO LA VISTA LOGIN-------
				Login iniciar =new Login();
				
				iniciar.setVisible(true);
				
				dispose();
				
				
				
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"No Registra Usuario");
		}
		//------------SI NO ESTA VACIO--------------------
	
	}
	public boolean existeUsuario(String usuario) {
	    String sql = "SELECT * FROM usuario WHERE nombre_usuario = ?";
	    try {
	    	con=cn.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, usuario);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            return true; // ya existe
	        }
	        rs.close(); ps.close(); con.close();
	    } catch (Exception e) {
	        System.out.println("Error al verificar usuario: " + e);
	    }
	    return false;
	}
}
