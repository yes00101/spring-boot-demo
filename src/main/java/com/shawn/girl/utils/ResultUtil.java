package com.shawn.girl.utils;

import com.shawn.girl.domain.Result;

public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result();
        result.setData(object);
        result.setMsg("成功");
        result.setCode(0);
        return result;
    }
    public static Result success(){
        return success(null);
    }
    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setMsg(msg);
        result.setCode(1);
        return result;
    }
}
