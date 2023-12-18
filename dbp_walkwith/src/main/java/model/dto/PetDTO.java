package model.dto;

public class PetDTO {
    private int petId;
    private String pImage;
    private String pName;
    private int pAge;
    private String pCategory;
    private String pDetailCa;
    private int pNeureting; 
    private String userId;
    

    // petId를 포함한 생성자
    public PetDTO(int petId, String pImage, String pName, int pAge, String pCategory, String pDetailCa, int pNeureting, String userId) {
        this.petId = petId;
        this.pImage = pImage;
        this.pName = pName;
        this.pAge = pAge;
        this.pCategory = pCategory;
        this.pDetailCa = pDetailCa;
        this.pNeureting = pNeureting;
        this.userId = userId;
    }

    // petId를 제외한 생성자
    public PetDTO(String pImage, String pName, int pAge, String pCategory, String pDetailCa, int pNeureting, String userId) {
        this.pImage = pImage;
        this.pName = pName;
        this.pAge = pAge;
        this.pCategory = pCategory;
        this.pDetailCa = pDetailCa;
        this.pNeureting = pNeureting;
        this.userId = userId;
    }

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage_path(String pImage) {
        this.pImage = pImage;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpAge() {
        return pAge;
    }

    public void setpAge(int pAge) {
        this.pAge = pAge;
    }

    public String getpCategory() {
        return pCategory;
    }

    public void setpCategory(String pCategory) {
        this.pCategory = pCategory;
    }

    public String getpDetailCa() {
        return pDetailCa;
    }

    public void setpDetailCa(String pDetailCa) {
        this.pDetailCa = pDetailCa;
    }

    public int getpNeureting() {
        return pNeureting;
    }

    public void setpNeureting(int pNeureting) {
        this.pNeureting = pNeureting;
    }
}
