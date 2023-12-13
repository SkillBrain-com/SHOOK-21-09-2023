package com.skillbrain.mentor.selenium_cap2;
//Exemple de checked exceptions(verificate de IDE cand incercam sa executam programul)

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptiiVerificate {
//Exemplu cel mai simplu si comun cand uitam sa pune ";"
   // int numar

    //Exemplu de checked exception cand incercam sa citim dintr-un fisier care nu exista
//    public static void main(String[] args) throws FileNotFoundException{
//        File file = new File("non_existing_file.txt");
//        FileInputStream stream = new FileInputStream(file);
//    }


    //Exemplude handle la checked exception
    public static void main(String[] args) {
        try {
            metoda();
        }catch (Exception e){
            System.out.println("Fisierul nu exista");
        }
    }

    public static void metoda()throws FileNotFoundException{
        File file = new File("non_existing_file.txt");
        FileInputStream stream = new FileInputStream(file);
    }


}
