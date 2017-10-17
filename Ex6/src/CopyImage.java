import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class CopyImage {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        //récupération de l'URL
        System.out.println("Saisissez l'url de l'image (JPG) :");
        String url = scan.nextLine();

        //saisie du nom
        System.out.println("Saisissez le nom de l'image :");
        String name = scan.nextLine();

        try {
            //Récupération de l'image via URL
            BufferedImage imgURL =  ImageIO.read(new URL(url));
            //Ecriture de l'image dans le dossier de ressources
            ImageIO.write(imgURL, "jpg", new File("./TPSimpleIO/Ex6/Images/"+name+".jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
