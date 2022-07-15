package org.cornell.fieldmonitor.controller;

import lombok.extern.slf4j.Slf4j;
import org.cornell.fieldmonitor.common.R;
import org.cornell.fieldmonitor.entity.User;
import org.cornell.fieldmonitor.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private userService us;

//    @PutMapping
//    public void update(HttpServlet req, @RequestBody User user){
//        us.updateById(user);
//        System.out.print(user.toString() + "success");
//    }

    @GetMapping("/{id}")
    public R<User> test(@PathVariable int id){
        User user = us.getById(id);
        if(user != null){
            return R.success(user);
        }
        return R.error("user not found");
    }







}
