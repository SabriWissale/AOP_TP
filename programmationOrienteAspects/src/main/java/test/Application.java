package test;

import metier.Compte;
import metier.IMetierBanque;
import metier.MetierBanqueImpl;

import java.util.Scanner;

public class Application {
    //il faut indiquer à l IDE qu'on est en train de compiler avec aspectj -->
    //settings-> build, execution, deployment -> compiler ->java compiler--> ue compiler --> ajc et dans le path : C:\aspectj1.9\lib\aspectjtools.jar
    //C:\aspectj1.9\lib\aspectjtools.jar -> le tisseur d'aspect
    public static void main(String[] args){
        //System.out.println("Message from Main Application");
        new Application().start();
    }
    public void start(){
            System.out.println("Demarrage de l'application");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Donner le code du compte :");
            long code = scanner.nextLong();
            System.out.println("Donner le solde initiale du compte");
            double solde = scanner.nextDouble();
            IMetierBanque metierBanque = new MetierBanqueImpl();
            metierBanque.addCompte(new Compte(code, solde));
            while (true) {
                try {
                    System.out.println("Type Operation: ");
                    String type = scanner.next();
                    if(type.equals("q")) break;
                    System.out.println("Montant: ");
                    double montant = scanner.nextDouble();
                    if (type.equals("v")) {
                        metierBanque.verser(code, montant);
                    } else if (type.equals("r")) {
                        metierBanque.retirer(code, montant);
                    }
                    Compte compte = metierBanque.consulter(code);
                    System.out.println("Etat du compte :" + compte.toString());
                } catch (Exception e){
                    e.getMessage();
                }
            }
    }
}
