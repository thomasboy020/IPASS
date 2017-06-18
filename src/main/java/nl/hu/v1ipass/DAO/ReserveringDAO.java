package nl.hu.v1ipass.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import nl.hu.v1ipass.POJO.Reservering;

public class ReserveringDAO implements IReserveringDAO {

	public List<Reservering> getAlleReserveringen() {
		List<Reservering> reserveringlist = new ArrayList<Reservering>();
		try {
			Connection myConn = BaseDAO.getConnection();

			Statement myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("select * from reservering");

			while (myRs.next()) {
				Reservering s = new Reservering(myRs.getInt("reserveringnummer"), myRs.getString("voornaam"),
						myRs.getString("achternaam"), myRs.getString("tijd"), myRs.getString("geb_datum"),
						myRs.getString("opmerking"), myRs.getInt("aantal_personen"), myRs.getString("datum"),
						myRs.getInt("telefoonnr"), myRs.getString("email"));
				reserveringlist.add(s);
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return reserveringlist;
	}

	public Reservering getReservering(int reserveringnummer) {
		Reservering p = null;
		try {
			Connection myConn = BaseDAO.getConnection();

			PreparedStatement pstmt = myConn.prepareStatement("SELECT * FROM reservering WHERE reserveringnummer = ?");
			pstmt.setInt(1, reserveringnummer);
			pstmt.executeQuery();

			ResultSet rs = pstmt.getResultSet();

			while (rs.next()) {
				int reserveringnummer1 = rs.getInt("reserveringnummer");
				String voornaam = rs.getString("voornaam");
				String achternaam = rs.getString("achternaam");
				String tijd = rs.getString("tijd");
				String gebdatum = rs.getString("geb_datum");
				String opmerking = rs.getString("opmerking");
				int aantalpersonen = rs.getInt("aantal_personen");
				String datum = rs.getString("datum");
				int telefoonnummer = rs.getInt("telefoonnr");
				String email = rs.getString("email");
				Reservering reservering = new Reservering(reserveringnummer1, voornaam, achternaam, tijd, gebdatum,
						opmerking, aantalpersonen, datum, telefoonnummer, email);

				p = reservering;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return p;
	}

	public void addReservering(Reservering reservering) {
		try {
			Connection myConn = BaseDAO.getConnection();

			PreparedStatement pstmt = myConn.prepareStatement(
					"INSERT into reservering(reserveringnummer, voornaam, achternaam, tijd, geb_datum, opmerking, aantal_personen, datum, telefoonnr, email) VALUES(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, reservering.getReserveringnummer());
			pstmt.setString(2, reservering.getVoornaam());
			pstmt.setString(3, reservering.getAchternaam());
			pstmt.setString(4, reservering.getTijd());
			pstmt.setString(5, reservering.getGebdatum());
			pstmt.setString(6, reservering.getOpmerking());
			pstmt.setInt(7, reservering.getAantalpersonen());
			pstmt.setString(8, reservering.getDatum());
			pstmt.setInt(9, reservering.getTelefoonnr());
			pstmt.setString(10, reservering.getEmail());
			pstmt.executeQuery();
			myConn.close();
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	public void updateReservering(Reservering reservering) {
		try {
			Connection myConn = BaseDAO.getConnection();

			PreparedStatement pstmt = myConn
					.prepareStatement("UPDATE reservering SET " + "voornaam = ?, " + "achternaam = ?, " + "tijd = ?, "
							+ "geb_datum = ?, " + "opmerking = ?, " + "aantal_personen = ?, " + "datum = ?, "
							+ "telefoonnr = ?, " + "email = ?, " + "WHERE reserveringnummer = ?");
			pstmt.setString(1, reservering.getVoornaam());
			pstmt.setString(2, reservering.getAchternaam());
			pstmt.setString(3, reservering.getTijd());
			pstmt.setString(4, reservering.getGebdatum());
			pstmt.setString(5, reservering.getOpmerking());
			pstmt.setInt(6, reservering.getAantalpersonen());
			pstmt.setString(7, reservering.getDatum());
			pstmt.setInt(8, reservering.getTelefoonnr());
			pstmt.setString(9, reservering.getEmail());
			pstmt.executeQuery();
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	public void deleteReservering(Reservering reservering) {
		try {
			Connection myConn = BaseDAO.getConnection();

			PreparedStatement pstmt = myConn.prepareStatement("DELETE FROM reservering WHERE reserveringnummer = ?");
			pstmt.setInt(1, reservering.getReserveringnummer());
			pstmt.execute();
			myConn.close();
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
