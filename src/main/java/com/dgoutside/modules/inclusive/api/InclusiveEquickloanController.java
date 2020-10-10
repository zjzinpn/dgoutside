package com.dgoutside.modules.inclusive.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.dgoutside.modules.common.dto.output.ApiResult;
import com.dgoutside.modules.inclusive.dto.InclusiveQueryPara;
import com.dgoutside.modules.inclusive.entity.InclusiveCorploan;
import com.dgoutside.modules.inclusive.entity.InclusiveEquickloan;
import com.dgoutside.modules.inclusive.entity.InclusiveHousename;
import com.dgoutside.modules.inclusive.service.IInclusiveCorploanService;
import com.dgoutside.modules.inclusive.service.IInclusiveEquickloanService;
import com.dgoutside.modules.inclusive.service.IInclusiveHousenameService;
import com.dgoutside.modules.system.entity.SysLog;
import com.dgoutside.modules.system.entity.User;

import io.swagger.annotations.ApiOperation;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liuxy
 * @since 2020-04-24
 */
@RestController
@RequestMapping("/api/inclusive/inclusiveEquickloan")
public class InclusiveEquickloanController {

	@Autowired
	 IInclusiveCorploanService iInclusiveCorploanService;
	@Autowired
	 IInclusiveEquickloanService iInclusiveEquickloanService;

	@PostMapping(value = "/saveEquickloan", produces = "application/json;charset=utf-8")
	    public ApiResult saveEquickloan(@RequestBody @Validated InclusiveEquickloan input) {
		 
		 String indate = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now());
		 input.setIndate(indate);
		 
		 boolean insert = iInclusiveEquickloanService.insert(input);
			return ApiResult.ok("保存个人e抵快贷成功", insert);
	 
	 
	}
	
	 @PostMapping(value = "/deleteEquickloan", produces = "application/json;charset=utf-8")
	    public ApiResult deleteEquickloan(@RequestBody InclusiveEquickloan filter) {
		 
		   String custname= filter.getCustname();
		   String housename = filter.getHousename();
		   String indate = filter.getIndate();
		   Map<String, Object> columnMap = new HashMap<String, Object>();

			columnMap.put("indate", indate);
			columnMap.put("custname", custname);
			columnMap.put("housename", housename);
		   
		   
		   boolean deleteByMap = iInclusiveEquickloanService.deleteByMap(columnMap);
	        
	        
	        
	        return ApiResult.ok("删除Equickloan成功", deleteByMap);
	    }
	
	
	
	
	
	
	
	 
	
}
