package util;

import java.util.Random;

public class AccountNumberGenerator {

    public static String generate() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
