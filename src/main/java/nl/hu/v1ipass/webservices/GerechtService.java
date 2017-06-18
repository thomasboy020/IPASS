package nl.hu.v1ipass.webservices;

import java.util.List;
import nl.hu.v1ipass.DAO.GerechtDAO;
import nl.hu.v1ipass.POJO.Gerecht;

public class GerechtService {
	
	private GerechtDAO gerechtDAO = new GerechtDAO();
	
	public List<Gerecht> getAlleGerechten() {
		return gerechtDAO.findAlleGerechten();
	}

}
