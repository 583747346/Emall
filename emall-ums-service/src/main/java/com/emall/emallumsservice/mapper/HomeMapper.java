package com.emall.emallumsservice.mapper;


import com.emall.emallumsentity.entity.vo.HomeMenuVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HomeMapper {

    @Select("SELECT ur.user_id,r.name as role_name,m.icon as icon,m.id as menu_id,m.name as menu_name,m.parent_id as parent_id,m.path as path FROM user_role_relation ur " +
            "LEFT JOIN role r ON ur.role_id = r.id  " +
            "LEFT JOIN role_menu_relation rm ON r.id = rm.role_id " +
            "LEFT JOIN menu m ON rm.menu_id = m.id " +
            "WHERE ur.user_id = #{userid} AND m.id IS NOT NULL group by m.id order by m.order_num")
    List<HomeMenuVo> listPermission(@Param("userid") Long userid);

}
