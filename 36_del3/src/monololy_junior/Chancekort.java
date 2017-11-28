package monololy_junior;

public class Chancekort {
	private int værdi;
	private int kortType;
	private String chanceKortTekst;
	
	
	/**
	 * 
	 * @param værdi
	 * @param type
	 * @param tekst
	 */
	public Chancekort (int værdi, int type, String tekst) {
		this.værdi = værdi;
		kortType = type;
		chanceKortTekst = tekst;
	}

	public int getVærdi() {
		return værdi;
	}

	public int getKortType() {
		return kortType;
	}

	public String getChanceKortTekst() {
		return chanceKortTekst;
	}
	
	
}
