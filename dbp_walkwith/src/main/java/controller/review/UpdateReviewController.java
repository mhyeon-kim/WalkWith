package controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.dto.ReviewDTO;
import model.service.ReviewManager;

public class UpdateReviewController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(CreateReviewController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ReviewDTO review = new ReviewDTO(
                0, // 리뷰 ID
                0, // 가게 ID
                request.getParameter("userId"), // 사용자 ID (문자열로 처리)
                request.getParameter("reContent"), // 리뷰 내용
                Double.parseDouble(request.getParameter("starScore")) // 별점 점수 (문자열을 double로 변환)
            );   // DTO는 다 String..?
        
        try {
            ReviewManager manager = ReviewManager.getInstance();
            manager.update(review);
            
            log.debug("Update Review : {}", review);
            return "/review/review_view.jsp";  // 성공 시 review_view 페이지로 이동 (forwarding) 
            
        } catch (Exception e) {     
            request.setAttribute("UpdateFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("review", review);
            return "/review/reivew_update.jsp";
        }

    
             
        
    }
}
