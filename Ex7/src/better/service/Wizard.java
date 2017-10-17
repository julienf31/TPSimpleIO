package better.service;
import better.domain.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Wizard {


    private int type = 0;
    private String typeLabel = "Non définis";
    private String firstname = "Non renseigné";
    private String lastname = "Non renseigné";
    private int age = 0;
    private String entryYear = "Non renseigné";
    private double salary = 0;
    private boolean valid = false;

    public Employee displayWizard(){
        String choice;
        Scanner sc = new Scanner(System.in);

        while(!valid) {
            System.out.println("--------------------------------");
            System.out.println("1: Type d'employé : " + typeLabel);
            System.out.println("2: Nom : " + lastname);
            System.out.println("3: Prénom : " + firstname);
            System.out.println("4: Age : " + age);
            System.out.println("5: Année d'arrivée : " + entryYear);
            System.out.println("6: Unité de calcul de salaire : " + salary);
            System.out.println("");
            System.out.println("7: Valider");
            System.out.println("--------------------------------");
            System.out.print("Selection : ");
            choice = sc.nextLine();
            switch (choice){
                case "1":
                    setEmployeeType();
                    break;
                case "2":
                    setLastname();
                    break;
                case "3":
                    setFirstname();
                    break;
                case "4":
                    setAge();
                    break;
                case "5":
                    setEntryYear();
                    break;
                case "6":
                    setSalary();
                    break;
                case "7":
                    valid = true;
                    break;
            }
        }
        valid = false;
        switch (type){
            case 1:
                return new Vendeur(lastname,firstname,age,entryYear,salary);
            case 2:
                return new Representant(lastname,firstname,age,entryYear,salary);
            case 3:
                return new Technicien(lastname,firstname,age,entryYear,(int)salary);
            case 4:
                return new TechnARisque(lastname,firstname,age,entryYear,(int)salary);
            case 5:
                return new Manutentionnaire(lastname,firstname,age,entryYear,(int)salary);
            case 6:
                return new ManutARisque(lastname,firstname,age,entryYear,(int)salary);
        }
        return null;
    }

    private void setEmployeeType(){
        Scanner sc = new Scanner(System.in);
        printEmployeeClass();
        int choice = this.type;
        try {
            choice = sc.nextInt();
        }
        catch(InputMismatchException e)
        {
            //e.printStackTrace();
            System.out.println("Valeur saisie non numérique !");
        }
        this.type = choice;
        switch (type){
            case 1:
                this.typeLabel = "Vendeur";
                break;
            case 2:
                this.typeLabel = "Représentant";
                break;
            case 3:
                this.typeLabel = "Technicien";
                break;
            case 4:
                this.typeLabel = "Technicien à risques";
                break;
            case 5:
                this.typeLabel = "Manutentionnaire";
                break;
            case 6:
                this.typeLabel = "Manutentionnaire à risques";
                break;
            default:
                    this.typeLabel = this.typeLabel;
        }
    }

    private void printEmployeeClass(){
        System.out.println("--------------------------------");
        System.out.println("Quel type d'employée ?");
        System.out.println("--------------------------------");
        System.out.println("1 - Vendeur");
        System.out.println("2 - Représentant");
        System.out.println("3 - Technicien");
        System.out.println("4 - Technicien à risques");
        System.out.println("5 - Manutentionnaire");
        System.out.println("6 - Manutentionnaire à risques");
    }

    private void setLastname(){
        System.out.print("Saisissez le nom de l'employé : ");
        this.lastname = new Scanner(System.in).nextLine();
    }

    private void setFirstname(){
        System.out.print("Saisissez le prénom de l'employé : ");
        this.firstname = new Scanner(System.in).nextLine();
    }

    private void setAge(){
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.print("Saisissez l'age de l'employé : ");
        try {
            choice = sc.nextInt();
        }
        catch(InputMismatchException e)
        {
            //e.printStackTrace();
            System.out.println("Valeur saisie non numérique !");
        }
        this.age = choice;
    }

    private void setEntryYear(){
        System.out.print("Saisissez l'année d'entrée de l'employé : ");
        this.entryYear = new Scanner(System.in).nextLine();
    }

    //fonction pour récupéréla valeur pour calculer le salaire
    //Si le type est renseigné le texte est plus précis
    private void setSalary(){
        double choice = this.salary;
        Scanner sc = new Scanner(System.in);
        switch (this.type){
            case 1:
            case 2:
                System.out.print("Saisissez le CA mensuel : ");
                break;
            case 3:
            case 4:
                System.out.print("Saisissez le nombre d'unités produite au mois : ");
                break;
            case 5:
            case 6:
                System.out.print("Saisissez le nombre d'heures travaillées dans le mois : ");
                break;
            default:
                System.out.print("Saisissez l'unité de calcul du salaire de l'employé : ");
        }
        try {
            choice = sc.nextDouble();
        }
        catch(InputMismatchException e)
        {
            //e.printStackTrace();
            System.out.println("Valeur saisie non numérique !");
        }
        this.salary = choice;
    }

    public void resetwizard(){
        this.type = 0;
        this.typeLabel = "Non définis";
        this.firstname = "Non renseigné";
        this.lastname = "Non renseigné";
        this.age = 0;
        this.entryYear = "Non renseigné";
        this.salary = 0;
        this.valid = false;
    }
}
