package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AplicatieThreaduri {

    public static void main(String[] args) {
        List<Student> studentiCititi = Collections.synchronizedList(new ArrayList<>());

        creeazaFisiereTest();

        Thread thread1 = new Thread(new CititorThread("input_thread_1.txt", studentiCititi), "Thread-Fisier-1");
        Thread thread2 = new Thread(new CititorThread("input_thread_2.txt", studentiCititi), "Thread-Fisier-2");

        System.out.println("Pornim thread-urile pentru citire...");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread-ul principal a fost intrerupt.");
        }

        System.out.println("\nCitirea paralela s-a incheiat! S-au gasit in total " + studentiCititi.size() + " studenti.");

        for (Student s : studentiCititi) {
            System.out.println(s);
        }

        Student.outputStudentList(studentiCititi, "output_din_threaduri.txt");
    }

    private static void creeazaFisiereTest() {
        try {
            java.io.PrintWriter w1 = new java.io.PrintWriter(new java.io.FileWriter("input_thread_1.csv"));
            w1.println("100,Vasile,Muresan,TI21");
            w1.println("101,Ana,Gheorghe,TI21");

            java.io.FileWriter csvWriter = new java.io.FileWriter("input_thread_1.csv");
            csvWriter.append("NumarMatricol");
            csvWriter.append(",");
            csvWriter.append("Prenume");
            csvWriter.append(",");
            csvWriter.append("Nume");
            csvWriter.append(",");
            csvWriter.append("FormatieDeStudiu");
            csvWriter.append("/n");
            csvWriter.flush();
            w1.close();

            java.io.PrintWriter w2 = new java.io.PrintWriter(new java.io.FileWriter("input_thread_2.txt"));
            w2.println("200,Mihai,Eminescu,ISM11");
            w2.println("201,Ion,Creanga,ISM11");

            java.io.FileWriter csvWriter1 = new java.io.FileWriter("input_thread_2.csv");
            csvWriter1.append("NumarMatricol");
            csvWriter1.append(",");
            csvWriter1.append("Prenume");
            csvWriter1.append(",");
            csvWriter1.append("Nume");
            csvWriter1.append(",");
            csvWriter1.append("FormatieDeStudiu");
            csvWriter1.append("/n");
            csvWriter1.flush();
            w2.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}