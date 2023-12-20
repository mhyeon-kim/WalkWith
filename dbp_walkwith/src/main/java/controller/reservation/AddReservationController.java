package controller.reservation;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.dto.ReservationDTO;
import model.service.ReservationManager;

public class AddReservationController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(AddReservationController.class);
    private ReservationManager reservationManager;

    public AddReservationController() {
        reservationManager = ReservationManager.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String dateParam = request.getParameter("date");
        String userIdParam = request.getParameter("userId");
        String storeIdParam = request.getParameter("storeId");

        if (dateParam == null || userIdParam == null || storeIdParam == null) {
            request.setAttribute("creationFailed", true);
            request.setAttribute("errorReason", "Missing required parameters");
            return "/reservation/creationForm.jsp";
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 시간까지 포함된 형식으로 변경
        Date parsedDate = format.parse(dateParam);
        Timestamp date = new Timestamp(parsedDate.getTime());  // Date를 Timestamp로 변환

        int storeId = Integer.parseInt(storeIdParam);

        ReservationDTO reservation = new ReservationDTO(
                0, date,
                userIdParam,
                null, // uName  
                storeId,
                null, // sName
                null  // comment
        );

        try {
            reservationManager.addReservation(reservation);

            log.debug("Add Reservation : {}", reservation);
            return "redirect:reservation_view.jsp"; // 성공 시 예약 리스트 화면으로 redirect

        } catch (Exception e) { // 예외 발생 시 입력 form으로 forwarding
            request.setAttribute("creationFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("reservation", reservation);
            return "/reservation/creationForm.jsp";
        }
    }

}
