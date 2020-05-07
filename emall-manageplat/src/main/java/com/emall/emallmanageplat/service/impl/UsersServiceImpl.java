package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.entity.po.Users;
import com.emall.emallmanageplat.entity.vo.UsersVo;
import com.emall.emallmanageplat.mapper.UsersMapper;
import com.emall.emallmanageplat.service.IUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@Slf4j
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    @Override
    public UsersVo getByUniqueId(String uniqueId) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",uniqueId).or().eq("mobile",uniqueId);
        Users users = this.getOne(queryWrapper);
        return new UsersVo(users);
    }
}
