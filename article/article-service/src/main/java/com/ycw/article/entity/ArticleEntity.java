package com.ycw.article.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ycw.common.base.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @类名称 Article
 * @类描述 <pre>【文章表】实体类</pre>
 * @作者 yuminjun
 * @创建时间 2019年09月17日
 * @版本 v1.00
 * @修改记录 <pre>
 * 版本     		修改人 	修改时间    	 	修改内容	描述
 * ----------------------------------------------
 * 1.00 	yuminjun     	2019年09月17日 	新建
 * ----------------------------------------------
 * </pre>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("article")
public class ArticleEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

 	/**
 	 *标题
 	 */
	@TableField("title")
	private String title;

 	/**
 	 *简介
 	 */
	@TableField("introduction")
	private String introduction;

 	/**
 	 *分类
 	 */
	@TableField("article_type")
	private String articleType;

 	/**
 	 *作者
 	 */
	@TableField("author")
	private String author;

 	/**
 	 *发布时间
 	 */
	@TableField("publish_time")
	private LocalDateTime publishTime;

 	/**
 	 *内容
 	 */
	@TableField("content")
	private String content;

 	/**
 	 *是否展示
 	 */
	@TableField("is_show")
	private Integer isShow;

 	/**
 	 *阅读数
 	 */
	@TableField("read_count")
	private Integer readCount;

 	/**
 	 *喜欢数
 	 */
	@TableField("like_count")
	private Integer likeCount;

 	/**
 	 *不喜欢数
 	 */
	@TableField("unlike_count")
	private Integer unlikeCount;

}
