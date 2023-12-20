package model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.dto.MenuDTO;
import model.dto.StoreDTO;
import model.dto.ReviewDTO;

public class store_reviewDAO {
    private JDBCUtil jdbcUtil = null;
    
    public store_reviewDAO() {       // 기본 생성자
        jdbcUtil = new JDBCUtil();
    }
    

    //**********
    //추천 매장 출력
    
	//if 예약했던 가게 존재할 시 최대 5개까지 넣기 + 나머지 recommand 매장으로 채우기
	// 추천매장 총 10개 반환 -> 필요시 숫자 조정할 것!
	// 추천매장은 좋아요 수 기준 상위 10개 뽑았는데 필요시 수정할 것
	//customer랑 reservation join해서 storeId 받아오기
	//reservation에 fk:(storeId, userId) 존재 -> reservation이랑 store만 join
	//List<store> 객체 반환
    public List<StoreDTO> selectionStore(String userId) {
        List<StoreDTO> recommandList = new ArrayList<>();
        try {
            // 1. 예약한 가게 정보 조회
            StringBuilder query1 = new StringBuilder();
            query1.append("SELECT S.* FROM RESERVATION R ");
            query1.append("INNER JOIN STORE S ON R.storeId = S.storeId ");
            query1.append("WHERE R.userId = ? ");
            query1.append("LIMIT 5 "); //최대 5개까지 추천 리스트에 포함

            jdbcUtil.setSqlAndParameters(query1.toString(), new Object[] {userId});
            ResultSet rs1 = jdbcUtil.executeQuery();

            while (rs1.next()) {
                StoreDTO recommand = new StoreDTO();
                recommand.setsName(rs1.getString("sName"));
                recommand.setsPhone(rs1.getString("sPhone"));
                recommand.setsTime(rs1.getString("sTime"));
                recommand.setsStarScore(rs1.getFloat("sStarScore"));
                recommand.setsDescription(rs1.getString("sDescription"));
                recommand.setSellerId(rs1.getString("sellerId"));
                recommand.setopenDays(rs1.getString("openDays"));
                recommand.setsImage_path(rs1.getString("sImage_path"));

                recommandList.add(recommand);
            }

            // 2. 나머지 추천 매장 조회
            StringBuilder query2 = new StringBuilder();
            query2.append("SELECT * FROM STORE ");
            query2.append("ORDER BY likeCount DESC LIMIT ? ");

            int remainingCount = 10 - recommandList.size(); // 나머지 매장을 채우기 위해 필요한 개수 계산
            jdbcUtil.setSqlAndParameters(query2.toString(), new Object[] {remainingCount});
            ResultSet rs2 = jdbcUtil.executeQuery();

            while (rs2.next()) {
                StoreDTO recommand = new StoreDTO();
                recommand.setsName(rs2.getString("sName"));
                recommand.setsPhone(rs2.getString("sPhone"));
                recommand.setsTime(rs2.getString("sTime"));
                recommand.setsStarScore(rs2.getFloat("sStarScore"));
                recommand.setsDescription(rs2.getString("sDescription"));
                recommand.setSellerId(rs2.getString("sellerId"));
                recommand.setopenDays(rs2.getString("openDays"));
                recommand.setsImage_path(rs2.getString("sImage_path"));


                recommandList.add(recommand);
            }
            return recommandList;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return null;
    }
    //**********
    
    
	public int addMenuItem(MenuDTO menu) throws SQLException {
		String sql = "INSERT INTO MenuItem (storeId, menuName, menuDescrip, mePrice) VALUES (?, ?, ?, ?)";      
		Object[] param = new Object[] {menu.getStoreId(), menu.getMenuName(), menu.getMenuDescrip(), menu.getMePrice()};             
		jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil 에 insert문과 매개 변수 설정

		try {               
			int result = jdbcUtil.executeUpdate();  // insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {     
			jdbcUtil.commit();
			jdbcUtil.close();   // resource 반환
		}       
		return 0;           
	}

     
    public int removeMenuItem(Integer menuId) throws SQLException {
        String sql = "DELETE FROM Menu WHERE menuId=?";      
        jdbcUtil.setSqlAndParameters(sql, new Object[] {menuId});   // JDBCUtil 에 insert문과 매개 변수 설정
                        
        try {               
            int result = jdbcUtil.executeUpdate();  // insert 문 실행
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }       
        return 0;           
    }
    
    public int updateMenuItem(MenuDTO menu) throws SQLException {
        String sql = "UPDATE Menu SET menuName=? menuDescript=? mePrice=? WHERE menuId=?";      
        Object[] param = new Object[] {menu.getMenuName(), menu.getMenuDescrip(), menu.getMePrice(), menu.getMenuId()};             
        jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil 에 insert문과 매개 변수 설정
                        
        try {               
            int result = jdbcUtil.executeUpdate();  // insert 문 실행
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }       
        return 0;           
    }
    
    public int addStore(StoreDTO storeDTO) {
        String sql = "INSERT INTO store(sellerId, storeId, sName, sPhone, sTime, openDays, sStarScore, sDetailDescription, likeCount, sImage) "
                    + "VALUES (?, store_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] param = new Object[] {
            storeDTO.getSellerId(), 
            storeDTO.getsName(), 
            storeDTO.getsPhone(), 
            storeDTO.getsTime(), 
            storeDTO.getopenDays(), 
            storeDTO.getsStarScore(), 
            storeDTO.getsDescription(), 
            storeDTO.getLikeCount(), 
            storeDTO.getsImage_path()
        };
        jdbcUtil.setSqlAndParameters(sql, param);

        try {
            int result = jdbcUtil.executeUpdate();
            jdbcUtil.commit();

            if (result == 1) { 
                String idQuery = "SELECT store_seq.currval FROM dual";
                jdbcUtil.setSqlAndParameters(idQuery, null);

                ResultSet rs = jdbcUtil.executeQuery();
                if (rs.next()) {
                    int storeId = rs.getInt(1);
                    storeDTO.setStoreId(storeId);
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
    } // seq 사용 가능하도록 수정


    public int updateStore(StoreDTO store, Integer categoryId) throws SQLException {
        String sql = "UPDATE store "
                    + "SET sName=?, sPhone=?, sTime=?, sStarScore=?, sDetailDescription=?, sellerId=?, openDays=?, category=?, sImage_path=? "
                    + "WHERE storeId=?";
        String category = searchCategory(categoryId);
        Object[] param = new Object[] {store.getsName(), store.getsPhone(), 
                    store.getsTime(), store.getsStarScore(), store.getsDescription(), 
                    store.getSellerId(), store.getopenDays(), category, store.getsImage_path(), store.getStoreId()};              
        jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil에 update문과 매개 변수 설정
            
        try {               
            int result = jdbcUtil.executeUpdate();  // update 문 실행
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }       
        return 0;
    }

    
    public int deleteStore(Integer storeId) throws SQLException {
        String sql = "DELETE FROM Store WHERE storeId=?";      
        jdbcUtil.setSqlAndParameters(sql, new Object[] {storeId});   // JDBCUtil 에 insert문과 매개 변수 설정
                        
        try {               
            int result = jdbcUtil.executeUpdate();  // insert 문 실행
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }       
        return 0;           
    }
    
    public void printStore(Integer storeId) {
        String sql = "SELECT sName, SPhone, STime, openDays, sStarScore, sDetailDescription, LikeCount, sImage "
                + "FROM Store WHERE storeId=?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {storeId});

        try {               
            ResultSet result = jdbcUtil.executeQuery();  
            if (result.next()) {  // ResultSet.next가 호출되도록 수정
                // 기타 코드들...
                String imagePath = result.getString("sImage_path");
                // imagePath를 사용하여 이미지를 출력하거나 사용자에게 제공.
            }
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }       
    }
    
    public String searchCategory(Integer cateId) {
        String sql = "SELECT caName FROM Category WHERE categoryId=?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {cateId});
        
        try {               
            ResultSet result = jdbcUtil.executeQuery();  
            if (result.next()) {        // 검색 결과 존재
                String category;
                category = result.getString("caName");
                
                return category;
            }
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }
        
        return null;       
    }
    
    public int deleteStore(String storeId) throws SQLException {
        String sql = "DELETE FROM store WHERE storeId=?";     
        jdbcUtil.setSqlAndParameters(sql, new Object[] {storeId});   // JDBCUtil에 delete문과 매개 변수 설정

        try {               
            int result = jdbcUtil.executeUpdate();  // delete 문 실행
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }       
        
        return 0;
    }
    
    
    //리뷰 
    public int writeReview(ReviewDTO review) {
        String sql = "INSERT INTO review(reviewId, userId, storeId, starScore, reContent) "
                    + "VALUES (review_seq.nextval, ?, ?, ?, ?)";
        Object[] param = new Object[] {
            review.getUserId(), 
            review.getStoreId(), 
            review.getStarScore(), 
            review.getReContent()
        };
        jdbcUtil.setSqlAndParameters(sql, param);

        try {
            int result = jdbcUtil.executeUpdate();
            jdbcUtil.commit();

            if (result == 1) { 
                String idQuery = "SELECT review_seq.currval FROM dual";
                jdbcUtil.setSqlAndParameters(idQuery, null);

                ResultSet rs = jdbcUtil.executeQuery();
                if (rs.next()) {
                    int reviewId = rs.getInt(1);
                    review.setReviewId(reviewId);
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
    
	public int deleteReview(String reviewId) throws SQLException {
        String sql = "DELETE FROM review WHERE reviewId=?";     
        jdbcUtil.setSqlAndParameters(sql, new Object[] {reviewId});   // JDBCUtil에 delete문과 매개 변수 설정

        try {               
            int result = jdbcUtil.executeUpdate();  // delete 문 실행
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }       
        
        return 0;
    }
	
    // 그럼 update로 가야하나...
    /*public int writeRating() {
            String sql = "INSERT INTO Review VALUES (?)";    
            Object[] param = new Object[] {//별점 선택};             
            jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil 에 insert문과 매개 변수 설정
            
         
            try {               
                int result = jdbcUtil.executeUpdate();  // delete 문 실행
                return result;
            } catch (Exception ex) {
                jdbcUtil.rollback();
                ex.printStackTrace();
            }
            finally {
                jdbcUtil.commit();
                jdbcUtil.close();   // resource 반환
            }       
            
            return 0;
    }*/
            
            
    public void readReview() {
        String sql = "SELECT userName, review, rating FROM REVIEW JOIN CUSTOMER USING (userId)  ";       // 작성자 정보도 같이? 그럼 join 해야하나 -> customer rating 2개 조인
        
        jdbcUtil.setSqlAndParameters(sql, null);
        
        try {               
            ResultSet result = jdbcUtil.executeQuery();  // update 문 실행
            String name = result.getString("userName");
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }
    }
    
    public int updateReview(ReviewDTO review) throws SQLException {
        String sql = "UPDATE Review "
                    + "SET reContent=? "
                    + "WHERE reviewId=?";
        Object[] param = new Object[] {review.getReContent(), review.getReviewId()};              
        jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil에 update문과 매개 변수 설정
            
        try {               
            int result = jdbcUtil.executeUpdate();  // update 문 실행
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }       
        return 0;
    } 
    
    public void printReview(String userId) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT reContent FROM Review JOIN Costomer USING (userId) ");
        query.append("WHERE userId = ? ");
        
        jdbcUtil.setSqlAndParameters(query.toString(), new Object[]{userId});
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            
            System.out.println("<나의 리뷰>");
            
            while (rs.next()) {
                System.out.println("리뷰 아이디: " + rs.getInt("reviewId"));
                System.out.println(rs.getString("reContent"));
                System.out.println();
            }
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
    }
    
    /*public int updateRating(Review review) throws SQLException {
        String sql = "UPDATE Review "
                    + "SET rating=? "
                    + "WHERE reviewId=?";
        Object[] param = new Object[] {review.getRating(), review.getReviewId()};              
        jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil에 update문과 매개 변수 설정
            
        try {               
            int result = jdbcUtil.executeUpdate();  // update 문 실행
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }       
        return 0;
    }*/
    
 // ===== 카테고리명을 통한 검색 =====
//    public List<StoreDTO> searchStoreByCategory(String categoryName) {
//        StringBuilder sqlSelect = new StringBuilder();
//        sqlSelect.append("SELECT s.storeId, s.sName, s.sStarScore, s.sDetailDescription, s.sAddress, s.LikeCount ")
//                 .append("FROM Store s ")
//                 .append("JOIN StoreCategory sc ON s.storeId = sc.storeId ")
//                 .append("JOIN Category c ON sc.categoryId = c.categoryId ")
//                 .append("WHERE c.caName = ?");
//
//        jdbcUtil.setSqlAndParameters(sqlSelect.toString(), new Object[] {categoryName});
//
//        try {
//            List<StoreDTO> storeList = new ArrayList<>();
//            ResultSet rs = jdbcUtil.executeQuery();
//
//            while (rs.next()) {
//                StoreDTO store = new StoreDTO();
//                store.setStoreId(rs.getInt("storeId"));
//                store.setsName(rs.getString("sName"));
//                store.setsStarScore(rs.getFloat("sStarScore"));
//                store.setsDescription(rs.getString("sDetailDescription"));
//                store.setLikeCount(rs.getInt("LikeCount")); 
//
//                storeList.add(store);
//            }
//
//            return storeList;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            jdbcUtil.close();
//        }
//
//        return null;
//    }



    // ===== 가게명을 통한 검색 =====
    public List<StoreDTO> searchStore(String storeName) {
        StringBuilder sqlSelect = new StringBuilder();
        sqlSelect.append("SELECT storeId, sName, sStarScore, sDetailDescription, sAddress, LikeCount ")
                 .append("FROM Store ")
                 .append("WHERE sName LIKE ?");

        jdbcUtil.setSqlAndParameters(sqlSelect.toString(), new Object[] {"%" + storeName + "%"});

        try {
            List<StoreDTO> storeList = new ArrayList<>();
            ResultSet rs = jdbcUtil.executeQuery();

            while (rs.next()) {
                StoreDTO store = new StoreDTO();
                store.setStoreId(rs.getInt("storeId"));
                store.setsName(rs.getString("sName"));
                store.setsStarScore(rs.getFloat("sStarScore"));
                store.setsDescription(rs.getString("sDetailDescription"));
                store.setLikeCount(rs.getInt("LikeCount")); 

                storeList.add(store);
            }

            return storeList;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return null;
    }
    
}
