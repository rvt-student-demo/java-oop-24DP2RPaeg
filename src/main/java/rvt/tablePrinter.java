package rvt;

import java.util.List;

public class tablePrinter {  // klase, kas izdrukā tabulu konsolē

    public static void printstudents(List<student> students) { // metode tabulas izdrukai

        String format = "| %-15s | %-15s | %-20s | %-19s | %n"; // formatēšanas šablons - nosaka kolonnu platumus

        String line = "+---------------------+---------------------+---------------------+---------------------+"; // tabulas augšējā, apakšējā līnija

        System.out.println(line); // izdrukā līniju
        System.out.format(format, "Vards", "Uzvards", "Personas kods", "Registracijas datums");
        System.out.println(line);

        for (student s : students) { //izdrukā katru studentu

            System.out.format(format,
                s.getName(),
                s.getSurname(),
                s.getEmail(),
                s.getPersonalCode(),
                s.getRegistrationDateTime());
        }

        System.out.println(line);
    }
}