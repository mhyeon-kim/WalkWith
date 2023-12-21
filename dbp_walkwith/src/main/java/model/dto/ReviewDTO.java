package model.dto;

public class ReviewDTO {
    private Integer reviewId;
    private Integer storeId;
    private String userId;
    private String reContent;
    private double starScore;
    
    public ReviewDTO(){
    }
    
    public ReviewDTO(Integer reviewId,  String userId, Integer storeId, String reContent, double starScore) {
        super();
        this.reviewId = reviewId;
        this.storeId = storeId;
        this.userId = userId;
        this.reContent = reContent;
        this.starScore = starScore;
    }
    


    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReContent() {
        return reContent;
    }

    public void setReContent(String reContent) {
        this.reContent = reContent;
    }

    public double getStarScore() {
        return starScore;
    }

    public void setStarScore(double starScore) {
        this.starScore = starScore;
    }

    @Override
    public String toString() {
        return "reviewId=" + reviewId + ", storeId=" + storeId + ", userId=" + userId + ", reContent="
                + reContent + ", starScore=" + starScore;
    }
    
    
}
