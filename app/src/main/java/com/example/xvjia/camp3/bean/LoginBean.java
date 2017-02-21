package com.example.xvjia.camp3.bean;

import java.util.List;

/**
 * Created by xjl on 2017/1/15.
 */

public class LoginBean {
    /**
     * lp : 0
     * data : {"msg":"请求成功","list":[{"id":"2","username":"xjl","password":"123","type":"1"}]}
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
         * msg : 请求成功
         * list : [{"id":"2","username":"xjl","password":"123","type":"1"}]
         */

        private String msg;
        private List<ListBean> list;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 2
             * username : xjl
             * password : 123
             * type : 1
             */

            private String id;
            private String username;
            private String password;
            private String type;

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

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
