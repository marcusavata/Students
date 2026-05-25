package ro.ulbs.proiectaresoftware.students;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Student {
    private final int numarMatricol;
    private final String prenume;
    private final String nume;
    private final String formatieDeStudiu;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public int getNumarMatricol() { return numarMatricol; }
    public String getPrenume() { return prenume; }
    public String getNume() { return nume; }
    public String getFormatieDeStudiu() { return formatieDeStudiu; }

    public Student schimbaFormatie(String nouaFormatie) {
        return new Student(this.numarMatricol, this.prenume, this.nume, nouaFormatie);
    }

    public static List<Student> imparteInFormatiiEgale(List<? extends Student> lista, String f1, String f2) {
        List<Student> nouaLista = new ArrayList<>();
        int n = lista.size();

        int mijloc = (n % 2 == 0) ? (n / 2) : (n / 2 + 1);

        for (int i = 0; i < n; i++) {
            Student studentOriginal = lista.get(i);
            if (i < mijloc) {
                nouaLista.add(studentOriginal.schimbaFormatie(f1));
            } else {
                nouaLista.add(studentOriginal.schimbaFormatie(f2));
            }
        }
        return nouaLista;
    }

    @Override
    public String toString() {
        return String.format("%-5d | %-15s | %-15s | %-10s",
                numarMatricol, prenume, nume, formatieDeStudiu);
    }
//ex3
    public String toCSV() {
        return numarMatricol + "," + prenume + "," + nume + "," + formatieDeStudiu;
    }

    public boolean studentPrezent(ArrayList<Student> lista) {
        return lista != null && lista.contains(this);
    }

    public boolean studentPrezentSet(HashSet<Student> set) {
        return set != null && set.contains(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return numarMatricol == student.numarMatricol &&
                Objects.equals(prenume, student.prenume) &&
                Objects.equals(nume, student.nume) &&
                Objects.equals(formatieDeStudiu, student.formatieDeStudiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol, prenume, nume, formatieDeStudiu);
    }

    public static List<Student> sortByName(List<Student> lista) {
        List<Student> listaSortata = new ArrayList<>(lista);
        listaSortata.sort(Comparator.comparing(Student::getNume));
        return listaSortata;
    }

    public static List<Student> sortStudents(List<Student> lista) {
        List<Student> listaSortata = new ArrayList<>(lista);
        listaSortata.sort(Comparator.comparing(Student::getFormatieDeStudiu)
                .thenComparing(Student::getNume));
        return listaSortata;
    }

    public static int notaStudent(Student student, Map<Student, Integer> note) {
        return note.getOrDefault(student, -1);
    }

    public static void outputStudentList(List<? extends Student> lista, String numeFisier) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(numeFisier))) {
            for (Student s : lista) {
                writer.println(s.toCSV());
            }
            System.out.println("Fisierul '" + numeFisier + "' a fost generat!");
        } catch (IOException e) {
            System.out.println("Eroare la scrierea in fisier: " + e.getMessage());
        }
    }

    public static void outputStudentCuNota(List<StudentCuNota> lista) {
        outputStudentList(lista, "studenti_cu_nota_output.txt");
    }
}