package service;

import domain.*;

import java.io.*;
import java.util.List;
public class SaveManager {

    public void saveEmployee(List<Employee> listEmp){
        try(FileOutputStream fileWriter = new FileOutputStream(new File("./Ex7/save/save.txt"));
        ObjectOutputStream objectWriter = new ObjectOutputStream(fileWriter)){    //on initialise le filewriter qui va écrire dans un second fichier

            for(Employee employee:listEmp){ // on lit la liste
                objectWriter.writeObject(employee);    //on ecris ce que le reader lit
                //System.out.println(employee.getInfo());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //fonction de récupératon de sauvegarde
     public void loadEmployee(Personnel p){
        Employee emp;
        try {
            FileInputStream file = new FileInputStream("./Ex7/save/save.txt");
            ObjectInputStream objectReader = new ObjectInputStream(file);
            while(file.available() > 0) { //tant que le fichier n'est pas vide (pour eviter EOFException)
                emp = (Employee) objectReader.readObject();
                p.ajouterEmploye(emp);
            }
            objectReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Aucune sauvegarde trouvée");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
