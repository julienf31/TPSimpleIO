import service.PathManager;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class ListExtension {

    private static PathManager pathManager = new PathManager();

    public static void main(String[] args){
        //récupération du chemin
        String path = pathManager.callPath();

        //récupération de l'extension
        System.out.println("Saisissez l'extension :");
        String extension = new Scanner(System.in).nextLine();

        //lancement de la fonction qui liste
        pathManager.listFiles(path,extension);
    }

}
