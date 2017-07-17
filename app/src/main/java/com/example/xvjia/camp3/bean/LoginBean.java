package com.example.xvjia.camp3.bean;

/**
 * Created by xjl on 2017/1/15.
 */

public class LoginBean {

    /**
     * lp : 0
     * data : {"msg":"登陆成功","info":{"id":"10","username":"admin2","email":"1359296867@qq.com","phone":"18768379083"}}
     */

    private int lp;
    private DataBean data;

    public int getLp() {
        return lp;
    }

    public void setLp(int lp) {
        this.lp = lp;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * msg : 登陆成功
         * info : {"id":"10","username":"admin2","email":"1359296867@qq.com","phone":"18768379083"}
         */

        private String msg;
        private InfoBean info;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public static class InfoBean {
            /**
             * id : 10
             * username : admin2
             * email : 1359296867@qq.com
             * phone : 18768379083
             */

            private String id;
            private String username;
            private String email;
            private String phone;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

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

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }
        }
    }
}
