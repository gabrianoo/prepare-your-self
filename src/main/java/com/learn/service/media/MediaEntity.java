package com.learn.service.media;

import com.google.common.base.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class MediaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer mediaId;
    private String mediaName;
    private String mediaExtension;
    private byte[] mediaBytes;

    private MediaEntity(Builder builder) {
        this.mediaId = builder.mediaId;
        this.mediaName = builder.mediaName;
        this.mediaExtension = builder.mediaExtension;
        this.mediaBytes = builder.mediaBytes;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getMediaExtension() {
        return mediaExtension;
    }

    public void setMediaExtension(String mediaExtension) {
        this.mediaExtension = mediaExtension;
    }

    public byte[] getMediaBytes() {
        return mediaBytes;
    }

    public void setMediaBytes(byte[] mediaBytes) {
        this.mediaBytes = mediaBytes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MediaEntity that = (MediaEntity) o;
        return Objects.equal(mediaId, that.mediaId) &&
                Objects.equal(mediaName, that.mediaName) &&
                Objects.equal(mediaExtension, that.mediaExtension) &&
                Objects.equal(mediaBytes, that.mediaBytes);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mediaId, mediaName, mediaExtension, mediaBytes);
    }

    @Override
    public String toString() {
        return "MediaEntity{" +
                "mediaId=" + mediaId +
                ", mediaName='" + mediaName + '\'' +
                ", mediaExtension='" + mediaExtension + '\'' +
                '}';
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private Integer mediaId;
        private String mediaName;
        private String mediaExtension;
        private byte[] mediaBytes;

        private Builder() {
        }

        public Builder mediaId(Integer mediaId) {
            this.mediaId = mediaId;
            return this;
        }

        public Builder mediaName(String mediaName) {
            this.mediaName = mediaName;
            return this;
        }

        public Builder mediaExtension(String mediaExtension) {
            this.mediaExtension = mediaExtension;
            return this;
        }

        public Builder mediaBytes(byte[] mediaBytes) {
            this.mediaBytes = mediaBytes;
            return this;
        }

        public MediaEntity build() {
            return new MediaEntity(this);
        }
    }
}
