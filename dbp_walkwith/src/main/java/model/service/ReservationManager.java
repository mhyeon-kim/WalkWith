package model.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import model.dto.*;
import model.dao.*;

public class ReservationManager {
    private static ReservationManager reservation = new ReservationManager();
    private ReservationDAO reservationDAO;
    private store_reviewDAO storeDAO;
    private CustomerDAO customerDAO;

    private ReservationManager() {
        try {
            reservationDAO = new ReservationDAO();
            storeDAO = new store_reviewDAO();
            customerDAO = new CustomerDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }           
    }

    public static ReservationManager getInstance() {
        return reservation;
    }

    // 예약 추가
    public int addReservation(ReservationDTO reservation) throws SQLException {
        return reservationDAO.addReservation(reservation);
    }

    // 예약 취소
    public int deleteReservation(int reservationId) throws SQLException {
        return reservationDAO.deleteReservation(reservationId);
    }

    // 예약 수정
    public int updateReservation(int reservationId, LocalDate newDate, String comment) throws SQLException {
        return reservationDAO.updateReservation(reservationId, newDate, comment);
    }
    
    public List<ReservationDTO> findReservationsByUser(String userId) throws SQLException {
        return reservationDAO.findReservationsByUser(userId);
    }

    // 가게 ID로 예약 찾기
    public List<ReservationDTO> findReservationsByStore(int storeId) throws SQLException {
        return reservationDAO.findReservationsByStore(storeId);
    }
    
    // 사용자별 예약 수 확인
    public Map<String, Integer> countReservationsByUser() throws SQLException {
        return reservationDAO.countReservationsByUser();
    }

    // 가게별 예약 수 확인
    public Map<Integer, Integer> countReservationsByStore() throws SQLException {
        return reservationDAO.countReservationsByStore();
    }
    
    // 해당 날짜에 누가 예약했는지 확인
    public List<ReservationDTO> findReservationsByDate(LocalDate date) throws SQLException {
        return reservationDAO.findReservationsByDate(date);
    }

    // 해당 날짜에 몇 명이 예약했는지 확인
    public int countReservationsByDate(LocalDate date) throws SQLException {
        return reservationDAO.countReservationsByDate(date);
    }
    
    // 전체 예약 보기
    public List<ReservationDTO> viewAllReservations()  throws SQLException{
        return reservationDAO.viewAllReservations();
    }
}