package model.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dto.PetDTO;
import model.dto.CustomerDTO;
import model.dto.ReservationDTO;
import model.dto.SellerDTO;
import model.dto.StoreDTO;

public class DAO_Test {
	
	private static CustomerDAO compDao = new CustomerDAO();
	private static SellerDAO sellDao = new SellerDAO();
	private static store_reviewDAO stoDao = new store_reviewDAO();
	
	public static void main(String[] args) throws SQLException {
	    Scanner scanner = new Scanner(System.in);

	 // 판매자 정보 생성
	    System.out.println("판매자 정보를 생성합니다.");

	    String sellerId = "seller001"; // 판매자 ID
	    String seName = "홍길동"; // 판매자 이름
	    String sePassword = "password123"; // 판매자 비밀번호
	    String sePhone = "010-1234-5678"; // 판매자 전화번호
	    String seMail = "seller001@example.com"; // 판매자 이메일

	    SellerDTO seller = new SellerDTO(sellerId, seName, sePassword, sePhone, seMail);
	    try {
	        sellDao.createSeller(seller);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    System.out.println("판매자 정보가 생성되었습니다.");

	 // 상점 추가
	    System.out.println("상점을 추가합니다.");

	    String sellerId2 = "seller001"; // 판매자 ID
	    int storeId = 1; // 상점 ID
	    String sName = "상점이름"; // 상점 이름
	    String sPhone = "010-1234-5678"; // 상점 전화번호

	    // java.util.Date를 java.sql.Date로 변환
	    java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sTime = new java.sql.Date(utilDate.getTime()); // 상점 운영 시간

	    String openDate = "2021-09-01"; // 상점 개장 날짜
	    double sStarScore = 4.5; // 상점 평점
	    String sDescription = "상점 설명"; // 상점 설명
	    int likeCount = 0; // 좋아요 수
	    String sImage_path = "상점 이미지 경로"; // 상점 이미지 경로
	    Integer categoryId = 1; // 카테고리 ID

	    StoreDTO store = new StoreDTO(sellerId2, storeId, sName, sPhone, sTime, openDate, sStarScore, sDescription, likeCount, sImage_path);
	    try {
	        stoDao.addStore(store, categoryId);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    System.out.println("상점이 추가되었습니다.");


	 // 고객 추가
	    System.out.println("고객을 추가합니다.");

	    String userId = "user001"; // 사용자 ID
	    String uName = "홍길동"; // 사용자 이름
	    String uPassword = "password123"; // 사용자 비밀번호
	    String uPhone = "010-1234-5678"; // 사용자 전화번호
	    String uMail = "user001@example.com"; // 사용자 이메일

	    CustomerDTO customer = new CustomerDTO(userId, uName, uPassword, uPhone, uMail, null, null);
	    compDao.addCustomer(customer);
   
	    System.out.println("고객 정보가 추가되었습니다.");


	 // 애완동물 추가
	    System.out.println("애완동물을 추가합니다.");

	    int petId = 1; // 애완동물 ID
	    String pImage = "애완동물 이미지 경로"; // 애완동물 이미지 경로
	    String pName = "멍멍이"; // 애완동물 이름
	    int pAge = 3; // 애완동물 나이
	    String pCategory = "강아지"; // 애완동물 종류
	    String pDetailCa = "푸들"; // 애완동물 세부 종류
	    String pNeureting = "중성화"; // 중성화 여부
	    String userId2 = "user001"; // 사용자 ID

	    PetDTO pet = new PetDTO(petId, pImage, pName, pAge, pCategory, pDetailCa, pNeureting, userId2);
	    compDao.addPet(pet);
	    System.out.println("애완동물 정보가 추가되었습니다.");

	}

}

