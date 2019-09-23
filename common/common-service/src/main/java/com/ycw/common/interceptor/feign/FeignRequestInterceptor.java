package com.ycw.common.interceptor.feign;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * @类名称 FeignRequestInterceptor.java
 * @类描述 允许Feign使用@RequestParam注解传输POJO（POJO必须以lombok的注解重写toString方法）
 * @作者 yuminjun yuminjun@lexiangbao.com
 * @创建时间 2019年9月23日 上午10:36:53
 * @版本 1.00
 *
 * @修改记录
 * <pre>
 *     版本                       修改人 		修改日期 		 修改内容描述
 *     ----------------------------------------------
 *     1.00 	yuminjun 	2019年9月23日
 *     ----------------------------------------------
 * </pre>
 */
@Slf4j
@Component
public class FeignRequestInterceptor implements RequestInterceptor {

	@Resource
	private ObjectMapper objectMapper;

	@Override
	public void apply(RequestTemplate template) {
		/* 拦截GET方式请求 */
		if (!HttpMethod.GET.name().equals(template.method()) || null == template.queries()) {
			return;
		}

		Map<String, Collection<String>> queries = template.queries();// 原有请求参数
		Map<String, Collection<String>> newQueries = new HashMap<>();// 新的请求参数

		/* 解析原有请求参数，组装成新的请求参数 */
		for (Collection<String> param : queries.values()) {
			String paramsStr = StringUtils.substringBetween(param.iterator().next(), "(", ")");
			if (null == paramsStr || "".equals(paramsStr)) {
				continue;
			}
			try {
				paramsStr = URLDecoder.decode(paramsStr, "utf-8");
			} catch (UnsupportedEncodingException e) {
				log.error("\n参数feign请求参数decode失败");
			}
			// 特殊空格trim方法不能处理，此处采用replace方法去除空格
			String[] paramsArray = StringUtils.split(paramsStr.replaceAll(" ",""), ",");
			for (String s : paramsArray) {
				String key = StringUtils.substringBefore(s, "=");
				String value = StringUtils.substringAfter(s, "=");
				if ("null".equals(value) || "".equals(value) || null == value) {
					continue;
				}
				Collection<String> values = new ArrayList<>();
				values.add(value);
				newQueries.put(key, values);
			}
		}

		template.queries(null);// 将之前的查询参数置空
		template.queries(newQueries);// 设置新的查询参数
	}

}