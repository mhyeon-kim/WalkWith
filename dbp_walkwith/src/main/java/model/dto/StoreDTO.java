package model.dto;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

public class StoreDTO {
	private String sellerId;
	private int storeId;
	private String sName;
	private String sPhone;
	private String sTime;
	private String openDays; // 영업 요일 저장 ex)월,화, 수, 목... 이런 형식 
	private double sStarScore;
	private String sDescription;
	private int likeCount;  // 좋아요 수 필드 추가
	private String sImage_path; // 가게 이미지 추가
	
    // 기본 생성자 추가
    public StoreDTO() {
    }
		
	public StoreDTO(String sellerId, int storeId, String sName, String sPhone, String sTime, String openDays, double sStarScore,
			String sDescription, int likeCount, String sImage_path) {
		super();
		this.sellerId = sellerId;
		this.storeId = storeId;
		this.sName = sName;
		this.sPhone = sPhone;
		this.sTime = sTime;
		this.openDays = openDays;
		this.sStarScore = sStarScore;
		this.sDescription = sDescription;
		this.likeCount = likeCount;  // 좋아요 수 초기화
		this.sImage_path = sImage_path;
	}
	
	public StoreDTO(String sellerId, String sName, String sPhone, String sTime, String openDays, double sStarScore,
			String sDescription, int likeCount, String sImage_path) {
		super();
		this.sellerId = sellerId;
		this.sName = sName;
		this.sPhone = sPhone;
		this.sTime = sTime;
		this.openDays = openDays;
		this.sStarScore = sStarScore;
		this.sDescription = sDescription;
		this.likeCount = likeCount;  // 좋아요 수 초기화
		this.sImage_path = sImage_path;
	}

	

    public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsPhone() {
		return sPhone;
	}
	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}
	public String getsTime() {
		return sTime;
	}
	public void setsTime(String date) {
		this.sTime = date;
;
	}
	public String getopenDays() {
		return openDays;
	}
	public void setopenDays(String openDays) {
		this.openDays = openDays;
	}
	public double getsStarScore() {
		return sStarScore;
	}
	public void setsStarScore(double sStarScore) {
		this.sStarScore = sStarScore;
	}
	public String getsDescription() {
		return sDescription;
	}
	public void setsDescription(String sDescription) {
		this.sDescription = sDescription;
	}

	// 좋아요 수 getter, setter 추가
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int LikeCount) {
		this.likeCount = likeCount;
	}
	
	// 가게 이미지 추가
	public String getsImage_path() {
		return sImage_path;
	}

	public void setsImage_path(String sImage_path) {
		this.sImage_path = sImage_path;
	}

	@Override
	public String toString() {
		return "Store [sellerId=" + sellerId + ", storeId=" + storeId + ", sName=" + sName + ", sPhone=" + sPhone
				+ ", sTime=" + sTime + ", openDays=" + openDays + ", sStarScore=" + sStarScore + ", sDescription="
				+ sDescription + ", likeCount=" + likeCount + "]";
	}
	
	
	
}