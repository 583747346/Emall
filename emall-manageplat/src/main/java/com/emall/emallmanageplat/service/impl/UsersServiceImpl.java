package com.emall.emallmanageplat.service.impl;

import com.emall.emallmanageplat.entity.po.Users;
import com.emall.emallmanageplat.entity.vo.UsersVo;
import com.emall.emallmanageplat.mapper.UsersMapper;
import com.emall.emallmanageplat.service.IUsersService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
        Users users = this.get
        return this.;
    }
}
