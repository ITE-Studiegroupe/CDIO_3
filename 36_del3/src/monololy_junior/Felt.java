package monololy_junior;

import java.awt.Color;

public class Felt {
	private int feltVærdi;
	private Color feltFarve;
	private Spiller feltEjer;
	private boolean feltHarEjer;
	private int feltType;
	private String feltNavn;
	
	public void setVærdi(int feltVærdi) {
		this.feltVærdi = feltVærdi;
	}
		
	public int getVærdi() {
		return feltVærdi;
	}
	
	public void setFeltFarve(Color feltFarve) {
		this.feltFarve = feltFarve;
	}

	public String getFeltNavn() {
		return feltNavn;
	}

	public void setFeltNavn(String feltNavn) {
		this.feltNavn = feltNavn;
	}

	public Color getFeltFarve() {
		return feltFarve;
	}

	public Spiller getFeltEjer() {
		return feltEjer;
	}

	public void setFeltEjer(Spiller feltEjer) {
		this.feltEjer = feltEjer;
	}

	public boolean isFeltHarEjer() {
		return feltHarEjer;
	}

	public void setFeltHarEjer(boolean feltHarEjer) {
		this.feltHarEjer = feltHarEjer;
	}

	public int getFeltType() {
		return feltType;
	}

	public void setFeltType(int feltType) {
		this.feltType = feltType;
	}
	

	

}
