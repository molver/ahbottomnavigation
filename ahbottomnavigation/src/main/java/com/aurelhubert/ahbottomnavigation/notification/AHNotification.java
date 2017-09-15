package com.aurelhubert.ahbottomnavigation.notification;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author repitch
 */
public class AHNotification implements Parcelable {

    @Nullable
    private String text; // can be null, so notification will not be shown

    @ColorInt
    private int textColor; // if 0 then use default value

    @ColorInt
    private int backgroundColor; // if 0 then use default value

    private boolean showDot;

    @DrawableRes
    private int dotDrawable;

    public AHNotification() {
        // empty
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(text);
    }

    public String getText() {
        return text;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public static AHNotification justText(String text) {
        return new Builder().setText(text).build();
    }

    public static List<AHNotification> generateEmptyList(int size) {
        List<AHNotification> notificationList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            notificationList.add(new AHNotification());
        }
        return notificationList;
    }

    public boolean isShowDot() {
        return showDot;
    }

    public void setShowDot(boolean showDot) {
        this.showDot = showDot;
    }

    public int getDotDrawable() {
        return dotDrawable;
    }

    public void setDotDrawable(int dotDrawable) {
        this.dotDrawable = dotDrawable;
    }

    public static class Builder implements Parcelable {
        @Nullable
        private String text;
        @ColorInt
        private int textColor;
        @ColorInt
        private int backgroundColor;

        private boolean showDot;

        @DrawableRes
        private int dotDrawable;

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public Builder setTextColor(@ColorInt int textColor) {
            this.textColor = textColor;
            return this;
        }

        public Builder setBackgroundColor(@ColorInt int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder setShowDot(boolean isShowDot) {
            this.showDot = isShowDot;
            return this;
        }

        public AHNotification build() {
            AHNotification notification = new AHNotification();
            notification.text = text;
            notification.textColor = textColor;
            notification.backgroundColor = backgroundColor;
            notification.showDot = showDot;
            notification.dotDrawable = dotDrawable;
            return notification;
        }

        public int getDotDrawable() {
            return dotDrawable;
        }

        public Builder setDotDrawable(int dotDrawable) {
            this.dotDrawable = dotDrawable;
            return this;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.text);
            dest.writeInt(this.textColor);
            dest.writeInt(this.backgroundColor);
            dest.writeByte(this.showDot ? (byte) 1 : (byte) 0);
            dest.writeInt(this.dotDrawable);
        }

        public Builder() {
        }

        protected Builder(Parcel in) {
            this.text = in.readString();
            this.textColor = in.readInt();
            this.backgroundColor = in.readInt();
            this.showDot = in.readByte() != 0;
            this.dotDrawable = in.readInt();
        }

        public static final Creator<Builder> CREATOR = new Creator<Builder>() {
            @Override
            public Builder createFromParcel(Parcel source) {
                return new Builder(source);
            }

            @Override
            public Builder[] newArray(int size) {
                return new Builder[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.text);
        dest.writeInt(this.textColor);
        dest.writeInt(this.backgroundColor);
        dest.writeByte(this.showDot ? (byte) 1 : (byte) 0);
    }

    protected AHNotification(Parcel in) {
        this.text = in.readString();
        this.textColor = in.readInt();
        this.backgroundColor = in.readInt();
        this.showDot = in.readByte() != 0;
    }

    public static final Creator<AHNotification> CREATOR = new Creator<AHNotification>() {
        @Override
        public AHNotification createFromParcel(Parcel source) {
            return new AHNotification(source);
        }

        @Override
        public AHNotification[] newArray(int size) {
            return new AHNotification[size];
        }
    };
}
