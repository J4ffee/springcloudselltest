package com.hand.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/4/13
 */
@RestController
public class ServerController {
    @GetMapping("/msg")
    public String msg(){
        return "this is product controller";
    }
}
