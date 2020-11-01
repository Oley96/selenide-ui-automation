package helpers;


import static org.apache.commons.lang3.RandomStringUtils.*;

public class RandomHelper {

    public static String getRandomNumberWithLength(int count) {
        return random(count, false, true);
    }

    public static String getRandomEmail() {
        return "test".concat(random(8, false, true)).concat("@test.com");
    }

    public static String getRandomPassword() {
        return randomAlphabetic(10);
    }

    public static String getRandomUsername() {
        return "john_doe".concat(getRandomNumberWithLength(5));
    }


}
