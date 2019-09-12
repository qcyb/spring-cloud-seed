package com.ycw.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.ycw.common.base.BaseVO;
import com.ycw.common.utils.BeanHandleUtils;

@Aspect
@Component
public class MapperAop {

	@Pointcut(value = "execution(public * com.ycw..*.mapper.*.query*(..))")
	private void queryMenthodPoint() {
	}

	@Pointcut(value = "execution(public * com.ycw..*.mapper.*.get*(..))")
	private void getMenthodPoint() {
	}

	/**
	 * @方法名称 process
	 * @功能描述
	 * @作者 yuminjun
	 * @创建时间 2019年9月12日 下午3:09:52
	 * @param point
	 * @return
	 * @throws Throwable
	 */
	@Around(value = "queryMenthodPoint() || getMenthodPoint()")
	public Object process(ProceedingJoinPoint point) throws Throwable {
		// 访问目标方法的参数：
		Object[] args = point.getArgs();
		if (args != null && args.length > 0 && args[0] instanceof BaseVO) {
			// 将VO对象转换成Map对象
			args[0] = BeanHandleUtils.beanToMap(args[0]);
		}

		// 用改变后的参数执行目标方法
		Object returnValue = point.proceed(args);

		return returnValue;
	}

}
