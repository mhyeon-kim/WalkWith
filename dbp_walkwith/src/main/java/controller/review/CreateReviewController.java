package controller.review;

import java.util.List;

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
        if (request.getMethod().equals("GET")) {   
            // GET request: 회원정보 등록 form 요청 
            log.debug("RegisterForm Request");

            return "/review/review_write.jsp";   //    
        }
        
        String st = request.getParameter("star");
        Double s = Double.parseDouble(st);
        
        ReviewDTO review = new ReviewDTO(
                6,
                "user1", // 사용자 ID (문자열로 변환)
                2, // 가게 ID
                request.getParameter("recontent"), // 리뷰 내용
                s // 별점 점수 (double 형식)
            );
        
        try {
            ReviewManager manager = ReviewManager.getInstance();
            manager.write(review);
            
            log.debug("Write Review : {}", review);
            return "/review/review_view.jsp";  // 성공 시 review_view 페이지로 이동 (forwarding) 
            
        } catch (Exception e) {    
            request.setAttribute("creationFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("review", review);
            return "/review/reivew_write.jsp";
        }

    
             
        
    }
}
