package com.dgoutside.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dgoutside.modules.system.entity.Menu;
import com.dgoutside.modules.system.entity.RoleMenu;
import com.dgoutside.modules.system.dto.input.RoleMenuQueryPara;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p> 系统管理 - 角色-菜单关联表  Mapper 接口 </p>
 *
 * @author : dgoutside
 * @date : 2019-08-20
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<RoleMenu> selectRoleMenus(Page page, @Param("filter") RoleMenuQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<RoleMenu> selectRoleMenus(@Param("filter") RoleMenuQueryPara filter);

    /**
     * 根据角色Id删除用户与菜单相关联数据
     *
     * @param roleId:
     * @return: void
     */
    void deleteByRoleId(@Param("roleId") Integer roleId);


    /**
     * 根据角色ID查询关联菜单
     *
     * @param roleId:
     * @return: java.util.List<com.dgoutside.modules.system.entity.Menu>
     */
    List<Menu> selectMenusByRoleId(@Param("roleId") Integer roleId);

}
