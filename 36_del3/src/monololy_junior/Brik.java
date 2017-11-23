package monololy_junior;

import java.awt.Color;

public class Brik {
	
	private Color brikFarve;
	private int brikPlacering;
	
	public Color getBrikFarve() {
		return brikFarve;
	}
	
	public void setBrikFarve(Color brikFarve) {
		this.brikFarve = brikFarve;
	}
	
	public int getBrikPlacering() {
		return brikPlacering;
	}
	
	public void setBrikPlacering(int brikPlacering) {
		this.brikPlacering = brikPlacering;
	} 
	//bruges til at skrive rykke brikken videre fra den nuværende 
	public void rykBrik(int antalRyk) {
		int nyPlacering = antalRyk + brikPlacering;
		if(nyPlacering>24) {
			int endeligNyPlacering = (nyPlacering-24);
			brikPlacering = endeligNyPlacering;
		}
		
	}
}
