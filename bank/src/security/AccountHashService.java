package security;

import java.security.MessageDigest;

public class AccountHashService {

    public static String hash(String accountNumber) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(accountNumber.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (Exception e) {
            throw new RuntimeException("Ошибка хеширования", e);
        }
    }
}
