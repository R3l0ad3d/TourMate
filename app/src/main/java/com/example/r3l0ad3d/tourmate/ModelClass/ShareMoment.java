package com.example.r3l0ad3d.tourmate.ModelClass;

/**
 * Created by r3l0ad3d on 5/2/17.
 */

public class ShareMoment {
    private String userId;
    private String userName;
    private String description;
    private String imageURL;
    private boolean isShareAble;

    public ShareMoment(String userName, String description, String imageURL) {
        this.userName = userName;
        this.description = description;
        this.imageURL = imageURL;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public boolean isShareAble() {
        return isShareAble;
    }

    public void setShareAble(boolean shareAble) {
        isShareAble = shareAble;
    }
}
