package com.dgoutside.modules.inclusive.api;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgoutside.modules.common.dto.output.ApiResult;
import com.dgoutside.modules.common.enumeration.ResultCode;
import com.dgoutside.modules.inclusive.dto.BatchExcelPara;
import com.dgoutside.modules.inclusive.dto.InclusiveQueryPara;
import com.dgoutside.modules.inclusive.dto.output.CorploanVO;
import com.dgoutside.modules.inclusive.dto.output.EquickloanVO;
import com.dgoutside.modules.inclusive.entity.InclusiveCorploan;
import com.dgoutside.modules.inclusive.entity.InclusiveEquickloan;
import com.dgoutside.modules.inclusive.entity.InclusiveHousename;
import com.dgoutside.modules.inclusive.entity.InclusiveManager;
import com.dgoutside.modules.inclusive.service.IInclusiveCorploanService;
import com.dgoutside.modules.inclusive.service.IInclusiveEquickloanService;
import com.dgoutside.modules.inclusive.service.IInclusiveHousenameService;
import com.dgoutside.modules.inclusive.service.IInclusiveManagerService;
import com.dgoutside.modules.inclusive.service.IInclusiveService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuxy
 * @since 2020-04-24
 */
@RestController
@RequestMapping("/api/inclusive/")
public class InclusiveController {
	
	@Autowired
	 IInclusiveService iInclusiveService;
	
	@Autowired
	 IInclusiveCorploanService iInclusiveCorploanService;
	@Autowired
	 IInclusiveEquickloanService iInclusiveEquickloanService;
	@Autowired
	IInclusiveHousenameService iInclusiveHousenameService;
	@Autowired
	IInclusiveManagerService iInclusiveManagerService;
	
	
	 @PostMapping(value = "/countInclusive", produces = "application/json;charset=utf-8")
	    public ApiResult countInclusive(@RequestBody @Validated InclusiveEquickloan input) {
		 String indate = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now());
		 String marketcode = input.getMarketcode();
		 
		 
		 Map<String, Object> columnMap = new HashMap<String, Object>();

		  columnMap.put("indate", indate);
		  columnMap.put("marketcode", marketcode);
		 
		 List<InclusiveCorploan> todayCorpList = iInclusiveCorploanService.selectByMap(columnMap);
		 int countCorploan = todayCorpList.size();
		 
		 List<InclusiveEquickloan> todayEquickList  = iInclusiveEquickloanService.selectByMap(columnMap);
		 int countEquickloan = todayEquickList.size();
		 
		 String descMsg = "今日已录个人e抵快贷【"+countEquickloan+"】笔，小企业法人贷款【"+countCorploan+"】笔";
		 
		 Map<String,Object> result = new HashMap<>();
		 result.put("descMsg", descMsg);
		 result.put("todayEquickList", todayEquickList);
		 result.put("todayCorpList", todayCorpList);
		 
		 
	     return ApiResult.ok("查询笔数成功", result);
	    }
	
	 @PostMapping(value = "/getEquickloanPage", produces = "application/json;charset=utf-8")
	    public ApiResult getEquickloanPage(@RequestBody InclusiveQueryPara filter) {
		 
		   String type = filter.getType();
		   String content = filter.getContent();
		   String startDate = filter.getStartDate();
		   String endDate = filter.getEndDate();
		   String causeStr = " a.marketcode=b.marketcode ";
		   if (null != startDate || null != endDate) {
				if (null==startDate||"".equals(startDate)) {
					startDate = "2020-04-01";
				} 
				if (null==endDate||"".equals(endDate)) {
					endDate = "2120-04-01";
				}
				startDate = startDate.substring(0,10).replaceAll("-", "");
				endDate = endDate.substring(0,10).replaceAll("-", "");
				causeStr += " and  indate between '"+startDate+ "' and '" +endDate+ "' ";
				
			}
		   
		    if(!"all".equals(type)) {
		    	causeStr += " and "+type+" = '"+content+"'";
		    }
	        PageHelper.startPage(filter.getPage(),filter.getLimit()); 
	        List<EquickloanVO> data = iInclusiveService.getEquickloanPage(causeStr);
	        PageInfo<EquickloanVO> pageInfo = new PageInfo<EquickloanVO>(data);
	        
	        return ApiResult.ok("获取系统管理 - 日志表列表分页成功", pageInfo);
	    }
	 
	
	 @PostMapping(value = "/getEquickloanAll", produces = "application/json;charset=utf-8")
	    public ApiResult getEquickloanAll(@RequestBody InclusiveQueryPara filter) {
		 
		   String type = filter.getType();
		   String content = filter.getContent();
		   String startDate = filter.getStartDate();
		   String endDate = filter.getEndDate();
		   String causeStr = " a.marketcode=b.marketcode ";
		   if (null != startDate || null != endDate) {
				if (null==startDate||"".equals(startDate)) {
					startDate = "2020-04-01";
				} 
				if (null==endDate||"".equals(endDate)) {
					endDate = "2120-04-01";
				}
				startDate = startDate.substring(0,10).replaceAll("-", "");
				endDate = endDate.substring(0,10).replaceAll("-", "");
				causeStr += " and  indate between '"+startDate+ "' and '" +endDate+ "' ";
			}
		   
		    if(!"all".equals(type)) {
		    	causeStr += " and "+type+" = '"+content+"'";
		    }
	        List<EquickloanVO> data = iInclusiveService.getEquickloanPage(causeStr);	       
	  
	        return ApiResult.ok("获取equickloan成功", data);
	    }
	 
	 
	 
	 @PostMapping(value = "/getCorploanPage", produces = "application/json;charset=utf-8")
	    public ApiResult getCorploanPage(@RequestBody InclusiveQueryPara filter) {
		 
		   String type = filter.getType();
		   String content = filter.getContent();
		   String startDate = filter.getStartDate();
		   String endDate = filter.getEndDate();
		   String causeStr = " a.marketcode=b.marketcode ";
		   if (null != startDate || null != endDate) {
				if (null==startDate||"".equals(startDate)) {
					startDate = "2020-04-01";
				} 
				if (null==endDate||"".equals(endDate)) {
					endDate = "2120-04-01";
				}
				startDate = startDate.substring(0,10).replaceAll("-", "");
				endDate = endDate.substring(0,10).replaceAll("-", "");
				causeStr += " and  indate between '"+startDate+ "' and '" +endDate+ "' ";
				
			}
		   
		    if(!"all".equals(type)) {
		    	causeStr += " and "+type+" = '"+content+"'";
		    }
	        PageHelper.startPage(filter.getPage(),filter.getLimit()); 
	        List<CorploanVO> data = iInclusiveService.getCorploanPage(causeStr);
	        PageInfo<CorploanVO> pageInfo = new PageInfo<CorploanVO>(data);
	        
	        return ApiResult.ok("获取系统管理 - 日志表列表分页成功", pageInfo);
	    }
	 
	
	 @PostMapping(value = "/getCorploanAll", produces = "application/json;charset=utf-8")
	    public ApiResult getCorploanAll(@RequestBody InclusiveQueryPara filter) {
		 
		   String type = filter.getType();
		   String content = filter.getContent();
		   String startDate = filter.getStartDate();
		   String endDate = filter.getEndDate();
		   String causeStr = " a.marketcode=b.marketcode ";
		   if (null != startDate || null != endDate) {
				if (null==startDate||"".equals(startDate)) {
					startDate = "2020-04-01";
				} 
				if (null==endDate||"".equals(endDate)) {
					endDate = "2120-04-01";
				}
				startDate = startDate.substring(0,10).replaceAll("-", "");
				endDate = endDate.substring(0,10).replaceAll("-", "");
				causeStr += " and  indate between '"+startDate+ "' and '" +endDate+ "' ";
			}
		   
		    if(!"all".equals(type)) {
		    	causeStr += " and "+type+" = '"+content+"'";
		    }
	        List<CorploanVO> data = iInclusiveService.getCorploanPage(causeStr);	       
	  
	        return ApiResult.ok("获取Corploan成功", data);
	    }
	
	 
	 
	 @PostMapping(value = "batchHousename", produces = "application/json;charset=utf-8")
		public ApiResult batchHousename(@RequestBody BatchExcelPara filter) {

			String username = filter.getUsername();
			List<Map<String, Object>> excelDataList = filter.getExcelData();

//			System.out.println(excelDataList.get(0).get("楼盘名称"));

            ArrayList<InclusiveHousename> arrayList = new ArrayList<InclusiveHousename>();
			for (int i = 0; i < excelDataList.size(); i++) {
				/*
				 * for (Map.Entry<String, Object> vo : excelDataList.get(i).entrySet()) { title
				 * = vo.getKey(); content = (String) vo.getValue();
				 * System.out.println(vo.getKey() + " " + vo.getValue()); }
				 */
				String housename = (String) excelDataList.get(i).get("楼盘名称");

				if (housename.length() > 100) {
					return ApiResult.fail(ResultCode.FAILURE.getCode(), "楼盘名称超过了100字的限制");
				}
				InclusiveHousename inclusiveHousename = new InclusiveHousename();
				arrayList.add(inclusiveHousename.setHousename(housename));

			}
			
			iInclusiveHousenameService.delete(null);
			
			iInclusiveHousenameService.insertBatch(arrayList);
			return ApiResult.ok(ResultCode.SUCCESS.getCode(), "保存成功", "保存成功");
		}
	 
	 @PostMapping(value = "batchManager", produces = "application/json;charset=utf-8")
		public ApiResult batchManager(@RequestBody BatchExcelPara filter) {

			String username = filter.getUsername();
			List<Map<String, Object>> excelDataList = filter.getExcelData();


         ArrayList<InclusiveManager> arrayList = new ArrayList<InclusiveManager>();
			for (int i = 0; i < excelDataList.size(); i++) {
				/*
				 * for (Map.Entry<String, Object> vo : excelDataList.get(i).entrySet()) { title
				 * = vo.getKey(); content = (String) vo.getValue();
				 * System.out.println(vo.getKey() + " " + vo.getValue()); }
				 */
				String branchname = (String) excelDataList.get(i).get("支行名称");
				String branchcode = (String) excelDataList.get(i).get("支行号");
				String networkname = (String) excelDataList.get(i).get("网点名称");
				String networkcode = (String) excelDataList.get(i).get("网点号");
				String name = (String) excelDataList.get(i).get("营销人员");
				String marketcode = (String) excelDataList.get(i).get("营销代码");

				InclusiveManager inclusiveManager = new InclusiveManager();
				
				inclusiveManager.setBranchname(branchname);
				inclusiveManager.setBranchcode(branchcode);
				inclusiveManager.setNetworkname(networkname);
				inclusiveManager.setNetworkcode(networkcode);
				inclusiveManager.setName(name);
				inclusiveManager.setMarketcode(marketcode);
				
				
				
				arrayList.add(inclusiveManager);

			}
			
			iInclusiveManagerService.delete(null);
			
			iInclusiveManagerService.insertBatch(arrayList);
			return ApiResult.ok(ResultCode.SUCCESS.getCode(), "保存成功", "保存成功");
		}

}

