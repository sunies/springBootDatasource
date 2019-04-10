package com.buegeon.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DynamicDataSourceAspect {
  /*  @Pointcut("@annotation(com.buegeon.config.DataSourceTarget)")
    public void dbPointCut() {
    }*/
    //这里可以配置成 @Before("dbPointCut()")
    @Before("@annotation(com.buegeon.config.DataSourceTarget)")
    @SuppressWarnings("rawtypes")
    public void beforeSwitchDS(JoinPoint point){
        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        String dataSource = DataSourceContextHolder.DEFAULT_DS;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@DataSourceTarget注解
            if (method.isAnnotationPresent(DataSourceTarget.class)) {
                DataSourceTarget annotation = method.getAnnotation(DataSourceTarget.class);
                // 取出注解中的数据源名
                dataSource = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 切换数据源
        DataSourceContextHolder.setDB(dataSource);
    }

    /**
     * 执行完切面后，将线程共享中的数据源名称清空
     * @param point
     */
    @After("@annotation(com.buegeon.config.DataSourceTarget)")
    public void afterSwitchDS(JoinPoint point){
        DataSourceContextHolder.clearDB();
    }
}