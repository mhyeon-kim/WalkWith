package controller.customer;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.dto.ReservationDTO;
import model.service.CustomerManager;

public class UpdateReservationController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateReservationController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
 
        if (request.getMethod().equals("GET")) {    
            // GET request: 회원정보 수정 form 요청 
            // 원래는 UpdateUserFormController가 처리하던 작업을 여기서 수행
            String updateId = request.getParameter("reservationId");

            log.debug("UpdateForm Reservation Request : {}", updateId);
            
            CustomerManager manager = CustomerManager.getInstance();
            ReservationDTO res = manager.getReservation(Integer.parseInt(updateId)); // 수정하려는 사용자 정보 검색
            request.setAttribute("user", res);         

            HttpSession session = request.getSession();
            if (CustomerSessionUtils.isLoginUser(updateId, session) ||
                    CustomerSessionUtils.isLoginUser("admin", session)) {
                // 현재 로그인한 사용자가 수정 대상 사용자이거나 관리자인 경우 -> 수정 가능
                
                return "/reservation/reservation_update.jsp";   // reservation update 이동 
            }    
            
            // else (수정 불가능한 경우) 사용자 보기 화면으로 오류 메세지를 전달
            request.setAttribute("updateFailed", true);
            request.setAttribute("exception", 
                    new IllegalStateException("타인의 정보는 수정할 수 없습니다."));            
            return "/user/customer.jsp";    // 사용자 보기 화면으로 이동 (forwarding)
        }   
        
        // POST request (예약정보 parameter로 전송됨)
        String resUserId = request.getParameter("userId");
        String sDate = request.getParameter("resDaTi");
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date = (Date)formatter.parse(sDate);
      

//        log.debug("Update Reservation : { ? , ? }", userId, resDaTi);

        CustomerManager manager = CustomerManager.getInstance();
        manager.updateReservation(resUserId, date);         
        return "redirect:/reservation/reservation_view";           
    }
}