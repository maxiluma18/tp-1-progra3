package interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.AsignarColores;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Intermedio extends JFrame {

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
					Intermedio frame = new Intermedio();
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
	public Intermedio() {
		AsignarColores asignar = new AsignarColores();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); // hace q aparezca en el centro
		setTitle("Histeria"); // le pone nomre arriba a la izq
		setResizable(false); // hace q no se pueda modificar ni agrandar la pantalla
		contentPane_1 = new PanelConFondo("intermedio.png");

		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);

		JButton btn3x3 = new JButton("Jugar 3x3");
		btn3x3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		btn3x3.setForeground(Color.BLACK);
		btn3x3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		btn3x3.setBackground(asignar.devolverColor());
		btn3x3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GrillaUI g = new GrillaUI(3);
				g.setVisible(true);
				dispose();
			}
		});
		btn3x3.setBounds(32, 107, 197, 41);
		contentPane_1.add(btn3x3);

		JButton btn5x5 = new JButton("Jugar 5x5");
		btn5x5.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		btn5x5.setForeground(Color.BLACK);
		btn5x5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		btn5x5.setBackground(asignar.devolverColor());
		btn5x5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GrillaUI g = new GrillaUI(5);
				g.setVisible(true);
				dispose();
			}
		});
		btn5x5.setBounds(258, 107, 197, 41);
		contentPane_1.add(btn5x5);

		JButton btn7x7 = new JButton("Jugar 7x7");
		btn7x7.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		btn7x7.setForeground(Color.BLACK);
		btn7x7.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		btn7x7.setBackground(asignar.devolverColor());
		btn7x7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GrillaUI g = new GrillaUI(7);
				g.setVisible(true);
				dispose();
			}
		});
		btn7x7.setBounds(32, 189, 197, 42);
		contentPane_1.add(btn7x7);

		JButton btn10x10 = new JButton("Jugar 10x10");
		btn10x10.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		btn10x10.setForeground(Color.BLACK);
		btn10x10.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		btn10x10.setBackground(asignar.devolverColor());
		btn10x10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GrillaUI g = new GrillaUI(10);
				g.setVisible(true);
				dispose();

			}
		});
		btn10x10.setBounds(258, 190, 197, 41);
		contentPane_1.add(btn10x10);

		JButton btn15x15 = new JButton("Jugar 15x15");
		btn15x15.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		btn15x15.setForeground(Color.BLACK);
		btn15x15.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		btn15x15.setBackground(asignar.devolverColor());
		btn15x15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GrillaUI g = new GrillaUI(15);
				g.setVisible(true);
				dispose();
			}
		});
		btn15x15.setBounds(32, 272, 197, 41);
		contentPane_1.add(btn15x15);

		JButton btn20x20 = new JButton("Jugar 20x20");
		btn20x20.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		btn20x20.setForeground(Color.BLACK);
		btn20x20.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		btn20x20.setBackground(asignar.devolverColor());
		btn20x20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GrillaUI g = new GrillaUI(20);
				g.setVisible(true);
				dispose();
			}
		});

		btn20x20.setBounds(258, 272, 197, 41);
		contentPane_1.add(btn20x20);

		JButton btnVolver = new JButton("Volver ");
		btnVolver.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		btnVolver.setBackground(asignar.devolverColor());
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				dispose();
			}
		});

		btnVolver.setBounds(0, 432, 131, 29);
		contentPane_1.add(btnVolver);
	}
}
