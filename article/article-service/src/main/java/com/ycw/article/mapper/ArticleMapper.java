package com.ycw.article.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ycw.article.entity.ArticleEntity;
import com.ycw.common.base.BaseCrudMapper;


/**
 * @类名称 ArticleMapper
 * @类描述 <pre> 【文章表】Mapper接口</pre>
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
@Mapper
public interface ArticleMapper extends BaseCrudMapper<ArticleEntity> {

	/**
	 * @方法名称 queryArticlePage
	 * @功能描述 <pre>【文章表】列表查询</pre>
	 * @作者    yuminjun
	 * @创建时间 2019/09/17 10:00
	 * @param pageParams 分页参数<br>
	 * @return
	 */
	<E, T> List<E> queryArticleList(T t);

}

