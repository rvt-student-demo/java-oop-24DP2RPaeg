package rvt;

import java.util.ArrayList;

import java.util.List;

public class registrationService { // klase, kas satur visas specifiskās darbības ar studentiem (pievienošanu, dzēšanu utt.)

    private final CsvFileHandler fileHandler; //failu apstrāde

    private List<student> students; //studentu saraksts

    public registrationService(CsvFileHandler fileHandler) { //konstrktors - nolasa studentus no faila

        this.fileHandler = fileHandler;
        this.students = new ArrayList <> (fileHandler.readAll());

    }

    public void register (student newstudent) { //reģistrē jaunu studentu

        if (students.stream().anyMatch(s -> s.getEmail(). equalsIgnoreCase(newstudent.getEmail()))) { //pārbauda vai e-pasts ir unikāls

            throw new validationException ("E-pasts ir jau aiznemts!");
        }

        if (students.stream().anyMatch(s -> s.getPersonalCode().equals(newstudent.getPersonalCode()))) { //pārbauda unikālu personas kodu

            throw new validationException ("Personas kods jau eksiste!");
        }

        students. add(newstudent); //pievieno sarakstam
        fileHandler.writeAll(students); //saglabā failā
    }

    public List<student> getAll() { //atgriež visus studentus

        return new ArrayList <> (students);
    }

    public boolean removeByPersonalCode (String personalCode) { //dzēš studentus pēc personas koda

        boolean removed = students.removeIf (s -> s.getPersonalCode(). equals(personalCode)); 

        if (removed) {
            
        fileHandler.writeAll(students);
    }

    return removed;

}

    public boolean editByPersonalCode (String personalCode, student updated) { // rediģē studentus

        for (int i = 0; i < students.size(); i++ ) {

            if (students.get(i).getPersonalCode().equals(personalCode)){

                students.set(i, updated); //aizstāj ar jauno
                fileHandler.writeAll(students);
                return true;
            }
        }

        return false;
    }
}