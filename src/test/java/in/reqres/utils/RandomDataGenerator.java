package in.reqres.utils;

import net.datafaker.Faker;

public class RandomDataGenerator {
    static Faker faker = new Faker();
    public static  String generateRandomName() {
        return faker.name().fullName();
    }

    public static String generateRandomJobTitle() {
        return faker.job().title();
    }
}
