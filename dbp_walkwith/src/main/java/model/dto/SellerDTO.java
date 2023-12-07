package model.dto;

public class SellerDTO {
	private String sellerId;
	private String seName;
	private String sePassword;
	private String sePhone;
	private String seMail;
	
	public SellerDTO(String sellerId, String seName, String sePassword, String sePhone, String seMail) {
		super();
		this.sellerId = sellerId;
		this.seName = seName;
		this.sePassword = sePassword;
		this.sePhone = sePhone;
		this.seMail = seMail;
	}
	
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getSeName() {
		return seName;
	}
	public void setSeName(String seName) {
		this.seName = seName;
	}
	public String getSePassword() {
		return sePassword;
	}
	public void setSePassword(String sePassword) {
		this.sePassword = sePassword;
	}
	public String getSePhone() {
		return sePhone;
	}
	public void setSePhone(String sePhone) {
		this.sePhone = sePhone;
	}
	public String getSeMail() {
		return seMail;
	}
	public void setSeMail(String seMail) {
		this.seMail = seMail;
	}
	
	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", seName=" + seName + ", sePassword=" + sePassword + ", sePhone="
				+ sePhone + ", seMail=" + seMail + "]";
	}
	
	
}
