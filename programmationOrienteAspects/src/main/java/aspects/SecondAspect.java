package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Around;

//syntax class
@Aspect
public class SecondAspect {
    @Pointcut("execution(* test.Application.main(..))")
    public void pointcut2(){}
    //code advice
    /*
    @Before("pointcut2()")
    public void beforeMain(){
        System.out.println("Before main from Aspect with AspectJ class");
    }
    @After("pointcut2()")
    public void afterMain(){
        System.out.println("After main from Aspect with AspectJ class");
    }
    */
    @Around("pointcut2()")
    public void aroundMain(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("Before main from Aspect with AspectJ class");
        proceedingJoinPoint.proceed();
        System.out.println("After main from Aspect with AspectJ class");
    }


}
