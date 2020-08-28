package com.emall.emallmanageplat.service;

import com.emall.emallmanageplat.entity.form.UsersLoginForm;
import com.emall.emallweb.entity.po.UsersPo;
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

    UserInfoVo getUsersInfo(UsersLoginForm usersLoginForm);

    boolean updateUserById(UsersPo usersPo);

    boolean deleteUserById(Long id);

    boolean insertUser(UsersPo usersPo);

    boolean updateRoleByUserId(Long userid, String roleId);
}
