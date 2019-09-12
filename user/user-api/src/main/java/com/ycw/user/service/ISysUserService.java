package com.ycw.user.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ycw.common.exception.MsgException;
import com.ycw.common.page.PageParams;
import com.ycw.common.response.ResponseVO;
import com.ycw.user.vo.SysUserVO;
import com.ycw.user.vo.params.SysUserParamsVO;

/**
 * @类名称 SysUserService
 * @类描述
 *
 *      <pre>
 * 【系统用户表】Service接口
 *      </pre>
 *
 * @作者 yuminjun
 * @创建时间 2019年08月28日
 * @版本 v1.00
 * @修改记录
 *
 *       <pre>
 * 版本     		修改人 	修改时间    	 	修改内容	描述
 * ----------------------------------------------
 * 1.00 	yuminjun     	2019年08月28日 	新建
 * ----------------------------------------------
 *       </pre>
 */
public interface ISysUserService {

	/**
	 * @方法名称 findSysUserList
	 * @功能描述 【系统用户表】分页查询
	 * @作者 yuminjun
	 * @创建时间 2019年9月9日 下午5:49:58
	 * @param vo         查询参数
	 * @param pageParams 分页参数
	 * @return
	 */
	ResponseVO<PageInfo<SysUserParamsVO>> querySysUserPage(SysUserParamsVO vo, PageParams pageParams);

	/**
	 * @方法名称 querySysUserList
	 * @功能描述 【系统用户表】列表查询
	 * @作者 yuminjun
	 * @创建时间 2019年9月12日 下午12:24:17
	 * @param vo 查询参数
	 * @return
	 */
	ResponseVO<List<SysUserParamsVO>> querySysUserList(SysUserParamsVO vo);

	/**
	 * @方法名称 getSysUser
	 * @功能描述 根据id查询【系统用户表】数据
	 * @作者 yuminjun
	 * @创建时间 2019/08/28 14:17
	 * @param id 主键id
	 * @return
	 * @throws MsgException
	 */
	ResponseVO<SysUserVO> getSysUser(Long id);

}
