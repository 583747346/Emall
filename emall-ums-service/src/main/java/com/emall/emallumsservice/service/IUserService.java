package com.emall.emallumsservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.emall.emallumsentity.entity.form.UsersLoginForm;
import com.emall.emallumsentity.entity.params.UserPageParam;
import com.emall.emallumsentity.entity.po.UserPo;
import com.emall.emallumsentity.entity.vo.UserInfoVo;
import com.emall.emallumsentity.entity.vo.UserVo;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author qinlang
 * @since 2020-05-06
 */
public interface IUserService {

    UserVo getByUniqueId(String uniqueId);

    UserInfoVo getUsersInfo(UsersLoginForm usersLoginForm);

    boolean updateUserById(UserPo userPo);

    boolean deleteUserById(Long id);

    boolean insertUser(UserPo userPo);

    boolean updateRoleByUserId(Long userid, List<String> roleId);

    IPage<UserVo> getUseList(UserPageParam userPageParam);

    boolean updateStatusByUserId(Long id, String status);

    UserVo getByUsername(String name);
}
