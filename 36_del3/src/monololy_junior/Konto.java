package monololy_junior;

public class Konto {
	private int pengeBeholdning;

	public int getPengeBeholdning() {
		return pengeBeholdning;
	}

	public void setPengeBeholdning(int pengeBeholdning) {
		this.pengeBeholdning = pengeBeholdning;
	}

	public boolean indsætPenge(int beløb) {
		int tjek = pengeBeholdning + beløb;
		boolean resultat;
		if (tjek < 0) {
			resultat = false;
		} else {
			this.pengeBeholdning = tjek;
			resultat = true;
		}
		return resultat;
	}

}
