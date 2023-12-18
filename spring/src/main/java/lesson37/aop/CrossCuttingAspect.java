package lesson37.aop;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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

    @Around("execution(* lesson37.service.impl.ReportServiceImpl.*(..))")
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
    public void logArround2(ProceedingJoinPoint point) {
        CodeSignature methodSignature = (CodeSignature) point.getSignature();
        log.info("Method started on " + point.getTarget() + " " + methodSignature.getName());
        try {
            point.proceed();
        }
        catch (Throwable e) {
            log.error("Exception happens", e);
        }
        finally {
            log.info("Method finished on " + point.getTarget() + " " + methodSignature.getName());
        }
    }
}
