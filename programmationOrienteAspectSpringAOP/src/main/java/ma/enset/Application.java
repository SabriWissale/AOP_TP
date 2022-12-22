package ma.enset;

import ma.enset.service.IMetier;
import ma.enset.service.MetierImpl;
import ma.enset.service.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"ma.enset"})
public class Application {
    public static void main(String[] args) {
        try{
            SecurityContext.authenticate("root","1234", new String[]{"ADMIN", "USER"});
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
            IMetier metier = applicationContext.getBean(IMetier.class); //retourn moi un bean qui implement cette interface
            System.out.println("*************");
            System.out.println(metier.getClass().getName());
            System.out.println("*************");
            metier.process();
            System.out.println("Result="+metier.compute());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
