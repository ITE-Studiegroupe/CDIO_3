package monololy_junior;

/**
 * Klasse: Terning
 * @author Gruppe_36
 * Klassen styrer spillerens kast med terning
 */
public class Terning {

/**
 * Metoden returnerer et tilfældigt tal mellem 1-6, som repræsenterer en ternings værdi
 * @return antalØjne
 */
	public int kastTerning() {
		int antalØjne = ((int) (Math.random() * 6) + 1);
		return antalØjne;
	}

}
