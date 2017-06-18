package nl.hu.v1ipass.POJO;

public class Reservering {
	private int reserveringnummer;
	private String voornaam;
	private String achternaam;
	private String tijd;
	private String gebdatum;
	private String opmerking;
	private int aantalpersonen;
	private String datum;
	private int telefoonnr;
	private String email;

	public Reservering(int reserveringnummer, String voornaam, String achternaam, String tijd, String gebdatum,
			String opmerking, int aantalpersonen, String datum, int telefoonnr, String email) {
		super();
		this.reserveringnummer = reserveringnummer;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.tijd = tijd;
		this.gebdatum = gebdatum;
		this.opmerking = opmerking;
		this.aantalpersonen = aantalpersonen;
		this.datum = datum;
		this.telefoonnr = telefoonnr;
		this.email = email;
	}

	public int getReserveringnummer() {
		return reserveringnummer;
	}

	public void setReserveringnummer(int reserveringnummer) {
		this.reserveringnummer = reserveringnummer;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getTijd() {
		return tijd;
	}

	public void setTijd(String tijd) {
		this.tijd = tijd;
	}

	public String getGebdatum() {
		return gebdatum;
	}

	public void setGebdatum(String gebdatum) {
		this.gebdatum = gebdatum;
	}

	public String getOpmerking() {
		return opmerking;
	}

	public void setOpmerking(String opmerking) {
		this.opmerking = opmerking;
	}

	public int getAantalpersonen() {
		return aantalpersonen;
	}

	public void setAantalpersonen(int aantalpersonen) {
		this.aantalpersonen = aantalpersonen;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public int getTelefoonnr() {
		return telefoonnr;
	}

	public void setTelefoonnr(int telefoonnr) {
		this.telefoonnr = telefoonnr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
