package rvt;

import java.io.*; //failu lasīšanai un rakstīšanai

import java.util.ArrayList;

import java.util.List;

public class CsvFileHandler { // klase, kas atbild par Csv faila apstrādi

    private final File file; //norāda uz SCV failu 

    public CsvFileHandler (String filePath) { //konstruktors - pieņem faila ceļu

        this.file = new File (filePath); // izveido File objektu

    }

    public List<student> readAll() { //nolasa visus studentus no faila

        List<student> students = new ArrayList<>();

        if (!file.exists()) return students; // ja faila nav, tad atgriež tukšu sarakstu

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null ) { // lasa rindu pa rindai

                if (!line.isBlank()) {

                    students.add(student.fromCvsRow(line)); // pārvērš par student objektu
                }
            }
        } catch (IOException e) {

            System.out.println ("Kluda lasot failu: " + e.getMessage());
        }

        return students;

    }

    public void writeAll(List<student> students) { // saglabā visus studentus failā

        try (BufferedWriter bw = new BufferedWriter (new FileWriter(file))) {
             
            for (student s : students) {

                bw.write(s.toCvsRow()); // ieraksta CSV rindu
                bw.newLine(); // pāriet jaunā rindā
            }
        } catch (IOException e) {

            System.out.println ("Kluda rakstot failu: " + e.getMessage());
        }
    }
}