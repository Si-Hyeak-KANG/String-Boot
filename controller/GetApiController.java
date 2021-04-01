package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")//default로 넣을 시 value 값으로 지정되면서 path로 동작..지금은 명시적 방법
    //http://localhost:9090/api/get/hello
    public String hello() {
        return "get Hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET) // get/ post/ put/ delete 모든 메서드 다 동작
    // 위 방법은 get 지정 .. http://localhost:9090/api/get/hi
    public String hi() {
        return "hi";
    }

    //http://localhost:9090/api/get/path-variable/{name} -> name은 계속 변함.
    @GetMapping("/path-variable/{name}")// 다른 예 {id} 이면 (name = "id")
    public String pathVariable(@PathVariable(name = "name") String pathName) {
        //주소에는 name을 했는데 변수에는 이름을 다르게 설정해야 할 때,
        System.out.println("PathVariable : " +pathName);
        return pathName;
    }

    //Query Parameter : 검색할 때 여러가지 매개변수의 인자
    //https://www.google.com/search?q=intellij&oq=&aqs=chrome.0.35i39i362l8...8.1638267j0j7&sourceid=chrome&ie=UTF-8
    //search?q=intellij
    // &oq =
    // &aqs = chrome.0.35i39i362l8...8.1638267j0j7
    // &sourceid = chrome
    // &ie = UTF-8

    // ?key=value&key2=value2

    //http:localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com$age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    //gueryParam에 유저가 넣을 수 있는 것을 명확하게 지정
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+email+" "+age;
    }

    //RequestParam 이라는 어노테이션을 붙이지 않는다.
    //객체가 들어오면 ?뒤에 값들을 스프링부트에서 판단
    //현업에서 가장 많이 사용
    @GetMapping("query-param03")
    //gueryParam에 유저가 넣을 수 있는 것을 명확하게 지정
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
