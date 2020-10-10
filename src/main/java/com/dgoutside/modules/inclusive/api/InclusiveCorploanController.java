package com.dgoutside.modules.inclusive.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgoutside.modules.common.dto.output.ApiResult;
import com.dgoutside.modules.inclusive.entity.InclusiveCorploan;
import com.dgoutside.modules.inclusive.entity.InclusiveEquickloan;
import com.dgoutside.modules.inclusive.service.IInclusiveCorploanService;
import com.dgoutside.modules.inclusive.service.IInclusiveEquickloanService;

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
@RequestMapping("/api/inclusive/inclusiveCorploan")
public class InclusiveCorploanController {

	@Autowired
	IInclusiveCorploanService iInclusiveCorploanService;
	@Autowired
	IInclusiveEquickloanService iInclusiveEquickloanService;

	@PostMapping(value = "/saveCorploan", produces = "application/json;charset=utf-8")
	public ApiResult saveCorploan(@RequestBody @Validated InclusiveCorploan input) {
		String indate = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now());
		input.setIndate(indate);

		boolean insert = iInclusiveCorploanService.insert(input);
			return ApiResult.ok("保存小企业法人贷款成功", insert);

	}
	
	 @PostMapping(value = "/deleteCorploan", produces = "application/json;charset=utf-8")
	    public ApiResult deleteCorploan(@RequestBody InclusiveCorploan filter) {
		 
		   String corpname= filter.getCorpname();
		   String loantype = filter.getLoantype();
		   String indate = filter.getIndate();
		   Map<String, Object> columnMap = new HashMap<String, Object>();

			columnMap.put("indate", indate);
			columnMap.put("corpname", corpname);
			columnMap.put("loantype", loantype);
		   
		   
		   boolean deleteByMap = iInclusiveCorploanService.deleteByMap(columnMap);
	        
	        
	        
	        return ApiResult.ok("删除Corploan成功", deleteByMap);
	    }

}
