package ro.ulbs.proiectaresoftware.students;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CititorThread implements Runnable {
    private final String numeFisier;
    private final List<Student> listaComuna;

    public CititorThread(String numeFisier, List<Student> listaComuna) {
        this.numeFisier = numeFisier;
        this.listaComuna = listaComuna;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            int contor = 0;

            while ((linie = br.readLine()) != null) {
                String[] date = linie.split(",");

                if (date.length == 4) {
                    Student student = new Student(
                            Integer.parseInt(date[0].trim()),
                            date[1].trim(),
                            date[2].trim(),
                            date[3].trim()
                    );

                    listaComuna.add(student);
                    contor++;
                }
            }
            System.out.println(Thread.currentThread().getName() + " a terminat de citit " + contor + " studenti din " + numeFisier);

        } catch (IOException e) {
            System.err.println("Eroare in " + Thread.currentThread().getName() + " citind fisierul " + numeFisier + ": " + e.getMessage());
        }
    }
}