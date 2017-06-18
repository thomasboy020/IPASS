package nl.hu.v1ipass.DAO;

import java.util.List;

import nl.hu.v1ipass.POJO.Reservering;

public interface IReserveringDAO {
	public List<Reservering> getAlleReserveringen();

	public Reservering getReservering(int reserveringnummer);

	public void addReservering(Reservering reservering);

	public void updateReservering(Reservering reservering);

	public void deleteReservering(Reservering reservering);

}
