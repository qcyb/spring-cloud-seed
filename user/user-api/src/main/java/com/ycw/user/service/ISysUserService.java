package com.ycw.user.service;

import com.ycw.common.exception.MsgException;
import com.ycw.common.response.ResponseVO;
import com.ycw.user.vo.SysUserVO;

/**
 * @类名称 SysUserService
 * @类描述 <pre>【系统用户表】Service接口</pre>
 * @作者 yuminjun
 * @创建时间 2019年08月28日
 * @版本 v1.00
 * @修改记录 <pre>
 * 版本     		修改人 	修改时间    	 	修改内容	描述
 * ----------------------------------------------
 * 1.00 	yuminjun     	2019年08月28日 	新建
 * ----------------------------------------------
 * </pre>
 */
public interface ISysUserService {

	/**
	 * @方法名称  getSysUser
	 * @功能描述 <pre>根据id查询【系统用户表】数据</pre>
	 * @作者    yuminjun
	 * @创建时间 2019/08/28 14:17
	 * @param id 主键id
	 * @return
	 * @throws MsgException
	 */ 
	ResponseVO<SysUserVO> getSysUser(Long id) throws MsgException;

}
