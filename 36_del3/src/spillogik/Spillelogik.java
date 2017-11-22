package spillogik;

import controller.GUIFører;
import monololy_junior.Plade;
import monololy_junior.Raflebæger;
import monololy_junior.Spiller;

public class Spillelogik {
	
	//Spillogikkens atributter.
	int antalSpillere;
	int nuværendeSpiller;
	
	Plade plade;
	GUIFører guiFører;	
	Raflebæger bæger;
	Spiller[] spillere;

	//Opretter nyt plade objekt.
	plade = new Plade();
	
	
	//Opretter getter.metode til Pladen
	public Plade getPlade() {
		return plade;
	}

	


	final static int taberPoint = 0;
	
	
	public static void CDIO3_logik(int terninger, Spiller s) {
		
	}

}
