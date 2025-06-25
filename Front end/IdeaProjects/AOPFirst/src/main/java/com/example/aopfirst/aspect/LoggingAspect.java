package com.example.aopfirst.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect // Mark this class as an Aspect
@Component // Mark this class as a Spring component so it's discovered and managed
public class LoggingAspect {

    // ------------------- Pointcuts -------------------

    // Define a pointcut for all public methods in the service package
    // `execution(* com.example.first.AOPFirst.service.*.*(..))`
    // - `*`: Any return type
    // - `com.example.first.AOPFirst.service.*`: Any class within the service package
    // - `*`: Any method name
    // - `(..)`: Any number of arguments (zero or more)
    @Pointcut("execution(* com.example.first.AOPFirst.service.*.*(..))")
    public void serviceMethods() {}

    // Define a pointcut for methods specifically in MyService
    @Pointcut("within(com.example.first.AOPFirst.service.MyService)")
    public void myServiceMethods() {}

    // ------------------- Advice Types -------------------

    // @Before Advice: Executes before the advised method is called.
    @Before("serviceMethods()") // Apply this advice to all methods matched by 'serviceMethods' pointcut
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("AOP @Before: Entering method: " + joinPoint.getSignature().getName() +
                " from " + joinPoint.getSignature().getDeclaringTypeName());
        System.out.print("AOP @Before: Arguments: [");
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]);
            if (i < args.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // @AfterReturning Advice: Executes after the advised method returns successfully (without throwing an exception).
    // `returning = "result"` binds the return value of the advised method to the `result` parameter.
    @AfterReturning(pointcut = "myServiceMethods()", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        System.out.println("AOP @AfterReturning: Method '" + joinPoint.getSignature().getName() +
                "' executed successfully. Return value: " + (result != null ? result : "void"));
    }

    // @AfterThrowing Advice: Executes after the advised method throws an exception.
    // `throwing = "exception"` binds the thrown exception to the `exception` parameter.
    @AfterThrowing(pointcut = "myServiceMethods()", throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        System.err.println("AOP @AfterThrowing: Method '" + joinPoint.getSignature().getName() +
                "' threw an exception: " + exception.getClass().getSimpleName() +
                " - Message: " + exception.getMessage());
    }

    // @After (Finally) Advice: Executes regardless of whether the advised method returns normally or throws an exception.
    // This is similar to a 'finally' block.
    @After("myServiceMethods()")
    public void afterFinallyAdvice(JoinPoint joinPoint) {
        System.out.println("AOP @After: Method '" + joinPoint.getSignature().getName() +
                "' has finished (finally block).");
    }

    // @Around Advice: Allows you to control when and how the advised method executes.
    // It can perform actions before and after, modify arguments, return values, or even prevent the method from executing.
    // `ProceedingJoinPoint` is used with @Around advice.
    @Around("execution(* com.learnwithlearnsquare.aopexamplethird.service.MyService.doSomethingWithArgs(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("AOP @Around: Before executing method: " + proceedingJoinPoint.getSignature().getName());

        long startTime = System.currentTimeMillis();

        Object result = null;
        try {
            // Proceed with the execution of the target method
            result = proceedingJoinPoint.proceed();
            System.out.println("AOP @Around: Method executed successfully. Result: " + result);
        } catch (Throwable e) {
            System.err.println("AOP @Around: Method threw an exception: " + e.getMessage());
            throw e; // Re-throw the exception so the @AfterThrowing advice can also pick it up.
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("AOP @Around: After executing method. Execution time: " + (endTime - startTime) + "ms");
        }
        return result; // Return the result of the advised method
    }
}
