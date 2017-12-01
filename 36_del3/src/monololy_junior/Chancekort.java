package monololy_junior;

/**
 * Holder styr på et chancekorts type, værdi og tekst.
 * @author Gruppe 36
 *
 */
public class Chancekort {
	private int værdi;
	private int kortType;
	private String chanceKortTekst;
	
	
	/**
	 * Konstruktøren
	 * @param værdi int, kan være penge eller feltNr afhængig af kort typen.
	 * @param type int, 1. betal penge, 2. få penge og 3. ryk felter.
	 * @param tekst String teksten på kortet.
	 */
	public Chancekort (int værdi, int type, String tekst) {
		this.værdi = værdi;
		kortType = type;
		chanceKortTekst = tekst;
	}

	/**
	 * Returnerer kortet værdi.
	 * @return værdi int
	 */
	public int getVærdi() {
		return værdi;
	}

	/**
	 * Returnerer kortets type
	 * @return kortType int
	 */
	public int getKortType() {
		return kortType;
	}

	/**
	 * Returnerer teksten til på chancekortet.
	 * @return chanceKortTekst String
	 */
	public String getChanceKortTekst() {
		return chanceKortTekst;
	}
	
	
}
