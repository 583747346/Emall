package com.emall.emallmanageplat.service.impl;

import com.emall.emallmanageplat.entity.Users;
import com.emall.emallmanageplat.mapper.UsersMapper;
import com.emall.emallmanageplat.service.IUsersService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
