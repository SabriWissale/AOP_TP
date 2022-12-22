package aspects;

public aspect FirstAspect {
    pointcut pointcut1(): execution(* test.Application.main(..));



    void around():pointcut1(){
        System.out.println("Before main from Aspect with AspectJ syntax");
        proceed();
        System.out.println("After main from Aspect with AspectJ syntax");
    }

}
