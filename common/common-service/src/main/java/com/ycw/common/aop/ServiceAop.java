package com.ycw.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.ycw.common.page.PageParams;

@Aspect
@Component
public class ServiceAop {

	@Pointcut(value = "execution(public * com.ycw..*.service.impl.*.query*(..))")
	private void queryMenthodPoint() {
	}

	@Around(value = "queryMenthodPoint()")
	public Object process(ProceedingJoinPoint point) throws Throwable {
		// 访问目标方法的参数
		Object[] args = point.getArgs();
		if (args != null && args.length > 0) {
			for (int i = args.length - 1; i >= 0; i--) {
				// 设置分页参数
				if (args[i] instanceof PageParams) {
					PageParams pageParams = (PageParams) args[i];
					PageHelper.startPage(pageParams.getPageNum(), pageParams.getPageSize());
					break;
				}
			}
		}

		// 用改变后的参数执行目标方法
		Object returnValue = point.proceed(args);

		return returnValue;
	}

}
