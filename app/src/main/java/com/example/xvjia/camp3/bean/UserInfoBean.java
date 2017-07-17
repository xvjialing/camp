package com.example.xvjia.camp3.bean;

import java.util.List;

/**
 * Created by xjl on 17-3-28.
 */

public class UserInfoBean {

    /**
     * lp : 0
     * data : [{"username":"agent2","email":"888@qq.com","mobile":"","userSex":"男","userFace":"2017-02-07/avater2.jpg","userPower":"394","userBrains":"126","userExp":"300","userGrade":"5","userGold":"129","userBlood":"203","physical_damage":"322","physical_defense":"433","spell_damage":"543","spell_defense":"234","speed":"554","treatment_intensity":"132"}]
     */

    private int lp;
    private List<DataBean> data;

    public int getLp() {
        return lp;
    }

    public void setLp(int lp) {
        this.lp = lp;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * username : agent2
         * email : 888@qq.com
         * mobile :
         * userSex : 男
         * userFace : 2017-02-07/avater2.jpg
         * userPower : 394
         * userBrains : 126
         * userExp : 300
         * userGrade : 5
         * userGold : 129
         * userBlood : 203
         * physical_damage : 322
         * physical_defense : 433
         * spell_damage : 543
         * spell_defense : 234
         * speed : 554
         * treatment_intensity : 132
         */

        private String username;
        private String email;
        private String mobile;
        private String userSex;
        private String userFace;
        private String userPower;
        private String userBrains;
        private String userExp;
        private String userGrade;
        private String userGold;
        private String userBlood;
        private String physical_damage;
        private String physical_defense;
        private String spell_damage;
        private String spell_defense;
        private String speed;
        private String treatment_intensity;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getUserSex() {
            return userSex;
        }

        public void setUserSex(String userSex) {
            this.userSex = userSex;
        }

        public String getUserFace() {
            return userFace;
        }

        public void setUserFace(String userFace) {
            this.userFace = userFace;
        }

        public String getUserPower() {
            return userPower;
        }

        public void setUserPower(String userPower) {
            this.userPower = userPower;
        }

        public String getUserBrains() {
            return userBrains;
        }

        public void setUserBrains(String userBrains) {
            this.userBrains = userBrains;
        }

        public String getUserExp() {
            return userExp;
        }

        public void setUserExp(String userExp) {
            this.userExp = userExp;
        }

        public String getUserGrade() {
            return userGrade;
        }

        public void setUserGrade(String userGrade) {
            this.userGrade = userGrade;
        }

        public String getUserGold() {
            return userGold;
        }

        public void setUserGold(String userGold) {
            this.userGold = userGold;
        }

        public String getUserBlood() {
            return userBlood;
        }

        public void setUserBlood(String userBlood) {
            this.userBlood = userBlood;
        }

        public String getPhysical_damage() {
            return physical_damage;
        }

        public void setPhysical_damage(String physical_damage) {
            this.physical_damage = physical_damage;
        }

        public String getPhysical_defense() {
            return physical_defense;
        }

        public void setPhysical_defense(String physical_defense) {
            this.physical_defense = physical_defense;
        }

        public String getSpell_damage() {
            return spell_damage;
        }

        public void setSpell_damage(String spell_damage) {
            this.spell_damage = spell_damage;
        }

        public String getSpell_defense() {
            return spell_defense;
        }

        public void setSpell_defense(String spell_defense) {
            this.spell_defense = spell_defense;
        }

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }

        public String getTreatment_intensity() {
            return treatment_intensity;
        }

        public void setTreatment_intensity(String treatment_intensity) {
            this.treatment_intensity = treatment_intensity;
        }
    }
}
