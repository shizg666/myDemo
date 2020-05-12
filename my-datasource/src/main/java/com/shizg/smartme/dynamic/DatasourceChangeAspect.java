package com.shizg.smartme.dynamic;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @author
 * @version V1.0
 * @Title: DatasourceChangeAspect
 * @Description: 数据源切换切面
 * @date 2017/8/8 14:46
 */
@Aspect
public class DatasourceChangeAspect {

    /**
     * 根据注解上指定的数据源类型切换数据源
     * @param joinPoint
     * @return
     * @throws Throwable
     * @author
     * @date 2017年08月08日15:04:28
     */
    @Around("@annotation(com.shizg.smartme.dynamic.AnotherDatasource)")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            //获取目标类
            Class<?> targetClazz = joinPoint.getTarget().getClass();
            //获取执行的方法名
            String methodName = joinPoint.getSignature().getName();
            //获取此方法的参数列表
            Class<?>[] par = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
            //获取到实际执行的方法
            Method objMethod = targetClazz.getMethod(methodName, par);
            //从执行的方法上获取注解
            AnotherDatasource annotation = objMethod.getAnnotation(AnotherDatasource.class);
            if (annotation != null) {
                //将注解上指定的数据源类型读取到
                String datasourceType = annotation.value();
                //设置当前处理的数据源类型为注解上指定的
                ContextDatasourceTypeHolder.setDatasourceType(datasourceType);
            }
            Object result = joinPoint.proceed();
            return result;
        } finally {
            ContextDatasourceTypeHolder.clearDatasourceType();
        }
    }

}