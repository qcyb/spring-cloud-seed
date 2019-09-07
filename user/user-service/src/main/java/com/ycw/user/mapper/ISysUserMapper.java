package com.ycw.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ycw.common.base.BaseCrudMapper;
import com.ycw.user.entity.SysUserEntity;

/**
 * @类名称 SysUserMapper
 * @类描述 <pre> 【系统用户表】Mapper接口</pre>
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
@Mapper
public interface ISysUserMapper extends BaseCrudMapper<SysUserEntity> {

	/**
	 * @方法名称 querySysUserPage
	 * @功能描述 <pre>【系统用户表】分页查询</pre>
	 * @作者    yuminjun
	 * @创建时间 2019/08/28 14:17
	 * @param pageParams 分页参数<br>
	 * @return
	*         id：主键<br>
	*         userNum：用户编号<br>
	*         realName：真实姓名<br>
	*         nickName：昵称<br>
	*         loginName：登录名<br>
	*         password：登录密码<br>
	*         salt：盐<br>
	*         profilePhotoUrl：头像url<br>
	*         sex：性别<br>
	*         birthday：生日<br>
	*         mobilePhone：手机号<br>
	*         eMail：电子邮箱<br>
	*         idCard：身份证号<br>
	*         qq：QQ<br>
	*         wechat：微信<br>
	*         token：登录token<br>
	*         status：状态：0-失效；1-生效<br>
	*         loginStatus：登录状态<br>
	*         lastLoginTime：最后登录时间<br>
	*         delInd：删除标识：0-未删除；1-删除<br>
	*         createUser：创建人<br>
	*         createTime：创建时间<br>
	*         updateUser：更新人<br>
	*         updateTime：更新时间<br>
	*         version：版本号<br>
	 */
//	IPage<SysUserListVO> querySysUserPage(Pagination<PageableQueryParams> pageParams,
//			@Param("params") SysUserQueryParams sysUserQueryParams);

}

