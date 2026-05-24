package ro.ulbs.proiectaresoftware.students;

public class StudentCuNota extends Student {
    private final double nota;

    public StudentCuNota(int numarMatricol, String prenume, String nume, String formatieDeStudiu, double nota) {
        super(numarMatricol, prenume, nume, formatieDeStudiu);
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public StudentCuNota schimbaFormatie(String nouaFormatie) {
        return new StudentCuNota(this.getNumarMatricol(), this.getPrenume(), this.getNume(), nouaFormatie, this.nota);
    }

    @Override
    public String toString() {
        return String.format("%s | %-5.2f", super.toString(), nota);
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + nota;
    }
}