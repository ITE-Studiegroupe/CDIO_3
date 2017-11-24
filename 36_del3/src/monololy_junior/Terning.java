package monololy_junior;

public class Terning {
	private int antalØjne;
	
	
	public int kastTerning() {
		int antalØjne = ((int) (Math.random()*6)+1);
		return this.antalØjne = antalØjne;
	}

	//Ikke nødvendig, heller ikke attributten
	public int getAntalØjne() {
		return antalØjne;
	}
}

