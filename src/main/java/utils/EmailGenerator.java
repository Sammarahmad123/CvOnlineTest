package utils;

import java.util.Random;

public class EmailGenerator {
    public static String generateRandomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder email = new StringBuilder();
        Random random = new Random();

        // Generate a random string of characters for the local part of the email
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(allowedChars.length());
            email.append(allowedChars.charAt(index));
        }

        // Add a domain
        email.append("@example.com");

        return email.toString();
    }


}
