package logica;

import java.awt.Color;
import java.util.Random;

//Clase creada especificamente para cambiar los colores de los botones del menu de forma aleatoria
//Fin unicamente ESTETICO

public class AsignarColores {
	static Color amarillo = new Color(154, 154, 0);
	static Color rojo = new Color(165, 72, 82);
	static Color naranja = new Color(217, 139, 60);
	static Color cyan = new Color(73, 117, 182);
	static Color verde = new Color(48, 96, 68);
	private static final Color[] colores = { rojo, amarillo, naranja, cyan, verde };

	private Random random;

	public AsignarColores() {
		random = new Random();
	}

	private Color darColorRandomBtnMenu() {
		return colores[(random.nextInt(4))];
	}

	public Color devolverColor() {

		return darColorRandomBtnMenu();
	}

}
