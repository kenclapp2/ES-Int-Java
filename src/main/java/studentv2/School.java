package studentv2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class School {
  public static void showAllStudents(Iterable<Student> ls) {
    for (Student s : ls) {
      System.out.println("> " + s);
    }
  }

  public static void main(String[] args) {
    List<Student> roster = new ArrayList<>();
    roster.add(Student.of("Fred", 3.2, "Math", "Physics"));
    roster.add(Student.of("Jim", 2.2, "Journalism"));
    roster.add(Student.of("Shiela", 3.8,
        "Math", "Physics", "Astrophysics", "Quantum Mechanics"));

    showAllStudents(roster);
  }
}
