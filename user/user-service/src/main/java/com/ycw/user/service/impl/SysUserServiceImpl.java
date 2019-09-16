package com.ycw.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.ycw.common.page.PageParams;
import com.ycw.common.response.ResponseVO;
import com.ycw.common.utils.BeanHandleUtils;
import com.ycw.user.entity.SysUserEntity;
import com.ycw.user.mapper.ISysUserMapper;
import com.ycw.user.service.ISysUserService;
import com.ycw.user.vo.SysUserDetailVO;
import com.ycw.user.vo.SysUserListVO;
import com.ycw.user.vo.param.SysUserListParamVO;
import com.ycw.user.vo.param.SysUserParamVO;

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

	@Override
	public ResponseVO<PageInfo<SysUserListVO>> querySysUserList(SysUserListParamVO vo, PageParams pageParams) {
		List<SysUserListVO> list = sysUserMapper.querySysUserList(vo);
		return ResponseVO.success(new PageInfo<>(list));
	}

	@Override
	public ResponseVO<SysUserDetailVO> getSysUser(Long id) {
		SysUserEntity sysUser = sysUserMapper.selectById(id);
		SysUserDetailVO vo = BeanHandleUtils.beanCopy(sysUser, SysUserDetailVO.class);
		return ResponseVO.success(vo);
	}

	@Override
	public ResponseVO<Long> saveSysUser(SysUserParamVO vo) {
		SysUserEntity sysUser = BeanHandleUtils.beanCopy(vo, SysUserEntity.class);
		sysUserMapper.insert(sysUser);
		return ResponseVO.success(sysUser.getId(), "新增成功");
	}

	@Override
	public ResponseVO<Long> updateSysUser(SysUserParamVO vo) {
		SysUserEntity sysUser = BeanHandleUtils.beanCopy(vo, SysUserEntity.class);
		sysUserMapper.updateById(sysUser);
		return ResponseVO.success(sysUser.getId(), "修改成功");
	}

	@Override
	public ResponseVO<String> deleteSysUser(Long id) {
		sysUserMapper.deleteById(id);
		return ResponseVO.success(null, "删除成功");
	}

}
