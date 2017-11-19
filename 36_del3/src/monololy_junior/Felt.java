package monololy_junior;

import java.awt.Color;

public class Felt {
	private int feltVærdi;
	private Color feltFarve;
	private Spiller feltEjer;
	private boolean feltHarEjer;
	private int feltType;
	
	public void setVærdi(int feltVærdi) {
		this.feltVærdi = feltVærdi;
	}
		
	public int getVærdi() {
		return feltVærdi;
	}

	public Color getFeltFarve() {
		return feltFarve;
	}

	public void setFeltFarve(Color feltFarve) {
		this.feltFarve = feltFarve;
	}
	
	
	
	

}
