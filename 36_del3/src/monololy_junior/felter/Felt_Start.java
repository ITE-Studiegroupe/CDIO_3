package monololy_junior.felter;

import java.awt.Color;

public class Felt_Start extends Felt{

	private int præmie;

	
	public Felt_Start (int feltNr, String navn, int præmie, Color bgFarve, Color tekstFarve) {
		feltNavn = navn;
		this.feltNr = feltNr;
		this.præmie = præmie;
		this.bgFarve = bgFarve;
		this.tekstFarve = tekstFarve;
		
	}

	public int getPræmie() {
		return præmie;
	}

	public void setPræmie(int præmie) {
		this.præmie = præmie;
	}

	
	
}
