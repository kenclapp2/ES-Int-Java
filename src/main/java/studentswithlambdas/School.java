package studentswithlambdas;

import java.util.ArrayList;
import java.util.List;

interface CriterionOfStudent {
  boolean test(Student s);
}

public class School {
  public static void showAllStudents(Iterable<Student> ls) {
    for (Student s : ls) {
      System.out.println("> " + s);
    }
  }

  public static List<Student> getStudentsByCriterion(
      Iterable<Student> is, CriterionOfStudent crit) {
    List<Student> results = new ArrayList<>();
    for (Student s : is) {
      if (crit.test(s)) {
        results.add(s);
      }
    }
    return results;
  }

  public static void main(String[] args) {
    List<Student> roster = new ArrayList<>();
    roster.add(Student.of("Fred", 3.2, "Math", "Physics"));
    roster.add(Student.of("Jim", 2.2, "Journalism"));
    roster.add(Student.of("Shiela", 3.8,
        "Math", "Physics", "Astrophysics", "Quantum Mechanics"));

    System.out.println("unenthusiastic: -----------------");

    showAllStudents(
        getStudentsByCriterion( roster, s -> s.getCourses().size() < 2 ));

  }
}
