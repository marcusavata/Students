package ro.ulbs.proiectaresoftware.students;
import java.util.Objects;
import java.util.HashSet;
import java.util.ArrayList;

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

    public int getNumarMatricol() {
        return numarMatricol;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }

    @Override
    public String toString() {
        return String.format("%-5d | %-15s | %-15s | %-10s",
                numarMatricol, prenume, nume, formatieDeStudiu);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return numarMatricol == student.numarMatricol && Objects.equals(prenume, student.prenume) && Objects.equals(nume, student.nume) && Objects.equals(formatieDeStudiu, student.formatieDeStudiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol, prenume, nume, formatieDeStudiu);
    }

    public boolean studentPrezent(ArrayList<Student> lista){
        return lista != null && lista.contains(this);
    }
    public boolean studentPrezentSet(HashSet<Student> set){
        return set != null && set.contains(this);
    }
}
