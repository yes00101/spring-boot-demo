package com.shawn.girl.controller;

import com.shawn.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * created by shawn
 * 2018-02-06
 */
@RestController
//@Controller
//@ResponseBody
public class Helloontroller {

//    @Value("${cupSize}")
//    private String cupSize;

//    @Value("${age}")
//    private Integer age;
//
//    @Value("${content}")
//    private String content;
    @Autowired
    private GirlProperties girlProperties;

//    @RequestMapping(value ={"/hello", "/hi"}, method = RequestMethod.POST)
    @GetMapping("/say")
    public String say(@RequestParam(value ="id", required = false, defaultValue = "0") Integer hongid){
//        return "Hello Spring Boot! cupSize="+ cupSize +" and age="+age +"  "+content;
//        return  girlProperties.getCupSize() + girlProperties.getAge();
//        return "index";
        return "id = "+hongid;
    }
}
