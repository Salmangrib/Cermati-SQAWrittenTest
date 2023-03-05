package app.cermati.handler;

import com.github.javafaker.Faker;


/**
 * used to test data
 */

public class TestDataProvider {
    private static final Faker faker = new Faker();

    public static String getRandomUserName(){
        return faker.name().firstName();
    }
    public static String getRandomFirstName(){
        return faker.name().firstName();
    }
    public static String getRandomLastName(){
        return faker.name().lastName();
    }
    public static String getRandomPassword() {
        return getRandomStringMatchingPattern("[A-Z]\\d{8}");
    }
    public static String getRandomStringMatchingPattern(String pattern) {
        return faker.regexify(pattern);
    }

    public static String getRandomEmail() {
        return getRandomStringMatchingPattern("random\\d{8}") + ".user-cermati@test.cermati.com";
    }

    public static  String getRandomNumber(int digits){
        return faker.number().digits(digits);
    }
    public static String getRandomPhoneNo(){
        return "081" + getRandomNumber(10);
    }

    public static String getRandomCity(){
        return faker.address().city();
    }

    public static String getRandomAddress(){
        return faker.address().streetAddress();
    }

    public static String getRandomPostalCode(){
        return faker.address().zipCode();
    }
}
