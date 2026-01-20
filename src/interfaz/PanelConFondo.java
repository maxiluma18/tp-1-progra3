package interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelConFondo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image fondo;

	public PanelConFondo(String nombreImagen) {

		ImageIcon icono = new ImageIcon(getClass().getResource("/fondos/" + nombreImagen));
		fondo = icono.getImage();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
	}
}
