package org.cornell.fieldmonitor.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.cornell.fieldmonitor.entity.User;
import org.cornell.fieldmonitor.mapper.UserMapper;
import org.cornell.fieldmonitor.service.userService;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl extends ServiceImpl<UserMapper, User> implements userService {
}
