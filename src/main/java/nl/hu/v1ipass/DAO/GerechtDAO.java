package nl.hu.v1ipass.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nl.hu.v1ipass.POJO.Gerecht;

public class GerechtDAO implements IGerechtDAO{

	public List<Gerecht> findAlleGerechten() {
		List<Gerecht> gerechtlist = new ArrayList<Gerecht>();
		try {
			Connection myConn = BaseDAO.getConnection();

			Statement myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("select * from gerecht");

			while (myRs.next()) {
				Gerecht s = new Gerecht(myRs.getString("naam"), myRs.getString("allergie_info"),
						myRs.getString("beschrijving"));
				gerechtlist.add(s);
				
				myConn.close();
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return gerechtlist;
	}

	public Gerecht findGerecht(String naam) {
		Gerecht p = null;
		try {
			Connection myConn = BaseDAO.getConnection();

			PreparedStatement pstmt = myConn.prepareStatement("SELECT * FROM gerecht WHERE naam = ?");
			pstmt.setString(1, naam);
			pstmt.executeQuery();

			ResultSet rs = pstmt.getResultSet();

			while (rs.next()) {
				String naam1 = rs.getString("naam");
				String allergieinfo = rs.getString("allergie_info");
				String beschrijving = rs.getString("beschrijving");
				Gerecht gerecht = new Gerecht(naam1, allergieinfo, beschrijving);

				p = gerecht;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return p;
	}

	public void addGerecht(Gerecht gerecht) {
		try {
			Connection myConn = BaseDAO.getConnection();

			PreparedStatement pstmt = myConn.prepareStatement(
					"INSERT into gerecht(naam, allergieinfo, beschrijving) VALUES(?,?,?)");
			pstmt.setString(1, gerecht.getNaam());
			pstmt.setString(2, gerecht.getAllergieinfo());
			pstmt.setString(3, gerecht.getBeschrijving());
			pstmt.executeQuery();
			myConn.close();
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	public void updateGerecht(Gerecht gerecht) {
		try {
			Connection myConn = BaseDAO.getConnection();

			PreparedStatement pstmt = myConn
					.prepareStatement("UPDATE gerecht SET " + "allergie_info = ?, " + "beschrijving = ?, " + "WHERE naam = ?");
			pstmt.setString(1, gerecht.getAllergieinfo());
			pstmt.setString(2, gerecht.getBeschrijving());
			pstmt.executeQuery();
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	public void deleteGerecht(Gerecht gerecht) {
		try {
			Connection myConn = BaseDAO.getConnection();

			PreparedStatement pstmt = myConn.prepareStatement("DELETE FROM gerecht WHERE naam = ?");
			pstmt.setString(1, gerecht.getNaam());
			pstmt.execute();
			myConn.close();
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
