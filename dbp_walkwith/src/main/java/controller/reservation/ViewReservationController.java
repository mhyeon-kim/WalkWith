package controller.reservation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.ReservationDTO;
import model.service.ReservationManager;

public class ViewReservationController implements Controller {
    private ReservationManager reservationManager;

    public ViewReservationController() {
        reservationManager = ReservationManager.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userId = request.getParameter("userId");
        List<ReservationDTO> reservations = reservationManager.findReservationsByUser(userId);

        request.setAttribute("reservations", reservations);

        return "/reservation/reservation_view.jsp";
    }
}



//<% List<ReservationDTO> reservations = (List<ReservationDTO>) request.getAttribute("reservations"); %>
//<% for (ReservationDTO reservation : reservations) { %>
//    ...
//<% } %> jsp에 들어가야 하는 내용