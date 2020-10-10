package com.dgoutside.modules.common.multipleselect.service;
 
 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dgoutside.modules.common.multipleselect.MultipleResult;
import com.dgoutside.modules.common.multipleselect.MultipleSelect;
import com.dgoutside.modules.common.multipleselect.mapper.MultipleMapper;

 
@Service
public class MultipleService {
	@Resource
	private MultipleMapper mapper;

    public MultipleResult mulSelect(MultipleSelect param) {
    	MultipleResult result = new MultipleResult();
    	List<Map<String, Object>> data = mapper.mulSelect(param);
    	result.setData(data);
    	
    	if (param.getStart() != null && param.getEnd() != null) {
    		Integer total = mapper.countMulSelect(param);
    		result.setPageNo(param.getStart() / param.getEnd() + 1);
    		result.setPageSize(param.getEnd());
    		result.setTotal(total);
    	}
    	
    	return result;
    	 
    }
}
