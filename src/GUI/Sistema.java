package GUI;
import BLL.Detalle;
import BLL.Entrenador;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BLL.Entrenador;
import BLL.EntrenadorDAO;
import BLL.Eventos;
import BLL.Rutina;
import BLL.RutinaDAO;
import BLL.Venta;
import BLL.VentaDAO;
import DLL.Cliente2;
import DLL.ClienteDAO2;
import DLL.Login2;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import BLL.Producto;
import BLL.ProductoDAO;

public class Sistema extends JFrame {
	
	private JTabbedPane tabbedPane;
//--------CLIENTE-----------------------
	Cliente2 cl=new Cliente2();
	ClienteDAO2 client= new ClienteDAO2();
	DefaultTableModel modelo;
//----------ENTRENADOR------------------------------	
	Entrenador en = new Entrenador();
	EntrenadorDAO enDAO=new EntrenadorDAO();
	//---------RUTINA-----------
	Rutina ru=new Rutina();
	RutinaDAO ruDAO=new RutinaDAO();
	//------------------------------------
	Producto pro=new Producto();
	ProductoDAO proDAO=new ProductoDAO();
	//--------------------------------
	int item;
	double totalPagar=0.00;
	//----------------------------------
	Venta v =new Venta();
	VentaDAO vDAO= new VentaDAO();
	//--------------------------------------
	Detalle dv=new Detalle();
	//--------------
	Eventos evento=new Eventos();
	
	
	
	
	
	
	
	
	
	
	
	public void ListarVenta() {

		List<Venta> listarVenta=vDAO.ListarVenta();
		modelo=(DefaultTableModel) table6_2.getModel();
		
		modelo.setRowCount(0);
		
		Object[]ob =new Object[4];
		for(int i=0;i<listarVenta.size();i++) { 
			ob[0]=listarVenta.get(i).getId_venta();
			ob[1]=listarVenta.get(i).getCliente();
			ob[2]=listarVenta.get(i).getVendedor();
			ob[3]=listarVenta.get(i).getTotal();
			
		
	
			modelo.addRow(ob);	
			table6_2.setModel(modelo);}
		
		
		
		
			
			
		
		
		
	}
	
     
	public void ListarCliente() {


		List<Cliente2> ListarCl=client.ListarCliente();
		modelo=(DefaultTableModel) table.getModel();
		
		modelo.setRowCount(0);
		
		Object[]ob =new Object[6];
		for(int i=0;i<ListarCl.size();i++) { 
			ob[0]=ListarCl.get(i).getId_cliente();
			ob[1]=ListarCl.get(i).getNombre();
			ob[2]=ListarCl.get(i).getAltura();
			ob[3]=ListarCl.get(i).getPeso();
			ob[4]=ListarCl.get(i).getEdad();
			ob[5]=ListarCl.get(i).getNivel();
			
			modelo.addRow(ob);		}
		//----OCULTO LA COLUMNA ID PORQUE LO NECESITAMOS PARA ELIMINAR-----
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setWidth(0);
		
			
			
		
		
		
	}
	public void ListarEntrenador() {


		List<Entrenador> listarEntrenador=enDAO.ListarEntrenador();
		modelo=(DefaultTableModel) table2.getModel();
		
		modelo.setRowCount(0);
		
		Object[]ob =new Object[4];
		for(int i=0;i<listarEntrenador.size();i++) { 
			ob[0]=listarEntrenador.get(i).getId_entrenador();
			ob[1]=listarEntrenador.get(i).getNombre();
			ob[2]=listarEntrenador.get(i).getTelefono();
			ob[3]=listarEntrenador.get(i).getEspecializacion();
	
			modelo.addRow(ob);		}
		
		
		
		
			
			
		
		
		
	}
	public void ListarRutina() {

		List<Rutina> listarRutina=ruDAO.ListarRutina();
		modelo=(DefaultTableModel) table4.getModel();
		
		modelo.setRowCount(0);
		
		Object[]ob =new Object[6];
		for(int i=0;i<listarRutina.size();i++) { 
			ob[0]=listarRutina.get(i).getId_rutina();
			ob[1]=listarRutina.get(i).getCodigo();
			ob[2]=listarRutina.get(i).getEjercicio();
			ob[3]=listarRutina.get(i).getSeries();
			ob[4]=listarRutina.get(i).getVeces_semana();
			ob[5]=listarRutina.get(i).getEntrenador();
	
			modelo.addRow(ob);		}
		
		
		
		
			
			
		
		
		
	}
	public void ListarProducto() {

		List<Producto> listarProducto=proDAO.ListarProducto();
		modelo=(DefaultTableModel) table7.getModel();
		
		modelo.setRowCount(0);
		
		Object[]ob =new Object[5];
		for(int i=0;i<listarProducto.size();i++) { 
			ob[0]=listarProducto.get(i).getId_producto();
			ob[1]=listarProducto.get(i).getCodigo();
			ob[2]=listarProducto.get(i).getNombre();
			ob[3]=listarProducto.get(i).getStock();
			ob[4]=listarProducto.get(i).getPrecio();
		
	
			modelo.addRow(ob);		}
		
		
		
		
			
			
		
		
		
	}
	
	
	
	
public 	void LimpiarTable() {
	for (int i = 0; i < modelo.getRowCount(); i++) {
		modelo.removeRow(i);
		i=i-1;
		
	}
}
	private static final long serialVersionUID = 1L;
	private JTextField textId_cliente;
	private JTextField textNombre;
	private JTextField textAltura;
	private JTextField textPeso;
	private JTextField textEdad;
	private JTextField textNivel;
	private JTable table;
	private JTextField inputNombreEntrenador;
	private JTextField inputTelefonoEntrenador;
	private JTextField inputEspecializacionEntrenador;
	private JTable table2;
	private JTextField inputCodigoRutina;
	private JTextField inputEjercicioRutina;
	private JTextField inputSeriesRutina;
	private JTextField inputVecesXsemanaRutina;
	private JTable table4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema frame = new Sistema();
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
	private JComboBox<String> comboBoxEntrenador;
	private JTextField inputCodigoTienda;
	private JTextField inputNombreTienda;
	private JTextField inputPrecioTienda;
	private JTextField inputCantidadTienda;
	private JTable table6;
	private JTable table6_2;
	private JTextField inputStockDisponibleTienda;
	private JTextField inputIdTienda;
	private JTextField inputClienteTienda;
	private JTextField inputTotal;
	private JTextField inputCodigoInventario;
	private JTextField inputNombreInventario;
	private JTextField inputCantidadInventario;
	private JTextField inputPrecioInventario;
	private JTable table7;
	
	public Sistema (Login2 privilegios) {
		this();
		if (privilegios.getTipo().equals("Entrenador")) {
			labelAdmin.setEnabled(false);
			botonTienda.setEnabled(false);
			botonInventario.setEnabled(false);
			botonVentas.setEnabled(false);
			
		}else {
			labelAdmin.setEnabled(true);
			botonTienda.setEnabled(true);
			botonInventario.setEnabled(true);
			botonVentas.setEnabled(true);
			labelEntrenador.setEnabled(false);
		}
	 
		
	}
	public Sistema() {
	
		getContentPane().setBackground(new Color(45, 62, 80));
		
	
		inicializarTextField();
		
		
		
		getContentPane().setFont(new Font("Bodoni MT", Font.PLAIN, 20));

		setSize(800,600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		tabbedPane=new JTabbedPane();
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 231, 522);
		panel.setBackground(new Color(45, 62, 80));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		
	
		
		
		
	
		
	
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\img5.png"));
		lblNewLabel_2.setBounds(63, 11, 102, 109);
		panel.add(lblNewLabel_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(251, 66, 523, 358);
		getContentPane().add(tabbedPane);
		
		
		
		JPanel txtClientes = new JPanel();
		txtClientes.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Clientes", null, txtClientes, null);
		txtClientes.setLayout(null);

		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setBounds(10, 29, 94, 19);
		lblNewLabel_3.setForeground(new Color(0, 51, 102));
		lblNewLabel_3.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		txtClientes.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Altura");
		lblNewLabel_3_1.setBounds(10, 59, 94, 19);
		lblNewLabel_3_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		txtClientes.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Peso");
		lblNewLabel_3_2.setBounds(10, 89, 94, 19);
		lblNewLabel_3_2.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_2.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		txtClientes.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Edad");
		lblNewLabel_3_3.setBounds(10, 119, 94, 19);
		lblNewLabel_3_3.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_3.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		txtClientes.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Nivel");
		lblNewLabel_3_4.setBounds(10, 149, 94, 19);
		lblNewLabel_3_4.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_4.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		txtClientes.add(lblNewLabel_3_4);
		
		
		textNombre = new JTextField();
		textNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				evento.ValidacionesCaracteres(e);
			}
		});
		textNombre.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textNombre.setBounds(114, 29, 139, 20);
		txtClientes.add(textNombre);
		textNombre.setColumns(10);
		
		textAltura = new JTextField();
		textAltura.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				evento.ValidacionesNumeros(e);
			}
		});
		textAltura.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textAltura.setBounds(114, 59, 139, 20);
		textAltura.setColumns(10);
		txtClientes.add(textAltura);
		
		textPeso = new JTextField();
		textPeso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				evento.ValidacionesNumeros(e);
			}
		});
		textPeso.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textPeso.setBounds(114, 89, 139, 20);
		textPeso.setColumns(10);
		txtClientes.add(textPeso);
		
		textEdad = new JTextField();
		textEdad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				evento.ValidacionesNumeros(e);
			}
		});
		textEdad.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textEdad.setBounds(114, 119, 139, 20);
		textEdad.setColumns(10);
		txtClientes.add(textEdad);
		
		textNivel = new JTextField();
		textNivel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				evento.ValidacionesCaracteres(e);
			}
		});
		textNivel.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		textNivel.setBounds(114, 149, 139, 20);
		textNivel.setColumns(10);
		txtClientes.add(textNivel);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int fila=table.getSelectedRow();
				if (fila==-1) {
					JOptionPane.showMessageDialog(null, "seleccione una fila");
				}else {
					
					if ("".equals(textNombre.getText())  || "".equals(textAltura.getText()) || "".equals(textPeso.getText()) || "".equals(textEdad.getText()) || "".equals(textNivel.getText())){
						JOptionPane.showMessageDialog(null,"Los campos estan vacios");
					}
						
						
						else {
							try {
								int id=Integer.parseInt(table.getValueAt(fila, 0).toString());
								Cliente2 cl=new Cliente2();
								cl.setNombre(textNombre.getText());
								cl.setAltura(Integer.parseInt(textAltura.getText()));
								cl.setPeso(Integer.parseInt(textPeso.getText()));
								cl.setEdad(Integer.parseInt(textEdad.getText()));
								cl.setNivel(textNivel.getText());

								cl.setId_cliente(id);
								client.ModificarCliente(cl);
								
								JOptionPane.showMessageDialog(null,"Cliente actualizado");
								textNombre.setText("");
								textAltura.setText("");
								textPeso.setText("");
								textEdad.setText("");
								textNivel.setText("");
								table.clearSelection();
								ListarCliente();
								
							} catch (Exception e2) {
								e2.printStackTrace();
								JOptionPane.showMessageDialog(null,"No se pudo actualizar ");
							}
						
						//-----------------
					
						
						
					}}}
					
					
				
			
		});
		//SE OCULTA EL ID-----
		
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\actualizar.png"));
		btnNewButton_1.setBounds(430, 84, 65, 54);
		txtClientes.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila=table.getSelectedRow();
				if(fila==-1) {
					JOptionPane.showMessageDialog(null,"Por favor selecione un Cliente para Eliminar");
				
					
				} else {	int pregunta=JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar?");
				if (pregunta==0) {
					int id=Integer.parseInt(table.getValueAt(fila,0).toString());
					client.EliminarCliente(id);
					
					ListarCliente();
					
					textNombre.setText("");
					textAltura.setText("");
					textPeso.setText("");
					textEdad.setText("");
					textNivel.setText("");
					table.clearSelection();
					

				}
				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\eliminar.png"));
		btnNewButton_2.setBounds(280, 84, 65, 53);
		txtClientes.add(btnNewButton_2);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!"".equals(textNombre.getText())  || !"".equals(textAltura.getText()) ||!"".equals(textPeso.getText())||!"".equals(textEdad.getText())||!"".equals(textNivel.getText())) {
					cl.setNombre(textNombre.getText());
					cl.setAltura(Integer.parseInt(textAltura.getText()));
					cl.setPeso(Integer.parseInt(textPeso.getText()));
					cl.setEdad(Integer.parseInt(textEdad.getText()));
					cl.setNivel(textNivel.getText());
					
					client.RegistrarCliente(cl);
					
					ListarCliente();
					textNombre.setText("");
					textAltura.setText("");
					textPeso.setText("");
					textEdad.setText("");
					textNivel.setText("");
					table.clearSelection();
					
					JOptionPane.showMessageDialog(null,"Cliente Registrado");
					
				}else {
					JOptionPane.showMessageDialog(null,"Los Campos estan Vacios...");
					
				}
				
			}
		});
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\guardar.png"));
		btnGuardar.setBounds(355, 84, 65, 54);
		txtClientes.add(btnGuardar);
		JButton botonEntrenador = new JButton("Entrenadores");
		botonEntrenador.setForeground(new Color(255, 255, 255));
		botonEntrenador.setBackground(new Color(255, 128, 64));
		botonEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListarEntrenador();
				tabbedPane.setSelectedIndex(1);
				inputNombreEntrenador.setText("");
				inputTelefonoEntrenador.setText("");
				inputEspecializacionEntrenador.setText("");
				
				table2.clearSelection();
				
				
				
			}
		});
		botonEntrenador.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonEntrenador.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\entrenador.png"));
		botonEntrenador.setBounds(10, 165, 211, 23);
		panel.add(botonEntrenador);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 238, 508, 64);
		txtClientes.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				int fila =table.rowAtPoint(e.getPoint());
				textNombre.setText(table.getValueAt(fila, 1).toString());
				textAltura.setText(table.getValueAt(fila, 2).toString());
				textPeso.setText(table.getValueAt(fila, 3).toString());
				textEdad.setText(table.getValueAt(fila, 4).toString());
				textNivel.setText(table.getValueAt(fila, 5).toString());
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre", "Altura", "Peso", "Edad", "Nivel"
			}
		));
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\busc.png"));
		lblNewLabel_4_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4_1.setBackground(new Color(255, 140, 0));
		lblNewLabel_4_1.setBounds(254, 22, 31, 37);
		txtClientes.add(lblNewLabel_4_1);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Entrenadores", null, panel2, null);
		panel2.setLayout(null);
		
		JLabel lblNewLabel_3_5 = new JLabel("Nombre");
		lblNewLabel_3_5.setBounds(10, 63, 80, 19);
		lblNewLabel_3_5.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_5.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		panel2.add(lblNewLabel_3_5);
		
		inputNombreEntrenador = new JTextField();
		inputNombreEntrenador.setBounds(100, 62, 123, 20);
		inputNombreEntrenador.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputNombreEntrenador.setColumns(10);
		panel2.add(inputNombreEntrenador);
		
		JLabel lblNewLabel_3_5_1 = new JLabel("Teléfono");
		lblNewLabel_3_5_1.setBounds(10, 111, 80, 19);
		lblNewLabel_3_5_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_5_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		panel2.add(lblNewLabel_3_5_1);
		
		JLabel lblNewLabel_3_5_2 = new JLabel("Especialización");
		lblNewLabel_3_5_2.setBounds(10, 159, 139, 19);
		lblNewLabel_3_5_2.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_5_2.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		panel2.add(lblNewLabel_3_5_2);
		
		inputTelefonoEntrenador = new JTextField();
		inputTelefonoEntrenador.setBounds(100, 110, 123, 20);
		inputTelefonoEntrenador.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputTelefonoEntrenador.setColumns(10);
		panel2.add(inputTelefonoEntrenador);
		
		inputEspecializacionEntrenador = new JTextField();
		inputEspecializacionEntrenador.setBounds(162, 158, 196, 20);
		inputEspecializacionEntrenador.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputEspecializacionEntrenador.setColumns(10);
		panel2.add(inputEspecializacionEntrenador);
		
		JButton botonEliminarEntrenador = new JButton("");
		botonEliminarEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila=table2.getSelectedRow();
				if(fila==-1) {
					JOptionPane.showMessageDialog(null,"Por favor selecione un Entrenador para Eliminar");
				
					
				} else {	int pregunta=JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar?");
				if (pregunta==0) {
					int id=Integer.parseInt(table2.getValueAt(fila,0).toString());
					 enDAO.EliminarEntrenador(id);
					
					ListarEntrenador();
					
					inputNombreEntrenador.setText("");
					inputTelefonoEntrenador.setText("");
					inputEspecializacionEntrenador.setText("");
					
					table2.clearSelection();
					

				}
				}
			}
		});
		botonEliminarEntrenador.setBounds(293, 76, 65, 53);
		botonEliminarEntrenador.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\eliminar.png"));
		panel2.add(botonEliminarEntrenador);
		
		JButton botonGuardarEntrenador = new JButton("");
		botonGuardarEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!"".equals(inputNombreEntrenador.getText()) || !"".equals(inputTelefonoEntrenador.getText()) || !"".equals(inputEspecializacionEntrenador.getText())) {
			//------------------
					
					en.setNombre(inputNombreEntrenador.getText());
					en.setTelefono(Integer.parseInt(inputTelefonoEntrenador.getText()));
					en.setEspecializacion(inputEspecializacionEntrenador.getText());
					//REGISTRA ENTRENADOR---
					enDAO.RegistrarEntrenador(en);
	
					
					ListarEntrenador();
					inputNombreEntrenador.setText("");
					inputTelefonoEntrenador.setText("");
					inputEspecializacionEntrenador.setText("");
					
					table2.clearSelection();
					
					
					
					JOptionPane.showMessageDialog(null,"Entrenador Registrado..." );
					
				}else {
					JOptionPane.showMessageDialog(null,"No se pudo registrar..." );
					
				}
			}
		});
		botonGuardarEntrenador.setBounds(368, 76, 65, 54);
		botonGuardarEntrenador.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\guardar.png"));
		panel2.add(botonGuardarEntrenador);
		
		JButton botonActualizarEntrenador = new JButton("");
		botonActualizarEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int fila=table2.getSelectedRow();
				if (fila==-1) {
					JOptionPane.showMessageDialog(null, "seleccione una fila");
				}else {
					
					if ("".equals(inputNombreEntrenador.getText())  || "".equals(inputTelefonoEntrenador.getText()) || "".equals(inputEspecializacionEntrenador.getText())){
						JOptionPane.showMessageDialog(null,"Los campos estan vacios");
					}
						
						
						else {
							try {
								int id=Integer.parseInt(table2.getValueAt(fila, 0).toString());
								Entrenador en=new Entrenador();
								en.setNombre(inputNombreEntrenador.getText());
								en.setTelefono(Integer.parseInt(inputTelefonoEntrenador.getText()));
								en.setEspecializacion(inputEspecializacionEntrenador.getText());
								

								en.setId_entrenador(id);
								enDAO.ModificarEntrenador(en);
								
								JOptionPane.showMessageDialog(null,"Entrenador actualizado");
								inputNombreEntrenador.setText("");
								inputTelefonoEntrenador.setText("");
								inputEspecializacionEntrenador.setText("");
								
								table2.clearSelection();
								ListarEntrenador();
								
							} catch (Exception e1) {
								System.out.println(e1.toString());
								JOptionPane.showMessageDialog(null,"No se pudo actualizar ");
							}
						}}}
						
						
					
						
					});
					
					
					
		botonActualizarEntrenador.setBounds(443, 76, 65, 54);
		botonActualizarEntrenador.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\actualizar.png"));
		panel2.add(botonActualizarEntrenador);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 234, 508, 85);
		panel2.add(scrollPane_1);
		
		table2 = new JTable();
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//ESTO ES PARA MOSTRAR LOS DATOS EN LA TABLA AL HACER CLICK---
				int fila =table2.rowAtPoint(e.getPoint());
				inputNombreEntrenador.setText(table2.getValueAt(fila,1).toString());
				inputTelefonoEntrenador.setText(table2.getValueAt(fila,2).toString());
				inputEspecializacionEntrenador.setText(table2.getValueAt(fila,3).toString());	

				
				
				
			
				
			}
		});
		scrollPane_1.setViewportView(table2);
		table2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre", "Telefono", "Especializacion"
			}
		));
		table2.getColumnModel().getColumn(3).setPreferredWidth(87);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\busc.png"));
		lblNewLabel_4_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4_2.setBackground(new Color(255, 140, 0));
		lblNewLabel_4_2.setBounds(233, 50, 31, 37);
		panel2.add(lblNewLabel_4_2);
		
		JPanel panel3 = new JPanel();
		tabbedPane.addTab("Planes", null, panel3, null);
		JButton botonPlan = new JButton("Planes");
		botonPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
				
			}
		});
		botonPlan.setForeground(new Color(255, 255, 255));
		botonPlan.setBackground(new Color(255, 128, 64));
		botonPlan.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonPlan.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\planes.png"));
		botonPlan.setBounds(10, 233, 211, 23);
		panel.add(botonPlan);
		
		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Rutinas", null, panel4, null);
		panel4.setLayout(null);
		
		JLabel lblNewLabel_3_6 = new JLabel(" Código");
		lblNewLabel_3_6.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_6.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_6.setBounds(0, 29, 83, 19);
		panel4.add(lblNewLabel_3_6);
		
		JLabel lblNewLabel_3_1_1 = new JLabel(" Ejercicio");
		lblNewLabel_3_1_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_1.setBounds(0, 59, 83, 19);
		panel4.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel(" Series");
		lblNewLabel_3_2_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_2_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_2_1.setBounds(0, 89, 83, 19);
		panel4.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_3_1 = new JLabel(" VecesXsemana");
		lblNewLabel_3_3_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_3_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_3_1.setBounds(0, 119, 136, 19);
		panel4.add(lblNewLabel_3_3_1);
		
		inputCodigoRutina = new JTextField();
		inputCodigoRutina.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					if (!"".equals(inputCodigoRutina.getText())) {
						String codigo=inputCodigoRutina.getText();
						ru=ruDAO.BuscarRutina(codigo);
						if (ru.getEjercicio()!=null) {
							inputEjercicioRutina.setText(""+ru.getEjercicio());
							inputSeriesRutina.setText(""+ru.getSeries());
							inputVecesXsemanaRutina.setText(""+ru.getVeces_semana());
							inputEjercicioRutina.setText(""+ru.getEjercicio());
							comboBoxEntrenador.setSelectedItem(ru.getEntrenador());
							
							inputCodigoRutina.requestFocus();//ESTO INICIALIZA POR DEFECTO...
							//---EN CASO DE VENTA
							//TXTCANTIDADVENTA.REQUESTfOCUS
							
							
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Ingrese el codigo del Producto");
						inputCodigoRutina.requestFocus();
					}
					
				}
			}
		});
		inputCodigoRutina.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputCodigoRutina.setColumns(10);
		inputCodigoRutina.setBounds(104, 29, 139, 20);
		panel4.add(inputCodigoRutina);
		
		inputEjercicioRutina = new JTextField();
		inputEjercicioRutina.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputEjercicioRutina.setColumns(10);
		inputEjercicioRutina.setBounds(104, 59, 139, 20);
		panel4.add(inputEjercicioRutina);
		
		inputSeriesRutina = new JTextField();
		inputSeriesRutina.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputSeriesRutina.setColumns(10);
		inputSeriesRutina.setBounds(104, 89, 139, 20);
		panel4.add(inputSeriesRutina);
		
		inputVecesXsemanaRutina = new JTextField();
		inputVecesXsemanaRutina.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputVecesXsemanaRutina.setColumns(10);
		inputVecesXsemanaRutina.setBounds(140, 118, 139, 20);
		panel4.add(inputVecesXsemanaRutina);
		
		JButton botonActualizarRutina = new JButton("");
		botonActualizarRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila=table4.getSelectedRow();
				if (fila==-1) {
					JOptionPane.showMessageDialog(null, "seleccione una fila");
				}else {
					
					if ("".equals(inputCodigoRutina.getText())  || "".equals(inputEjercicioRutina.getText()) || "".equals(inputSeriesRutina.getText())|| "".equals(inputVecesXsemanaRutina.getText())|| "".equals(comboBoxEntrenador.getSelectedItem())){
						JOptionPane.showMessageDialog(null,"Los campos estan vacios");
					}
						
						
						else {
							try {
								int id=Integer.parseInt(table4.getValueAt(fila, 0).toString());
								
								ru.setCodigo(inputCodigoRutina.getText());
								ru.setEjercicio(inputEjercicioRutina.getText());
								ru.setSeries(inputSeriesRutina.getText());
								ru.setVeces_semana(Integer.parseInt(inputVecesXsemanaRutina.getText()));
								ru.setEntrenador(comboBoxEntrenador.getSelectedItem().toString());
								

								ru.setId_rutina(id);
								ruDAO.ModificarRutina(ru);
								
								JOptionPane.showMessageDialog(null,"Rutina actualizada");
								inputCodigoRutina.setText("");
								inputEjercicioRutina.setText("");
								inputSeriesRutina.setText("");
								inputVecesXsemanaRutina.setText("");
								inputSeriesRutina.setText("");
								actualizarComboBoxEntrenador();
								table4.clearSelection();
								ListarRutina();
								
							} catch (Exception e1) {
								System.out.println(e1.toString());
								JOptionPane.showMessageDialog(null,"No se pudo actualizar ");
							}
						}}}
						
			}
		);
		botonActualizarRutina.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\actualizar.png"));
		botonActualizarRutina.setBounds(430, 59, 65, 54);
		panel4.add(botonActualizarRutina);
		
		JButton botonEliminarRutina = new JButton("");
		botonEliminarRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila=table4.getSelectedRow();
				if(fila==-1) {
					JOptionPane.showMessageDialog(null,"Por favor selecione una Rutina para Eliminar");
				
					
				} else {	int pregunta=JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar?");
				if (pregunta==0) {
					int id=Integer.parseInt(table4.getValueAt(fila,0).toString());
					 ruDAO.EliminarRutina(id);
					
					ListarRutina();
					actualizarComboBoxEntrenador();
					inputCodigoRutina.setText("");
					inputEjercicioRutina.setText("");
					inputSeriesRutina.setText("");
					inputVecesXsemanaRutina.setText("");
					
					
					table4.clearSelection();
					

				}
				}
				
			}
		});
		botonEliminarRutina.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\eliminar.png"));
		botonEliminarRutina.setBounds(280, 59, 65, 53);
		panel4.add(botonEliminarRutina);
		 
		 comboBoxEntrenador = new JComboBox<>();
		comboBoxEntrenador.setBounds(140, 149, 139, 22);
		panel4.add(comboBoxEntrenador);
	    
		
		ruDAO.ConsultarEntrenador(comboBoxEntrenador);
		if(comboBoxEntrenador.getItemCount()>0) {
			
			comboBoxEntrenador.setSelectedIndex(0);
		}
		
		
		JButton botonGuardarRutina = new JButton("");
		
		botonGuardarRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!"".equals(inputCodigoRutina.getText()) || !"".equals(inputEjercicioRutina.getText()) || !"".equals(inputSeriesRutina.getText())|| !"".equals(inputVecesXsemanaRutina.getText()) || !"".equals(comboBoxEntrenador.getSelectedItem().toString() )) {
			//------------------
					
					ru.setCodigo(inputCodigoRutina.getText());
					ru.setEjercicio(inputEjercicioRutina.getText());
					ru.setSeries(inputSeriesRutina.getText());
					ru.setVeces_semana(Integer.parseInt(inputVecesXsemanaRutina.getText()));
					ru.setEntrenador(comboBoxEntrenador.getSelectedItem().toString());
					//REGISTRA ENTRENADOR---
					ruDAO.RegistrarRutina(ru);
					ListarRutina();
	
					//---FALTA LISTAR RUTINA---
					//ListarRutina();
					inputCodigoRutina.setText("");
					inputEjercicioRutina.setText("");
					inputSeriesRutina.setText("");
					inputVecesXsemanaRutina.setText("");
					
					
					
					
					JOptionPane.showMessageDialog(null,"Rutina Registrada..." );
					
				}else {
					JOptionPane.showMessageDialog(null,"No se pudo registrar campos vacios..." );
					
				}
			}
		});
		botonGuardarRutina.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\guardar.png"));
		botonGuardarRutina.setBounds(355, 59, 65, 54);
		panel4.add(botonGuardarRutina);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 187, 508, 132);
		panel4.add(scrollPane_2);
		
		table4 = new JTable();
		table4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int fila =table4.rowAtPoint(e.getPoint());
				inputCodigoRutina.setText(table4.getValueAt(fila, 1).toString());
				inputEjercicioRutina.setText(table4.getValueAt(fila, 2).toString());
				inputSeriesRutina.setText(table4.getValueAt(fila, 3).toString());
				inputVecesXsemanaRutina.setText(table4.getValueAt(fila, 4).toString());
				comboBoxEntrenador.setSelectedItem(table4.getValueAt(fila, 5).toString().trim());
				
			}
		});
		table4.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "C\u00F3digo", "Ejercicio", "Series", "VecesXsemana", "Entrenador"
			}
		));
		table4.getColumnModel().getColumn(4).setPreferredWidth(87);
		scrollPane_2.setViewportView(table4);
		
		JLabel lblNewLabel_3_3_1_1 = new JLabel(" Entrenador");
		lblNewLabel_3_3_1_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_3_1_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_3_1_1.setBounds(0, 149, 136, 19);
		panel4.add(lblNewLabel_3_3_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(new Color(255, 140, 0));
		lblNewLabel_4.setForeground(new Color(192, 192, 192));
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\busc.png"));
		lblNewLabel_4.setBounds(248, 22, 31, 37);
		panel4.add(lblNewLabel_4);
		
		
		
		JPanel panel5 = new JPanel();
		tabbedPane.addTab("Dietas", null, panel5, null);
		JButton botonDieta = new JButton("Dietas");
		botonDieta.setForeground(new Color(255, 255, 255));
		botonDieta.setBackground(new Color(255, 128, 64));
		botonDieta.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonDieta.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\dieta.png"));
		botonDieta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		botonDieta.setBounds(10, 301, 211, 23);
		panel.add(botonDieta);
		
		JPanel panel6 = new JPanel();
		panel6.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Tienda", null, panel6, null);
		panel6.setLayout(null);
		
		JLabel lblNewLabel_3_7 = new JLabel("Código");
		lblNewLabel_3_7.setBounds(10, 35, 94, 19);
		lblNewLabel_3_7.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_7.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		panel6.add(lblNewLabel_3_7);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Nombre");
		lblNewLabel_3_1_2.setBounds(10, 64, 94, 19);
		lblNewLabel_3_1_2.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_2.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		panel6.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_3_2 = new JLabel("Cantidad");
		lblNewLabel_3_3_2.setBounds(10, 94, 94, 19);
		lblNewLabel_3_3_2.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_3_2.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		panel6.add(lblNewLabel_3_3_2);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("Precio");
		lblNewLabel_3_4_1.setBounds(356, 64, 60, 19);
		lblNewLabel_3_4_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_4_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		panel6.add(lblNewLabel_3_4_1);
		
		inputCodigoTienda = new JTextField();
		inputCodigoTienda.setBounds(114, 34, 139, 20);
		inputCodigoTienda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER ) {
					if (!"".equals(inputCodigoTienda.getText())) {
						String codigo=inputCodigoTienda.getText();
						pro=proDAO.BuscarProducto(codigo);
						if (pro.getNombre()!=null) {
							inputNombreTienda.setText(""+pro.getNombre());
							inputPrecioTienda.setText(""+pro.getPrecio());
							inputStockDisponibleTienda.setText(""+pro.getStock());
							
							
							//POSICIONA EL CURSOR EN EL CAMPO CANTIDAD-----
							inputCantidadTienda.requestFocus();
							
							
						}else {
							LimpiarVenta();
							//POSICIONA EL CURSOR EN EL CAMPO CODIGO------
							inputCodigoTienda.requestFocus();
						
							
						}
						
						}else {
							JOptionPane.showMessageDialog(null,"Ingrese el Código del Producto ");
							inputCodigoTienda.requestFocus();
						}
						
					}
					
				}
			}
		);
		inputCodigoTienda.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputCodigoTienda.setColumns(10);
		panel6.add(inputCodigoTienda);
		
		inputNombreTienda = new JTextField();
		inputNombreTienda.setBounds(114, 64, 139, 20);
		inputNombreTienda.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputNombreTienda.setColumns(10);
		panel6.add(inputNombreTienda);
		
		inputPrecioTienda = new JTextField();
		inputPrecioTienda.setBounds(414, 63, 94, 20);
		inputPrecioTienda.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputPrecioTienda.setColumns(10);
		panel6.add(inputPrecioTienda);
		
		inputCantidadTienda = new JTextField();
		inputCantidadTienda.setBounds(114, 93, 60, 20);
		inputCantidadTienda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					if(!"".equals(inputCantidadTienda.getText())) {
						String codigo = inputCodigoTienda.getText();
						String descripcion=inputNombreTienda.getText();
						if (inputCantidadTienda.getText().trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad...");
							return;
							
						}
						if (inputPrecioTienda.getText().trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Debe ingresar El precio");
							return;
							
						}
						int cantidad=Integer.parseInt(inputCantidadTienda.getText());
						double precio= Double.parseDouble(inputPrecioTienda.getText());
						double total= cantidad * precio; 
						int stock=Integer.parseInt(inputStockDisponibleTienda.getText());
						if (stock>=cantidad) {
							item=item+1;
							modelo=(DefaultTableModel) table6.getModel();
							boolean productoYaExiste=false;
							
							for (int i = 0; i < table6.getRowCount(); i++) {
								
								
								if (table6.getValueAt(i,1 ).equals(descripcion)) {
									productoYaExiste=true;
												
									break;
								}
								
							}if (productoYaExiste) {
								JOptionPane.showMessageDialog(null, "El producto ya esta Registrado ") ;
								return;
								
							}
							
							
							ArrayList lista=new ArrayList();
							lista.add(item);
							lista.add(codigo);
							lista.add(descripcion);
							lista.add(cantidad);
							lista.add(precio);
							lista.add(total);
							Object[] o=new Object[5];
							o[0]=lista.get(1);
							o[1]=lista.get(2);
							o[2]=lista.get(3);
							o[3]=lista.get(4);
							o[4]=lista.get(5);
							modelo.addRow(o);
							table6.setModel(modelo);
							//AGREGO FUNCION DE CALCULO DE VENTA---
							TotalPagar();
							LimpiarVenta();
							//SE VA EL FOCO EN EL INPUT CODIGO---
							inputCodigoTienda.requestFocus();
							
							
							
							
							
						}else {
							JOptionPane.showMessageDialog(null,"Stock no disponible");
						}
					}else {
						JOptionPane.showMessageDialog(null,"Ingrese cantidad");
					}
					
				}
			}
		});
		inputCantidadTienda.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputCantidadTienda.setColumns(10);
		panel6.add(inputCantidadTienda);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 124, 498, 68);
		panel6.add(scrollPane_3);
		
		table6 = new JTable();
		table6.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO", "NOMBRE", "CANTIDAD", "PRECIO U.", "TOTAL"
			}
		));
		scrollPane_3.setViewportView(table6);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("");
		lblNewLabel_4_1_1.setBounds(254, 27, 31, 37);
		lblNewLabel_4_1_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\busc.png"));
		lblNewLabel_4_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4_1_1.setBackground(new Color(255, 140, 0));
		panel6.add(lblNewLabel_4_1_1);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				ListarVenta();
				

				
			}
		});
		scrollPane_4.setBounds(10, 263, 498, 56);
		panel6.add(scrollPane_4);
		
		table6_2 = new JTable();
		table6_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "CLIENTE", "VENDEDOR", "TOTAL"
			}
		));
		scrollPane_4.setViewportView(table6_2);
		
		JLabel lblNewLabel_3_7_1 = new JLabel("Stock Disponible");
		lblNewLabel_3_7_1.setBounds(304, 35, 139, 19);
		lblNewLabel_3_7_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_7_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		panel6.add(lblNewLabel_3_7_1);
		
		inputStockDisponibleTienda = new JTextField();
		inputStockDisponibleTienda.setBounds(453, 36, 55, 20);
		inputStockDisponibleTienda.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputStockDisponibleTienda.setColumns(10);
		panel6.add(inputStockDisponibleTienda);
		
		JLabel lblNewLabel_3_7_2 = new JLabel("Nombre");
		lblNewLabel_3_7_2.setBounds(10, 233, 66, 19);
		lblNewLabel_3_7_2.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_7_2.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		panel6.add(lblNewLabel_3_7_2);
		
		JLabel lblNewLabel_3_7_3 = new JLabel("Id");
		lblNewLabel_3_7_3.setBounds(10, 203, 35, 19);
		lblNewLabel_3_7_3.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_7_3.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		panel6.add(lblNewLabel_3_7_3);
		
		inputIdTienda = new JTextField();
		inputIdTienda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					if (!"".equals(inputIdTienda.getText())) {
						int id=Integer.parseInt(inputIdTienda.getText());
						cl=client.BuscarCliente(id);
						if (cl.getNombre()!= null) {
							inputClienteTienda.setText(""+cl.getNombre());
							
							
							
						}else {
							JOptionPane.showMessageDialog(null, "El cliente no existe...");
						}
						
					}
					
				}
			}
		});
		inputIdTienda.setBounds(114, 203, 126, 20);
		inputIdTienda.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputIdTienda.setColumns(10);
		panel6.add(inputIdTienda);
		
		inputClienteTienda = new JTextField();
		inputClienteTienda.setBounds(114, 233, 126, 19);
		inputClienteTienda.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputClienteTienda.setColumns(10);
		panel6.add(inputClienteTienda);
		
		inputTotal = new JTextField();
		inputTotal.setBounds(384, 232, 124, 20);
		inputTotal.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputTotal.setColumns(10);
		panel6.add(inputTotal);
		
		JButton botonRegistrarVenta = new JButton("");
		botonRegistrarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (table6.getRowCount()>0) {
					if (!"".equals(inputClienteTienda)) {
						
						 RegistarVenta();
						 inputIdTienda.setText("");
						 inputClienteTienda.setText("");
						 inputTotal.setText("");
						 //
						 RegistrarDetalle();
						 ActualizarStock();
						LimpiarTablaTienda();
					}else {JOptionPane.showMessageDialog(null, "Debes Buscar un Cliente...");
						
					}
					
				
					
				}else {JOptionPane.showMessageDialog(null, "No hay Productos en la venta...");
				
			
				 
			}}
		});
		botonRegistrarVenta.setBounds(250, 220, 35, 32);
		botonRegistrarVenta.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\impresora2.png"));
		panel6.add(botonRegistrarVenta);
		
		
		JLabel lblNewLabel_3_7_2_1 = new JLabel("");
		lblNewLabel_3_7_2_1.setBounds(349, 220, 31, 32);
		lblNewLabel_3_7_2_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\dinero.png"));
		lblNewLabel_3_7_2_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_7_2_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		panel6.add(lblNewLabel_3_7_2_1);
		
		JLabel labelTotal = new JLabel("Total");
		labelTotal.setBounds(304, 233, 47, 19);
		labelTotal.setForeground(new Color(0, 51, 102));
		labelTotal.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		panel6.add(labelTotal);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBounds(222, 86, 31, 32);
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\blanco.png"));
		panel6.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo=(DefaultTableModel) table6.getModel();
				modelo.removeRow(table6.getSelectedRow());
				TotalPagar();
				inputCodigoTienda.requestFocus();
				
				
			}
		});
		btnNewButton_5.setBounds(304, 87, 36, 31);
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\eliminar (2).png"));
		panel6.add(btnNewButton_5);
		 botonTienda = new JButton("Tienda");
		botonTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarVenta();
				tabbedPane.setSelectedIndex(5);
			}
		});
		botonTienda.setForeground(new Color(255, 255, 255));
		botonTienda.setBackground(new Color(255, 128, 64));
		botonTienda.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonTienda.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\shop.png"));
		botonTienda.setBounds(10, 335, 211, 23);
		panel.add(botonTienda);
		
		JPanel panel7 = new JPanel();
		panel7.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Inventario", null, panel7, null);
		panel7.setLayout(null);
		
		JLabel lblNewLabel_3_7_4 = new JLabel("Código");
		lblNewLabel_3_7_4.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_7_4.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_7_4.setBounds(10, 37, 94, 19);
		panel7.add(lblNewLabel_3_7_4);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("Nombre");
		lblNewLabel_3_1_2_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_1_2_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_1_2_1.setBounds(10, 66, 94, 19);
		panel7.add(lblNewLabel_3_1_2_1);
		
		JLabel lblNewLabel_3_3_2_1 = new JLabel("Stock");
		lblNewLabel_3_3_2_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_3_2_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_3_2_1.setBounds(10, 96, 94, 19);
		panel7.add(lblNewLabel_3_3_2_1);
		
		JLabel lblNewLabel_3_4_1_1 = new JLabel("Precio");
		lblNewLabel_3_4_1_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_4_1_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_4_1_1.setBounds(322, 96, 53, 19);
		panel7.add(lblNewLabel_3_4_1_1);
		
		inputCodigoInventario = new JTextField();
		inputCodigoInventario.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputCodigoInventario.setColumns(10);
		inputCodigoInventario.setBounds(114, 36, 139, 20);
		panel7.add(inputCodigoInventario);
		
		inputNombreInventario = new JTextField();
		inputNombreInventario.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputNombreInventario.setColumns(10);
		inputNombreInventario.setBounds(114, 66, 139, 20);
		panel7.add(inputNombreInventario);
		
		inputCantidadInventario = new JTextField();
		inputCantidadInventario.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputCantidadInventario.setColumns(10);
		inputCantidadInventario.setBounds(114, 95, 104, 20);
		panel7.add(inputCantidadInventario);
		
		inputPrecioInventario = new JTextField();
		inputPrecioInventario.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		inputPrecioInventario.setColumns(10);
		inputPrecioInventario.setBounds(405, 95, 103, 20);
		panel7.add(inputPrecioInventario);
		
		JScrollPane scrollPane_3_1 = new JScrollPane();
		scrollPane_3_1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				
			
			}
		});
		scrollPane_3_1.setBounds(10, 214, 498, 105);
		panel7.add(scrollPane_3_1);
		
		table7 = new JTable();
		table7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila =table7.getSelectedRow();
				
				
				inputCodigoInventario.setText("");
				inputNombreInventario.setText("");
				inputCantidadInventario.setText("");
				inputPrecioInventario.setText("");
				
				inputCodigoInventario.setText(table7.getValueAt(fila, 1).toString());
				inputNombreInventario.setText(table7.getValueAt(fila, 2).toString());
				inputCantidadInventario.setText(table7.getValueAt(fila, 3).toString());
				inputPrecioInventario.setText(table7.getValueAt(fila, 4).toString());
				
			
				
				
			}
		});
		table7.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "C\u00F3digo", "Nombre", "Stock", "Precio"
			}
		));
		scrollPane_3_1.setViewportView(table7);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("");
		lblNewLabel_4_1_1_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\busc.png"));
		lblNewLabel_4_1_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4_1_1_1.setBackground(new Color(255, 140, 0));
		lblNewLabel_4_1_1_1.setBounds(254, 29, 31, 37);
		panel7.add(lblNewLabel_4_1_1_1);
		
		JButton btnNewButton_4_1 = new JButton("");
		btnNewButton_4_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\blanco.png"));
		btnNewButton_4_1.setBounds(228, 96, 25, 31);
		panel7.add(btnNewButton_4_1);
		
		JButton botonEliminarInventario = new JButton("");
		botonEliminarInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int fila=table7.getSelectedRow();
				if(fila==-1) {
					JOptionPane.showMessageDialog(null,"Por favor selecione un Producto para Eliminar");
				
					
				} else {	int pregunta=JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar?");
				if (pregunta==0) {
					int id=Integer.parseInt(table7.getValueAt(fila,0).toString());
					
					proDAO.EliminarProducto(id);
					
					
					inputCodigoInventario.setText("");
					inputNombreInventario.setText("");
					inputCantidadInventario.setText("");
					inputPrecioInventario.setText("");
					proDAO.ListarProducto();
					
					JOptionPane.showMessageDialog(null, "Producto Eliminado...");
					((DefaultTableModel)table7.getModel()).removeRow(fila);;
				
					
					

				}else {
					JOptionPane.showMessageDialog(null, "No se Pudo eliminar");

				}
				}
				
			}
		});
		botonEliminarInventario.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\eliminar.png"));
		botonEliminarInventario.setBounds(114, 149, 65, 53);
		panel7.add(botonEliminarInventario);
		
		JButton botonGuardarInventario = new JButton("");
		botonGuardarInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!"".equals(inputNombreInventario.getText()) || !"".equals(inputCodigoInventario.getText()) || !"".equals(inputCantidadInventario.getText())||  !"".equals(inputPrecioInventario.getText()  )) {
					//------------------
							
							pro.setNombre(inputNombreInventario.getText());
							pro.setCodigo(inputCodigoInventario.getText());
							pro.setPrecio(Double.parseDouble(inputPrecioInventario.getText()));
							pro.setStock(Integer.parseInt(inputCantidadInventario.getText()));
							
							//REGISTRA ENTRENADOR---
							proDAO.RegistrarProducto(pro);
							ListarProducto();
			
							//---FALTA LISTAR RUTINA---
							//ListarRutina();
							inputNombreInventario.setText("");
							inputCodigoInventario.setText("");
							inputPrecioInventario.setText("");
							inputCantidadInventario.setText("");
							
							
							
							
							JOptionPane.showMessageDialog(null,"Producto Registrado..." );
							
						}else {
							JOptionPane.showMessageDialog(null,"No se pudo registrar campos vacios..." );
							
						}
			}
		});
		botonGuardarInventario.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\guardar.png"));
		botonGuardarInventario.setBounds(189, 149, 65, 54);
		panel7.add(botonGuardarInventario);
		
		JButton botonActualizarInventario = new JButton("");
		botonActualizarInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila=table7.getSelectedRow();
				if (fila==-1) {
					JOptionPane.showMessageDialog(null, "seleccione una fila");
				}else {
					
					if ("".equals(inputCodigoInventario.getText())  || "".equals(inputNombreInventario.getText()) || "".equals(inputPrecioInventario.getText()) || "".equals(inputCantidadInventario.getText())){
						JOptionPane.showMessageDialog(null,"Los campos estan vacios");
					}
						
						
						else {
							try {
								int id=Integer.parseInt(table7.getValueAt(fila, 0).toString());
								Producto pro=new Producto();
								pro.setCodigo(inputCodigoInventario.getText());
								pro.setNombre(inputNombreInventario.getText());
								pro.setPrecio(Double.parseDouble(inputPrecioInventario.getText()));
								pro.setStock(Integer.parseInt(inputCantidadInventario.getText()));
							

								pro.setId_producto(id);
								proDAO.ModificarProducto(pro);
								
								JOptionPane.showMessageDialog(null,"Producto actualizado");
								inputCodigoInventario.setText("");
								inputNombreInventario.setText("");
								inputPrecioInventario.setText("");
								inputCantidadInventario.setText("");
							
								table7.clearSelection();
								ListarProducto();
								
							} catch (Exception e2) {
								e2.printStackTrace();
								JOptionPane.showMessageDialog(null,"No se pudo actualizar ");
							}
						
						//-----------------
					
						
						
					}}
			}
		});
		botonActualizarInventario.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\actualizar.png"));
		botonActualizarInventario.setBounds(264, 149, 65, 54);
		panel7.add(botonActualizarInventario);
		
		JLabel lblNewLabel_3_7_2_1_1 = new JLabel("");
		lblNewLabel_3_7_2_1_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\dinero.png"));
		lblNewLabel_3_7_2_1_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_3_7_2_1_1.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		lblNewLabel_3_7_2_1_1.setBounds(374, 84, 31, 31);
		panel7.add(lblNewLabel_3_7_2_1_1);
		
		JPanel panel8 = new JPanel();
		tabbedPane.addTab("Ventas", null, panel8, null);
		
		JButton botonRutina = new JButton("Rutinas");
		botonRutina.setForeground(new Color(255, 255, 255));
		botonRutina.setBackground(new Color(255, 128, 64));
		botonRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				actualizarComboBoxEntrenador();
				inputCodigoRutina.setText("");
				inputEjercicioRutina.setText("");
				inputSeriesRutina.setText("");
				inputVecesXsemanaRutina.setText("");
				//LLAMO A LOS DATOS DE RUTINA---
				
				ListarRutina();
				
				
				tabbedPane.setSelectedIndex(3);
				
				
			}
		});
		botonRutina.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonRutina.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\rutina.png"));
		botonRutina.setBounds(10, 267, 211, 23);
		panel.add(botonRutina);
		
		botonInventario = new JButton("Inventario");
		botonInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputCodigoInventario.setText("");
				inputNombreInventario.setText("");
				inputPrecioInventario.setText("");
				inputCantidadInventario.setText("");
				ListarProducto();
				tabbedPane.setSelectedIndex(6);
			
			}
		});
		botonInventario.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\inventario.png"));
		botonInventario.setForeground(Color.WHITE);
		botonInventario.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonInventario.setBackground(new Color(255, 128, 64));
		botonInventario.setBounds(10, 369, 211, 23);
		panel.add(botonInventario);
		
		 botonVentas = new JButton("Ventas");
		botonVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(7);
				
			}
		});
		botonVentas.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\ventas.png"));
		botonVentas.setForeground(Color.WHITE);
		botonVentas.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonVentas.setBackground(new Color(255, 128, 64));
		botonVentas.setBounds(10, 403, 211, 23);
		panel.add(botonVentas);
		
		
		labelAdmin= new JButton("Admin");
		labelAdmin.setBounds(10, 131, 211, 23);
		panel.add(labelAdmin);
		labelAdmin.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\corona.png"));
		labelAdmin.setForeground(new Color(33, 33, 33));
		labelAdmin.setFont(new Font("Verdana", Font.BOLD, 17));
		labelAdmin.setBackground(new Color(255, 215, 0));
		
				JButton btnNewButton = new JButton("Clientes");
				btnNewButton.setBounds(10, 199, 211, 23);
				panel.add(btnNewButton);
				btnNewButton.setForeground(new Color(255, 255, 255));
				btnNewButton.setBackground(new Color(255, 128, 64));
				btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
				btnNewButton.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\cliente.png"));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					ListarCliente();
					
					tabbedPane.setSelectedIndex(0);
					textNombre.setText("");
					textAltura.setText("");
					textPeso.setText("");
					textEdad.setText("");
					textNivel.setText("");
					table.clearSelection();
					
				
					
					}
				});
		
		 labelEntrenador = new JButton("");
		labelEntrenador.setBounds(660, 11, 103, 66);
		getContentPane().add(labelEntrenador);
		labelEntrenador.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\AppGym\\src\\img\\entrenadorPerfil.png"));
		labelEntrenador.setForeground(new Color(33, 33, 33));
		labelEntrenador.setFont(new Font("Verdana", Font.BOLD, 17));
		labelEntrenador.setBackground(new Color(255, 215, 0));
		
	}
	
	private void inicializarTextField() {
		textId_cliente=new JTextField();
		textNombre=new JTextField();
		textAltura=new JTextField();
		textPeso=new JTextField();
		textEdad=new JTextField();
		textNivel=new JTextField();
	}
	public void actualizarComboBoxEntrenador() {
		comboBoxEntrenador.removeAllItems();
		ruDAO.ConsultarEntrenador(comboBoxEntrenador);
	}
	private void TotalPagar() {
		totalPagar=0.00;
		int numeroFila=table6.getRowCount();
		for (int i = 0; i < numeroFila; i++) {
			double cal =Double.parseDouble(String.valueOf(table6.getModel().getValueAt(i, 4)));
			totalPagar=totalPagar+cal;
			
		}inputTotal.setText(String.format("%.2f", totalPagar));
		
	}
	private void LimpiarVenta() {
		inputCodigoTienda.setText("");
		inputNombreTienda.setText("");
		inputPrecioTienda.setText("");
		inputCantidadTienda.setText("");
		inputStockDisponibleTienda.setText("");
	}
	private void RegistarVenta() {
		String cliente = inputClienteTienda.getText();
		String vendedor=labelAdmin.getText();
		double monto=totalPagar;
		v.setCliente(cliente);
		v.setVendedor(vendedor);
		v.setTotal(monto);
		vDAO.RegistrarVenta(v);
		
		
		
	}
	
	private void RegistrarDetalle() {
		//LLAMO A LA FUNCION DE REGISTRAR VENTA Y A LA VEZ EJECUTO LA FUNCION DE DEVOLVERME EL ID DE LA ULTIMA VENTA QUE SE GUARDA EN EL ID DE DETALLE VENTA-------------
		int id=vDAO.idVenta();
		//----------------------------
		for (int i = 0; i < table6.getRowCount(); i++) {
			String codigo=table6.getValueAt(i, 0).toString();
			int cantidad=Integer.parseInt( table6.getValueAt(i, 2).toString());
			double precio=Double.parseDouble(table6.getValueAt(i,3).toString());
			
			dv.setCodigo_producto(codigo);
			dv.setCantidad(cantidad);
			dv.setPrecio(precio);
			//-----------------AHI EJECUTO ID--------
			dv.setId_venta(id);
			vDAO.RegistrarDetalle(dv);
			
		}
	}
	private  void ActualizarStock() {
		
		for (int i = 0; i < table6.getRowCount(); i++) {
			
			String codigo=table6.getValueAt(i, 0).toString();
			int cantidad=Integer.parseInt(table6.getValueAt(i, 2).toString());
			pro=proDAO.BuscarProducto(codigo);
			int StockActual=pro.getStock() - cantidad;
			vDAO.ActualizarStock(StockActual, codigo);
			
		}
		
	}
	private void LimpiarTablaTienda() {
		
		DefaultTableModel modelo=(DefaultTableModel) table6.getModel(); 
			
			modelo.setRowCount(0);
		}

private JButton botonVentas;
private JButton botonInventario;
private JButton botonTienda;
	
	private JButton labelAdmin;
	private JButton labelEntrenador;
}
