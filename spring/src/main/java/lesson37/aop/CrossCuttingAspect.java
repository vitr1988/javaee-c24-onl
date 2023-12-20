package lesson37.aop;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

@Log4j
@Aspect
@Component
public class CrossCuttingAspect {

//    @Before("execution(* lesson37.service.impl.ReportServiceImpl.*(..))")
//    public void logBefore(JoinPoint point) {
//        CodeSignature methodSignature = (CodeSignature) point.getSignature();
//        log.info("Method started on " + point.getTarget() + " " + methodSignature.getName());
//    }
//
//    @After("execution(* lesson37.service.impl.ReportServiceImpl.*(..))")
//    public void logAfter(JoinPoint point) {
//        CodeSignature methodSignature = (CodeSignature) point.getSignature();
//        log.info("Method finished on " + point.getTarget() + " " + methodSignature.getName());
//    }

//    @Around("execution(* lesson37.service.impl.ReportServiceImpl.*(..))")
    public void logArround(ProceedingJoinPoint point) {
        CodeSignature methodSignature = (CodeSignature) point.getSignature();
        log.info("Method_ started on " + point.getTarget() + " " + methodSignature.getName());
        try {
            point.proceed();
        }
        catch (Throwable e) {
            log.error("Exception happens", e);
        }
        finally {
            log.info("Method_ finished on " + point.getTarget() + " " + methodSignature.getName());
        }
    }

    @Pointcut("execution(* lesson37.service.impl.ReportServiceImpl.*(..))")
    public void logArround2() {}
    @Before("logArround2()")
    public void beforeAnyRun(JoinPoint jointPoint){
        log.info("Before_ " + jointPoint.getClass().getName() + "." + jointPoint.getSignature().getName());
    }

    @After("logArround2()")
    public void afterAnyRun(JoinPoint jointPoint){
        log.info("After_ " + jointPoint.getClass().getName() + "." + jointPoint.getSignature().getName());
    }

}
