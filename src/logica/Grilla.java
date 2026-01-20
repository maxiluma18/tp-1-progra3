package logica;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Grilla {
	private static Color[][] matriz;
	private Random random;
	private boolean ganoJuego;
	public int turnos;
	private static final Color[] colores = { null, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA,
			Color.CYAN, };

	public Grilla(int n) {
		matriz = new Color[n][n];
		random = new Random();
		ganoJuego = false;
		turnos = 0;
	}

	private Color darColoresRandom() {
		return colores[(random.nextInt(6)) + 1];
	}

	private void resetearValor(int fila, int columna) {
		if (fila < matriz.length - 1)
			matriz[fila + 1][columna] = null;

		if (fila > 0)
			matriz[fila - 1][columna] = null;

		if (columna < matriz[0].length - 1)
			matriz[fila][columna + 1] = null;

		if (columna > 0)
			matriz[fila][columna - 1] = null;

		matriz[fila][columna] = null;
	}

	private boolean verificarLimitesGrilla(int fila, int columna) {
		boolean limite = false;
		if (fila < matriz.length - 1)
			limite |= matriz[fila][columna] == matriz[fila + 1][columna];

		if (fila > 0)
			limite |= matriz[fila][columna] == matriz[fila - 1][columna];

		if (columna < matriz[0].length - 1)
			limite |= matriz[fila][columna] == matriz[fila][columna + 1];

		if (columna > 0)
			limite |= matriz[fila][columna] == matriz[fila][columna - 1];

		if (limite == true) {
			resetearValor(fila, columna);
			return true;
		}
		return limite;
	}

	private boolean verificarGano() {
		for (int fila = 0; fila < matriz.length; fila++) {
			for (int columna = 0; columna < matriz[0].length; columna++) {
				if (matriz[fila][columna] == null) {
					return false;
				}
			}
		}
		return true;
	}

	private Object sugerirMovimiento() {

		for (int fila = 0; fila < matriz.length; fila++) {
			for (int columna = 0; columna < matriz[0].length; columna++) {
				if (matriz[fila][columna] == null) {
					boolean mismo = true;
					if (fila < matriz.length - 1)
						mismo &= matriz[fila][columna] == matriz[fila + 1][columna];

					if (fila > 0)
						mismo &= matriz[fila][columna] == matriz[fila - 1][columna];

					if (columna < matriz[0].length - 1)
						mismo &= matriz[fila][columna] == matriz[fila][columna + 1];

					if (columna > 0)
						mismo &= matriz[fila][columna] == matriz[fila][columna - 1];
					if (mismo == true)
						return new Point(fila, columna);
				}
			}
		}
		for (int fila = 0; fila < matriz.length; fila++) {
			for (int columna = 0; columna < matriz[0].length; columna++) {
				if (matriz[fila][columna] == null) {
					return new Point(fila, columna);
				}
			}
		}
		return null;
	}

	

	public void cambiarColorGrilla(int fila, int columna) {
		matriz[fila][columna] = darColoresRandom();
		turnos++;
		verificarLimitesGrilla(fila, columna);
		if (turnos >= fila * fila) {
			ganoJuego = verificarGano();
		}
	}

	public Object obtenerSugerencia() {
		return sugerirMovimiento();
	}

	public Color obtenerColorCelda(int fila, int columna) {
		return matriz[fila][columna];
	}

	public boolean Gano() {
		return ganoJuego;
	}

	public int click() {
		return turnos;
	}

}
