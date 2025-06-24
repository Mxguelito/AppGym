package GUI;

import java.awt.EventQueue;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import BLL.Basico;
import BLL.Objetivo;
import BLL.Rutina;
import BLL.RutinaDAO;
import BLL.SesionUsuario;
import BLL.Vip;
import CONT.Dieta;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DatosCliente extends JFrame {
	
	Conexion2 cn = new Conexion2();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	//---------RUTINA-----------
	Rutina ru=new Rutina();
	RutinaDAO ruDAO=new RutinaDAO();
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputEdad;
	private JTextField inputPeso;
	private JTextField inputAltura;
	private JTextField inputNombre;
	private JTextField inputEdadCliente;
	private JTextField inputPesoCliente;
	private JTextField inputAlturaCliente;
	private JTextField inputNombreCliente;
	private JTextField inputTipoPlan;
	private JTextField inputNivelCliente;
	private JTextField inputObjetivoCliente;

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
		setSize(800,600);
		setLocationRelativeTo(null);

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
		
		JButton botonEntrenador = new JButton("Entrenadores");
		botonEntrenador.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\entrenador.png"));
		botonEntrenador.setForeground(Color.WHITE);
		botonEntrenador.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonEntrenador.setBackground(new Color(255, 128, 64));
		botonEntrenador.setBounds(10, 199, 211, 23);
		panel.add(botonEntrenador);
		
		JButton botonDieta = new JButton("Dietas");
		botonDieta.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\dieta.png"));
		botonDieta.setForeground(Color.WHITE);
		botonDieta.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonDieta.setBackground(new Color(255, 128, 64));
		botonDieta.setBounds(10, 267, 211, 23);
		panel.add(botonDieta);
		
		JButton botonTienda = new JButton("Tienda");
		botonTienda.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\shop.png"));
		botonTienda.setForeground(Color.WHITE);
		botonTienda.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonTienda.setBackground(new Color(255, 128, 64));
		botonTienda.setBounds(10, 301, 211, 23);
		panel.add(botonTienda);
		
		JButton botonRutina = new JButton("Rutinas");
		botonRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarRutina();
				tabbedPane.setSelectedIndex(2);
				
				
			}
		});
		botonRutina.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\rutina.png"));
		botonRutina.setForeground(Color.WHITE);
		botonRutina.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonRutina.setBackground(new Color(255, 128, 64));
		botonRutina.setBounds(10, 233, 211, 23);
		panel.add(botonRutina);
		
		 tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(267, 77, 523, 358);
		contentPane.add(tabbedPane);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Inicio", null, panel1, null);
		
		JLabel lblNewLabel_3_1 = new JLabel(" Objetivo");
		lblNewLabel_3_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(81, 255, 73, 19);
		panel1.add(lblNewLabel_3_1);
		
		JComboBox comboObjetivo = new JComboBox();
		comboObjetivo.setBounds(164, 256, 139, 22);
		comboObjetivo.setBackground(new Color(40,45,60));
		comboObjetivo.setForeground(Color.WHITE);
		comboObjetivo.setBorder(new LineBorder(Color.GRAY));
		comboObjetivo.setFont(new Font("Segoe UI",Font.PLAIN,14));
	
		panel1.add(comboObjetivo);
		cargarObjetivos(comboObjetivo);
	
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm=JOptionPane.showConfirmDialog(null, "Estas seguro de Cerrar sesión","Cerrar sesión",JOptionPane.YES_NO_OPTION);
				if (confirm==JOptionPane.YES_OPTION) {
					Login login =new Login();
					login.setVisible(true);
					dispose();
					
				}
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\eliminar (2).png"));
		btnNewButton_1_1.setBounds(455, 11, 53, 44);
		panel1.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_3_1_4 = new JLabel("Cerrar sesión");
		lblNewLabel_3_1_4.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_4.setFont(new Font("Bodoni MT", Font.BOLD, 12));
		lblNewLabel_3_1_4.setBounds(441, 50, 67, 19);
		panel1.add(lblNewLabel_3_1_4);
		JComboBox comboNivel = new JComboBox();
		comboNivel.setBounds(164, 212, 139, 22);
		comboNivel.setBackground(new Color(40,45,60));
		comboNivel.setForeground(Color.WHITE);
		comboNivel.setBorder(new LineBorder(Color.GRAY));
		comboNivel.setFont(new Font("Segoe UI",Font.PLAIN,14));
	
		comboNivel.addItem("Principiante");
		comboNivel.addItem("Intermedio");
		comboNivel.addItem("Avanzado");
		panel1.add(comboNivel);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Nivel");
		lblNewLabel_3_1_2.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_2.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_2.setBounds(111, 211, 43, 19);
		panel1.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_5 = new JLabel("Peso");
		lblNewLabel_3_1_5.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_5.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_5.setBounds(111, 114, 43, 19);
		panel1.add(lblNewLabel_3_1_5);
		
		JLabel lblNewLabel_3_1_6 = new JLabel("Altura");
		lblNewLabel_3_1_6.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_6.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_6.setBounds(100, 62, 54, 19);
		panel1.add(lblNewLabel_3_1_6);
		
		JLabel lblNewLabel_3_1_7 = new JLabel("Nombre");
		lblNewLabel_3_1_7.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_7.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_7.setBounds(68, 23, 92, 19);
		panel1.add(lblNewLabel_3_1_7);
		
		JLabel lblNewLabel_3_1_8 = new JLabel("Edad");
		lblNewLabel_3_1_8.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_8.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_8.setBounds(111, 163, 53, 19);
		panel1.add(lblNewLabel_3_1_8);
		
		
		
		inputEdad = new JTextField();
		inputEdad.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputEdad.setColumns(10);
		inputEdad.setBounds(164, 162, 139, 20);
		panel1.add(inputEdad);
		
		inputPeso = new JTextField();
		inputPeso.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputPeso.setColumns(10);
		inputPeso.setBounds(164, 113, 139, 20);
		panel1.add(inputPeso);
		
		inputAltura = new JTextField();
		inputAltura.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputAltura.setColumns(10);
		inputAltura.setBounds(164, 61, 139, 20);
		panel1.add(inputAltura);
		
		inputNombre = new JTextField();
		inputNombre.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputNombre.setColumns(10);
		inputNombre.setBounds(164, 23, 139, 20);
		panel1.add(inputNombre);
		
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
				
				Cliente2 clienteExistente =new Cliente2();
				clienteExistente=dao.obtenerClientePorUsuario2(SesionUsuario.id_usuario);
				
				if (clienteExistente !=null) {
					JOptionPane.showMessageDialog(null, "Ya tenes un plan asignado");
					
					int id_cliente=clienteExistente.getId_cliente();
					
					int idObjetivo=clienteExistente.getIdObjetivo();

					mostrarDatos(clienteExistente.getId_cliente());
					tabbedPane.setSelectedIndex(1);
					return;
					
				}
				
				Cliente2 cliente=new Cliente2();
				int idObjetivo=dao.obtenerIdObjetivo(objetivo);
				cliente.setNombre(nombre);
				cliente.setAltura(altura);
				cliente.setPeso(peso);
				cliente.setEdad(edad);
				cliente.setNivel(nivel);
				cliente.setIdObjetivo(idObjetivo);
				
				cliente.setId_usuario(SesionUsuario.id_usuario);
				int idCliente=dao.registrarYdevolverId(cliente);
				dao.obtenerIdObjetivo(objetivo);
				
				SeleccionarPlan plan =new SeleccionarPlan(idCliente,idObjetivo);
				
				plan.setVisible(true);
				dispose();
				
				
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error al guardar los datos");
				}
				
				
			}
		});
		btnGuardarCliente.setIcon(new ImageIcon("C:\\Users\\pc\\Downloads\\icons8-siguiente-48 (1).png"));
		btnGuardarCliente.setBounds(421, 150, 53, 44);
		panel1.add(btnGuardarCliente);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\icons8-objetivo-48.png"));
		btnNewButton_3.setBounds(313, 255, 38, 38);
		panel1.add(btnNewButton_3);
		
		JButton btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\icons8-cinta-métrica-48.png"));
		btnNewButton_1_2.setBounds(313, 61, 43, 38);
		panel1.add(btnNewButton_1_2);
		
		JButton btnNewButton_2_3 = new JButton("");
		btnNewButton_2_3.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\icons8-balanza-48.png"));
		btnNewButton_2_3.setBounds(313, 113, 43, 38);
		panel1.add(btnNewButton_2_3);
		
		JButton btnNewButton_2_1_1 = new JButton("");
		btnNewButton_2_1_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\icons8-cumpleaños-48.png"));
		btnNewButton_2_1_1.setBounds(313, 162, 40, 38);
		panel1.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_2_1 = new JButton("");
		btnNewButton_2_2_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\icons8-cerebro-48.png"));
		btnNewButton_2_2_1.setBounds(313, 211, 43, 38);
		panel1.add(btnNewButton_2_2_1);
		
		JButton btnNewButton_1_2_1 = new JButton("");
		btnNewButton_1_2_1.setIcon(new ImageIcon("C:\\Users\\pc\\Downloads\\icons8-documentos-de-identificación-comprobados-48.png"));
		btnNewButton_1_2_1.setBounds(313, 6, 48, 49);
		panel1.add(btnNewButton_1_2_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(10, 11, 5, 308);
		panel1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_7.setColumns(10);
		textField_7.setBounds(20, 11, 5, 308);
		panel1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_8.setColumns(10);
		textField_8.setBounds(30, 11, 5, 308);
		panel1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_9.setColumns(10);
		textField_9.setBounds(41, 11, 5, 308);
		panel1.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_10.setColumns(10);
		textField_10.setBounds(53, 11, 5, 308);
		panel1.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_11.setColumns(10);
		textField_11.setBounds(68, 315, 440, 4);
		panel1.add(textField_11);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Bienvenid@", null, panel2, null);
		panel2.setLayout(null);
		
		JLabel lblNewLabel_3_1_1 = new JLabel(" Objetivo");
		lblNewLabel_3_1_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_1.setBounds(370, 86, 75, 19);
		panel2.add(lblNewLabel_3_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm=JOptionPane.showConfirmDialog(null, "Estas seguro de Cerrar sesión","Cerrar sesión",JOptionPane.YES_NO_OPTION);
				if (confirm==JOptionPane.YES_OPTION) {
					Login login =new Login();
					login.setVisible(true);
					dispose();
					
				}}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\eliminar (2).png"));
		btnNewButton_1_1_1.setBounds(451, 11, 43, 35);
		panel2.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel_3_1_4_1 = new JLabel("Cerrar sesión");
		lblNewLabel_3_1_4_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_4_1.setFont(new Font("Bodoni MT", Font.BOLD, 12));
		lblNewLabel_3_1_4_1.setBounds(433, 45, 75, 19);
		panel2.add(lblNewLabel_3_1_4_1);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("Nivel");
		lblNewLabel_3_1_2_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_2_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_2_1.setBounds(335, 276, 57, 19);
		panel2.add(lblNewLabel_3_1_2_1);
		
		JLabel lblNewLabel_3_1_5_1 = new JLabel("Peso");
		lblNewLabel_3_1_5_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_5_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_5_1.setBounds(335, 182, 57, 19);
		panel2.add(lblNewLabel_3_1_5_1);
		
		JLabel lblNewLabel_3_1_6_1 = new JLabel("Altura");
		lblNewLabel_3_1_6_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_6_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_6_1.setBounds(335, 135, 65, 19);
		panel2.add(lblNewLabel_3_1_6_1);
		
		JLabel lblNewLabel_3_1_8_1 = new JLabel("Edad");
		lblNewLabel_3_1_8_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_8_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_8_1.setBounds(335, 223, 57, 19);
		panel2.add(lblNewLabel_3_1_8_1);
		
		inputEdadCliente = new JTextField();
		inputEdadCliente.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputEdadCliente.setColumns(10);
		inputEdadCliente.setBounds(186, 222, 139, 20);
		panel2.add(inputEdadCliente);
		
		inputPesoCliente = new JTextField();
		inputPesoCliente.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputPesoCliente.setColumns(10);
		inputPesoCliente.setBounds(186, 181, 139, 20);
		panel2.add(inputPesoCliente);
		
		inputAlturaCliente = new JTextField();
		inputAlturaCliente.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputAlturaCliente.setColumns(10);
		inputAlturaCliente.setBounds(186, 134, 139, 20);
		panel2.add(inputAlturaCliente);
		
		JLabel lblNewLabel_3_1_7_1_1 = new JLabel("Bienvenid@");
		lblNewLabel_3_1_7_1_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_7_1_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_7_1_1.setBounds(118, 11, 102, 19);
		panel2.add(lblNewLabel_3_1_7_1_1);
		
		inputNombreCliente = new JTextField();
		inputNombreCliente.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputNombreCliente.setColumns(10);
		inputNombreCliente.setBounds(230, 11, 123, 20);
		panel2.add(inputNombreCliente);
		
		JLabel lblNewLabel_3_1_8_1_1 = new JLabel("Plan");
		lblNewLabel_3_1_8_1_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_8_1_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_8_1_1.setBounds(128, 42, 50, 19);
		panel2.add(lblNewLabel_3_1_8_1_1);
		
		inputTipoPlan = new JTextField();
		inputTipoPlan.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputTipoPlan.setColumns(10);
		inputTipoPlan.setBounds(186, 41, 139, 20);
		panel2.add(inputTipoPlan);
		
		inputNivelCliente = new JTextField();
		inputNivelCliente.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputNivelCliente.setColumns(10);
		inputNivelCliente.setBounds(186, 275, 139, 20);
		panel2.add(inputNivelCliente);
		
		inputObjetivoCliente = new JTextField();
		inputObjetivoCliente.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputObjetivoCliente.setColumns(10);
		inputObjetivoCliente.setBounds(186, 85, 174, 20);
		panel2.add(inputObjetivoCliente);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\icons8-objetivo-48.png"));
		btnNewButton.setBounds(116, 72, 38, 38);
		panel2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\icons8-cinta-métrica-48.png"));
		btnNewButton_1.setBounds(116, 121, 43, 38);
		panel2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\icons8-balanza-48.png"));
		btnNewButton_2.setBounds(116, 170, 43, 38);
		panel2.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\icons8-cumpleaños-48.png"));
		btnNewButton_2_1.setBounds(116, 219, 40, 38);
		panel2.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("");
		btnNewButton_2_2.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\icons8-cerebro-48.png"));
		btnNewButton_2_2.setBounds(118, 269, 43, 38);
		panel2.add(btnNewButton_2_2);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_14.setColumns(10);
		textField_14.setBounds(10, 11, 5, 308);
		panel2.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_15.setColumns(10);
		textField_15.setBounds(22, 13, 5, 308);
		panel2.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_16.setColumns(10);
		textField_16.setBounds(37, 11, 5, 308);
		panel2.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_17.setColumns(10);
		textField_17.setBounds(52, 13, 5, 308);
		panel2.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_18.setColumns(10);
		textField_18.setBounds(67, 13, 5, 308);
		panel2.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_19.setColumns(10);
		textField_19.setBounds(82, 13, 5, 308);
		panel2.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_20.setColumns(10);
		textField_20.setBounds(97, 13, 5, 308);
		panel2.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_21.setColumns(10);
		textField_21.setBounds(503, 13, 5, 308);
		panel2.add(textField_21);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Rutina", null, panel3, null);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel(" Ejercicio");
		lblNewLabel_3_1_1_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_1_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_1_1.setBounds(129, 64, 83, 19);
		panel3.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel(" Series");
		lblNewLabel_3_2_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_2_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_2_1.setBounds(129, 94, 83, 19);
		panel3.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_3_1 = new JLabel(" VecesXsemana");
		lblNewLabel_3_3_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_3_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_3_1.setBounds(129, 124, 136, 19);
		panel3.add(lblNewLabel_3_3_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(233, 64, 139, 20);
		panel3.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(233, 94, 139, 20);
		panel3.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(269, 123, 139, 20);
		panel3.add(textField_3);
		
		JComboBox<String> comboBoxEntrenador = new JComboBox<String>();
		comboBoxEntrenador.setBounds(269, 154, 139, 22);
		comboBoxEntrenador.setBackground(new Color(40,45,60));
		comboBoxEntrenador.setForeground(Color.WHITE);
		comboBoxEntrenador.setBorder(new LineBorder(Color.GRAY));
		comboBoxEntrenador.setFont(new Font("Segoe UI",Font.PLAIN,14));
		panel3.add(comboBoxEntrenador);
		
		JLabel lblNewLabel_3_3_1_1 = new JLabel(" Entrenador");
		lblNewLabel_3_3_1_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_3_1_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_3_1_1.setBounds(129, 154, 136, 19);
		panel3.add(lblNewLabel_3_3_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 209, 498, 110);
		panel3.add(scrollPane);
		
		tableListarRutina = new JTable();
		tableListarRutina.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ejercicio", "Series", "VecesXsemana", "Entrenador"
			}
		));
		tableListarRutina.getColumnModel().getColumn(2).setPreferredWidth(86);
		scrollPane.setViewportView(tableListarRutina);
		
		textField = new JTextField();
		textField.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(10, 11, 498, 10);
		panel3.add(textField);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(10, 27, 498, 10);
		panel3.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(10, 43, 498, 10);
		panel3.add(textField_5);
	}
	public void mostrarDatos(int id_cliente) {
		ClienteDAO2 dao=new ClienteDAO2();
		Cliente2 cliente =dao.obtenerClientePorId(id_cliente);
		
		//MOSTRAMOS DATOS PERSONALES---
		 inputNombreCliente.setText(cliente.getNombre());
		 inputAlturaCliente.setText(String.valueOf(cliente.getAltura()));
		 inputPesoCliente.setText(String.valueOf(cliente.getPeso()));
		 inputEdadCliente.setText(String.valueOf(cliente.getEdad()));
		 inputNivelCliente.setText(String.valueOf(cliente.getNivel()));
		 
		 //MOSTRAR DESCRIPCION DEL OBJETIVO---------
		 Objetivo objetivo= new Objetivo();
		 String descripcionObjetivo=objetivo.obtenerNombreObjetivo(cliente.getIdObjetivo());//FALTA OBTENER LA DESCRIPCION POR ID----obtenerDescripcionPorId();
		 inputObjetivoCliente.setText(descripcionObjetivo);
		 
		 //DETERMINAR SI TIENE PLAN BASICO O VIP-------------
		 Basico basico =new Basico();
		  id_cliente=cliente.getId_cliente();
		 if (basico.tienePlanAsignado(id_cliente)) {
			 JOptionPane.showMessageDialog(null, "Este Cliente ya tiene un Plan basico asignado...");
			 return;
			
		}
		boolean encontrado= basico.obtenerPlanBasicoPorIdCliente(id_cliente);
		 if (encontrado) {
			 Rutina rutina=new Rutina();
			  rutina.obtenerRutinaPorObjetivo(basico.getIdObjetivo());
			  
			  
			  inputTipoPlan.setText("Basico");
			 
			  
			  }else {
				  Vip vip =new Vip();
				  if (vip.tienePlanAsignado(id_cliente)) {
					  JOptionPane.showMessageDialog(null, "Este Cliente ya tiene un Plan vip asignado...");
					  
					
					  
					
				}
				 boolean encontradoVip=vip.obtenerPlanVipPorIdCliente(id_cliente);
				  if (encontradoVip) {
					  inputTipoPlan.setText("VIP");
					  Rutina rutina =new Rutina();
					  rutina.obtenerRutinaPorObjetivo(id_cliente);
					 
					 //DIETA.OBTENERDIETAPORID(VIP.GETIDDIETA)-----
					  
					
					
				}
				  
			  }
		 
		 
		
		
		
	}
	public void ListarRutina() {

		List<Rutina> listarRutina=ruDAO.ListarRutina();
		DefaultTableModel modelo=(DefaultTableModel)tableListarRutina.getModel();
		
		
		modelo.setRowCount(0);
		
		Object[]ob =new Object[4];
		for(int i=0;i<listarRutina.size();i++) { 
			
			ob[0]=listarRutina.get(i).getEjercicio();
			ob[1]=listarRutina.get(i).getSeries();
			ob[2]=listarRutina.get(i).getVeces_semana();
			ob[3]=listarRutina.get(i).getEntrenador();
			
	
			modelo.addRow(ob);		}
		
		
		
		
			
			
		
		
		
	}
	
	public void mostrarBienvenida() {
		tabbedPane.setSelectedIndex(1);
	}
	private	JTabbedPane tabbedPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable tableListarRutina;
	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
}
