package com.emall.emallmanageplat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallmanageplat.config.PasswordEncoder;
import com.emall.emallmanageplat.entity.form.UsersLoginForm;
import com.emall.emallmanageplat.entity.po.UsersPo;
import com.emall.emallmanageplat.entity.vo.UserInfoVo;
import com.emall.emallmanageplat.entity.vo.UsersVo;
import com.emall.emallmanageplat.mapper.UsersMapper;
import com.emall.emallmanageplat.service.IUsersService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            usersPo.setPassword(passwordEncoder.passwordEncoder().encode(usersPo.getPassword()));
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
    public boolean deleteUserById(String id) {
        UsersPo usersPo = this.baseMapper.selectById(id);
        usersPo.setDeleted("1");//删除标记
        //删除该用户的所有角色信息

        return this.save(usersPo);
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
            usersPo.setPassword(passwordEncoder.passwordEncoder().encode(usersPo.getPassword()));
        boolean inserts = this.save(usersPo);//保存用户
        //保存用户角色信息
        return inserts;
    }
}
