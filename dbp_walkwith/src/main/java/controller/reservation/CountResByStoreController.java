package controller.reservation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ReservationManager;

public class CountResByStoreController implements Controller {
    private ReservationManager reservationManager;

    public CountResByStoreController() {
        reservationManager = ReservationManager.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<Integer, Integer> countMap = reservationManager.countReservationsByStore();

        request.setAttribute("countMap", countMap);

        return "얘는 어디로 가야 할까요...?";
    }
}