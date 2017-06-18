package nl.hu.v1ipass.DAO;

import nl.hu.v1ipass.POJO.Gerecht;

public class main {
	
	public static void main(String[] args) {
		GerechtDAO gerechtDAO = new GerechtDAO();
	
	
	for (Gerecht gerecht : gerechtDAO.findAlleGerechten()) {
		System.out.println(gerecht.getNaam());
		System.out.println(gerecht.getAllergieinfo());
		System.out.println(gerecht.getBeschrijving());
	}
}

}
