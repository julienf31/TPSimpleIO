import service.PathManager;

import java.util.Scanner;

public class ListFiles {

    private static PathManager pathManager = new PathManager();

    public static void main(String[] args){
        //récupération du chemin
        String path = pathManager.callPath();

        //lancement de la fonction qui liste
        pathManager.listFiles(path);
    }
}
