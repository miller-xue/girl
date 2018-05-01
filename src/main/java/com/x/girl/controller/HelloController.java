package com.x.girl.controller;

import com.x.girl.pojo.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by miller on 2018/5/1
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
//
//    @Value("${cupSize}")
//    private String cupsize;
//
//    @Value("${age}")
//    private Integer age;
//
//    @Value("${content}")
//    private String content;



    @Autowired
    private GirlProperties girlProperties;

    //@RequestMapping(value = {"/say","hi"}, method = RequestMethod.GET)
    @GetMapping("/say")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id) {
        return id +"";

    }
}
