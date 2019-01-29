package com.xiudoua.micro.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月24日 下午1:47:09
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public class CopyPropertiesUtil {

	private CopyPropertiesUtil() {
    }

    /**
     * 获取对象中null属性名数组列表
     * 
     * @param source
     * @return
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null)
                emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
	
}