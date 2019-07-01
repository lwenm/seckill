package com.blackface.seckill.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;

/**
 * Author:lwenm
 * Description:
 * Date:2018/12/26
 * Time:15:39
 **/

@Component
@Aspect
@Slf4j
public class LogAspectConfiguration {
    String controllerName;
    String method;

    /**
     * 切点
     */
    @Pointcut("execution(public * com.blackface.seckill.controller.*.*(..))") //建立切点并标注范围
    public void webLog() {

    }

    /**
     * 进入前
     * @param joinPoint
     */
    @Before("webLog()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        log.info("url={}", request.getRequestURL());

        //method
        log.info("method={}", request.getMethod());

        //ip
        log.info("ip={}", request.getRemoteAddr());

        //反射获取目标类的全名
        try {
            controllerName = joinPoint.getTarget().getClass().getName();//通过目标类反射获取目标类的全名
            controllerName = controllerName.substring(controllerName.lastIndexOf(".") + 1,
                    controllerName.length());//截取全名 获得当前包的类名
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        //利用路径查找处理的方法
        method = request.getRequestURL().toString();
        if (method.endsWith("html")) {
            method = method.substring(method.lastIndexOf("/") + 1, method.lastIndexOf("."));
        } else {
            method = method.substring(method.lastIndexOf("/") + 1, method.length());
        }
        log.info("准备进入" + controllerName + "类下" + method + "方法");
        //获取请求的所有参数
        Object[] objects = joinPoint.getArgs();
        for (Object obj : objects) {
            //去除参数中的LinkedHashMap
            if (obj instanceof LinkedHashMap) {
                continue;
            }
            if (obj != null) {
                //将对象转成json格式 并进行日志的打印
//                String result = "";
                //                log.info("请求" + controllerName + "类下" + method + "方法的参数为;" + result);
                log.info("***********" + method + "方法的参数  ; " + obj);
            }
        }
    }

    //    //返回通知
    //    @AfterReturning(value = "webLog()",returning = "retVal" )
    //    public void after(JoinPoint joinPoint,Object retVal) {
    //        log.info("已经完成"+controllerName+"类下"+method+"方法的调用");
    //        //反射获取类加载器加载的目标对象类
    //        Class objectClass = joinPoint.getTarget().getClass();
    //        //反射获取目标对象所有的可见方法
    //        Method[] methods = objectClass.getDeclaredMethods();
    //        Method methodReal = null;
    //        //前提你映射的mapper和类名必须保持一致 才可判断类型
    //        for (Method classMethod : methods) {
    //            if (classMethod.getName().equals(method)) {
    //                methodReal = classMethod;
    //                break;
    //            }
    //        }
    //        Object object = methodReal.getAnnotation(RestController.class);
    //        //判断是否是responsebody标签注解的类
    //        if(object!=null){
    //            //存在repsonsebody注解 则直接进行将整个放回值进行打印
    //            String result = JSON.toJSONString(retVal);
    //        }else{
    //            //不存在，则将model里面的所有参数进行打印
    //            Object[] objects = joinPoint.getArgs();
    //            for(Object obj:objects){
    //                if(obj instanceof LinkedHashMap){
    //                    Iterator interator = ((LinkedHashMap) obj).keySet().iterator();
    //                    while(interator.hasNext()){
    //                        Object key = interator.next();
    //                        //判断是否为验证对象
    //                        if(key.toString().contains("BindingResult")){
    //                            continue;
    //                        }
    //                        Object value = ((LinkedHashMap) obj).get(key);
    //                        //如果放回值包含list 则进行list的json转化
    //                        if(value instanceof List){
    //                            String arrayResult = JSON.toJSONString(value);
    //                            log.info("请求完成后"+controllerName+"类下"+method+"方法的返回参数为;"+arrayResult);
    //                        }else{
    //                            String result = JSON.toJSONString(value);
    //                            log.info("请求完成后"+controllerName+"类下"+method+"方法的返回参数为;"+result);
    //                        }
    //
    //                    }
    //                }
    //            }
    //        }
    //    }

    /**
     * 返回
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "webLog()")
    public void doAfterReturning(Object object) {
        log.info("********** 请求响应内容 ： {}", JSON.toJSONString(object));
    }

}
