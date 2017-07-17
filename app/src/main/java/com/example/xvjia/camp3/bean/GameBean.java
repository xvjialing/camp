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
     * description : 赤壁之战，是指东汉末年，孙权、刘备联军于建安十三年（208年）在长江赤壁（今湖北省赤壁市西北）一带大破曹操大军，奠定三国鼎立基础的以少胜多,以弱胜强的著名战役。这是中国历史上以少胜多的著名战争之一，也是三国时期“三大战役”中最为著名的一场。它也是中国历史上第一次在长江流域进行的大规模江河作战，标志着中国军事政治中心不再限于黄河流域。孙刘联军最后以火攻大破曹军，曹操北回，孙、刘各自夺去荆州的一部分。
     * rank : 4级
     * menber : 5人
     */

    private String id;
    private String title;
    private String price;
    private String type;
    private String logo;
    private String description;
    private String rank;
    private String menber;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getMenber() {
        return menber;
    }

    public void setMenber(String menber) {
        this.menber = menber;
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
        dest.writeString(this.description);
        dest.writeString(this.rank);
        dest.writeString(this.menber);
    }

    public GameBean() {
    }

    protected GameBean(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.price = in.readString();
        this.type = in.readString();
        this.logo = in.readString();
        this.description = in.readString();
        this.rank = in.readString();
        this.menber = in.readString();
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
