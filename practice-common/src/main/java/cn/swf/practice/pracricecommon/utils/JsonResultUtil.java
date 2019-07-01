package cn.swf.practice.pracricecommon.utils;

import cn.swf.practice.pracricecommon.enums.CodeEnum;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by 宋维飞
 * 2019/7/1 14:44
 */
public class JsonResultUtil {
    private static final String IDENTIFICATION = "identification";
    public static final String ERRORCODE = "code";
    public static final String ERRORMSG = "msg";
    public static final String DATA = "data";

    /**
     * 网关要求 登陆成功返回 int 0,非 0 为失败
     */
    public static final int LOGIN_ERRORCODE_OK = 0;
    public static final String ERRORCODE_OK = CodeEnum.SUCCESS.getCode();
    public static final String ERRORCODE_OK_MSG = CodeEnum.SUCCESS.getMsg();
    public static final String ERRORCODE_ERROR = CodeEnum.FAIL.getCode();
    public static final String ERRORCODE_ERROR_MSG = CodeEnum.FAIL.getMsg();

    public static JSONObject bindPhoneJson() {
        JSONObject jsonObj = new JSONObject(true);
        jsonObj.put(ERRORCODE, ERRORCODE_ERROR);
        jsonObj.put(ERRORMSG, CodeEnum.NO_BIND_PHONE.getCode());
        return jsonObj;
    }

    public static JSONObject getFailureJson() {
        JSONObject jsonObj = new JSONObject(true);
        jsonObj.put(ERRORCODE, ERRORCODE_ERROR);
        jsonObj.put(ERRORMSG, ERRORCODE_ERROR_MSG);
        jsonObj.put(DATA, new JSONObject());
        return jsonObj;
    }

    public static JSONObject getFailureJson(Object data) {
        JSONObject jsonObj = new JSONObject(true);
        jsonObj.put(ERRORCODE, ERRORCODE_ERROR);
        jsonObj.put(ERRORMSG, ERRORCODE_ERROR_MSG);
        jsonObj.put(DATA, data);
        return jsonObj;
    }

    public static JSONObject getFailureJson(String msg, Object data) {
        JSONObject jsonObj = new JSONObject(true);
        jsonObj.put(ERRORCODE, ERRORCODE_ERROR);
        jsonObj.put(ERRORMSG, msg);
        jsonObj.put(DATA, data);
        return jsonObj;
    }

    public static JSONObject getJson(CodeEnum codeEnum) {
        JSONObject jsonObj = new JSONObject(true);
        jsonObj.put(ERRORCODE, codeEnum.getCode());
        jsonObj.put(ERRORMSG, codeEnum.getMsg());
        jsonObj.put(DATA, new JSONObject());
        return jsonObj;
    }

    public static JSONObject getJson(CodeEnum codeEnum, Object data) {
        JSONObject jsonObj = new JSONObject(true);
        jsonObj.put(ERRORCODE, codeEnum.getCode());
        jsonObj.put(ERRORMSG, codeEnum.getMsg());
        jsonObj.put(DATA, data);
        return jsonObj;
    }

    public static JSONObject getJson(String code, String msg, Object data) {
        JSONObject jsonObj = new JSONObject(true);
        jsonObj.put(ERRORCODE, code);
        jsonObj.put(ERRORMSG, msg);
        jsonObj.put(DATA, data);
        return jsonObj;
    }

    public static JSONObject getLoginJson(String identification, String msg) {
        JSONObject jsonObj = new JSONObject(true);
        jsonObj.put(ERRORCODE, LOGIN_ERRORCODE_OK);
        jsonObj.put(ERRORMSG, ERRORCODE_OK_MSG);
        jsonObj.put(IDENTIFICATION, identification);
        return jsonObj;
    }

    public static JSONObject getSuccessJson() {
        JSONObject jsonObj = new JSONObject(true);
        jsonObj.put(ERRORCODE, ERRORCODE_OK);
        jsonObj.put(ERRORMSG, ERRORCODE_OK_MSG);
        jsonObj.put(DATA, new JSONObject());
        return jsonObj;
    }

    public static JSONObject getSuccessJson(Object data) {
        JSONObject jsonObj = new JSONObject(true);
        jsonObj.put(ERRORCODE, ERRORCODE_OK);
        jsonObj.put(ERRORMSG, ERRORCODE_OK_MSG);
        jsonObj.put(DATA, data);
        return jsonObj;
    }

    public static JSONObject getSuccessJson(String msg, Object data) {
        JSONObject jsonObj = new JSONObject(true);
        jsonObj.put(ERRORCODE, ERRORCODE_OK);
        jsonObj.put(ERRORMSG, msg);
        jsonObj.put(DATA, data);
        return jsonObj;
    }

}
