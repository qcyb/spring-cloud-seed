package com.ycw.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ycw.common.base.BaseController;
import com.ycw.common.page.PageParams;
import com.ycw.common.response.ResponseVO;
import com.ycw.user.service.ISysUserService;
import com.ycw.user.vo.SysUserVO;
import com.ycw.user.vo.params.SysUserParamsVO;

@RestController
@RequestMapping("/sys")
public class SysUserController extends BaseController{

	@Autowired
	private ISysUserService sysUserService;

	@GetMapping("/user/list")
	public ResponseVO<PageInfo<SysUserParamsVO>> findSysUserList(@RequestParam("params") SysUserParamsVO vo, @RequestParam("pageParams") PageParams pageParams){
		return sysUserService.querySysUserPage(vo, pageParams);
	}

	@GetMapping("/user")
	public ResponseVO<SysUserVO> getUser(Long id) {
		return sysUserService.getSysUser(id);
	}

}
