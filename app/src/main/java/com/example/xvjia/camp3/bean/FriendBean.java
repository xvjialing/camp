package com.example.xvjia.camp3.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xjl on 17-2-7.
 */

public class FriendBean implements Parcelable {

    /**
     * id : 1
     * name : 小明
     * avater : 2017-02-07/avater1.jpg
     * address : 浙江杭州
     * sex : 男
     * age : 12
     * birthday : 2017-03-27
     * description : 爱玩
     */

    private String id;
    private String name;
    private String avater;
    private String address;
    private String sex;
    private String age;
    private String birthday;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvater() {
        return avater;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
        dest.writeString(this.name);
        dest.writeString(this.avater);
        dest.writeString(this.address);
        dest.writeString(this.sex);
        dest.writeString(this.age);
        dest.writeString(this.birthday);
        dest.writeString(this.description);
    }

    public FriendBean() {
    }

    protected FriendBean(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.avater = in.readString();
        this.address = in.readString();
        this.sex = in.readString();
        this.age = in.readString();
        this.birthday = in.readString();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<FriendBean> CREATOR = new Parcelable.Creator<FriendBean>() {
        @Override
        public FriendBean createFromParcel(Parcel source) {
            return new FriendBean(source);
        }

        @Override
        public FriendBean[] newArray(int size) {
            return new FriendBean[size];
        }
    };
}
