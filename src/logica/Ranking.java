package logica;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Ranking {
	static Map<String, Integer> tablaNombres = new LinkedHashMap<>();
	static String ultimoNombre;

	public Ranking() {
	}

	private void cargarNombre(String nombre) {
		if (nombre != null) {
			ultimoNombre = nombre;
		}
	}

//Este mapa ordena los jugadores que obtengan menos clicks y los guarda en el ranking 
	private Map<String, Integer> top() {
		return tablaNombres.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()) // Ordenar por
																										// valor en
																										// orden
																										// ascendente
				.limit(5) // Limitar a las 5 entradas más bajas
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, // En caso de
																									// colisión, se
																									// mantiene el
																									// primer valor
						LinkedHashMap::new // Especifica que se debe usar un LinkedHashMap para mantener el orden
				));
	}

	private void actualizar(int clicks) {

		if (ultimoNombre != null) {
			tablaNombres.put(ultimoNombre, clicks);
		}

	}

	private String dameNombreTop(int indice) {
		int contador = 0;

		for (Map.Entry<String, Integer> entry : top().entrySet()) {
			if (contador == indice) {
				return entry.getKey();
			}
			contador++;
		}
		return "     ";
	}

	// Este metodo devuelve los clicks que realizo el jugador
	private Integer dameClicksTop(int indice) {

		int contador = 0;

		for (Map.Entry<String, Integer> entry : top().entrySet()) {

			if (contador == indice) {

				return entry.getValue();
			}
			contador++;

		}
		return 0;
	}

	private Integer largoLista() {
		int longitud = tablaNombres.size();
		if (longitud > 5) {
			return 5;
		}
		return longitud;
	}

	public Integer longuitudLista() {
		return largoLista();

	}

	public Integer obtenerClicks(int i) {
		return dameClicksTop(i);

	}

	public String obtenerNombreR(int i) {
		return dameNombreTop(i);
	}

	public void obtenerAct(int clicks) {
		actualizar(clicks);
	}

	public void guardarNombre(String nombre) {
		cargarNombre(nombre);
	}

}
