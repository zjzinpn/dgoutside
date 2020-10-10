package com.dgoutside.modules.inclusive.service;

import java.util.List;

import com.dgoutside.modules.inclusive.dto.output.CorploanVO;
import com.dgoutside.modules.inclusive.dto.output.EquickloanVO;


public interface IInclusiveService {

	
	
	List<EquickloanVO> getEquickloanPage(String causeStr);
	List<CorploanVO> getCorploanPage(String causeStr);
	
	
	
}
