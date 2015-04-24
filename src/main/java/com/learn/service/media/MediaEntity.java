package com.learn.service.media;

import com.google.common.base.Objects;

import java.io.Serializable;

public class MediaEntity implements Serializable {

    private Integer mediaId;
    private String mediaName;
    private String mediaExtension;
    private byte[] mediaBytes;

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
}
