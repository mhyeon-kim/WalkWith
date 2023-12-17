package controller.seller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.dto.SellerDTO;
import model.service.ExistingUserException;
import model.service.SellerManager;

public class CreateSellerController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(CreateSellerController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("GET")) {    
            // GET request: 회원정보 등록 form 요청 
            log.debug("RegisterForm Request");
      
        }   

        // POST request (회원정보가 parameter로 전송됨)
        SellerDTO sel = new SellerDTO(
            request.getParameter("sellerId"),
            request.getParameter("seName"),
            request.getParameter("sePassword"),
            request.getParameter("sePhone"),
            request.getParameter("seMail")
        );
        
        log.debug("Create Seller : {}", sel);

        try {
            SellerManager manager = SellerManager.getInstance();
            manager.create(sel);
            return "redirect:/home";   // 성공 시 home 화면으로 redirect
            
        } catch (ExistingUserException e) { // 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("user", sel);
            return "/register/registerForm.jsp";
        }
    }
}