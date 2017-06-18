package nl.hu.v1ipass.DAO;

import java.util.List;

import nl.hu.v1ipass.POJO.Review;

public interface IReviewDAO {
	public List<Review> getAlleReviews();

	public Review getReview(int reserveringnummer);

	public void addReview(Review review);

	public void updateReview(Review review);

	public void deleteReview(Review review);

}