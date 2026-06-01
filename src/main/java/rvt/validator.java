package rvt;

import java.util.regex.Pattern;

public class validator { //pārbauda lietotāja ievadi

    private static final Pattern name_pattern = Pattern.compile ("^[A-Za-zĀ-ž]{3,}$"); //RegEx, kas atļauj tikai burtus, min garums 3

    private static final Pattern email_pattern = Pattern.compile ("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$"); 

    private static final Pattern personal_code_pattern = Pattern.compile ("^\\d{6}-?\\d{5}$"); //RegEx personas kodam

    public static boolean isValidName (String name) { // pārbauda vārdu

        return name_pattern.matcher(name).matches(); 
    }

    public static boolean isValidEmail (String email) { // pārbauda e-pastu

        return email_pattern.matcher(email).matches(); //atgriež true vai false
        
    }

    public static boolean isValidPersonalCode (String personalCode) { //pārbauda personas kodu
        
        return personal_code_pattern.matcher(personalCode).matches(); //atgriež true vai false
    }
}