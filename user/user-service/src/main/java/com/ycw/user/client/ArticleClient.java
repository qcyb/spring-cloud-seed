package com.ycw.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import com.ycw.article.service.ArticleService;
import com.ycw.user.fallback.ArticleFallback;

@FeignClient(name = "blog-article", fallback = ArticleFallback.class)
public interface ArticleClient extends ArticleService {

}
