package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class SeleccionarPlan extends JFrame {

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
	public SeleccionarPlan() {
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
	          // asignarPlanBasico(cliente.getId());
	          //  new VistaCliente(cliente).setVisible(true);
	            dispose();
	        });

	        // Acción para elegir plan VIP
	        btnVip.addActionListener(e -> {
	           //TODAVIA FALTA ESTA FUNCION  asignarPlanVIP(cliente.getId());
	           // new VistaCliente(cliente).setVisible(true);
	            dispose();
	        });
	}

}
