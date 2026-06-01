package rvt;

public class validationException extends RuntimeException { // izņēmuma klase, ja ievade nav pareiza

    public validationException (String message) { //konstruktors, kas pieņem kļūdas ziņu

        super(message);
    }
}