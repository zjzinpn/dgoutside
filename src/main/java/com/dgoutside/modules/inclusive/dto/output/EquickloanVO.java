package com.dgoutside.modules.inclusive.dto.output;

import com.dgoutside.modules.inclusive.entity.InclusiveCorploan;
import com.dgoutside.modules.inclusive.entity.InclusiveEquickloan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *  <p>  websocket消息内容 </p>
 *
 * @author：  dgoutside <br/>
 * @date：  2019/12/4$ 10:27$ <br/>
 * @version：  <br/>
 */
@Data
@ApiModel(description = "websocket消息内容")
public class EquickloanVO extends InclusiveEquickloan {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String branchname;
	private String branchcode;
	private String networkname;
	private String networkcode;
	
	
    
    
    
    
    
    


}
