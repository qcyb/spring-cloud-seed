package com.ycw.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.ycw.common.exception.MsgException;
import com.ycw.common.response.ResponseCode;

public class BeanHandleUtils extends BeanUtils {

	/**
	 * @方法名称 beanCopy
	 * @功能描述 bean转换方法
	 * @作者     yuminjun
	 * @创建时间 2019年8月29日 下午6:00:11
	 * @param <T>
	 * @param source
	 * @param targetBean
	 * @return
	 * @throws MsgException
	 */
	public static <T> T beanCopy(Object source, Class<T> targetBean) throws MsgException {
		if (null == source)
			return null;
		T target = null;
		try {
			target = targetBean.newInstance();
			copyProperties(source, target);
		} catch (InstantiationException | IllegalAccessException e) {
			throw new MsgException(ResponseCode.ERR_500.getCode(),
					"bean转换异常：【" + source.getClass().getName() + "】转换成【" + targetBean.getName() + "】失败", e);
		}
		return target;
	}

	/**
	 * @方法名称 mapToBean
	 * @功能描述 map转换成bean方法
	 * @作者     yuminjun
	 * @创建时间 2019年8月30日 下午1:54:54
	 * @param <T>
	 * @param map
	 * @param targetBean
	 * @return
	 * @throws MsgException
	 */
	public static <T> T mapToBean(Map<String, Object> map, Class<T> targetBean) throws MsgException {
		if (map == null)
			return null;
		T obj = null;
		try {
			obj = targetBean.newInstance();
			org.apache.commons.beanutils.BeanUtils.populate(obj, map);
		} catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
			throw new MsgException(ResponseCode.ERR_500.getCode(),
					"map转换异常：【" + map.getClass().getName() + "】转换成【" + targetBean.getName() + "】失败", e);
		}
		return obj;
	}

	/**
	 * @方法名称 beanToMap
	 * @功能描述 bean转换成map方法
	 * @作者     yuminjun
	 * @创建时间 2019年8月30日 下午1:55:26
	 * @param source
	 * @return
	 */
	public static Map<Object, Object> beanToMap(Object source) {
		if (source == null)
			return null;
		return new org.apache.commons.beanutils.BeanMap(source);
	}
}
