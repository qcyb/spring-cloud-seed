package com.ycw.user.mapper;

import java.util.List;

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
	 * @功能描述 <pre>【系统用户表】列表查询</pre>
	 * @作者    yuminjun
	 * @创建时间 2019/08/28 14:17
	 * @param params 查询参数<br>
	 * @param <T> VO参数对象
	 * @return
	 */
	<E, T> List<E> querySysUserList(T t);

}

