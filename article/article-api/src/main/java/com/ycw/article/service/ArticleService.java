package com.ycw.article.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.ycw.article.vo.ArticleListVO;
import com.ycw.article.vo.param.ArticleListParamVO;
import com.ycw.article.vo.param.UserArticleListParamVO;
import com.ycw.common.page.PageParams;
import com.ycw.common.response.ResponseVO;

/**
 * @类名称 ArticleService
 * @类描述 <pre>【文章表】Service接口</pre>
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
public interface ArticleService {

	/**
	 * @方法名称 queryArticlePage
	 * @功能描述 <pre>查询用户的文章列表</pre>
	 * @作者    yuminjun
	 * @创建时间 2019/09/17 10:00
	 * @param articleQueryParams 查询参数
	 * @return
	 */
	@GetMapping(value = "/article/user-article/list")
	ResponseVO<PageInfo<ArticleListVO>> queryUserArticleList(@RequestParam UserArticleListParamVO vo, @RequestParam PageParams pageParams);

}
