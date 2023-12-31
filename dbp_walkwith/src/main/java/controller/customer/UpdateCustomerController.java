package controller.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.dto.CustomerDTO;
import model.service.CustomerManager;

public class UpdateCustomerController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateCustomerController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
 
        if (request.getMethod().equals("GET")) {    
            // GET request: 회원정보 수정 form 요청 
            // 원래는 UpdateUserFormController가 처리하던 작업을 여기서 수행
            String updateId = request.getParameter("userId");

            log.debug("UpdateForm Request : {}", updateId);
            
            CustomerManager manager = CustomerManager.getInstance();
            CustomerDTO cus = manager.getCustomer(updateId); // 수정하려는 사용자 정보 검색
            request.setAttribute("user", cus);         

            HttpSession session = request.getSession();
            if (CustomerSessionUtils.isLoginUser(updateId, session) ||
                    CustomerSessionUtils.isLoginUser("admin", session)) {
                // 현재 로그인한 사용자가 수정 대상 사용자이거나 관리자인 경우 -> 수정 가능
                
                return "/user/customer_update.jsp";   // 검색한 사용자 정보 및 커뮤니티 리스트를 updateForm으로 전송     
            }    
            
            // else (수정 불가능한 경우) 사용자 보기 화면으로 오류 메세지를 전달
            request.setAttribute("updateFailed", true);
            request.setAttribute("exception", 
                    new IllegalStateException("타인의 정보는 수정할 수 없습니다."));            
            return "/user/view.jsp";    // 사용자 보기 화면으로 이동 (forwarding)
        }   
        
        // POST request (회원정보가 parameter로 전송됨)
        CustomerDTO updateCustomer = new CustomerDTO(
                request.getParameter("userId"),
                request.getParameter("uName"),
                request.getParameter("uPassword"),
                request.getParameter("uPhone"),
                request.getParameter("uMail"),
                (List)request.getAttribute("petList"),
                (List)request.getAttribute("likeList")
        );

        log.debug("Update User : {}", updateCustomer);

        CustomerManager manager = CustomerManager.getInstance();
        manager.update(updateCustomer);         
        return "redirect:/user/customer";           
    }
}