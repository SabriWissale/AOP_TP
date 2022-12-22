package test;

import metier.Compte;
import metier.IMetierBanque;
import metier.MetierBanqueImpl;

import java.util.Scanner;

public class Application {

    public static void main(String[] args){

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
                    System.out.println("Type de l Operation: ");
                    String type = scanner.next();
                    if(type.equals("quit")) break;
                    System.out.println("Montant: ");
                    double montant = scanner.nextDouble();
                    if (type.equals("versement")) {
                        metierBanque.verser(code, montant);
                    } else if (type.equals("retrait")) {
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
