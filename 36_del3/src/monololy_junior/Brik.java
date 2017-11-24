package monololy_junior;

import java.awt.Color;

public class Brik {
	
	private Color brikFarve;
	private int brikPlacering;
	private int tidlPlacering;
	
	public Color getBrikFarve() {
		return brikFarve;
	}
	
	public void setBrikFarve(Color brikFarve) {
		this.brikFarve = brikFarve;
	}
	
	public int getBrikPlacering() {
		tidlPlacering = brikPlacering;
		return brikPlacering;
	}
	
	public void setBrikPlacering(int brikPlacering) {
		this.brikPlacering = brikPlacering;
	} 
	//bruges til at skrive rykke brikken videre fra den nuværende 
	public void rykBrik(int antalRyk) {
		int nyPlacering = antalRyk + brikPlacering;
		if(nyPlacering>23) {
			nyPlacering = nyPlacering-24;
		}
		tidlPlacering = brikPlacering;
		brikPlacering = nyPlacering;
	}

	public int getTidlPlacering() {
		return tidlPlacering;
	}

}
