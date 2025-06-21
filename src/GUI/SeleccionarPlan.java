package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import DLL.Conexion2;
import DLL.Login2;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class SeleccionarPlan extends JFrame {
	
	Conexion2 cn = new Conexion2();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionarPlan frame = new SeleccionarPlan();
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
	public SeleccionarPlan() {
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
		
		JLabel lblNewLabel_3_1 = new JLabel("Selecciona Tu Objetivo");
		lblNewLabel_3_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(48, 143, 188, 19);
		txtClientes.add(lblNewLabel_3_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\actualizar.png"));
		btnNewButton_1.setBounds(32, 265, 65, 54);
		txtClientes.add(btnNewButton_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\busc.png"));
		lblNewLabel_4_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4_1.setBackground(new Color(255, 140, 0));
		lblNewLabel_4_1.setBounds(389, 134, 32, 32);
		txtClientes.add(lblNewLabel_4_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(246, 144, 139, 22);
		txtClientes.add(comboBox);
		cargarObjetivos(comboBox);
	
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\Logout_37127.png"));
		btnNewButton_1_1.setBounds(329, 265, 65, 54);
		txtClientes.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_3_1_3 = new JLabel("Actualizar Rutina");
		lblNewLabel_3_1_3.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_3.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_3.setBounds(98, 300, 149, 19);
		txtClientes.add(lblNewLabel_3_1_3);
		
		JLabel lblNewLabel_3_1_4 = new JLabel("Cerrar sesión");
		lblNewLabel_3_1_4.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_4.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_4.setBounds(395, 300, 113, 19);
		txtClientes.add(lblNewLabel_3_1_4);
	}
	 public SeleccionarPlan(Login2 cliente) {
	        setTitle("Elegí tu plan");
	        setSize(600, 400);
	        setLocationRelativeTo(null);
	        getContentPane().setLayout(null);

	        JLabel titulo = new JLabel("Elegí tu plan de entrenamiento");
	        titulo.setBounds(170, 20, 300, 30);
	        titulo.setFont(new Font("Arial", Font.BOLD, 18));
	        getContentPane().add(titulo);

	        // Panel Básico
	        JTextArea planBasico = new JTextArea(
	            "🟠 Plan Básico\n\n" +
	            "✅ Rutinas personalizadas\n" +
	            "❌ Sin dieta\n" +
	            "💰 Precio: $5.000/mes"
	        );
	        planBasico.setBounds(50, 70, 200, 180);
	        planBasico.setEditable(false);
	        getContentPane().add(planBasico);

	        JButton btnBasico = new JButton("Elegir Básico");
	        btnBasico.setBounds(80, 260, 140, 30);
	        getContentPane().add(btnBasico);

	        // Panel VIP
	        JTextArea planVip = new JTextArea(
	            "🔵 Plan VIP\n\n" +
	            "✅ Rutina + Dieta personalizada\n" +
	            "✅ Beneficios exclusivos\n" +
	            "💰 Precio: $8.000/mes"
	        );
	        planVip.setBounds(330, 70, 200, 180);
	        planVip.setEditable(false);
	        getContentPane().add(planVip);

	        JButton btnVip = new JButton("Elegir VIP");
	        btnVip.setBounds(360, 260, 140, 30);
	        getContentPane().add(btnVip);

	        // Acción para elegir plan Básico
	        btnBasico.addActionListener(e -> {
	           //TODAVIA FALTA ESTA FUNCION asignarPlanBasico(cliente.getId());
	            new VistaCliente(cliente).setVisible(true);
	            dispose();
	        });

	        // Acción para elegir plan VIP
	        btnVip.addActionListener(e -> {
	           //TODAVIA FALTA ESTA FUNCION  asignarPlanVIP(cliente.getId());
	            new VistaCliente(cliente).setVisible(true);
	            dispose();
	        });
	    }
	 
}
