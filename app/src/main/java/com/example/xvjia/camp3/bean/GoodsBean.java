package com.example.xvjia.camp3.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xjl on 17-2-8.
 */

public class GoodsBean implements Parcelable {

    /**
     * id : 1
     * pic : 2017-02-08/data_pic_bag1.jpg
     * name : 帐篷
     * price : 30
     * description : 帐篷
     */

    private String id;
    private String pic;
    private String name;
    private String price;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.pic);
        dest.writeString(this.name);
        dest.writeString(this.price);
        dest.writeString(this.description);
    }

    public GoodsBean() {
    }

    protected GoodsBean(Parcel in) {
        this.id = in.readString();
        this.pic = in.readString();
        this.name = in.readString();
        this.price = in.readString();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<GoodsBean> CREATOR = new Parcelable.Creator<GoodsBean>() {
        @Override
        public GoodsBean createFromParcel(Parcel source) {
            return new GoodsBean(source);
        }

        @Override
        public GoodsBean[] newArray(int size) {
            return new GoodsBean[size];
        }
    };
}
