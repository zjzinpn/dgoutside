package com.dgoutside.modules.inclusive.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.dgoutside.modules.inclusive.dto.output.CorploanVO;
import com.dgoutside.modules.inclusive.dto.output.EquickloanVO;
import com.dgoutside.modules.inclusive.entity.InclusiveEquickloan;
import com.dgoutside.modules.inclusive.entity.InclusiveManager;

public interface InclusiveMapper extends BaseMapper<EquickloanVO>{
	
	
//	@Select("SELECT a.*,b.branchname,b.networkname,b.name FROM inclusive_equickloan a "
//			+ "LEFT JOIN inclusive_manager b ON a.marketcode = b.marketcode "
//			+ "where b.branchname=#{content}"
//			+ " and ")  
//	List<EquickloanVO> getEquickloanPageByBranchname(Page<InclusiveEquickloan> page,@Param("content") String content);

	
	
	
	@SelectProvider(type = EqucikloanSQLBuilder.class,method = "selectEqucikloanSql")
	List<EquickloanVO> selectEqucikloan(String causeStr);
	class EqucikloanSQLBuilder{
	    public static String selectEqucikloanSql(String causeStr) {
		  return new SQL() {{
		    SELECT("a.*,b.branchname as branchname,b.networkname as networkname,b.name as name");
		    FROM(" inclusive_equickloan a,inclusive_manager b ");
		    WHERE(causeStr);		    
		    ORDER_BY("a.indate");		    
		  }}.toString();
		}
	}
	
	
	@SelectProvider(type = CorploanSQLBuilder.class,method = "selectCorploanSql")
	List<CorploanVO> selectCorploan(String causeStr);
	class CorploanSQLBuilder{
	    public static String selectCorploanSql(String causeStr) {
		  return new SQL() {{
		    SELECT("a.*,b.branchname as branchname,b.networkname as networkname,b.name as name");
		    FROM(" inclusive_corploan a,inclusive_manager b ");
		    WHERE(causeStr);		    
		    ORDER_BY("a.indate");		    
		  }}.toString();
		}
	}
	

}
