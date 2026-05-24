package ro.ulbs.proiectaresoftware.students;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AplicatieStreams {

    public static void main(String[] args) {
        List<StudentCuNota> studentiCuNote = Arrays.asList(
                new StudentCuNota(1025, "Andrei", "Popa", "ISM141/2", 8.70),
                new StudentCuNota(1024, "Ioan", "Mihalcea", "ISM141/1", 10.0),
                new StudentCuNota(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new StudentCuNota(1029, "Bianca", "Popescu", "TI131/1", 10.0),
                new StudentCuNota(1029, "Maria", "Pana", "TI131/2", 4.10),
                new StudentCuNota(1029, "Gabriela", "Mohanu", "TI131/2", 7.33),
                new StudentCuNota(1029, "Marius", "Nasta", "TI131/2", 3.20),
                new StudentCuNota(1029, "Marius", "Nasta", "TI131/1", 5.12),
                new StudentCuNota(1029, "Andrei", "Dobrescu", "TI131/2", 2.22)
        );

        System.out.println("a) Studenti cu nota 10");
        studentiCuNote.stream()
                .filter(s -> s.getNota() == 10.0)
                .forEach(System.out::println);

        System.out.println("\nb) Studenti cu nota sub 5");
        studentiCuNote.stream()
                .filter(s -> s.getNota() < 5.0)
                .forEach(System.out::println);

        System.out.println("\nc) Lista transformata (notele < 4 devin 4)");
        List<StudentCuNota> listaTransformata = studentiCuNote.stream()
                .map(s -> {

                    if (s.getNota() < 4.0) {

                        return new StudentCuNota(s.getNumarMatricol(), s.getPrenume(), s.getNume(), s.getFormatieDeStudiu(), 4.0);
                    }

                    return s;
                })
                .collect(Collectors.toList());


        listaTransformata.forEach(System.out::println);

        System.out.println("\nd) Suma notelor (reduce)");

        double sumaNotelor = studentiCuNote.stream()
                .map(StudentCuNota::getNota)
                .reduce(0.0, Double::sum);

        System.out.println("Suma notelor este: " + sumaNotelor);

        System.out.println("\ne) Media notelor");
        double media = sumaNotelor / studentiCuNote.size();
        System.out.println("Media aritmetica este: " + String.format("%.2f", media));
    }
}