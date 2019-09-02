package club.gongsir.utils;

import java.util.HashMap;
import java.util.Map;

public class ResponseData {
    public static final String ERRORS_KEY = "errors";

    private int code;
    private String msg;
    private int count;
    private Map<String,Object> data = new HashMap<>();

    public ResponseData() {
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCount() {
        return count;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public ResponseData putDataValue(String key,Object value){
        data.put(key,value);
        return this;
    }

    public ResponseData(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static ResponseData ok(){
        return new ResponseData(200,"OK");
    }
    public static ResponseData error(){
        return new ResponseData(1024,"ERROR");
    }
    public static ResponseData notFound(){
        return new ResponseData(404,"Not Found");
    }
    public static ResponseData badRequest(){
        return new ResponseData(400,"Bad Request");
    }
    public static ResponseData forbidden(){
        return new ResponseData(403,"Forbidden");
    }
    public static ResponseData unauthorized(){
        return new ResponseData(401,"Unauthorized");
    }
    public static ResponseData serverInternalError(){
        return new ResponseData(500,"Server Internal Error");
    }
    public static ResponseData customerError(){
        return new ResponseData(1001,"Customer Error");
    }
}
