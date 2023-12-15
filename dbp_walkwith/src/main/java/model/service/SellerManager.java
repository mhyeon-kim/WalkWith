package model.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import model.dao.SellerDAO;
import model.dto.ReservationDTO;
import model.dto.SellerDTO;
import model.dto.StoreDTO;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * SellerDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */

public class SellerManager {
    private static SellerManager selMan = new SellerManager();
    private SellerDAO selDAO;
    //DAO 필요한 거 import
    //Analysis import 필요?
    
    private SellerManager() {
        try {
            selDAO = new SellerDAO();
            
        } catch (Exception e) {
            e.printStackTrace();
        }           
    }
    
    public static SellerManager getInstance() {
        return selMan;
    }
    
    //seller 추가
    public int create(SellerDTO sel) throws SQLException, ExistingUserException {
        if (selDAO.existingSeller(sel.getSellerId()) == true) {
            throw new ExistingUserException(sel.getSellerId() + "는 존재하지 않는 아이디입니다.");
        }
        return selDAO.createSeller(sel);
    }
    
    //seller update
    public SellerDTO update(SellerDTO sel) throws SQLException, UserNotFoundException {
        return selDAO.updateSeller(sel);
    }   

    //seller delete
    public SellerDTO remove(String selId) throws SQLException, UserNotFoundException {
//        int commId = findSeller(selId)
        
        return selDAO.deleteSeller(selId);
    }
    
    public SellerDTO findSeller(String selId)
            throws SQLException, UserNotFoundException {
            SellerDTO sel = selDAO.findSeller(selId);
            
            if (sel == null) {
                throw new UserNotFoundException(selId + "는 존재하지 않는 아이디입니다.");
            }       
            return sel;
    }
    
    public List<SellerDTO> findSellerList() throws SQLException {
        return selDAO.getAllSellerInfo();
    }
    
    public List<StoreDTO> findMyStore(String selId) throws SQLException {
        return selDAO.findMyStore(selId);
    }
    
    public List<ReservationDTO> findReservationByStore(int storeId) throws SQLException {
        return selDAO.findReservationsByStore(storeId);
    }
    
//    public int countReservation(int sel)
    
    public List<ReservationDTO> findReservationByDate(Date date) throws SQLException {
        return selDAO.findReservationsByDate(date);
    }
    
    public int countReservationByDate(Date date) throws SQLException {
        return selDAO.countReservationsByDate(date);
    }
    
    public boolean login(String selId, String password)
            throws SQLException, UserNotFoundException, PasswordMismatchException {
            SellerDTO sel = findSeller(selId);

            if (!sel.matchPassword(password)) {
                throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
            }
            return true;
    }
}