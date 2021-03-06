package com.ycw.user.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ycw.common.base.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @类名称 SysUser
 * @类描述 <pre>【系统用户表】实体类</pre>
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
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
public class SysUserEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

 	/**
 	 *用户编号
 	 */
	private String userNum;

 	/**
 	 *真实姓名
 	 */
	private String realName;

 	/**
 	 *昵称
 	 */
	private String nickName;

 	/**
 	 *登录名
 	 */
	private String loginName;

 	/**
 	 *登录密码
 	 */
	private String password;

 	/**
 	 *盐
 	 */
	private String salt;

 	/**
 	 *头像url
 	 */
	private String profilePhotoUrl;

 	/**
 	 *性别
 	 */
	private Integer sex;

 	/**
 	 *生日
 	 */
	private LocalDateTime birthday;

 	/**
 	 *手机号
 	 */
	private String mobilePhone;

 	/**
 	 *电子邮箱
 	 */
	private String eMail;

 	/**
 	 *身份证号
 	 */
	private String idCard;

 	/**
 	 *QQ
 	 */
	private String qq;

 	/**
 	 *微信
 	 */
	private String wechat;

 	/**
 	 *登录token
 	 */
	private String token;

 	/**
 	 *状态：0-失效；1-生效
 	 */
	private Integer status;

 	/**
 	 *登录状态
 	 */
	private Integer loginStatus;

 	/**
 	 *最后登录时间
 	 */
	private LocalDateTime lastLoginTime;

}
