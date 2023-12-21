package controller.reservation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.ReservationDTO;
import model.service.ReservationManager;

public class ViewReservationByStoreController implements Controller {
    private ReservationManager reservationManager;

    public ViewReservationByStoreController() {
        reservationManager = ReservationManager.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userId = request.getParameter("userId");
        List<ReservationDTO> userReservations = reservationManager.findReservationsByUser(userId);
        
        int storeId = Integer.parseInt(request.getParameter("storeId"));  // 사용자가 선택한 가게의 ID를 가져옵니다.
        List<ReservationDTO> storeReservations = reservationManager.findReservationsByStore(storeId);

        request.setAttribute("reservations", userReservations);
        request.setAttribute("storeReservations", storeReservations);

        return "/reservation/reservation_view.jsp";
    }
}


//<% List<ReservationDTO> reservations = (List<ReservationDTO>) request.getAttribute("reservations"); %>
//<% for (ReservationDTO reservation : reservations) { %>
//    ...
//<% } %> jsp에 들어가야 하는 내용