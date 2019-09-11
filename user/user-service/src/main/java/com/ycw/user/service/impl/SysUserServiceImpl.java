package com.ycw.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycw.common.exception.MsgException;
import com.ycw.common.page.PageParams;
import com.ycw.common.response.ResponseVO;
import com.ycw.user.entity.SysUserEntity;
import com.ycw.user.mapper.ISysUserMapper;
import com.ycw.user.service.ISysUserService;
import com.ycw.user.vo.SysUserVO;
import com.ycw.user.vo.params.SysUserParamsVO;
import com.ycw.utils.BeanHandleUtils;

/**
 * @类名称 SysUserServiceImpl
 * @类描述 【系统用户表】Service接口实现类
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
@Service("sysUserService")
public class SysUserServiceImpl implements ISysUserService {

	@Autowired
	private ISysUserMapper sysUserMapper;

	/**
	 * @方法名称 querySysUserPage
	 * @功能描述  分页查询方法
	 * @作者     yuminjun
	 * @创建时间 2019年9月11日 下午5:59:14
	 * @param vo
	 * @param pageParams
	 * @return
	 */
	@Override
	public ResponseVO<PageInfo<SysUserParamsVO>> querySysUserPage(SysUserParamsVO vo, PageParams pageParams){
		List<SysUserParamsVO> list = sysUserMapper.querySysUserList(vo);
		return ResponseVO.success(new PageInfo<>(list));
	}

	/**
	 * @方法名称 getSysUser
	 * @功能描述  根据id查询用户
	 * @作者 yuminjun
	 * @创建时间 2019/08/28 14:17
	 * @param id 主键id
	 * @return
	 */
	@Override
	public ResponseVO<SysUserVO> getSysUser(Long id) {
		SysUserEntity sysUser = sysUserMapper.selectById(id);
		SysUserVO vo = BeanHandleUtils.beanCopy(sysUser, SysUserVO.class);
		return ResponseVO.success(vo);
	}

}
