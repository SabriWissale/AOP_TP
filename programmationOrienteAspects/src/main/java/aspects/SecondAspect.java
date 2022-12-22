package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Around;


@Aspect
public class SecondAspect {
    @Pointcut("execution(* test.Application.main(..))")
    public void pointcut2(){}

    @Around("pointcut2()")
    public void aroundMain(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("Before main from Aspect with AspectJ class");
        proceedingJoinPoint.proceed();
        System.out.println("After main from Aspect with AspectJ class");
    }


}
