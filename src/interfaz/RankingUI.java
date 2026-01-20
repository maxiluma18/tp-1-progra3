package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import logica.Ranking;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RankingUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankingUI frame = new RankingUI();
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
	public RankingUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350); // Ajustá el tamaño si lo necesitás

		// Fondo con imagen del top
		contentPane = new PanelConFondo("top (1).png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(236, 153, 37));
		btnVolver.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		btnVolver.setFont(new Font("Lora", Font.PLAIN, 15));
		btnVolver.setForeground(Color.BLACK);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVolver.setBounds(10, 277, 89, 23);
		contentPane.add(btnVolver);
		setTitle("Histeria"); // le pone nomre arriba a la izq
		setResizable(false); // hace q no se pueda modificar ni agrandar la pantalla

		// Obtener ranking
		Ranking tops = new Ranking();
		
		
	

		for (int i = 0; i < tops.longuitudLista(); i++) {
			
			// Nombre del jugador
			JLabel lblNombre = new JLabel(tops.obtenerNombreR(i));
			lblNombre.setForeground(new Color(236, 153, 37));
			lblNombre.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 18));
			lblNombre.setBounds(200,107 + (i * 34), 150, 20);
			contentPane.add(lblNombre);
			
			
			

			// Clicks
			JLabel lblClicks = new JLabel(String.valueOf(tops.obtenerClicks(i)));
			lblClicks.setForeground(new Color(236, 153, 37));
			lblClicks.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 18));
			lblClicks.setBounds(350, 107+ (i * 34), 50, 20);
			contentPane.add(lblClicks);

		
			}
	}
}
