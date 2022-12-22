package ma.enset.service;

import ma.enset.aspects.Log;
import ma.enset.aspects.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service //ou component pour qu'n puisse l'utiliser
public class MetierImpl implements  IMetier{
    @Override
    @Log //annotation que nous avons creer
    @SecuredByAspect(roles={"ADMIN", "USER"}) //annotation que nous avons creer
    public void process() {
        System.out.println("business Process ...");
    }

    @Override
    @Log //dire que nous voudrons journaliser cette methode c nous qui a fait cette annotation
    @SecuredByAspect(roles={"ADMIN"}) //annotation que nous avons creer  c nous qui a fait cette annotation
    public double compute() {
        double data = 78;
        System.out.println("Business Computing and returning ...");
        return data;
    }
}
