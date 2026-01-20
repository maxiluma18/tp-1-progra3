package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import logica.AsignarColores;
import logica.Ranking;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ganar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ganar frame = new Ganar(0);
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
	public Ganar(int n) {
		Ranking tops = new Ranking();
		AsignarColores asignar = new AsignarColores();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 230,500, 500);
		setTitle("Histeria");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1 = new PanelConFondo("win.png");
		setLocationRelativeTo(null);
		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);
		setResizable(false); // hace q no se pueda modificar ni agrandar la pantalla
		JButton btnsalirJuego = new JButton("Salir");
		btnsalirJuego.setBackground(new Color(236, 153, 37));
		;
		btnsalirJuego.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		btnsalirJuego.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnsalirJuego.setForeground(Color.BLACK);
		btnsalirJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnsalirJuego.setBounds(293, 391, 191, 59);
		contentPane_1.add(btnsalirJuego);

		JButton btnJugarDNuevo = new JButton("Jugar De Nuevo");
		btnJugarDNuevo.setBackground(new Color(236, 153, 37));

		btnJugarDNuevo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		btnJugarDNuevo.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnJugarDNuevo.setForeground(Color.BLACK);
		btnJugarDNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Color  color=asignar.devolverColor();
				UIManager.put("OptionPane.background",color);
	            UIManager.put("Panel.background", color);
	            
	          
	            UIManager.put("Button.background", asignar.devolverColor()); 
	            UIManager.put("Button.foreground", Color.BLACK);
	            
				String nombre = JOptionPane.showInputDialog(contentPane, "Ingrese su nombre:", "Sugerencia", JOptionPane.PLAIN_MESSAGE);
				
				tops.guardarNombre(nombre);
				
				UIManager.put("OptionPane.background", null);
			    UIManager.put("Panel.background", null);
			    UIManager.put("Button.background",null);
			    UIManager.put("Button.foreground", null);
			    
				Intermedio inter = new Intermedio();
				inter.setVisible(true);
				dispose();

			}
		});
		btnJugarDNuevo.setBounds(0, 391, 191, 59);
		contentPane_1.add(btnJugarDNuevo);

		JLabel lblClicksCount = new JLabel("Click Totales: " + n);
		
		lblClicksCount.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblClicksCount.setForeground(new Color(236, 153, 37));
		lblClicksCount.setBounds(163, 363, 299, 28);
		contentPane_1.add(lblClicksCount);
		
		JButton btnTop = new JButton("Top");
		btnTop.setBackground(new Color(236, 153, 37));
		btnTop.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		btnTop.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnTop.setForeground(Color.BLACK);
		btnTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RankingUI rank=new RankingUI();
				rank.setVisible(true);
				
				
			}
		});
		btnTop.setBounds(183, 0, 124, 61);
		contentPane_1.add(btnTop);
	}
}
