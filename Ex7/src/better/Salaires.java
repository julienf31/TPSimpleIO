package better;

import better.domain.*;
import better.service.*;

import java.io.*;

public class Salaires {

    public static Menu menu = new Menu();
    public static Wizard wizard = new Wizard();
    public static boolean quit = true;
    private static SaveManager saver = new SaveManager();
    public static Personnel p = new Personnel();

    public static void main(String[] args) {

        saver.loadEmployee(p); // chargement des employés
        launch(p);
        saver.saveEmployee(p.employees); // lors de la sortie du programme on enregistre les employés dans le fichier
    }

    public static void launch(Personnel p){
        while(quit){
            menu.displayMenu();
            switch(menu.getChoice("Séléction : ")){
                case "q": // cas de sortie
                    quit = false;
                    break;
                case "Q":
                    quit = false;
                    break;
                case "s": // cas d'ajouts
                    p.ajouterEmploye(wizard.displayWizard());
                    wizard.resetwizard();
                    saver.saveEmployee(p.employees); //sauvegarde apres la création
                    break;
                case "S":
                    p.ajouterEmploye(wizard.displayWizard());
                    wizard.resetwizard();
                    saver.saveEmployee(p.employees); //sauvegarde apres la création
                    break;
                case "c": // cas de calcul des slaires
                    p.afficherSalaires();
                    break;
                case "C":
                    p.afficherSalaires();
                    break;
                case "0": // pour vider la liste des employé (pour faire les tests)
                    p.cleanEmployeeList();
                    break;
                default:
                    System.out.println("Mauvais choix");
            }
        }
        System.out.println("Sortie du programme, sauvegarde des données ...");

    }

}
