package addons;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Wyniki
 *
 * @author Tobiasz Rumian
 */
class Results {

	private Map<String, Long> results = new HashMap<>();

	/**
	 * Funkcja dodająca wynik do mapy.
	 *
	 * @param label Opis wyniku.
	 * @param value Wartość wyniku.
	 */
	void add(String label, Long value) {
		if (results.containsKey(label)) {
			results.replace(label, value);
		}
		results.put(label, value);
	}

	/**
	 * Funkcja czyszcząca wyniki.
	 */
	void clear() {
		results.clear();
	}

	/**
	 * Funkcja pozwalająca na zapis wyników do pliku
	 */
	void save() {
		try (PrintStream out = new PrintStream(new FileOutputStream("results.txt"))) {
			StringBuilder stringBuilder = new StringBuilder();
			results.forEach((n, v) -> stringBuilder.append(n).append("\t").append(v).append("\n"));
			out.print(stringBuilder.toString());
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Funkcja zwracająca wyniki w formie tekstu.
	 *
	 * @return Zwraca wyniki w formie tekstu.
	 */
	String show() {
		StringBuilder stringBuilder = new StringBuilder();
		results.forEach((n, v) -> stringBuilder.append(n).append("\t").append(v).append("\n"));
		return stringBuilder.toString();
	}

	public Map<String, Long> getResults() {
		return results;
	}
}
