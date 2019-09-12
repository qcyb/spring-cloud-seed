package com.ycw.common.base;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;

public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableField("version")
	private Integer id;

	/**
	 * 删除标识：0-未删除；1-删除
	 */
	@TableField("del_ind")
	private Integer delInd;

	/**
	 * 创建人
	 */
	@TableField("create_user")
	private String createUser;

	/**
	 * 更新人
	 */
	@TableField("update_user")
	private String updateUser;

	/**
	 * 版本号
	 */
	@Version
	@TableField("version")
	private Integer version;

}
