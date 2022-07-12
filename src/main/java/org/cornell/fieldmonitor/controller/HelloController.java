package org.cornell.fieldmonitor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/114514")
public class HelloController {

    @GetMapping("/1919")
    public String helloWorld1() {
        return "你好，德川";
    }

    @GetMapping("/180")
    public String helloWorld2() {
        return "你好，李田所";
    }


}
