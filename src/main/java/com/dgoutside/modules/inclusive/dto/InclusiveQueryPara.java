package com.dgoutside.modules.inclusive.dto;

import com.dgoutside.modules.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 *
 * @author: dgoutside
 * @description:
 * @date: 2019-08-19
 */
@Data
public class InclusiveQueryPara extends BasePageQuery{

	

    private String username;
    private String type;
    private String content;
    private String startDate;
    private String endDate;


}
