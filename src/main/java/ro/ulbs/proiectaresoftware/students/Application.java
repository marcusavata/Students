import ro.ulbs.proiectaresoftware.students.Student;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public static void main() {
    Student s1 = new Student(112, "Ioan", "Popa", "C21/1");
    Student s2 = new Student(112, "Maria", "Oprea", "C23/2");
    Student s3 = new Student(120, "Andrei", "Ghita", "C21/2");
    Student s4 = new Student(122, "Totu", "John", "C22/2");
    Student s5 = new Student(122, "Ioana", "Nocila", "C23/1");

    //System.out.println(s2.toString());
    //System.out.println(s3.toString());
    //System.out.println(s4.toString());
    //System.out.println(s5.toString());

    ArrayList<Student> listaStudenti = new ArrayList<>();
    listaStudenti.add(s1);
    listaStudenti.add(s2);
    listaStudenti.add(s3);
    listaStudenti.add(s4);
    listaStudenti.add(s5);

    HashSet<Student> setStudenti = new HashSet<>();
    setStudenti.add(s1);
    setStudenti.add(s2);
    setStudenti.add(s3);
    setStudenti.add(s4);
    setStudenti.add(s5);

    System.out.println("E Andrei prezent? " + s3.studentPrezent(listaStudenti));
    System.out.println("E Ioana prezenta? " + s5.studentPrezentSet(setStudenti));

    System.out.println("Lista initiala");
    for (Student s : listaStudenti) {
        System.out.println(s);
    }

    System.out.println("\nLista sortata dupa Nume");
    List<Student> sortatiDupaNume = sorteazaNume(listaStudenti);
    for (Student s : sortatiDupaNume) {
        System.out.println(s);
    }

    System.out.println("\nLista sortata dupa Formatie de Studiu, apoi Nume");
    List<Student> sortatiComplet = sorteazaStudenti(listaStudenti);
    for (Student s : sortatiComplet) {
        System.out.println(s);
    }
    System.out.println("\nGenerare fisier");
    outputStudentList(listaStudenti);
}
    public static List<Student> sorteazaNume (List < Student > listaStudenti) {
        List<Student> listaSortataNume = new ArrayList<>(listaStudenti);
        listaSortataNume.sort(Comparator.comparing(Student::getNume));
        return listaSortataNume;
    }
    public static List<Student> sorteazaStudenti (List <Student> listaStudenti) {
        List<Student> listaSorataStudenti = new ArrayList<>(listaStudenti);
        listaSorataStudenti.sort(Comparator.comparing(Student::getFormatieDeStudiu).thenComparing(Student::getNume));
        return listaSorataStudenti;
    }

    public static void outputStudentList(List<Student> listaStudenti) {
    String numeFisier = "studenti_output.txt";

    try (PrintWriter writer = new PrintWriter(new FileWriter(numeFisier))) {
        for (Student s : listaStudenti) {
            writer.println(s.getNumarMatricol() + "," + s.getPrenume() + "," + s.getNume() + "," + s.getFormatieDeStudiu());
        }
        System.out.println("Fisierul '" + numeFisier + "' a fost generat cu succes!");
    } catch (IOException e) {
        System.out.println("Eroare la scrierea in fisier: " + e.getMessage());
    }
}


