package com.ycw.user.vo.params;

import com.ycw.common.base.BaseVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserParamsVO extends BaseVO{

	private static final long serialVersionUID = 1L;

	/**
 	 *主键
 	 */
	private Integer id;

 	/**
 	 *用户编号
 	 */
	private String userNum;

 	/**
 	 *真实姓名
 	 */
	private String realName;

}
