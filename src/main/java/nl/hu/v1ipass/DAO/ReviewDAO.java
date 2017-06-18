package nl.hu.v1ipass.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nl.hu.v1ipass.POJO.Review;

public class ReviewDAO implements IReviewDAO {

	public List<Review> getAlleReviews() {
		List<Review> reviewlist = new ArrayList<Review>();
		try {
			Connection myConn = BaseDAO.getConnection();

			Statement myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("select * from review");

			while (myRs.next()) {
				Review s = new Review(myRs.getInt("reserveringnummer"), myRs.getString("review"));
				reviewlist.add(s);
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return reviewlist;
	}

	public Review getReview(int reserveringnummer) {
		Review p = null;
		try {
			Connection myConn = BaseDAO.getConnection();

			PreparedStatement pstmt = myConn.prepareStatement("SELECT * FROM review WHERE reserveringnummer = ?");
			pstmt.setInt(1, reserveringnummer);
			pstmt.executeQuery();

			ResultSet rs = pstmt.getResultSet();

			while (rs.next()) {
				int reserveringnummer1 = rs.getInt("rekeningnummer");
				String review1 = rs.getString("review");
				Review review = new Review(reserveringnummer1, review1);

				p = review;
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return p;
	}

	public void addReview(Review review) {
		try {
			Connection myConn = BaseDAO.getConnection();

			PreparedStatement pstmt = myConn.prepareStatement(
					"INSERT into review(reserveringnummer, review) VALUES(?,?)");
			pstmt.setInt(1, review.getReserveringnummer());
			pstmt.setString(2, review.getReview());
			pstmt.executeQuery();
			myConn.close();
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	public void updateReview(Review review) {
		try {
			Connection myConn = BaseDAO.getConnection();

			PreparedStatement pstmt = myConn
					.prepareStatement("UPDATE review SET " + "review = ?, " + "WHERE reserveringnummer = ?");
			pstmt.setString(1, review.getReview());
			pstmt.executeQuery();
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	public void deleteReview(Review review) {
		try {
			Connection myConn = BaseDAO.getConnection();

			PreparedStatement pstmt = myConn.prepareStatement("DELETE FROM review WHERE reserveringnummer = ?");
			pstmt.setInt(1, review.getReserveringnummer());
			pstmt.execute();
			myConn.close();
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
