package controller.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.dto.CustomerDTO;
import model.dto.PetDTO;
import model.service.CustomerManager;
import model.service.ExistingUserException;

public class CreateCustomerController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(CreateCustomerController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("GET")) {    
            // GET request: 회원정보 등록 form 요청 
            log.debug("RegisterForm Request");
      
        }   

        // POST request (회원정보가 parameter로 전송됨)
        CustomerDTO cus = new CustomerDTO(
            request.getParameter("userId"),
            request.getParameter("uName"),
            request.getParameter("uPassword"),
            request.getParameter("uPhone"),
            request.getParameter("uMail"),
            (List)request.getAttribute("petList"),
            (List)request.getAttribute("likeList")
        );
        
        log.debug("Create Customer : {}", cus);

        try {
            CustomerManager manager = CustomerManager.getInstance();
            manager.create(cus);
            return "redirect:/home";   // 성공 시 home 화면으로 redirect
            
        } catch (ExistingUserException e) { // 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("user", cus);
            return "/register/registerForm.jsp";
        }
    }

    private List<PetDTO> List(Object attribute) {
        // TODO Auto-generated method stub
        return null;
    }
}