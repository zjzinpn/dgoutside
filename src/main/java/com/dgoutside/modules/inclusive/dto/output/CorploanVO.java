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
public class CorploanVO extends InclusiveCorploan {

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
