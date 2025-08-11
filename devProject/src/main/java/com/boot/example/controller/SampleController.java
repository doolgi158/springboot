package com.boot.example.controller;

import com.boot.example.domain.ExampleVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    //@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
    @GetMapping(value = "/getText", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getTExt(){
        return "안녕하세요";
    }

    //@Getmapping(value = "/getExample", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/getExample")
    public ExampleVO getSample(){
        return new ExampleVO(1, "홍길동", "010-1234-9087");
    }
}
