package com.ycw.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ycw.common.base.BaseController;
import com.ycw.common.page.PageParams;
import com.ycw.common.response.ResponseVO;
import com.ycw.user.service.ISysUserService;
import com.ycw.user.vo.SysUserVO;
import com.ycw.user.vo.params.SysUserParamsVO;

/**
 * @类名称 SysUserController.java
 * @类描述 用户信息Controller
 * @作者 yuminjun yuminjun@lexiangbao.com
 * @创建时间 2019年9月12日 下午12:19:16
 * @版本 1.00
 *
 * @修改记录
 *
 *       <pre>
 *     版本                       修改人 		修改日期 		 修改内容描述
 *     ----------------------------------------------
 *     1.00 	yuminjun 	2019年9月12日
 *     ----------------------------------------------
 *       </pre>
 */
@RestController
@RequestMapping("/sys")
public class SysUserController extends BaseController {

	@Autowired
	private ISysUserService sysUserService;

	/**
	 * @方法名称 findSysUserList
	 * @功能描述 用户信息分页查询
	 * @作者 yuminjun
	 * @创建时间 2019年9月12日 下午12:18:17
	 * @param vo
	 * @param pageParams
	 * @return
	 */
	@GetMapping("/user/list")
	public ResponseVO<PageInfo<SysUserParamsVO>> findSysUserList(SysUserParamsVO vo, PageParams pageParams) {
		return sysUserService.querySysUserPage(vo, pageParams);
	}

	/**
	 * @方法名称 getzzUser
	 * @功能描述 获取用户基本
	 * @作者 yuminjun
	 * @创建时间 2019年9月12日 下午12:20:28
	 * @param id
	 * @return
	 */
	@GetMapping("/user")
	public ResponseVO<SysUserVO> getSysUser(Long id) {
		return sysUserService.getSysUser(id);
	}

}
