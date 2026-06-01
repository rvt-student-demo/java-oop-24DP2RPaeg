package rvt;

import java.time.LocalDateTime; // importē datumu un laiku

import java.time.format.DateTimeFormatter; // datuma un laika formatejumam

public class dateTimeUtil { // klase, kas atgriež pašreizējo laiku un datumu, kā String

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss"); // formāts, 
    // kādā tiks saglabāts datums un laiks

    public static String nowAsString() { // metode, kas atgriež pašreizējo datumu un laiku

        return LocalDateTime.now().format(formatter);
    }
}