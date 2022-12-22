package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
//pour la journalisation

//synax class
@Aspect
public class LogginAspect {
    Logger logger = Logger.getLogger(LogginAspect.class.getName());
    long t1, t2;

    public LogginAspect() throws IOException {
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false);
    }

    @Pointcut("execution(* metier.MetierBanqueImpl.*(..))")
    public void pointcut1() {

    }

    /*
    @Before("pointcut1()")
    public void avant(JoinPoint joinPoint){
        t1 = System.currentTimeMillis();
        logger.info("Before execute the method "+joinPoint.getSignature());
    }
    @After("pointcut1()")
    public void apres(JoinPoint joinPoint){
        logger.info("After execute the method "+joinPoint.getSignature());
        t2 = System.currentTimeMillis();
        logger.info("The execution time of the method is : "+ (t2-t1));
    }
     */
    @Around("pointcut1()")
    public Object autour(JoinPoint joinPoint, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        t1 = System.currentTimeMillis();
        logger.info("Before execute the method " + joinPoint.getSignature());
        Object result= proceedingJoinPoint.proceed();
        logger.info("After execute the method " + joinPoint.getSignature());
        t2 = System.currentTimeMillis();
        logger.info("The execution time of the method is : " + (t2 - t1));
        return result; //obliged
    }
}