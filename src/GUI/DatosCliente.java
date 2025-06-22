package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import DLL.Cliente2;
import DLL.ClienteDAO2;
import DLL.Conexion2;
import DLL.Login2;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DatosCliente extends JFrame {
	
	Conexion2 cn = new Conexion2();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputEdad;
	private JTextField inputPeso;
	private JTextField inputAltura;
	private JTextField inputNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosCliente frame = new DatosCliente();
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
	public void cargarObjetivos(JComboBox<String> comboBox) {
		try {
			con=cn.getConnection();
			String sql="SELECT descripcion FROM objetivo";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				comboBox.addItem(rs.getString("descripcion"));
			}
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public DatosCliente() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(45, 62, 80));
		panel.setBounds(26, 11, 231, 522);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\img5.png"));
		lblNewLabel_2.setBounds(63, 11, 102, 109);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Clientes");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\cliente.png"));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(255, 128, 64));
		btnNewButton.setBounds(10, 165, 211, 23);
		panel.add(btnNewButton);
		
		JButton botonEntrenador = new JButton("Entrenadores");
		botonEntrenador.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\entrenador.png"));
		botonEntrenador.setForeground(Color.WHITE);
		botonEntrenador.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonEntrenador.setBackground(new Color(255, 128, 64));
		botonEntrenador.setBounds(10, 199, 211, 23);
		panel.add(botonEntrenador);
		
		JButton botonPlan = new JButton("Planes");
		botonPlan.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\planes.png"));
		botonPlan.setForeground(Color.WHITE);
		botonPlan.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonPlan.setBackground(new Color(255, 128, 64));
		botonPlan.setBounds(10, 233, 211, 23);
		panel.add(botonPlan);
		
		JButton botonDieta = new JButton("Dietas");
		botonDieta.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\dieta.png"));
		botonDieta.setForeground(Color.WHITE);
		botonDieta.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonDieta.setBackground(new Color(255, 128, 64));
		botonDieta.setBounds(10, 301, 211, 23);
		panel.add(botonDieta);
		
		JButton botonTienda = new JButton("Tienda");
		botonTienda.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\shop.png"));
		botonTienda.setForeground(Color.WHITE);
		botonTienda.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonTienda.setBackground(new Color(255, 128, 64));
		botonTienda.setBounds(10, 335, 211, 23);
		panel.add(botonTienda);
		
		JButton botonRutina = new JButton("Rutinas");
		botonRutina.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\rutina.png"));
		botonRutina.setForeground(Color.WHITE);
		botonRutina.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonRutina.setBackground(new Color(255, 128, 64));
		botonRutina.setBounds(10, 267, 211, 23);
		panel.add(botonRutina);
		
		JButton botonInventario = new JButton("Inventario");
		botonInventario.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\inventario.png"));
		botonInventario.setForeground(Color.WHITE);
		botonInventario.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonInventario.setBackground(new Color(255, 128, 64));
		botonInventario.setBounds(10, 369, 211, 23);
		panel.add(botonInventario);
		
		JButton botonVentas = new JButton("Ventas");
		botonVentas.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\ventas.png"));
		botonVentas.setForeground(Color.WHITE);
		botonVentas.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonVentas.setBackground(new Color(255, 128, 64));
		botonVentas.setBounds(10, 403, 211, 23);
		panel.add(botonVentas);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(267, 77, 523, 358);
		contentPane.add(tabbedPane);
		
		JPanel txtClientes = new JPanel();
		txtClientes.setLayout(null);
		txtClientes.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Usuario", null, txtClientes, null);
		
		JLabel lblNewLabel_3_1 = new JLabel(" Objetivo");
		lblNewLabel_3_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(26, 170, 92, 19);
		txtClientes.add(lblNewLabel_3_1);
		
		JComboBox comboObjetivo = new JComboBox();
		comboObjetivo.setBounds(128, 171, 139, 22);
		txtClientes.add(comboObjetivo);
		cargarObjetivos(comboObjetivo);
	
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\Logout_37127.png"));
		btnNewButton_1_1.setBounds(329, 265, 65, 54);
		txtClientes.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_3_1_4 = new JLabel("Cerrar sesión");
		lblNewLabel_3_1_4.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_4.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_4.setBounds(395, 300, 113, 19);
		txtClientes.add(lblNewLabel_3_1_4);
		JComboBox comboNivel = new JComboBox();
		comboNivel.setBounds(128, 138, 139, 22);
		comboNivel.addItem("Principiante");
		comboNivel.addItem("Intermedio");
		comboNivel.addItem("Avanzado");
		txtClientes.add(comboNivel);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Nivel");
		lblNewLabel_3_1_2.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_2.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_2.setBounds(32, 140, 92, 19);
		txtClientes.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_5 = new JLabel("Peso");
		lblNewLabel_3_1_5.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_5.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_5.setBounds(32, 80, 92, 19);
		txtClientes.add(lblNewLabel_3_1_5);
		
		JLabel lblNewLabel_3_1_6 = new JLabel("Altura");
		lblNewLabel_3_1_6.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_6.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_6.setBounds(32, 50, 92, 19);
		txtClientes.add(lblNewLabel_3_1_6);
		
		JLabel lblNewLabel_3_1_7 = new JLabel("Nombre");
		lblNewLabel_3_1_7.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_7.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_7.setBounds(32, 20, 92, 19);
		txtClientes.add(lblNewLabel_3_1_7);
		
		JLabel lblNewLabel_3_1_8 = new JLabel("Edad");
		lblNewLabel_3_1_8.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_8.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_8.setBounds(32, 110, 92, 19);
		txtClientes.add(lblNewLabel_3_1_8);
		
		
		
		inputEdad = new JTextField();
		inputEdad.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputEdad.setColumns(10);
		inputEdad.setBounds(128, 109, 139, 20);
		txtClientes.add(inputEdad);
		
		inputPeso = new JTextField();
		inputPeso.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputPeso.setColumns(10);
		inputPeso.setBounds(128, 80, 139, 20);
		txtClientes.add(inputPeso);
		
		inputAltura = new JTextField();
		inputAltura.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputAltura.setColumns(10);
		inputAltura.setBounds(128, 49, 139, 20);
		txtClientes.add(inputAltura);
		
		inputNombre = new JTextField();
		inputNombre.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputNombre.setColumns(10);
		inputNombre.setBounds(128, 20, 139, 20);
		txtClientes.add(inputNombre);
		
		JButton btnGuardarCliente = new JButton("");
		btnGuardarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				String nombre=inputNombre.getText();
				int altura =Integer.parseInt(inputAltura.getText());
				int peso =Integer.parseInt(inputPeso.getText());
				int edad =Integer.parseInt(inputEdad.getText());
				String nivel=comboNivel.getSelectedItem().toString();
				String objetivo=comboObjetivo.getSelectedItem().toString();
				ClienteDAO2 dao = new ClienteDAO2();
				Cliente2 cliente =new Cliente2();
				cliente.setNombre(nombre);
				cliente.setAltura(altura);
				cliente.setPeso(peso);
				cliente.setEdad(edad);
				cliente.setNivel(nivel);
				
				int idCliente=dao.registrarYdevolverId(cliente);
				dao.obtenerIdObjetivo(objetivo);
				
				SeleccionarPlan plan =new SeleccionarPlan();
				plan.setVisible(true);
				dispose();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error al guardar los datos");
				}
				
				
			}
		});
		btnGuardarCliente.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\guardar.png"));
		btnGuardarCliente.setBounds(32, 265, 65, 54);
		txtClientes.add(btnGuardarCliente);
	}
	
	 public void asignarPlanBasico(int idCliente,int idObjetivo,int idRutina) {
		 ClienteDAO2 dao=new ClienteDAO2();
		 dao.asignarPlanBasico(idCliente, idObjetivo, idRutina);
	 }
}
