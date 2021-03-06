package com.dgoutside.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dgoutside.modules.system.entity.Role;
import com.dgoutside.modules.system.dto.input.RoleQueryPara;
import com.dgoutside.modules.system.mapper.RoleMapper;
import com.dgoutside.modules.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p> 系统管理-角色表  服务实现类 </p>
 *
 * @author: dgoutside
 * @date: 2019-08-20
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    RoleMapper roleMapper;

//    @Override
//    public void listPage(Page<Role> page, RoleQueryPara filter) {
//        page.setRecords(roleMapper.selectRoles(page, filter));
//    }

    @Override
    public List<Role> list(RoleQueryPara filter) {
        return roleMapper.selectRoles(filter);
    }

    @Override
    public void listPage(Page<Role> page, RoleQueryPara filter) {
        page.setRecords(roleMapper.selectRoles(page, filter));
    }

    @Override
    public boolean save(Role para) {
        if (para.getId()!=null) {
            roleMapper.updateById(para);
        } else {
            roleMapper.insert(para);
        }
        return para.getId() == null;
    }

}
