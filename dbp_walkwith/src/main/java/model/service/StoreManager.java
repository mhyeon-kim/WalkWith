package model.service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import model.dao.CustomerDAO;
import model.dao.store_reviewDAO;
import model.dto.CustomerDTO;
import model.dto.PetDTO;
import model.dto.ReservationDTO;
import model.dto.StoreDTO;

public class StoreManager {
	private static StoreManager stoMan = new StoreManager();

	private store_reviewDAO storeDAO;

	private StoreManager() {
	    try {
	        storeDAO = new store_reviewDAO();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
    
    public static StoreManager getInstance() {
        return stoMan;
    }
    
    // Store 추가
    public int addReservation(StoreDTO store) throws SQLException {
        return storeDAO.addStore(store);
    }

    // store 삭제
    public int deleteStore(int StoreId) throws SQLException {
        return storeDAO.deleteStore(StoreId);
    }

    // store 수정
    public int updateStore(StoreDTO store, Integer categoryId) throws SQLException {
        return storeDAO.updateStore(store, categoryId);
    }
    
//    public StoreDTO printStore(Integer storeId) {
//        // storeDAO.printStore 메소드를 호출하여 결과를 가져옴
//        StoreDTO store = storeDAO.printStore(storeId);
//        // 결과를 출력하거나 사용자에게 제공
//        // 예: System.out.println(store.getsName());
//        return store;
//    }
    
}
