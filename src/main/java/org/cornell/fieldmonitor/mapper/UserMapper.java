package org.cornell.fieldmonitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.cornell.fieldmonitor.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User>{
}
