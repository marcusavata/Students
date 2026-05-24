package ro.ulbs.proiectaresoftware.students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

class AplicatieCuBursaTest {

    AplicatieCuBursa appCuBursa = new AplicatieCuBursa();

    @Test
    void sortTest1() {
        List<StudentBursier> lista = appCuBursa.genereaza();

        List<StudentBursier> listaSortata = appCuBursa.sorteaza(lista);

        Comparator<StudentBursier> comparator = Comparator
                .comparing(StudentBursier::getFormatieDeStudiu)
                .thenComparing(StudentBursier::getNume)
                .thenComparing(StudentBursier::getPrenume)
                .thenComparing(StudentBursier::getNota)
                .thenComparing(StudentBursier::getCuantumBursa);

        for (int i = 0; i < listaSortata.size() - 1; i++) {
            StudentBursier curent = listaSortata.get(i);
            StudentBursier urmator = listaSortata.get(i + 1);

            Assertions.assertTrue(comparator.compare(curent, urmator) <= 0,
                    "Lista nu a fost sortata corect la indexul " + i);
        }
    }
}