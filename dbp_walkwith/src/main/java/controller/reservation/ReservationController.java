package controller.reservation;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.dto.ReservationDTO;
import model.service.ReservationManager;

public class ReservationController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ReservationController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		   Timestamp resDaTi = Timestamp.valueOf(request.getParameter("resDaTi"));
		    String userId = request.getParameter("userId");
		    int storeId = Integer.parseInt(request.getParameter("storeId"));
		    String comment = request.getParameter("comment");

		    ReservationDTO res = new ReservationDTO(
		        resDaTi, // 예약 날짜와 시간
		        userId, // 사용자 ID
		        storeId, // 가게 ID
		        comment // 코멘트
		    );

	    try {
	        ReservationManager manager = ReservationManager.getInstance();
	        manager.addReservation(res);
	        
	        log.debug("Create Reservation : {}", res);
	        return "/reservation/reservation_view.jsp";  // 예약 성공 시 reservation_view 페이지로 이동 (forwarding) 

	    } catch (Exception e) {    
	        request.setAttribute("creationFailed", true);
	        request.setAttribute("exception", e);
	        request.setAttribute("reservation", res);
	        return "/reservation/reservation.jsp";  // 예약 실패 시 다시 예약 페이지로 이동
	    }
	}


}
