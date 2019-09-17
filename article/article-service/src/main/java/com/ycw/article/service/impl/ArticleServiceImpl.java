package com.ycw.article.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.ycw.article.mapper.ArticleMapper;
import com.ycw.article.service.ArticleService;
import com.ycw.article.vo.ArticleListVO;
import com.ycw.article.vo.param.ArticleListParamVO;
import com.ycw.common.page.PageParams;
import com.ycw.common.response.ResponseVO;

/**
 * @类名称 ArticleServiceImpl
 * @类描述 <pre>【文章表】Service接口实现类</pre>
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
@Service("articleService")
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleMapper articleMapper;

	/**
	 * @方法名称 queryArticlePage
	 * @功能描述 <pre>【文章表】分页查询</pre>
	 * @作者    yuminjun
	 * @创建时间 2019/09/17 10:00
	 * @param articleQueryParams 查询参数
	 * @return
	 */
	@Override
	public ResponseVO<PageInfo<ArticleListVO>> queryArticleList(ArticleListParamVO vo, PageParams pageParams) {
		List<ArticleListVO> list = articleMapper.queryArticleList(vo);
		return ResponseVO.success(new PageInfo<>(list));
	}

}

