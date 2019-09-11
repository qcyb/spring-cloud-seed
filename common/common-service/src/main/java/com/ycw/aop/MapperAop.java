package com.ycw.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.ycw.common.base.BaseVO;
import com.ycw.utils.BeanHandleUtils;

@Aspect
@Component
public class MapperAop {

	@Pointcut(value = "execution(public * com.ycw..*.mapper.*.query*(..))")
	private void queryMenthodPoint() {}

	@Pointcut(value = "execution(public * com.ycw..*.mapper.*.get*(..))")
	private void getMenthodPoint() {}

    @Around(value = "queryMenthodPoint() || getMenthodPoint()")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        //访问目标方法的参数：
        Object[] args = point.getArgs();
        if (args != null && args.length > 0 && args[0] instanceof BaseVO) {
        	args[0] = BeanHandleUtils.beanToMap(args[0]);
        }

        //用改变后的参数执行目标方法
        Object returnValue = point.proceed(args);
        return returnValue;
    }

}
