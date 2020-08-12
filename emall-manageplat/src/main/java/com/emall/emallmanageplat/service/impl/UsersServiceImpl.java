package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.config.PasswordEncoder;
import com.emall.emallmanageplat.entity.form.UsersLoginForm;
import com.emall.emallmanageplat.entity.po.UserRolePo;
import com.emall.emallmanageplat.entity.po.UsersPo;
import com.emall.emallmanageplat.entity.vo.UserInfoVo;
import com.emall.emallmanageplat.entity.vo.UsersVo;
import com.emall.emallmanageplat.mapper.UsersMapper;
import com.emall.emallmanageplat.service.IUsersRolesService;
import com.emall.emallmanageplat.service.IUsersService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, UsersPo> implements IUsersService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IUsersRolesService usersRolesService;

    @Override
    public UsersVo getByUniqueId(String uniqueId) {
        QueryWrapper<UsersPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", uniqueId).or().eq("mobile", uniqueId);
        UsersPo usersPo = this.getOne(queryWrapper);
        return new UsersVo(usersPo);
    }

    /**
     * 登录获取用户信息
     *
     * @param usersLoginForm
     * @return
     */
    @Override
    public UserInfoVo getUsersInfo(UsersLoginForm usersLoginForm) {
        QueryWrapper<UsersPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", usersLoginForm.getUsername());
        queryWrapper.eq("password", usersLoginForm.getPassword());
        UsersPo usersPo = this.getOne(queryWrapper);
        return new UserInfoVo(usersPo);
    }

    /**
     * 更新用户信息
     *
     * @param usersPo
     * @return
     */
    @Override
    @Transactional
    public boolean updateUserById(UsersPo usersPo) {
        if (StringUtils.isNotBlank(usersPo.getPassword()))
            usersPo.setPassword(passwordEncoder.mypasswordEncoder().encode(usersPo.getPassword()));
        return this.save(usersPo);
    }

    /**
     * 逻辑删除用户
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public boolean deleteUserById(Long id) {
        UsersPo usersPo = this.baseMapper.selectById(id);
        usersPo.setDeleted("1");//删除标记
        //删除该用户的所有角色信息
        usersRolesService.deleteRolesByUseridId(id);
        return this.updateById(usersPo);
    }

    /**
     * 添加用户
     *
     * @param usersPo
     * @return
     */
    @Override
    public boolean insertUser(UsersPo usersPo) {
        if (StringUtils.isNotBlank(usersPo.getPassword()))
            usersPo.setPassword(passwordEncoder.mypasswordEncoder().encode(usersPo.getPassword()));
        boolean inserts = this.save(usersPo);//保存用户
        return inserts;
    }

    /**
     * 根据用户id更新用户角色
     *
     * @param userid
     * @param roleId
     * @return
     */
    @Override
    public boolean updateRoleByUserId(Long userid, String roleId) {
        String[] role_str = roleId.split(",");   //角色id按逗号分开
        List<UserRolePo> poList = new ArrayList<>();
        for (String roleStr : role_str) {
            UserRolePo userRolePo = new UserRolePo();
            userRolePo.setUserId(userid);
            userRolePo.setRoleId(Long.parseLong(roleStr));
            poList.add(userRolePo);
        }

        return usersRolesService.saveAll(poList);
    }
}
