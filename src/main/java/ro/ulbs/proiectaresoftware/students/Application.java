import ro.ulbs.proiectaresoftware.students.Student;
import java.util.HashSet;
import java.util.ArrayList;

public static void main() {
    Student s1 = new Student(112,"Ioan","Popa","C21/1");
    Student s2 = new Student(112,"Maria","Oprea","C23/2");
    Student s3 = new Student(120,"Andrei","Ghita","C21/2");
    Student s4 = new Student(122,"Totu","John","C22/2");
    Student s5 = new Student(122,"Ioana","Nocila","C23/1");

    System.out.println(s1.toString());
    System.out.println(s2.toString());
    System.out.println(s3.toString());
    System.out.println(s4.toString());
    System.out.println(s5.toString());

    ArrayList<Student> listaStudenti = new ArrayList<>();
    listaStudenti.add(s1); listaStudenti.add(s2); listaStudenti.add(s3); listaStudenti.add(s4); listaStudenti.add(s5);

    HashSet<Student> setStudenti = new HashSet<>();
    setStudenti.add(s1); setStudenti.add(s2); setStudenti.add(s3); setStudenti.add(s4); setStudenti.add(s5);

    System.out.println("E Andrei prezent? " + s3.studentPrezent(listaStudenti));
    System.out.println("E Ioana prezenta? " + s5.studentPrezentSet(setStudenti));

    Test
}
