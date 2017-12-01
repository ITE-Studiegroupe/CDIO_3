package monopoly_junior;

import java.awt.Color;

/**
 * Brik klassen, holder styr på brikkens farve, <br>
 * placering, tidligere placering og kan rykkes
 * @author Gruppe 36
 */
public class Brik {
	
	private Color brikFarve;
	private int brikPlacering;
	private int tidlPlacering;
	
	/**
	 * Returnerer brikken farve
	 * @return brikFarve Color
	 */
	public Color getBrikFarve() {
		return brikFarve;
	}
	
	/**
	 * Sætter brikkens farve til den givne parameter
	 * @param brikFarve Color
	 */
	public void setBrikFarve(Color brikFarve) {
		this.brikFarve = brikFarve;
	}
	
	/**
	 * Returnerer brikkens nuværende placering (felt nummer).
	 * @return brikPlacering int
	 */
	public int getBrikPlacering() {
		return brikPlacering;
	}
	
	/**
	 * Sætter færst den tidligere placering til den nuværende<br>
	 * og ændrer den nuværende til den givne parameteren
	 * @param brikPlacering int
	 */
	public void setBrikPlacering(int brikPlacering) {
		tidlPlacering = this.brikPlacering;
		this.brikPlacering = brikPlacering;
	} 
	
	/**
	 * Rykker brikken antalRyk gange og gemmer den tidligere placering
	 * @param antalRyk int
	 */
	public void rykBrik(int antalRyk) {
		int nyPlacering = antalRyk + brikPlacering;
		if(nyPlacering>23) {
			nyPlacering = nyPlacering-24;
		}
		tidlPlacering = brikPlacering;
		brikPlacering = nyPlacering;
	}
	
	/**
	 * Returnerer den tidligere placering.
	 * @return tidlPlacering int
	 */
	public int getTidlPlacering() {
		return tidlPlacering;
	}

}
