package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import logica.Grilla;
import logica.Ranking;

import javax.swing.JMenuBar;
import java.awt.Font;

public class GrillaUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Grilla grilla;
	int clicks;
	private JButton[][] botones;
	private Point punto;
	private JLabel turnoLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GrillaUI frame = new GrillaUI(3);
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
	public GrillaUI(int n) {

		grilla = new Grilla(n); // Inicializa la grilla correctamente
		botones = new JButton[n][n];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Window.HEIGHT / 3, Window.WIDTH / 3, 500, 500);

		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		menuBar.setBorderPainted(false);

		setJMenuBar(menuBar);
		menuBar.setLayout(new java.awt.FlowLayout(FlowLayout.CENTER, 60, 1));

		JButton sugerirMovimiento = new JButton("Sugerir Movimiento");
		sugerirMovimiento.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		sugerirMovimiento.setBorderPainted(false);
		sugerirMovimiento.setBackground(null); // Eliminar el fondo
		sugerirMovimiento.setBorderPainted(false); // Desactivar el borde
		sugerirMovimiento.setFocusPainted(false); // Eliminar el efecto de enfoque
		// sugerirMovimiento.setContentAreaFilled(false);

		sugerirMovimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object movimiento = grilla.obtenerSugerencia();
				if (movimiento instanceof Point) {
					punto = (Point) movimiento;
					botones[punto.x][punto.y].setBorder(BorderFactory.createLineBorder(Color.RED, 2));

				}
			}
		});

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		menuBar.add(btnNewButton);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(null); // Eliminar el fondo
		btnNewButton.setBorderPainted(false); // Desactivar el borde
		btnNewButton.setFocusPainted(false); // Eliminar el efecto de enfoque
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Intermedio L = new Intermedio();
				L.setVisible(true);
				dispose();
			}
		});
		menuBar.add(sugerirMovimiento);

		JButton btnNewButton_2 = new JButton("Salir   ");
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		menuBar.add(btnNewButton_2);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(null); // Eliminar el fondo
		btnNewButton_2.setBorderPainted(false); // Desactivar el borde
		btnNewButton_2.setFocusPainted(false); // Eliminar el efecto de enfoque
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(n, n, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0)); // Configuramos BorderLayout
		setContentPane(contentPane);

		// Panel con la grilla de botones
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(n, n, 0, 0)); // Configura la grilla NxN
		contentPane.add(panel, BorderLayout.CENTER);
		
	    turnoLabel = new JLabel("Clicks: 0");
	    JPanel panelInferior = new JPanel();
	    panelInferior.add(turnoLabel);

	    contentPane.add(panel, BorderLayout.CENTER);
	    contentPane.add(panelInferior, BorderLayout.SOUTH);
	    
        setLocationRelativeTo(null);
        setVisible(true);
		Comienzo(n, panel);
	}

	private void Comienzo(int n, JPanel panel) {

		setLocationRelativeTo(null); // hace q aparezca en el centro
		setTitle("Histeria");
		setResizable(false);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				botones[i][j] = new JButton("");
				botones[i][j].putClientProperty("x", i); // Asocia la fila
				botones[i][j].putClientProperty("y", j); // Asocia la columna
				botones[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				botones[i][j].addActionListener(this); // Asigna el listener
				panel.add(botones[i][j]);
			}
		}
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botonPresionado = (JButton) e.getSource(); // Obtén el botón que disparó el evento
		int x = (int) botonPresionado.getClientProperty("x"); // Recupera la fila
		int y = (int) botonPresionado.getClientProperty("y"); // Recupera la columna
		if (punto != null)
			botones[punto.x][punto.y].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		grilla.cambiarColorGrilla(x, y);
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				botones[i][j].setBackground(grilla.obtenerColorCelda(i, j));
			}
		}
		clicks = grilla.click();
		turnoLabel.setText("Clicks: " + clicks);
		
		if (grilla.Gano()) {
			
			dispose();
			Ranking tops = new Ranking();
			
			tops.obtenerAct(clicks);
			Ganar ganar = new Ganar(clicks);
			ganar.setVisible(true);
		}
	}

}
