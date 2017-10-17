package service;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class PathManager {

    public String callPath(){
        //récupération du chemin d'accés
        System.out.println("Saisissez le chemin :");
        return new Scanner(System.in).nextLine();
    }


    public void testPath(String path){
        String message = "";
        File pathToTest = new File(path);
        if (pathToTest.exists()) { //existe
            if (pathToTest.isFile()) { //est un fichier
                message = "Le fichier existe";
            } else if (pathToTest.isDirectory()) {  //est un dossier
                message = "Le dossier existe";
            }
        } else {   //n'existe pas
            message = "Le chemin n'existe pas";
        }
        System.out.println(message);
    }

    //ex 2
    public void listFiles(String path){
        File directory = new File(path);
        File[] files; //tableau contenant les fichiers

        files = directory.listFiles(); // ajout des fichiers/dossiers dans le tableau
        for(File file:files) {  //for sur le tableau qui affiche les chemins
            System.out.println(file);
        }
    }

    //ex 3
    public static void listFiles(String path, String extension){
        File directory = new File(path);

        //tableau contenant les fichiers
        File[] files;

        // ajout des fichiers/dossiers dans le tableau
        files = directory.listFiles(new FilenameFilter() { //utilisation de FilenameFilter pour filtrer les extensions
            @Override
            public boolean accept(File dir, String name) {
                //vérification de l'extension, cette fonction ajoutera le fichier à la liste si l'extension
                //correspond à celle passée en paramétre
                return name.endsWith(extension);
            }
        });

        //on regarde si des fichiers ont été trouvés
        if(files.length != 0) {
            for (File file : files) {  //for sur le tableau qui affiche les chemins
                System.out.println(file);
            }
        }
        else
            System.out.println("Aucun fichier avec l'extension " + extension + " trouvés dans le répertoire " + path);

    }
}
