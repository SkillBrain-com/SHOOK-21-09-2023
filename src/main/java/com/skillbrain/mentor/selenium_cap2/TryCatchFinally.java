package com.skillbrain.mentor.selenium_cap2;
//Blockul finally se executa indiferent de ce se intampla in blockurile try sau catch
public class TryCatchFinally {

    public static void main(String[] args) {
//        try{
//            int x = 0;
//            int y = 6;
//            int z = y/x;
//        }catch (ArithmeticException e){
//            System.out.println("Avem o exceptie de logica artmetica");
//        }finally {
//            int x = 2;
//            int y = 6;
//            int z = y/x;
//            System.out.println(z);
//        }

        try{
            int x = 2;
            int y = 6;
            int z = y/x;
            System.out.println(z);
        }catch (ArithmeticException e){
            System.out.println("Avem o exceptie de logica artmetica");
        }finally {
            System.out.println("Am executat blockul finally");
        }


        System.out.println("casdcas");
    }
}
