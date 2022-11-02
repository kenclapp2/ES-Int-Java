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
    System.out.println("ORIGINAL USE A STUDENT!!!");
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

    studentv2.School.main(new String[0]);
    System.out.println("ORIGINAL USE A STUDENT ENDS HERE!!!!!");
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

class Scratch {
  public static void showADate(int day, int month, int year) {
    System.out.println("Day is " + day + " month is " + month
      + " year is " + year);
  }

  public static void main(String[] args) {
    // positional parameter passing. Must be in the right order!!
    showADate(12, 11, 2022);
//    showADate(12, 26, 2022);
    // some languages but NOT JAVA allow "named" parameter passing
    // NOT the same as "pass by name"
//    showADate(month=12, day=26, year=2022);
//    showADate(month: 12, day: 26, year: 2022);
  }
}