package nl.hu.v1ipass.POJO;

public class Gerecht {
	private String naam;
	private String allergieinfo;
	private String beschrijving;
	
	public Gerecht(String naam, String allergieinfo, String beschrijving) {
		super();
		this.naam = naam;
		this.allergieinfo = allergieinfo;
		this.beschrijving = beschrijving;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getAllergieinfo() {
		return allergieinfo;
	}

	public void setAllergieinfo(String allergieinfo) {
		this.allergieinfo = allergieinfo;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}


}
