package nl.hu.v1ipass.DAO;

import java.util.List;

import nl.hu.v1ipass.POJO.Gerecht;

public interface IGerechtDAO {
	public List<Gerecht> findAlleGerechten();

	public Gerecht findGerecht(String naam);

	public void addGerecht(Gerecht gerecht);

	public void updateGerecht(Gerecht gerecht);

	public void deleteGerecht(Gerecht gerecht);

}