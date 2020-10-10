package com.dgoutside.modules.common.multipleselect.mapper;
 
import java.util.List;
import java.util.Map;

import com.dgoutside.modules.common.multipleselect.MultipleSelect;

 

public interface MultipleMapper{
    public List<Map<String, Object>> mulSelect(MultipleSelect param);
    public Integer countMulSelect(MultipleSelect param);
}
