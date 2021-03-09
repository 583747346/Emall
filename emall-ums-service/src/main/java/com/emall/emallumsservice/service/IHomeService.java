package com.emall.emallumsservice.service;


import com.emall.emallumsentity.entity.vo.PermissionVo;

import java.util.List;

public interface IHomeService {
    List<PermissionVo> treeList(String name);
}
