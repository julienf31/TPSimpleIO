import java.io.*;

public class CopyContent {
    public static void main(String[] args){

        //on ouvre le fichier dans les ressources
        InputStreamReader file = new InputStreamReader(CopyContent.class.getResourceAsStream("./file1.txt"));

        try(BufferedReader reader = new BufferedReader(file);){ //on initialise le bufferedReader qui va lire le fichier
            try(FileWriter fileWriter = new FileWriter(new File("./TPSimpleIO/Ex5/resources/file2.txt"));){    //on initialise le filewriter qui va écrire dans un second fichier

                while (reader.ready()){ // on lit le fichier
                    fileWriter.write(reader.readLine()+"\n");    //on ecris ce que le reader lit
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
