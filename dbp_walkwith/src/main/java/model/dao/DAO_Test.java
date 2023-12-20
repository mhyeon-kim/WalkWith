package model.dao;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import model.dto.PetDTO;
import model.dto.ReviewDTO;
import model.dto.SellerDTO;
import model.dto.StoreDTO;

public class DAO_Test {
	
	public static void main(String[] args) {
        store_reviewDAO dao = new store_reviewDAO();

        ReviewDTO review = new ReviewDTO(
            1, // 가게 ID
            "user1", // 사용자 ID
            "테스트 리뷰 내용입니다.", // 리뷰 내용
            5.0  // 별점 점수
        );

        try {
            // 리뷰 작성
            int result = dao.writeReview(review);
            if (result == 1) {
                System.out.println("리뷰가 성공적으로 작성되었습니다.");
            } else {
                System.out.println("리뷰 작성에 실패하였습니다.");
            }

            // 리뷰 삭제 테스트
            result = dao.deleteReview(String.valueOf(review.getReviewId())); // getReviewId() 가 리뷰 ID를 반환한다고 가정

            if (result == 1) {
                System.out.println("리뷰가 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("리뷰 삭제에 실패하였습니다.");
            }

        } catch (SQLException e) {
            System.out.println("오류가 발생하였습니다: " + e.getMessage());
            e.printStackTrace();
        }
	    
	}
}


	

