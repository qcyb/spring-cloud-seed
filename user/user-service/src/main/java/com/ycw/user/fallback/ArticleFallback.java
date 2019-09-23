package com.ycw.user.fallback;

import org.springframework.stereotype.Component;

import com.github.pagehelper.PageInfo;
import com.ycw.article.vo.ArticleListVO;
import com.ycw.article.vo.param.UserArticleListParamVO;
import com.ycw.common.page.PageParams;
import com.ycw.common.response.ResponseVO;
import com.ycw.user.client.ArticleClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ArticleFallback implements ArticleClient{

	@Override
	public ResponseVO<PageInfo<ArticleListVO>> queryUserArticleList(UserArticleListParamVO vo, PageParams pageParams) {
		log.error("\n调用远程服务查询用户文章列表失败");
		return ResponseVO.success(null, "调用远程服务查询用户文章列表失败");
	}

}
