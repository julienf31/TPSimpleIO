package better.service;

import better.domain.*;

import java.util.Scanner;

public class Menu {
    //fonction d'affichage du menu
    public void displayMenu(){
        System.out.println("--------------------------------");
        System.out.println("Que voulez vous faire ?");
        System.out.println("--------------------------------");
        System.out.println("s/S - Ajouter un employé");
        System.out.println("c/C - Calculer les salaires");
        System.out.println("q/Q - Quitter");
        System.out.println("0 - vider liste employé");
    }

    //fonction pour recuperer le choix du menu
    public String getChoice(String message){
        System.out.print(message);
        return new Scanner(System.in).nextLine();
    }

}
