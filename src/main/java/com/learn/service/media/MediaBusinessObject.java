package com.learn.service.media;

public class MediaBusinessObject implements Media {

    private Integer mediaId;
    private String mediaName;
    private String mediaExtension;
    private byte[] mediaBytes;

    private MediaBusinessObject(Builder builder) {
        this.mediaId = builder.mediaId;
        this.mediaName = builder.mediaName;
        this.mediaExtension = builder.mediaExtension;
        this.mediaBytes = builder.mediaBytes;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public String getMediaName() {
        return mediaName;
    }

    public String getMediaExtension() {
        return mediaExtension;
    }

    public byte[] getMediaBytes() {
        return mediaBytes;
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

        public Media build() {
            return new MediaBusinessObject(this);
        }
    }
}
