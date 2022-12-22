package ma.enset.aspects;

import ma.enset.service.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AuthorizationAspect {
    @Around(value = "@annotation(securedByAspect)", argNames = "proceedingJoinPoint,securedByAspect")
    public Object secure(ProceedingJoinPoint proceedingJoinPoint, SecuredByAspect securedByAspect) throws Throwable {
        String[] roles= securedByAspect.roles();
        boolean authorized = false;
        for (String role : roles){
            if(SecurityContext.hasRole(role)){
                authorized = true;
                break;
            }
        }
        if(authorized == true){
            Object result = proceedingJoinPoint.proceed();
            return result;
        }
        throw new RuntimeException("Unauthorized 403");
    }
    //@AfterReturning //s appliquer aux methodes qui retournent des resultats
    //@AfterThrowing //methodes qui generent err

}
