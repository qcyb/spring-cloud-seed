package com.ycw.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ycw.article.service.ArticleService;
import com.ycw.article.vo.ArticleListVO;
import com.ycw.article.vo.param.ArticleListParamVO;
import com.ycw.common.page.PageParams;
import com.ycw.common.response.ResponseVO;

@RestController
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	/**
	 * @方法名称 queryArticlePage
	 * @功能描述 <pre>【文章表】分页查询</pre>
	 * @作者    yuminjun
	 * @创建时间 2019/09/17 10:00
	 * @param articleQueryParams 查询参数
	 * @return
	 */
	@GetMapping(value = "/list")
	public ResponseVO<PageInfo<ArticleListVO>> queryArticleList(ArticleListParamVO vo, PageParams pageParams) {
		return articleService.queryArticleList(vo, pageParams);
	}

}
