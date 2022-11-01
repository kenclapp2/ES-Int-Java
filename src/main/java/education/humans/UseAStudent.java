package education.humans;

public class UseAStudent {
  void otherStuff() {
    float f = 3.2F;
    long x = 3_000_000_000L;
  }

  public static void showAStudent(Student s) {
    System.out.println("Student " + s.getName() + " has gpa " + s.getGpa());
  }

  public static void main(String[] args) {
//    Student s1 = new Student("Fred", 3.2);
//    Student s2 = new Student("Jim", 2.2);
    Student s1 = Student.of("Fred", 3.2);
    Student s2 = Student.of("Jim", 2.2);

    System.out.println(s1.getName());
    System.out.println(s1.getGpa());
    System.out.println(s2.getName());
    System.out.println(s2.getGpa());
    s2.setGpa(2.8);
    System.out.println(s2.getName());
    System.out.println(s2.getGpa());

//    VIPStudent rich = new VIPStudent("Rich", 3.6);
    Student rich = Student.of("Rich", 3.6);
    showAStudent(rich);

    Student richAgain = rich;
    richAgain.setGpa(2.0);
    /*UseAStudent.*/showAStudent(rich);
//    /*UseAStudent.*/showAStudent(richAgain);
  }

  // private fields won't let us do this
//  public static void main(String[] args) {
//    Student s1 = new Student();
//    s1.name = "Fred";
//    s1.gpa = 3.2; // double type literal
//
//    System.out.println(s1.name);
//    System.out.println(s1.gpa);
//
//    Student s2 = new Student();
//    s2.name = "Jim";
//    s2.gpa = 10.2;
//
//    System.out.println(s2.name);
//    System.out.println(s2.gpa);
//  }
}
