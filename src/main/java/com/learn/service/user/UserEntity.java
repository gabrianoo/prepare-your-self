package com.learn.service.user;

import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.Calendar;

public class UserEntity implements Serializable {

    private Integer userId;
    private String userFirstName;
    private String userLastName;
    private Calendar userDateOfBirth;
    private String userEmail;
    private Integer mediaId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public Calendar getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public void setUserDateOfBirth(Calendar userDateOfBirth) {
        this.userDateOfBirth = userDateOfBirth;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equal(userId, that.userId) &&
                Objects.equal(userFirstName, that.userFirstName) &&
                Objects.equal(userLastName, that.userLastName) &&
                Objects.equal(userDateOfBirth, that.userDateOfBirth) &&
                Objects.equal(userEmail, that.userEmail) &&
                Objects.equal(mediaId, that.mediaId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId, userFirstName, userLastName, userDateOfBirth, userEmail, mediaId);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
