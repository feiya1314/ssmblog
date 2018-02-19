package blog.aop;

import org.aspectj.lang.JoinPoint;

public class LoggerAdvice {
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知fuck");
        System.out.println(joinPoint.getSignature().getName());
    }

    public void after(JoinPoint joinPoint){
        System.out.println("后置通知fuck");
        System.out.println(joinPoint.getSignature().getName());
    }
}
