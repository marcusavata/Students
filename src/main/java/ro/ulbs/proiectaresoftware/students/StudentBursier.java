package ro.ulbs.proiectaresoftware.students;

import java.util.Objects;

public class StudentBursier extends StudentCuNota {
    private final double cuantumBursa;

    public StudentBursier(int numarMatricol, String prenume, String nume, String formatieDeStudiu, double nota, double bursa) {
        super(numarMatricol, prenume, nume, formatieDeStudiu, nota);
        this.cuantumBursa = bursa;
    }

    public double getCuantumBursa() {
        return cuantumBursa;
    }

    @Override
    public StudentBursier schimbaFormatie(String nouaFormatie) {
        return new StudentBursier(this.getNumarMatricol(), this.getPrenume(), this.getNume(), nouaFormatie, this.getNota(), this.cuantumBursa);
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += String.format("    [ %6.2f ]", cuantumBursa);
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentBursier that = (StudentBursier) o;
        return Double.compare(cuantumBursa, that.cuantumBursa) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cuantumBursa);
    }
}