package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.dto.PetDTO;
import model.service.CustomerManager;
import model.service.ExistingPetException;

public class CreatePetController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(CreatePetController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("GET")) {    
            // GET request: 회원정보 등록 form 요청 
            log.debug("RegisterForm Pet Request");
      
        }   

        // POST request (pet 정보 parameter로 전송됨)
        PetDTO pet = new PetDTO(
        	    Integer.parseInt(request.getParameter("petId")),
        	    request.getParameter("pImage"),
        	    request.getParameter("pName"),
        	    Integer.parseInt(request.getParameter("pAge")),
        	    request.getParameter("pCategory"),
        	    request.getParameter("pDatailCa"),
        	    Integer.parseInt("pNeureting"), // 'Y'는 true, 'N'는 false로 변환
        	    request.getParameter("userId")
        	);
                
        
        log.debug("Create Pet : {}", pet);

        try {
            CustomerManager manager = CustomerManager.getInstance();
            manager.createPet(pet);
            return "redirect:/user/customer";   // 성공 시 home 화면으로 redirect
            
        } catch (ExistingPetException e) { // 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("pet", pet);
            return "/user/pet_ResiterForm.jsp";
        }
    }
}