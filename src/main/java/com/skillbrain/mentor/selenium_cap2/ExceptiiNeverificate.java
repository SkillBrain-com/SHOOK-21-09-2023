package com.skillbrain.mentor.selenium_cap2;

//Unchecked exceptions -> exceptii pe care ide-ul nu le poate identifica cand
// incercam sa rulam programul

public class ExceptiiNeverificate {

    //Exemplu de unchecked exception -> impartirea la 0 care este matematic imposibila
//    public static void main(String[] args) {
//        int x = 0;
//        int y = 10;
//        int z = y/x;
//    }


    //Handle la unchecked exception division by 0 si rethrow la exceptie
//    public static void main(String[] args) {
//        try{
//            int x = 0;
//            int y = 11;
//            int z = y/x;
//        }catch (Exception ArithmeticException){
//            System.out.println("Incercam sa impartim la 0");
//            throw ArithmeticException;
//        }
//    }

//Unchecked exception -> index out of bounds
//    public static void main(String[] args) {
//        int[] array= {1,2,5,6};
//
//        for(int i = 0; i< 7;i++){
//            System.out.println(array[i]);
//        }
//    }

    //Multiple catch example
    public static void main(String[] args) {
        try{
            int[] array ={1,3,5,6};
            for(int i = 0;i< 7;i++){
                System.out.println(array[i]);
            }
        }catch (ArithmeticException e){
            System.out.println("exceptie de logica aritmetica");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array este mai mic decat unde cautam noi");
        }
    }
}
