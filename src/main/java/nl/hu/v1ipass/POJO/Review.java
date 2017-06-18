package nl.hu.v1ipass.POJO;

public class Review {
	private int reserveringnummer;
	private String review;
	
	public Review(int reserveringnummer, String review) {
		super();
		this.reserveringnummer = reserveringnummer;
		this.review = review;
	}

	public int getReserveringnummer() {
		return reserveringnummer;
	}

	public void setReserveringnummer(int reserveringnummer) {
		this.reserveringnummer = reserveringnummer;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	
	
	

}
