package controller.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ReservationManager;

public class DeleteReservationController implements Controller {
    private ReservationManager reservationManager;

    public DeleteReservationController() {
        reservationManager = ReservationManager.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));
        int result = reservationManager.deleteReservation(reservationId);

        request.setAttribute("result", result);

        return "/reservation/reservation_view.jsp";
    }
}
