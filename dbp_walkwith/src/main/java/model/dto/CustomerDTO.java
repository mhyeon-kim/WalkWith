package model.dto;

import java.util.List;

public class CustomerDTO {
    
    private String userId;
    private String uName;
    private String uPassword;
    private String uPhone;
    private String uMail;
    private List<PetDTO> petList;
    private List<StoreDTO> likeList;

    public CustomerDTO(String userId, String uName, String uPassword, String uPhone, String uMail, List<PetDTO> petList, List<StoreDTO> likeList) {
        super();
        this.userId = userId;
        this.uName = uName;
        this.uPassword = uPassword;
        this.uPhone = uPhone;
        this.uMail = uMail;
        this.petList = petList;
        this.likeList = likeList;
    }

    public List<StoreDTO> getLikeList() {
        return likeList;
    }

    public void setLikeList(List<StoreDTO> likeList) {
        this.likeList = likeList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuMail() {
        return uMail;
    }

    public void setuMail(String uMail) {
        this.uMail = uMail;
    }

    public List<PetDTO> getPetList() {
        return petList;
    }

    public void setPetList(List<PetDTO> petList) {
        this.petList = petList;
    }
    
    /* 비밀번호 검사 */
    public boolean matchPassword(String password) {
        if (password == null) {
            return false;
        }
        return uPassword.equals(password);
    }
    
    /*아이디 비밀번호 일치 검사*/
    public boolean isSameUser(String userId) {
        return uPassword.equals(userId);
    }
}
