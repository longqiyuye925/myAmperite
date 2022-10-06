package com.example.amperite.controller;

import com.example.amperite.annotation.Amperite;
import com.example.amperite.vo.TestVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author wushichao5
 * @Date 2022/10/5 16:24
 * @Version 1.0
 **/
@RestController
@RequestMapping("/test")
public class TestController {
    @Amperite()
    @RequestMapping("/testAmperite")
    public TestVo testAmperite(){
        TestVo testVo = new TestVo();
        testVo.setMsg("ok");
        return testVo;
    }
}
