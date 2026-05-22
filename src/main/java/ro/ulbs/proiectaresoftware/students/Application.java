import ro.ulbs.proiectaresoftware.students.Student;

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
}
