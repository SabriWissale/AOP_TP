package ma.enset.aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //c une methode qui sera interpretee au moment e l execution
@Target(ElementType.METHOD) //l'annotation sera juste appliquée sur les methodes
public @interface SecuredByAspect {
    String[] roles();
}
