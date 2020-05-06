package com.emall.emallmanageplat.service;

import com.baomidou.mybatisplus.service.IService;
import com.emall.emallmanageplat.entity.po.Users;
import com.emall.emallmanageplat.entity.vo.UsersVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
public interface IUsersService extends IService<Users> {

    UsersVo getByUniqueId(String uniqueId);
}
