package model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dto.CustomerDTO;
import model.dto.PetDTO;
import model.dto.ReservationDTO;
import model.dto.SellerDTO;
import model.dto.StoreDTO;

public class CustomerDAO {

    private JDBCUtil jdbcUtil = null;

    public CustomerDAO() {
        jdbcUtil = new JDBCUtil();
    }

    public List<StoreDTO> getLikeListByUserId(String userID) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT like FROM CUSTOMER WHERE userId = ? ");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { userID });

        List<StoreDTO> likeList = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            while (rs.next()) {
                StoreDTO like = new StoreDTO();
                like.setsName(rs.getString("sName"));
                like.setSellerId(rs.getString("sellerId"));

                likeList.add(like);
            }
            return likeList;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return null;
    }

    public int updateReservationByUserId(String userId, Date newDate) {
        StringBuilder query = new StringBuilder();
        query.append("UPDATE Reservation SET resDaTi = ? WHERE userId = ? ");

        Object[] parameters = new Object[] { newDate, userId };

        jdbcUtil.setSqlAndParameters(query.toString(), parameters);

        try {
            int result = jdbcUtil.executeUpdate();
            jdbcUtil.commit();
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return 0;
    }

    public List<ReservationDTO> findReservationsByUserId(String userId) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM Reservation WHERE userId = ? ");

        Object[] parameters = new Object[] { userId };
        jdbcUtil.setSqlAndParameters(query.toString(), parameters);

        List<ReservationDTO> reservationList = new ArrayList<>();

        try {
            ResultSet rs = jdbcUtil.executeQuery();
            while (rs.next()) {
                ReservationDTO reservation = new ReservationDTO();
                reservation.setReservationId(rs.getInt("reservationId"));
                reservation.setResDaTi(rs.getTimestamp("resDaTi"));
                reservation.setUserId(rs.getString("userId"));
                reservation.setStoreId(rs.getInt("storeId"));

                reservationList.add(reservation);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return reservationList;
    }
    
    //reservationId로 예약 찾기
    public ReservationDTO getReservation(int reservationId) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM Reservation ");
        query.append("WHERE reservationId = ? ");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { reservationId });

        try {
            ResultSet rs = jdbcUtil.executeQuery();  
            ReservationDTO res = new ReservationDTO(
                    rs.getInt("reservationId"),
                    rs.getTimestamp("resDaTi"),
                    rs.getString("userId"),
                    rs.getString("uName"),
                    rs.getInt("storeId"),
                    rs.getString("sName"),
                    rs.getString("comment")
                    );
            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return null;
    }

    public Map<String, Integer> countReservationsByUser() {
        String sql = "SELECT userId, COUNT(*) FROM Reservation GROUP BY userId ";
        Map<String, Integer> countMap = new HashMap<>();

        jdbcUtil.setSqlAndParameters(sql, null);

        try {
            ResultSet rs = jdbcUtil.executeQuery();
            while (rs.next()) {
                String userId = rs.getString("userId");
                int count = rs.getInt(2);
                countMap.put(userId, count);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return countMap;
    }

    public CustomerDTO getCustomer(String userId) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM CUSTOMER ");
        query.append("WHERE userid = ? ");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { userId });

        try {
            ResultSet resultSet = jdbcUtil.executeQuery();
            if (resultSet.next()) {
                String uName = resultSet.getString("uName");
                String uPhone = resultSet.getString("uPhone");
                String uMail = resultSet.getString("uMail");
                String uPassword = resultSet.getString("uPassword");
                List<PetDTO> petList = getAllPets(userId);
                List<StoreDTO> likeList = getLikeListByUserId(userId);
                return new CustomerDTO(userId, uName, uPassword, uPhone, uMail, petList, likeList);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return null;
    }

    public void addCustomer(CustomerDTO customer) {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO CUSTOMER (userId, uName, uPassword, uPhone, uMail) VALUES (?, ?, ?, ?, ?)");

        jdbcUtil.setSqlAndParameters(query.toString(),
                new Object[] { customer.getUserId(), customer.getuName(), customer.getuPassword(),
                        customer.getuPhone(), customer.getuMail() });

        try {
            jdbcUtil.executeUpdate();
            jdbcUtil.commit();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
    }

    public void updateCustomer(CustomerDTO customer) {
        StringBuilder query = new StringBuilder();
        query.append("UPDATE CUSTOMER SET uName=?, uPassword=?, uPhone=?, uMail=? WHERE userId=? ");

        jdbcUtil.setSqlAndParameters(query.toString(),
                new Object[] { customer.getuName(), customer.getuPassword(), customer.getuPhone(),
                        customer.getuMail(), customer.getUserId() });

        try {
            jdbcUtil.executeUpdate();
            jdbcUtil.commit();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
    }

    public void deleteCustomer(String userId) {
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM CUSTOMER WHERE userId=? ");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { userId });

        try {
            jdbcUtil.executeUpdate();
            jdbcUtil.commit();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
    }

    public List<PetDTO> getAllPets(String userId) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM Pet WHERE userId = ? ");
        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { userId });

        List<PetDTO> petList = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            while (rs.next()) {
                PetDTO pet = new PetDTO(rs.getInt("petId"), rs.getString("pImage"), rs.getString("pName"),
                        rs.getInt("pAge"), rs.getString("pCategory"), rs.getString("pDetailCa"),
                        rs.getInt("pNeureting"), // 'Y'는 true, 'N'는 false로 변환
                        userId);

                petList.add(pet);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return petList;
    }

    public int addPet(PetDTO pet) {
        StringBuilder query = new StringBuilder();
        query.append(
                "INSERT INTO PET (petId, pName, pAge, pCategory, pDetailCategory, userId, pNeureting, pImage) VALUES (pet_seq.nextval, ?, ?, ?, ?, ?, ?, ?)");

        jdbcUtil.setSqlAndParameters(query.toString(),
                new Object[] {pet.getpName(), pet.getpAge(), pet.getpCategory(), pet.getpDetailCa(), pet.getUserId(), pet.getpNeureting(), pet.getpImage()});

        try {
            int result = jdbcUtil.executeUpdate();
            jdbcUtil.commit();

            if (result == 1) { 
                String idQuery = "SELECT pet_seq.currval FROM dual";
                jdbcUtil.setSqlAndParameters(idQuery, null);

                ResultSet rs = jdbcUtil.executeQuery();
                if (rs.next()) {
                    int petId = rs.getInt(1);
                    pet.setPetId(petId);
                }
                rs.close();
            }

            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return 0;
    }

    public void updatePet(PetDTO pet) {
        StringBuilder query = new StringBuilder();
        query.append("UPDATE PET SET pImage=?, pName=?, pAge=?, pCategory=?, pDetailCa=?, pNeureting=? WHERE petId=? ");

        jdbcUtil.setSqlAndParameters(query.toString(),
        	    new Object[] {pet.getpName(), pet.getpAge(), pet.getpCategory(), pet.getpDetailCa(), pet.getpNeureting(), pet.getUserId(), pet.getpImage()});


        try {
            jdbcUtil.executeUpdate();
            jdbcUtil.commit();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
    }

    public void deletePet(int petId) {
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM PET WHERE petId=? ");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { petId });

        try {
            jdbcUtil.executeUpdate();
            jdbcUtil.commit();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
    }
    
    //petId로 찾기
    public PetDTO getPet(int petId) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM Pet ");
        query.append("WHERE petId = ? ");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { petId });

        try {
            ResultSet rs = jdbcUtil.executeQuery();  
            PetDTO pet = new PetDTO(
                    rs.getInt("petId"),
                    rs.getString("pImage"),
                    rs.getString("pName"),
                    rs.getInt("pAge"),
                    rs.getString("pCategory"),
                    rs.getString("pDetailCa"),
                    rs.getInt("pNeureting"), 
                    rs.getString("userId")
                    );
            return pet;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return null;
    }

    
  //이미 있는 유저 등록
    public boolean existingCustomer(String userId) throws SQLException {
        String sql = "SELECT count(*) FROM Customer WHERE userId=? ";      
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});   // JDBCUtil에 query문과 매개 변수 설정

        try {
            ResultSet rs = jdbcUtil.executeQuery();     // query 실행
            if (rs.next()) {
                int count = rs.getInt(1);
                return (count == 1 ? true : false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       // resource 반환
        }
        return false;
    }
    
  //이미 있는 반려동물 등록
    public boolean existingPet(int petId) throws SQLException {
        String sql = "SELECT count(*) FROM Pet WHERE petId=? ";      
        jdbcUtil.setSqlAndParameters(sql, new Object[] {petId});   // JDBCUtil에 query문과 매개 변수 설정

        try {
            ResultSet rs = jdbcUtil.executeQuery();     // query 실행
            if (rs.next()) {
                int count = rs.getInt(1);
                return (count == 1 ? true : false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       // resource 반환
        }
        return false;
    }
}
