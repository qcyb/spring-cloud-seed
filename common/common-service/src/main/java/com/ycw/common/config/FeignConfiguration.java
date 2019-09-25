package com.ycw.common.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import feign.Logger;

@Configuration
public class FeignConfiguration {

	@Bean
	Logger.Level feignLoggerLevel() {
		// 这里记录所有，根据实际情况选择合适的日志level
		return Logger.Level.FULL;
	}

	@Bean
	public ResponseEntityDecoder feignDecoder() {
		ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(createFastJsonConverter());
		return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
	}

	@Bean
	public SpringEncoder feignEncoder() {
		ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(createFastJsonConverter());
		return new SpringEncoder(objectFactory);
	}

	private HttpMessageConverter createFastJsonConverter() {

		// 创建fastJson消息转换器
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

		/* 增加媒体类型 */
		List<MediaType> supportedMediaTypes = new ArrayList<>();
		supportedMediaTypes.add(MediaType.APPLICATION_JSON);
		supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
		supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
		supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
		supportedMediaTypes.add(MediaType.APPLICATION_PDF);
		supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
		supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
		supportedMediaTypes.add(MediaType.APPLICATION_XML);
		supportedMediaTypes.add(MediaType.IMAGE_GIF);
		supportedMediaTypes.add(MediaType.IMAGE_JPEG);
		supportedMediaTypes.add(MediaType.IMAGE_PNG);
		supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
		supportedMediaTypes.add(MediaType.TEXT_HTML);
		supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
		supportedMediaTypes.add(MediaType.TEXT_PLAIN);
		supportedMediaTypes.add(MediaType.TEXT_XML);
		fastConverter.setSupportedMediaTypes(supportedMediaTypes);

		/* 创建配置类 */
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		// 修改配置返回内容的过滤
		// WriteNullListAsEmpty ：List字段如果为null,输出为[],而非null
		// WriteNullStringAsEmpty ： 字符类型字段如果为null,输出为"",而非null
		// DisableCircularReferenceDetect ：消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
		// WriteNullBooleanAsFalse：Boolean字段如果为null,输出为false,而非null
		// WriteMapNullValue：是否输出值为null的字段,默认为false
		fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteMapNullValue);
		fastConverter.setFastJsonConfig(fastJsonConfig);

		return fastConverter;
	}

}
