package helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomHelper {

    public static String getRandomNumberWithLength(int count) {
        return RandomStringUtils.random(count, false, true);
    }

    public static String getRandomEmail() {
        return "test" + RandomStringUtils.random(8, false, true) + "@test.com";
    }
}
