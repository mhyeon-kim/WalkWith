package model.dao;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import model.dto.PetDTO;
import model.dto.ReservationDTO;
import model.dto.ReviewDTO;
import model.dto.SellerDTO;
import model.dto.StoreDTO;

public class DAO_Test {
	
	public static void main(String[] args) throws SQLException {
        ReservationDAO dao = new ReservationDAO();

        Timestamp resDaTi = null;
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2024-01-01 12:00:00");
            resDaTi = new Timestamp(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return;  // 예외 발생 시 메인 메서드 종료
        }
        String userId = "user2"; // 사용자 ID
        int storeId = 2; // 가게 ID
        String comment = "처음 방문하는 가게, 기대됩니다."; // 코멘트

        ReservationDTO reservation = new ReservationDTO(resDaTi, userId, storeId, comment);

        // 예약 추가
		int result = dao.addReservation(reservation);
		if (result == 1) {
		    System.out.println("예약이 성공적으로 추가되었습니다.");
		} else {
		    System.out.println("예약 추가에 실패하였습니다.");
		}

		// 예약 삭제 테스트
		result = dao.deleteReservation(reservation.getReservationId());
		if (result == 1) {
		    System.out.println("예약이 성공적으로 삭제되었습니다.");
		} else {
		    System.out.println("예약 삭제에 실패하였습니다.");
		}
	    
	}
}



	

