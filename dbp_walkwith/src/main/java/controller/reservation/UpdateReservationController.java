package controller.reservation;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.ReservationDTO;
import model.service.ReservationManager;

public class UpdateReservationController implements Controller {
    private ReservationManager reservationManager;

    public UpdateReservationController() {
        reservationManager = ReservationManager.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));
        
        // GET
        if (request.getMethod().equals("GET")) {	
            String userId = (String) request.getSession().getAttribute("userId");
            List<ReservationDTO> reservations = reservationManager.findReservationsByUser(userId);
            request.setAttribute("reservations", reservations);
            return "/reservation/reservation_view.jsp";
        }
        
     // POST...?
        LocalDate newDate = LocalDate.parse(request.getParameter("newDate"));
        String comment = request.getParameter("comment");

        int result = reservationManager.updateReservation(reservationId, newDate, comment);

        request.setAttribute("result", result);

        return "redirect:/reservation/reservation_view.jsp";
    }
}