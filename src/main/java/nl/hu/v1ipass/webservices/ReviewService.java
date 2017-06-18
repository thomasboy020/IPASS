package nl.hu.v1ipass.webservices;

import nl.hu.v1ipass.DAO.ReviewDAO;
import nl.hu.v1ipass.POJO.Review;

public class ReviewService {

	private ReviewDAO reviewDAO = new ReviewDAO();

	public void addReview(Review review) {
		reviewDAO.addReview(review);
	}
}