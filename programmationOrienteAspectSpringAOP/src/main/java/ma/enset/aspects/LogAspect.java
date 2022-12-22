package ma.enset.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.logging.Logger;

@Component //car au moment de l'execution il doit etre instancier
@Aspect
@EnableAspectJAutoProxy //demander spring au demarrage de hercher les pointcut et genereer un proxy pour implementer le code advice
public class LogAspect {
    //code advice
    /*
    @Before("execution(* ma.enset.service..*(..))")
    public void log(){
        System.out.println("From logging Aspects... Before");
    }
    */
    Logger logger = Logger.getLogger(LogAspect.class.getName());
    //@Around("execution(* ma.enset.service..*(..))")
    @Around("@annotation(ma.enset.aspects.Log)") //toutes les methodes qui sont precedées par cette annotation, nous appliquant ce code advice
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long t1 = System.currentTimeMillis();
        logger.info("From logging Aspects... Before"+ proceedingJoinPoint.getSignature());
        Object result = proceedingJoinPoint.proceed();
        logger.info("From Logging Aspects ... After"+proceedingJoinPoint.getSignature());
        long t2 = System.currentTimeMillis();
        logger.info("Duration :"+(t2-t1));
        return result;
    }
}
