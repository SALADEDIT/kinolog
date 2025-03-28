package ru.salad.ws.kinolog.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class FindByIDAspect {
    @Pointcut("execution(public * ru.salad.ws.kinolog.service.ActorService.findById(*))")
    public void actorFindByIdAspect() {
    }

    @Pointcut("execution(public * ru.salad.ws.kinolog.service.ContentService.findById(*))")
    public void contentFindByIdAspect() {
    }

    @After("actorFindByIdAspect()")
    public void addLoggingForActor(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            log.info("After actorFindById method. ID: {}", args[0]);
        } else {
            log.info("After actorFindById method. No ID provided.");
        }
    }

    @After("contentFindByIdAspect()")
    public void addLoggingForContent(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            log.info("After contentFindById method. ID: {}", args[0]);
        } else {
            log.info("After contentFindById method. No ID provided.");
        }
    }

}
