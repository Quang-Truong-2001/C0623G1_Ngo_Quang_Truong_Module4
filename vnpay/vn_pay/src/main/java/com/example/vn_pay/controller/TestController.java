package com.example.vn_pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class TestController {
    @GetMapping("/loi")
    public String loi(@RequestParam("vnp_ResponseCode") String vnp_ResponseCode ){
        System.out.println(vnp_ResponseCode);
        return "home";
    }
}
