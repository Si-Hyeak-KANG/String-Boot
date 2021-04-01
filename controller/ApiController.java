package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// 해당 Class는 REST API 처리하는 Controller
@RequestMapping("/api")//주소를 맵핑, 할당 ,, URI를 지정해주는 Annotqtion
public class ApiController {

    @GetMapping("/hello") //http://localhost:9090/api/hello
    public String hello() {
        return "hello spring boot!"; // 해당주소로 get 방식으로 요청이 들어오면 문자열 반환
    }
}
