import java.util.Scanner;
import service.*;

public class TestPath {

    private static PathManager pathManager = new PathManager();

    public static void main(String[] args){
        //récupération du chemin
        String path = pathManager.callPath();

        //lancement du test
        pathManager.testPath(path);
    }
}
