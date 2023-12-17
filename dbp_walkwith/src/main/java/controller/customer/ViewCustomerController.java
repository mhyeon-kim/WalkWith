package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.CustomerManager;
import model.service.UserNotFoundException;
import model.User;
import model.dto.CustomerDTO;

public class ViewCustomerController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {          
        // 로그인 여부 확인
        if (!CustomerSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/login/loginForm";     // login form 요청으로 redirect
        }
        
        CustomerManager manager = CustomerManager.getInstance();
        String userId = request.getParameter("userId");
        
        CustomerDTO cus = null;
        try {
            cus = manager.getCustomer(userId);    // 사용자 정보 검색
        } catch (UserNotFoundException e) {             
            return "redirect:/register/registerForm"; //없으면 회원가입창
        }   
        
        request.setAttribute("user", cus);     // 사용자 정보 저장                
        return "/user/customer.jsp";                // 사용자 보기 화면으로 이동
    }
}
