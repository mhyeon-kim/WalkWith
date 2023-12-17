package controller.seller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.SellerManager;
import model.service.UserNotFoundException;
import model.dto.SellerDTO;

public class ViewSellerController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {          
        // 로그인 여부 확인
        if (!SellerSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/login/loginForm";     // login form 요청으로 redirect
        }
        
        SellerManager manager = SellerManager.getInstance();
        String userId = request.getParameter("userId");
        
        SellerDTO sel = null;
        try {
            sel = manager.findSeller(userId);    // 사용자 정보 검색
        } catch (UserNotFoundException e) {             
            return "redirect:/user/registerForm"; //없으면 회원가입창
        }    
        
        request.setAttribute("user", sel);     // 사용자 정보 저장                
        return "/user/seller.jsp";                // 사용자 보기 화면으로 이동
    }
}
