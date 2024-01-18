package com.skillbrain.mentor.utils;

import com.github.javafaker.Faker;
import net.bytebuddy.asm.MemberSubstitution;

public class DataGeneration {


    Faker faker = new Faker();
     public String fName;
     public String lName;

     public String email;
     public String message;


    private static DataGeneration instance;

    private DataGeneration() {

        fName = faker.name().firstName();
        lName = faker.name().lastName();
        email = fName + lName + "@mailinator.com";
        message = faker.lorem().characters(55);

    }

    public static DataGeneration getInstance(){

        if(instance == null){
            instance = new DataGeneration();
        }

        return instance;
    }
}
