package com.emall.emallumsservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.emallumsentity.entity.form.UsersLoginForm;
import com.emall.emallumsentity.entity.params.UserPageParam;
import com.emall.emallumsentity.entity.po.UserPo;
import com.emall.emallumsentity.entity.vo.UserInfoVo;
import com.emall.emallumsentity.entity.vo.UserVo;
import com.emall.emallumsservice.config.PasswordEncoder;
import com.emall.emallumsservice.mapper.UsersMapper;
import com.emall.emallumsservice.service.IUserRoleService;
import com.emall.emallumsservice.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
public class UserServiceImpl extends ServiceImpl<UsersMapper, UserPo> implements IUserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IUserRoleService usersRolesService;

    @Override
    public UserVo getByUniqueId(String uniqueId) {
        QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", uniqueId).or().eq("mobile", uniqueId);
        UserPo userPo = this.getOne(queryWrapper);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userPo, userVo);
        return userVo;
    }

    /**
     * 登录获取用户信息
     *
     * @param usersLoginForm
     * @return
     */
    @Override
    public UserInfoVo getUsersInfo(UsersLoginForm usersLoginForm) {
        QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", usersLoginForm.getUsername());
        queryWrapper.eq("password", usersLoginForm.getPassword());
        UserPo userPo = this.getOne(queryWrapper);
        return new UserInfoVo(userPo);
    }

    /**
     * 更新用户信息
     *
     * @param userPo
     * @return
     */
    @Override
    @Transactional
    public boolean updateUserById(UserPo userPo) {
        UserPo user = this.baseMapper.selectById(userPo.getId());
        //校验密码是否有修改
        if (!StringUtils.equals(user.getPassword(), userPo.getPassword()))
            userPo.setPassword(passwordEncoder.mypasswordEncoder().encode(userPo.getPassword()));
        return this.updateById(userPo);
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
        UserPo userPo = this.baseMapper.selectById(id);
        userPo.setDeleted("Y");//删除标记
        boolean flag_user = this.updateById(userPo);
        //删除该用户的所有角色信息
        boolean flag_user_role = usersRolesService.deleteRolesByUseridId(id);
        return flag_user && flag_user_role;
    }

    /**
     * 添加用户
     *
     * @param userPo
     * @return
     */
    @Override
    @Transactional
    public boolean insertUser(UserPo userPo) {
        if (StringUtils.isNotBlank(userPo.getPassword()))
            userPo.setPassword(passwordEncoder.mypasswordEncoder().encode(userPo.getPassword()));
        boolean inserts = this.save(userPo);//保存用户
        return inserts;
    }

    /**
     * 根据用户id更新用户角色
     *
     * @param userid
     * @param roleIds
     * @return
     */
    @Override
    @Transactional
    public boolean updateRoleByUserId(Long userid, List<String> roleIds) {
        List<Long> ids = roleIds.stream().map(roleId -> Long.parseLong(roleId)).collect(Collectors.toList());
        return usersRolesService.saveAll(userid, ids);
    }

    @Override
    public IPage<UserVo> getUseList(UserPageParam userPageParam) {
        QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(userPageParam.getName()), "name", userPageParam.getName());
        queryWrapper.eq(StringUtils.isNotBlank(userPageParam.getStatus()), "deleted", userPageParam.getStatus());
        IPage<UserPo> userIPage = this.page(userPageParam.getPage(), queryWrapper);
        return userIPage.convert(UserVo::new);
    }

    /**
     * 更新用户状态
     *
     * @param id
     * @param status
     * @return
     */
    @Override
    @Transactional
    public boolean updateStatusByUserId(Long id, String status) {
        UserPo user = this.baseMapper.selectById(id);
        user.setDeleted(status);
        return this.updateById(user);
    }

    @Override
    public UserVo getByUsername(String name) {
        QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", name);
        UserPo userPo = this.getOne(queryWrapper);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userPo, userVo);
        return userVo;
    }

}
