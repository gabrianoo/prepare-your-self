package com.learn.service.user;

import com.google.common.base.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Calendar;

@Entity
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String userFirstName;
    private String userLastName;
    private Calendar userDateOfBirth;
    private String userEmail;
    private Integer mediaId;

    public UserEntity(Builder builder) {
        this.userId = builder.userId;
        this.userFirstName = builder.userFirstName;
        this.userLastName = builder.userLastName;
        this.userDateOfBirth = builder.userDateOfBirth;
        this.userEmail = builder.userEmail;
        this.mediaId = builder.mediaId;
    }

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

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private Integer userId;
        private String userFirstName;
        private String userLastName;
        private Calendar userDateOfBirth;
        private String userEmail;
        private Integer mediaId;

        private Builder() {
        }

        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder userFirstName(String userFirstName) {
            this.userFirstName = userFirstName;
            return this;
        }

        public Builder userLastName(String userLastName) {
            this.userLastName = userLastName;
            return this;
        }

        public Builder userDateOfBirth(Calendar userDateOfBirth) {
            this.userDateOfBirth = userDateOfBirth;
            return this;
        }

        public Builder userEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public Builder mediaId(Integer mediaId) {
            this.mediaId = mediaId;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(this);
        }
    }
}
