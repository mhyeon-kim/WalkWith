package controller.seller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.SellerManager;

public class LoginSellerController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        
        try {
            // 모델에 로그인 처리를 위임
            SellerManager manager = SellerManager.getInstance();
            manager.login(userId, password);
    
            // 세션에 사용자 이이디 저장
            HttpSession session = request.getSession();
            session.setAttribute(SellerSessionUtils.USER_SESSION_KEY, userId);
            
            return "/seller/login";           
        } catch (Exception e) {
            /* UserNotFoundException이나 PasswordMismatchException 발생 시
             * 다시 login form을 사용자에게 전송하고 오류 메세지도 출력
             */
            request.setAttribute("loginFailed", true);
            request.setAttribute("exception", e);
            return "/login/loginForm.jsp";           
        }   
    }
}