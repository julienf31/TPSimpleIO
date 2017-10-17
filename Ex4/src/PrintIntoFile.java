import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PrintIntoFile {

    static File file = new File("./TPSimpleIO/Ex4/file/file.txt");

    public static void main(String[] args){
        String s = "";
        Scanner scan = new Scanner(System.in);
        while(!s.equals("quit")){   //boucle tant que quit n'est pas tapé
            s = scan.nextLine();    //récupération de la saisie
            if(!s.equals("quit")){   //si non quit, on écrit dans le fichier
                // écriture dans le fichier (avec exception), append pour ajouter a la suite et ne pas réécrire par dessus
                try(FileWriter writer = new FileWriter(file,true);) {
                    s = s + "\n";
                    writer.write(s);
                }
                catch(FileNotFoundException e){
                    e.printStackTrace();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
