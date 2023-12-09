package controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.dto.ReviewDTO;
import model.service.ReviewManager;

public class CreateReviewController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(CreateReviewController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ReviewDTO review = new ReviewDTO(
                0,0,0, request.getParameter("reContent"), 0);   // DTO는 다 String..?
        
        try {
            ReviewManager manager = ReviewManager.getInstance();
            manager.write(review);
            
            log.debug("Write Review : {}", review);
            return "/review/review_view.jsp";  // 성공 시 review_view 페이지로 이동 (forwarding) 
            
        } catch (Exception e) {     // 예외 발생 시 어디로 가지...
            
            return "";
        }

    
             
        
    }
}
