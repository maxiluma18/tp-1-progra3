package interfaz;

import java.awt.Color;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import logica.AsignarColores;
import logica.Ranking;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		Ranking tops = new Ranking();
		AsignarColores asignar = new AsignarColores();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); // hace q aparezca en el centro
		setTitle("Histeria"); // le pone nomre arriba a la izq
		setResizable(false); // hace q no se pueda modificar ni agrandar la pantalla

		contentPane = new PanelConFondo("fondomenu.png");

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnJugar = new JButton("Jugar");
		btnJugar.setForeground(Color.BLACK);
		btnJugar.setBackground(asignar.devolverColor());
		btnJugar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		btnJugar.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Color color=asignar.devolverColor();
				UIManager.put("OptionPane.background",color);
	            UIManager.put("Panel.background", color);
	            UIManager.put("OptionPane.minimumSize", new Dimension(250, 100));
	            UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 17)); // Fuente más grande para el mensaje
	            UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 18)); // Fuente más grande para los botones

	            
	            UIManager.put("Button.background", asignar.devolverColor()); 
	            UIManager.put("Button.foreground", Color.BLACK);
	            
				String nombre = JOptionPane.showInputDialog(contentPane, "Ingrese su nombre:", "Sugerencia", JOptionPane.PLAIN_MESSAGE);
				tops.guardarNombre(nombre);
				
				UIManager.put("OptionPane.background", null);
			    UIManager.put("Panel.background", null);
			    UIManager.put("Button.background",null);
			    UIManager.put("Button.foreground", null);
				Intermedio I = new Intermedio();
				I.setVisible(true);
				dispose();

			}
		});
		btnJugar.setBounds(174, 121, 145, 46);
		contentPane.add(btnJugar);

		JButton btnReglas = new JButton("Reglas");
		btnReglas.setForeground(Color.BLACK);
		btnReglas.setBackground(asignar.devolverColor());
		btnReglas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		btnReglas.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		btnReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reglas r = new Reglas();
				r.setVisible(true);
				dispose();
			}
		});
		btnReglas.setBounds(174, 209, 145, 46);
		contentPane.add(btnReglas);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.BLACK);
		btnSalir.setBackground(asignar.devolverColor());
		btnSalir.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		btnSalir.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(174, 299, 145, 46);
		contentPane.add(btnSalir);

	}
}
