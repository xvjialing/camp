package com.example.xvjia.camp3.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xjl on 2017/1/26.
 */

public class GameBean implements Parcelable {


    /**
     * id : 1
     * title : 赤壁之战
     * price : 300
     * type : 冒险
     * logo : 2017-01-26/yingdi1.jpg
     */

    private String id;
    private String title;
    private String price;
    private String type;
    private String logo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.price);
        dest.writeString(this.type);
        dest.writeString(this.logo);
    }

    public GameBean() {
    }

    protected GameBean(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.price = in.readString();
        this.type = in.readString();
        this.logo = in.readString();
    }

    public static final Parcelable.Creator<GameBean> CREATOR = new Parcelable.Creator<GameBean>() {
        @Override
        public GameBean createFromParcel(Parcel source) {
            return new GameBean(source);
        }

        @Override
        public GameBean[] newArray(int size) {
            return new GameBean[size];
        }
    };
}
