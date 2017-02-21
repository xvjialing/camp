package com.example.xvjia.camp3.bean;

/**
 * Created by xjl on 2017/1/16.
 */

public class RegisterBean {
    /**
     * lp : 0
     * data : {"msg":"请求成功","list":4}
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
         * list : 4
         */

        private String msg;
        private int list;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getList() {
            return list;
        }

        public void setList(int list) {
            this.list = list;
        }
    }
}
