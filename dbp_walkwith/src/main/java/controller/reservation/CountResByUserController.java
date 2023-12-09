package controller.reservation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ReservationManager;

public class CountResByUserController implements Controller {
    private ReservationManager reservationManager;

    public CountResByUserController() {
        reservationManager = ReservationManager.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Integer> countMap = reservationManager.countReservationsByUser();

        request.setAttribute("countMap", countMap);

        return "모르겠음..... 얘는 어디로 보내야 할까요...?";
    }
}
