package monololy_junior;

/**
 * Holder styr på pengebeholdning og håndterer en pengeoverførsel.
 * @author Gruppe 36
 *
 */
public class Konto {
	private int pengeBeholdning;

	/**
	 * Returnerer penge beholdningen.
	 * @return pengeBeholdning int
	 */
	public int getPengeBeholdning() {
		return pengeBeholdning;
	}

	/**
	 * Sætter penge beholdningen til den givne parameter.
	 * @param pengeBeholdning int
	 */
	public void setPengeBeholdning(int pengeBeholdning) {
		this.pengeBeholdning = pengeBeholdning;
	}

	/**
	 * Tjekker først om beløbet ryger i nul, hvis det gør returneres der false. <br>
	 * Ellers indsættes/trækkes pengene fra penge beholdningen og true returneres.
	 * @param beløb int, + beløb insættes, - beløb trækkes
	 * @return boolean, true for lykket, false for mislykket
	 */
	public boolean indsætPenge(int beløb) {
		int tjek = pengeBeholdning + beløb;
		boolean resultat;
		if (tjek <= 0) {
			resultat = false;
		} else {
			this.pengeBeholdning = tjek;
			resultat = true;
		}
		return resultat;
	}

}
