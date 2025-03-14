package com.erosnox.backend.domain.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.regex.Pattern;

public class EntityUtils {

    private static final String EMAIL_REGEXP = "(?i)\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}\\b";
    private static final String PASSWORD_REGEXP = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$";
    private static final String PHONE_REGEXP = "^\\d{2}9\\d{8}$";
    private static final String CEP_REGEXP = "^\\d{8}$";

    public static void isFieldEmpty(String value, String fieldName) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " is null or empty");
        }
    }

    public static boolean isEmailValid(String email) {
        isFieldEmpty(email, "Email");
        return validateRegex(EMAIL_REGEXP, email);
    }

    public static boolean isPasswordValid(String password) {
        isFieldEmpty(password, "Password");
        return validateRegex(PASSWORD_REGEXP, password);
    }

    public static boolean isPhoneValid(String phone) {
        isFieldEmpty(phone, "Phone");
        return validateRegex(PHONE_REGEXP, phone);
    }

    public static boolean isCepValid(String cep) {
        isFieldEmpty(cep, "Cep");
        return validateRegex(CEP_REGEXP, cep);
    }

    public static String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    private static boolean validateRegex(String regexPattern, String value) {
        var pattern = Pattern.compile(regexPattern);
        return pattern.matcher(value).matches();
    }
}
