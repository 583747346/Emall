package com.emall.emallmanageplat.service;

import com.emall.emallmanageplat.entity.form.UsersForm;
import com.emall.emallmanageplat.entity.vo.UserInfoVo;
import com.emall.emallmanageplat.entity.vo.UsersVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
public interface IUsersService{

    UsersVo getByUniqueId(String uniqueId);

    UserInfoVo getUsersInfo(UsersForm usersForm);
}
