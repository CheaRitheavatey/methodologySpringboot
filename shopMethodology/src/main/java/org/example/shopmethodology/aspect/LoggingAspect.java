package org.example.shopmethodology.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private static Logger logger = Logger.getLogger("org.example.shopmethodology.aspect");

    // every method in every class in evey package inside com.example.shopmethodlogy
    // for any return type
    // any number of parameter passed
    // make sure the pointcut reach the method level with the .*
    @Pointcut("execution(* org.example.shopmethodology.*.*.*(..))")
    public void loggingPointcut() {}

    // look for every type that is for that start with a customer
    @Pointcut("within(org.example.shopmethodology.*.Customer*)")
    public void customerPointcut() {}

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void restControllerPointcut() {}

    // all getter
    @Before("execution(* org.example.shopmethodology.*.*.get*(..))")
    public void loggingBefore() {
        logger.log(Level.INFO, "executing a getter");
    }

    // logging a statement after a customer is being added
    @AfterReturning("execution(* org.example.shopmethodology.*.*.addCustomer(..))")
    public void loggingAfter() {
        logger.log(Level.INFO, "executing statement after customer is added");
    }

    @Around("loggingPointcut()")
    public Object loggingAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // proceeding joinpoint is an object that can be provided to @Around advice and can be use to change detail of the method execution at runtime
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        logger.log(Level.INFO, "Executing " + className + "." + methodName + "wo-wo-woahhh");
        return joinPoint.proceed();


    }

    // due to the nature of springboot aop
    // protected method are not intercepted by definiteion
    // as a reesult the given point matches only the public methods


}
