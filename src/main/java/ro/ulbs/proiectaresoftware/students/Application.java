package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        Student s1 = new Student(112, "Ioan", "Popa", "C21/1");
        Student s2 = new Student(112, "Maria", "Oprea", "C23/2");
        Student s3 = new Student(120, "Andrei", "Ghita", "C21/2");
        Student s4 = new Student(122, "Totu", "John", "C22/2");
        Student s5 = new Student(122, "Ioana", "Nocila", "C23/1");

        ArrayList<Student> listaStudenti = new ArrayList<>();
        listaStudenti.add(s1);
        listaStudenti.add(s2);
        listaStudenti.add(s3);
        listaStudenti.add(s4);
        listaStudenti.add(s5);

        for (Student s : listaStudenti) {
            System.out.println(s);
        }

        System.out.println("Este Ioan in lista? " + s1.studentPrezent(listaStudenti));

        HashSet<Student> setStudenti = new HashSet<>();
        setStudenti.add(s1);
        setStudenti.add(s2);
        System.out.println("Este Maria in set? " + s2.studentPrezentSet(setStudenti));
        System.out.println("Este Andrei in set? " + s3.studentPrezentSet(setStudenti));

        System.out.println("Sortare dupa nume:");
        List<Student> sortatiDupaNume = Student.sortByName(listaStudenti);
        sortatiDupaNume.forEach(System.out::println);

        System.out.println("\nSortare dupa formatie, apoi nume:");
        List<Student> sortatiComplet = Student.sortStudents(listaStudenti);
        sortatiComplet.forEach(System.out::println);

        System.out.println("\nTest Generare Fisier");
        Student.outputStudentList(listaStudenti, "studenti_output.txt");

        System.out.println("\nTest Studenti cu Nota");
        StudentCuNota sn1 = new StudentCuNota(201, "Alexandru", "Ionescu", "TI21/1", 9.50);
        StudentCuNota sn2 = new StudentCuNota(202, "Elena", "Vasilescu", "TI21/2", 10.00);
        StudentCuNota sn3 = new StudentCuNota(203, "Cristian", "Marin", "TI22/1", 7.25);

        List<StudentCuNota> listaStudentiCuNota = new ArrayList<>();
        listaStudentiCuNota.add(sn1);
        listaStudentiCuNota.add(sn2);
        listaStudentiCuNota.add(sn3);

        for (StudentCuNota sn : listaStudentiCuNota) {
            System.out.println(sn);
        }

        System.out.println("\nTest Generare Fisier prin Polimorfism");
        Student.outputStudentCuNota(listaStudentiCuNota);

        System.out.println("\nTest Cautare prin Catalog (Map)");
        Map<Student, Integer> noteStudenti = new HashMap<>();
        noteStudenti.put(s1, 10);
        noteStudenti.put(s2, 8);

        System.out.println("Nota lui " + s1.getPrenume() + " este: " + Student.notaStudent(s1, noteStudenti));
        System.out.println("Nota lui " + s3.getPrenume() + " este: " + Student.notaStudent(s3, noteStudenti));
    }
}