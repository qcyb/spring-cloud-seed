package com.ycw.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ycw.common.response.ResponseVO;
import com.ycw.user.service.ISysUserService;
import com.ycw.user.vo.SysUserVO;

@RestController
@RequestMapping("/sys")
public class SysUserController {

	@Autowired
	private ISysUserService sysUserService;

	@GetMapping("/user")
	public ResponseVO<SysUserVO> getUser(Long id) throws Exception{
		return sysUserService.getSysUser(id);
	}

}
