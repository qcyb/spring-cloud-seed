package com.ycw.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ycw.common.base.BaseController;
import com.ycw.common.page.PageParams;
import com.ycw.common.response.ResponseVO;
import com.ycw.user.service.ISysUserService;
import com.ycw.user.vo.SysUserDetailVO;
import com.ycw.user.vo.SysUserListVO;
import com.ycw.user.vo.param.SysUserListParamVO;
import com.ycw.user.vo.param.SysUserParamVO;

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
	 * @方法名称 findSysUserPage
	 * @功能描述 用户信息分页查询
	 * @作者 yuminjun
	 * @创建时间 2019年9月12日 下午12:18:17
	 * @param vo         查询参数
	 * @param pageParams 分页参数(为null时查询所有)
	 * @return
	 */
	@GetMapping("/user/list")
	public ResponseVO<PageInfo<SysUserListVO>> findSysUserPage(SysUserListParamVO vo, PageParams pageParams) {
		return sysUserService.querySysUserList(vo, pageParams);
	}

	/**
	 * @方法名称 getSysUser
	 * @功能描述 获取用户基本
	 * @作者 yuminjun
	 * @创建时间 2019年9月12日 下午12:20:28
	 * @param id
	 * @return
	 */
	@GetMapping("/user")
	public ResponseVO<SysUserDetailVO> getSysUser(Long id) {
		return sysUserService.getSysUser(id);
	}

	/**
	 * @方法名称 saveOrUpdateSysUser
	 * @功能描述 保存/修改用户数据
	 * @作者 yuminjun
	 * @创建时间 2019年9月16日 上午10:25:18
	 * @param vo
	 * @return
	 */
	@PostMapping("/user")
	public ResponseVO<Long> saveOrUpdateSysUser(SysUserParamVO vo) {
		Long id = vo.getId();
		if (null == id) {
			return sysUserService.saveSysUser(vo);
		} else {
			return sysUserService.updateSysUser(vo);
		}
	}

	/**
	 * @方法名称 deleteSysUser
	 * @功能描述 删除【系统用户表】数据
	 * @作者 yuminjun
	 * @创建时间 2019年9月16日 上午10:53:11
	 * @param id
	 * @return
	 */
	@DeleteMapping("/user")
	public ResponseVO<String> deleteSysUser(Long id) {
		return sysUserService.deleteSysUser(id);
	}
}
