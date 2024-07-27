package ar.com.laboratory.candidatesapi.infrastructure.util.aop;



import ar.com.laboratory.candidatesapi.infrastructure.util.annotations.CommonsLogging;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Aspect
@Slf4j
public class Aspects {

    //PUNTO DE CORTE EN ANNOTATION
    @Pointcut("@annotation( ar.com.laboratory.candidatesapi.infrastructure.util.annotations.CommonsLogging)")
    public void allResources(){}

    //CONSEJOS
    @Around("allResources()")
    public Object requestLog(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNames = methodSignature.getParameterNames();
        Object[] parameterValues = joinPoint.getArgs();
        CommonsLogging commonsLogging = methodSignature.getMethod().getAnnotation(CommonsLogging.class);
        String tag = commonsLogging.tag();
        String type = commonsLogging.type();
        String path = commonsLogging.path();
        StringBuilder logInfo = new StringBuilder();
        logInfo.append("\n");
        logInfo.append("\n------ REQUEST ").append(tag).append(" ------");
        if (path != null && !path.isEmpty()) {
            logInfo.append("\nPath: ").append(path);
        }
        if (type != null && !type.isEmpty()) {
            logInfo.append("\nType: ").append(type);}
        logInfo.append("\nClass: ".concat(joinPoint.getSignature().getDeclaringTypeName()));
        logInfo.append("\nMethod: ".concat(joinPoint.getSignature().getName()));
        logInfo.append("\n");
        logInfo.append("\nArguments: ");
        for (int i = 0; i < parameterNames.length; i++) {
            logInfo.append("\n").append(parameterNames[i]).append(" : ").append(parameterValues[i]);
        }
        logInfo.append("\n------ REQUEST ").append(tag).append("-END ------\n");
        logInfo.append("\n");
        log.info(logInfo.toString());
        return joinPoint.proceed();
    }

    @AfterReturning(pointcut ="allResources()", returning="response")
    public void responseLog(JoinPoint jp, Object response){
        StringBuilder logInfo = new StringBuilder();
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        CommonsLogging commonsLogging = methodSignature.getMethod().getAnnotation(CommonsLogging.class);
        String tag = commonsLogging.tag();
        String type = commonsLogging.type();
        String path = commonsLogging.path();
        logInfo.append("\n");
        logInfo.append("\n------ RESPONSE ").append(tag).append(" ------");
        if (path != null && !path.isEmpty()) {
            logInfo.append("\nPath: ").append(path);
        }
        if (type != null && !type.isEmpty()) {
            logInfo.append("\nType: ").append(type);}
        logInfo.append("\nClass: ".concat(jp.getSignature().getDeclaringTypeName()));
        logInfo.append("\nMethod: ".concat(jp.getSignature().getName()));
        logInfo.append("\nResponse:".concat(Objects.isNull(response)?" El response llego nulo del endpoint: ".concat(path): response.toString()));
        logInfo.append("\n------ RESPONSE ").append(tag).append("-END ------\n");
        logInfo.append("\n");
        log.info(logInfo.toString());

    }

@AfterThrowing(pointcut = "allResources()", throwing="exception")
public void inExceptionsLog(JoinPoint jp, Exception exception){
    MethodSignature methodSignature = (MethodSignature) jp.getSignature();
    CommonsLogging commonsLogging = methodSignature.getMethod().getAnnotation(CommonsLogging.class);
    String tag = commonsLogging.tag();
    StringBuilder logInfo = new StringBuilder();
    logInfo.append("\n");
    logInfo.append("\n------ EXCEPTION ").append(tag).append(" ------");
    String type = commonsLogging.type();
    String path = commonsLogging.path();
    if (path != null && !path.isEmpty()) {
        logInfo.append("\nPath: ").append(path);
    }
    if (type != null && !type.isEmpty()) {
        logInfo.append("\nType: ").append(type);}
    logInfo.append("\nException:".concat(exception.getClass().getName()));
    logInfo.append("\nMessage:".concat(exception.getMessage()));
    logInfo.append("\n------ EXCEPTION ").append(tag).append("-END ------\n");
    logInfo.append("\n");
    log.error(logInfo.toString());
}
}