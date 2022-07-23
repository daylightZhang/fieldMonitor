package org.cornell.fieldmonitor.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.cornell.fieldmonitor.common.R;
import org.cornell.fieldmonitor.entity.User;
import org.cornell.fieldmonitor.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

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

    @PostMapping("/login")
    public R<User> login(HttpServletRequest request, @RequestBody User user){
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        LambdaQueryWrapper<User> queryWrapper= new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername());
        User user1 = us.getOne(queryWrapper);

        if(user1 == null){
            return R.error("login fall");
        }

        if(!user1.getPassword().equals(password)){
            return R.error("login fall");
        }

        if(user1.getStatus() == 0){
            return R.error("account forbidden");
        }

        request.getSession().setAttribute("user",user1.getId());
        return R.success(user1);
    }







}
