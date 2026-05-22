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
    protected int numarMatricol;
    protected String prenume;
    protected String nume;
    protected String formatieDeStudiu;

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

    @Override
    public String toString() {
        return String.format("%-5d | %-15s | %-15s | %-10s",
                numarMatricol, prenume, nume, formatieDeStudiu);
    }

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