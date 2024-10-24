package com.opencart.managers;

import com.github.javafaker.Faker;

public class DataGeneratorManager {

    private static Faker faker = new Faker();

    public static String getRandomEmail(){
        return faker.internet().emailAddress();
    }

    public static String getRandomName(){
        return faker.name().name();
    }

    public static String getRandomFirstName(){
        return  faker.name().firstName();
    }

    public static String getRandomPassword(int min, int max){
        return faker.internet().password(min, max);
    }

    public static String getPhoneNumber(){
        return faker.phoneNumber().phoneNumber();

    }
}
