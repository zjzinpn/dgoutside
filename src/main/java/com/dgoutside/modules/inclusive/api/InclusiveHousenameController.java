package com.dgoutside.modules.inclusive.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgoutside.modules.common.dto.output.ApiResult;
import com.dgoutside.modules.inclusive.entity.InclusiveHousename;
import com.dgoutside.modules.inclusive.service.IInclusiveHousenameService;
import com.dgoutside.modules.system.dto.input.UserRoleQueryPara;
import com.dgoutside.modules.system.entity.UserRole;
import com.dgoutside.modules.system.service.IUserRoleService;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuxy
 * @since 2020-04-24
 */
@RestController
@RequestMapping("/api/inclusive/inclusiveHousename")
public class InclusiveHousenameController {
	
	 @Autowired
	 IInclusiveHousenameService iInclusiveHousenameService;
	
	 @PostMapping(value = "/listHousename", produces = "application/json;charset=utf-8")
	    public ApiResult listHousename() {
	        List<InclusiveHousename> result = iInclusiveHousenameService.selectList(null);
	        return ApiResult.ok("获取楼盘名称成功",result);
	    }

}

