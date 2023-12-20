package model.dao;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import model.dto.PetDTO;
import model.dto.SellerDTO;
import model.dto.StoreDTO;

public class DAO_Test {
	
	public static void main(String[] args) {
	    // store_reviewDAO 인스턴스 생성
		store_reviewDAO dao = new store_reviewDAO();

		StoreDTO store = new StoreDTO(
		    "seller2",
		    "Test Store2",
		    "010-1234-5679",
		    "10:00-22:00",
		    "월,화",
		    4.5,
		    "This is a test store.",
		    0,
		    "testImage2.jpg"
		);

		try {
		    // 스토어 추가
		    Integer storeId = dao.addStore(store); // addStore가 새로 추가된 스토어의 ID를 반환한다고 가정

		    // 추가된 스토어 정보 출력
		    dao.printStore(storeId);

		    // 스토어 추가 성공 메시지 출력
		    System.out.println("새 스토어의 ID는 " + storeId + "입니다.");

		} catch (SQLException e) {
		    // 스토어 추가 실패 메시지 출력
		    System.out.println("스토어 추가에 실패했습니다: " + e.getMessage());

		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} // SQLException을 throw하지 않는다고 가정


	    
	}
}


	

