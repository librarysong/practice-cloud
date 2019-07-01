package cn.swf.practice.practicehystrix.bean;

import com.alibaba.fastjson.JSON;

/**
 * Created by 宋维飞
 * 2019/7/1 19:19
 */
public class IconBeanRet {

    private String code;
    private String msg;
    private JSON data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JSON getData() {
        return data;
    }

    public void setData(JSON data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IconBeanRet{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
