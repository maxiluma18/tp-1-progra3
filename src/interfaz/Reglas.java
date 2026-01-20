package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Reglas extends JFrame {

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
					Reglas frame = new Reglas();
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
	public Reglas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setLocationRelativeTo(null); // hace q aparezca en el centro
		setTitle("Histeria"); // le pone nomre arriba a la izq
		setResizable(false); // hace q no se pueda modificar ni agrandar la pantalla

		contentPane_1 = new PanelConFondo("Reglas (1).png");
		contentPane_1.setBackground(new Color(204, 178, 128));
		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Reglas");
		lblNewLabel.setBounds(205, 75, 74, 25);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		contentPane_1.add(lblNewLabel);

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBackground(new Color(233, 204, 142));
		btnNewButton.setBorder(BorderFactory.createLineBorder(new Color(153, 102, 51), 2));
		btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 88, 38);
		contentPane_1.add(btnNewButton);

		JTextPane txtpnTrataDeColorear = new JTextPane();
		txtpnTrataDeColorear.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		txtpnTrataDeColorear.setEditable(false);
		txtpnTrataDeColorear.setText(
				"Trata de colorear todo el tablero. Cada vez que pulses en una celda, esta cambiará su color a uno de entre seis, elegido al azar. \r\n\r\nLa locura, la histeria, reside en que si este nuevo color coincide con el que tenga una casilla vecina... ¡la casilla pulsada y todas las vecinas se apagarán! Esto puede resultar especialmente exasperante cuando se había conseguido colorear el tablero casi por completo...");
		txtpnTrataDeColorear.setBounds(118,111, 274, 262);
		txtpnTrataDeColorear.setOpaque(false);
		txtpnTrataDeColorear.setBackground(new Color(0, 0, 0, 0));
		contentPane_1.add(txtpnTrataDeColorear);
	}
}
