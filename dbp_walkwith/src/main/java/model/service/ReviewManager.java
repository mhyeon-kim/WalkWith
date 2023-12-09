package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Community;
import model.User;
import model.dto.ReviewDTO;
import model.dao.store_reviewDAO;

public class ReviewManager{
    private static ReviewManager reviewMan = new ReviewManager();
    private store_reviewDAO reviewDAO;
    
    private ReviewManager() {
        try {
            reviewDAO = new store_reviewDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int write(ReviewDTO reviewDTO) throws SQLException, ExistingUserException {
        return reviewDAO.writeReview(reviewDTO);
    }
    
    public int remove(String reviewId) throws SQLException, UserNotFoundException {
        return reviewDAO.deleteReview(reviewId);
    }
    
    public int update(ReviewDTO reviewDTO) throws SQLException, UserNotFoundException {
        return reviewDAO.updateReview(reviewDTO);
    }
    
    public static ReviewManager getInstance() {
        return reviewMan;
    }
    
    public store_reviewDAO getstore_reviewDAO() {
        return this.reviewDAO;
    }
}