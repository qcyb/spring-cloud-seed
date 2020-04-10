package com.ycw.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.filter.logging.Slf4jLogFilter;

@Configuration
public class LogConfig {

	@Bean
	public Slf4jLogFilter slf4jLogFilter(){
		Slf4jLogFilter slf4jLogFilter = new Slf4jLogFilter();
		slf4jLogFilter.setConnectionLogEnabled(Boolean.FALSE);
		slf4jLogFilter.setStatementLogEnabled(Boolean.TRUE);
		slf4jLogFilter.setStatementExecuteAfterLogEnabled(Boolean.FALSE);
		slf4jLogFilter.setResultSetLogEnabled(Boolean.TRUE);
		slf4jLogFilter.setStatementExecutableSqlLogEnable(Boolean.TRUE);
		return slf4jLogFilter;
	}

}
