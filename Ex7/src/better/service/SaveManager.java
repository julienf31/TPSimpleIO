package better.service;

import better.domain.*;

import java.io.*;
import java.util.List;
public class SaveManager {

    public void saveEmployee(List<Employee> listEmp){
        try(FileOutputStream fileWriter = new FileOutputStream(new File("./TPSimpleIO/Ex7/save/save.txt"));
        ObjectOutputStream objectWriter = new ObjectOutputStream(fileWriter)){    //on initialise le filewriter qui va écrire dans un second fichier

            for(Employee employee:listEmp){ // on lit la liste
                objectWriter.writeObject(employee);    //on ecris ce que le reader lit
                //System.out.println(employee.getInfo());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}