package org.cornell.fieldmonitor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/**")
    public String helloWorld() {
        return "你好，114514";
    }
}
