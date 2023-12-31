package model.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import model.dao.CustomerDAO;
import model.dao.store_reviewDAO;
import model.dto.CustomerDTO;
import model.dto.PetDTO;
import model.dto.ReservationDTO;
import model.dto.SellerDTO;
import model.dto.StoreDTO;

public class CustomerManager {
    private static CustomerManager cusMan = new CustomerManager();
    private CustomerDAO cusDAO;
    private store_reviewDAO storeDAO;
    
    private CustomerManager() {
        try {
            cusDAO = new CustomerDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static CustomerManager getInstance() {
        return cusMan;
    }
    
  //customer 추가
    public void create(CustomerDTO cus) throws SQLException, ExistingUserException {
        if (cusDAO.existingCustomer(cus.getUserId()) == true) {
            throw new ExistingUserException(cus.getUserId() + "는 존재하지 않는 아이디입니다.");
        }
        cusDAO.addCustomer(cus);
    }
    
    //customer update
    public void update(CustomerDTO cus) throws SQLException, UserNotFoundException {
        cusDAO.updateCustomer(cus);
    }   

    //customer delete
    public void remove(String userId) throws SQLException, UserNotFoundException {        
        cusDAO.deleteCustomer(userId);
    }
    
    //customer 정보
    public CustomerDTO getCustomer(String userId) throws SQLException, UserNotFoundException {
        return cusDAO.getCustomer(userId);
    }
    
    //내 예약 찾기
    public List<ReservationDTO> myReservation(String userId) throws SQLException, UserNotFoundException {
        return cusDAO.findReservationsByUserId(userId);
    }
    
    //내 예약 수정
    public int updateReservation(String userId, Date date) throws SQLException, UserNotFoundException {
        return cusDAO.updateReservationByUserId(userId, date);
    }
    
    //예약Id로 찾기
    public ReservationDTO getReservation(int reservationId) throws SQLException, ReservationNotFoundException {
        return cusDAO.getReservation(reservationId);
    }
    
    //내가 좋아요 한 가게
    public List<StoreDTO> myLike(String userId) throws SQLException, UserNotFoundException {
        return cusDAO.getLikeListByUserId(userId);
    }
    
    //petId로 찾기
    public PetDTO getPet(int petId) throws SQLException, PetNotFoundException {
        return cusDAO.getPet(petId);
    }
    
    //pet 추가
    public void createPet(PetDTO pet) throws SQLException, ExistingPetException {
        if (cusDAO.existingPet(pet.getPetId()) == true) {
            throw new ExistingPetException(pet.getpName() + "는 존재하지 않습니다.");
        }
        cusDAO.addPet(pet);
    }
    
    //pet update
    public void updatePet(PetDTO pet) throws SQLException, PetNotFoundException {
        cusDAO.updatePet(pet);
    }
    
    //pet delete
    public void removePet(int petId) throws SQLException, PetNotFoundException {
        cusDAO.deletePet(petId);
    }
    
    //petList 출력
    public List<PetDTO> petList(String userId) throws SQLException {
        return cusDAO.getAllPets(userId);
    }
    
    //추천매장 출력
    public List<StoreDTO> mySelectionStore(String userId) throws SQLException {
        return storeDAO.selectionStore(userId);
    }
    
    public boolean login(String userId, String password)
            throws SQLException, UserNotFoundException, PasswordMismatchException {
            CustomerDTO cus = getCustomer(userId);

            if (!cus.matchPassword(password)) {
                throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
            }
            return true;
    }
}