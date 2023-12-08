package controller.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.dto.ReservationDTO;

public class ReservationController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ReservationController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReservationDTO res = new ReservationDTO();
	
		return null;
	}

}
