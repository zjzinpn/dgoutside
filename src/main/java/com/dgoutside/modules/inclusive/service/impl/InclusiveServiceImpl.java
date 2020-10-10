package com.dgoutside.modules.inclusive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.dgoutside.modules.inclusive.dto.output.CorploanVO;
import com.dgoutside.modules.inclusive.dto.output.EquickloanVO;
import com.dgoutside.modules.inclusive.entity.InclusiveEquickloan;
import com.dgoutside.modules.inclusive.mapper.InclusiveMapper;
import com.dgoutside.modules.inclusive.service.IInclusiveService;

@Service
public class InclusiveServiceImpl implements IInclusiveService{
	
	@Autowired
	InclusiveMapper inclusiveMapper;

	@Override
	public List<EquickloanVO> getEquickloanPage(String causeStr) {
		// TODO Auto-generated method stub
		
		return inclusiveMapper.selectEqucikloan(causeStr);
	}
	
	@Override
	public List<CorploanVO> getCorploanPage(String causeStr) {
		// TODO Auto-generated method stub
		
		return inclusiveMapper.selectCorploan(causeStr);
	}

}
