package model.dao;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
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
        String testUserId = "user1"; // 테스트할 사용자 ID 설정
        CustomerDTO customer = compDao.getCustomer(testUserId); // getCustomer 메소드 호출

        if (customer != null) {
            System.out.println("사용자 ID: " + customer.getUserId());
            System.out.println("이름: " + customer.getuName());
            System.out.println("전화번호: " + customer.getuPhone());
            System.out.println("이메일: " + customer.getuMail());
            System.out.println("비밀번호: " + customer.getuPassword());
        } else {
            System.out.println("해당 사용자를 찾을 수 없습니다.");
        }


	 // 애완동물 추가
	    System.out.println("애완동물을 추가합니다.");

	    String pImage = "애완동물 이미지 경로"; // 애완동물 이미지 경로
	    String pName = "멍멍이"; // 애완동물 이름
	    int pAge = 2016; // 애완동물 나이
	    String pCategory = "강아지"; // 애완동물 종류
	    String pDetailCa = "푸들"; // 애완동물 세부 종류
	    int pNeureting = 0; // 중성화 여부
	    String userId = "user1"; // 사용자 ID

	    PetDTO pet = new PetDTO(pImage, pName, pAge, pCategory, pDetailCa, pNeureting, userId);
	    compDao.addPet(pet);
	    System.out.println("새 애완동물의 petId는 " + pet.getPetId() + "입니다.");


	}

}

