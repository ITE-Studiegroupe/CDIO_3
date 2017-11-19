package monololy_junior;

public class Spiller {
	private String spillerNavn;
	private Felt[] ejetFelter;
	private boolean erDød;
	
	public Spiller() {
		erDød = false;
	}

	public String getSpillerNavn() {
		return spillerNavn;
	}

	public void setSpillerNavn(String spillerNavn) {
		this.spillerNavn = spillerNavn;
	}
	
	public boolean tjekOmDød() {
		if(erDød) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public void setDød(boolean erDød) {
		this.erDød = erDød;
	}
	
	
	
	

}
