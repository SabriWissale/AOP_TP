package ma.enset.service;

import ma.enset.aspects.Log;
import ma.enset.aspects.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements  IMetier{
    @Override
    @Log
    @SecuredByAspect(roles={"ADMIN", "USER"})
    public void process() {
        System.out.println("business Process ...");
    }

    @Override
    @Log
    @SecuredByAspect(roles={"ADMIN"})
    public double compute() {
        double data = 78;
        System.out.println("Business Computing and returning ...");
        return data;
    }
}
