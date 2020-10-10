package com.dgoutside.modules.inclusive.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class BatchExcelPara  {

	private String username;
	private List<Map<String,Object>> excelData;
	
	
}
