package com.yao.building.manage.web.aop;

import com.yao.building.manage.response.ResultBean;
import com.yao.building.manage.exception.BuildingException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

@Slf4j
/*@Aspect
@Component
@Order(1)*/
public class BuildingExceptionHandleAspect {
    public BuildingExceptionHandleAspect() {}

    @Pointcut("execution(* com.yao.building..*.*(..))")
    public void addAllServiceHandler() {}

    @Around("addAllServiceHandler()")
    public Object doServiceAspect(ProceedingJoinPoint joinPoint) {
        ResultBean resultBean = new ResultBean();
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String serviceName = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        log.info("########## Call Method {}.{} Begin args:{} ########## ", new Object[]{serviceName, methodName, args});
        Object result = null;
        StopWatch sw = new StopWatch();
        try{
            sw.start();
            result = joinPoint.proceed();
            resultBean.setData(result == null ? new Object() : result);
        }catch (BuildingException e){
            resultBean.setCode(e.getCode());
            resultBean.setMessage(e.getMessage());
        } catch (Throwable throwable) {
            resultBean.setCode("1000");
            resultBean.setMessage("系统异常");
        } finally {
            sw.stop();
            log.info("########## Call Method {}.{} End ########## Method {} takes {}ms result:{}", new Object[]{serviceName, methodName, methodName, sw.getTotalTimeMillis(), resultBean});
        }
        return resultBean;
    }
}
