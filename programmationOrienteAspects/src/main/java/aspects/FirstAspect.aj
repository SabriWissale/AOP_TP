package aspects;

public aspect FirstAspect {
    //qlq soit le type de rerour, dans le package test, la classe application, la methode main avec qlq soit les params de mai
    pointcut pointcut1(): execution(* test.Application.main(..));

    /*before():pointcut1(){ //code advice
        System.out.println("\n\nBefore main from Aspect with AspectJ syntax\n\n");
    }
    after():pointcut1(){ //code advice
        System.out.println("\n\nAfter main from Aspect with AspectJ syntax\n\n");
    }*/

    void around():pointcut1(){
        System.out.println("Before main from Aspect with AspectJ syntax");
        proceed();
        System.out.println("After main from Aspect with AspectJ syntax");
    }

}
