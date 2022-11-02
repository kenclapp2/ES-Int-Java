package studentv2;

import java.util.ArrayList;
import java.util.List;

/*
an interface describing a (single) method that "qualifies" a Student (pass/fail)
one or more implementations of that for different criteria
"getStudentsByCriterion" method--args are many students, and a single
  criterion object. It returns the list of students that pass the test
"show all student" which simply prints every student in a list
 */

interface CriterionOfStudent {
  boolean test(Student s);
}

class SmartStudent implements CriterionOfStudent {
  private double threshold;

  public SmartStudent(double threshold) {
    this.threshold = threshold;
  }

  @Override
  public boolean test(Student s) {
    return s.getGpa() > threshold;
  }
}

class EnthusiasticStudent implements CriterionOfStudent {
  @Override
  public boolean test(Student s) {
    return s.getCourses().size() > 2;
  }
}

class FirstHalfAlpha implements CriterionOfStudent {

  @Override
  public boolean test(Student s) {
    return s.getName().toUpperCase().charAt(0) <= 'M';
  }
}

public class School {
  public static void showAllStudents(Iterable<Student> ls) {
    for (Student s : ls) {
      System.out.println("> " + s);
    }
  }

//  private static double threshold = 3.0;
//
//  public static void showSmartStudents(Iterable<Student> ls) {
//    showSmartStudents(ls, threshold);
//  }

//  public static void showSmartStudents(
//      Iterable<Student> ls, double threshold) {
//    for (Student s : ls) {
//      if (s.getGpa() > threshold) {
//        System.out.println("> " + s);
//      }
//    }
//  }

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

//  public static List<Student> getSmartStudents(
//      Iterable<Student> is, double threshold) {
//    List<Student> results = new ArrayList<>();
//    for (Student s : is) {
//      if (s.getGpa() > threshold) {
//        results.add(s);
//      }
//    }
//    return results;
//  }
//
//  public static List<Student> getEnthusiasticStudents(
//      Iterable<Student> is, int threshold) {
//    List<Student> results = new ArrayList<>();
//    for (Student s : is) {
//      if (s.getCourses().size() > threshold) {
//        results.add(s);
//      }
//    }
//    return results;
//  }
//
  public static void main(String[] args) {
    System.out.println("NEW SCHOOL EXAMPLE");
    List<Student> roster = new ArrayList<>();
    roster.add(Student.of("Fred", 3.2, "Math", "Physics"));
    roster.add(Student.of("Jim", 2.2, "Journalism"));
    roster.add(Student.of("Shiela", 3.8,
        "Math", "Physics", "Astrophysics", "Quantum Mechanics"));

    showAllStudents(roster);
    System.out.println("smart: -----------------");
    showAllStudents(
        getStudentsByCriterion(
            roster, new SmartStudent(3.0)));

    System.out.println("enthusiastic: -----------------");
    showAllStudents(
        getStudentsByCriterion(
            roster, new EnthusiasticStudent()));

    System.out.println("enthusiastic: -----------------");
    showAllStudents(
        getStudentsByCriterion(
            roster, new FirstHalfAlpha()));

//    showAllStudents(roster);
//    System.out.println("smart: -----------------");
//    showAllStudents(getSmartStudents(roster, 3.0));
//    System.out.println("enthusiastic: -----------------");
//    showAllStudents(getEnthusiasticStudents(roster, 3));

    // sample behaviors!! Not implemented :)
//    sendToDatabase(getSmartStudents(roster, 2.8));
//    transferOverNetwork(getSmartStudents(roster, 2.8));

//    showSmartStudents(roster);
//    showSmartStudents(roster, 3.0);
//    System.out.println("-----------------");
//    threshold = 2.0;
//    showSmartStudents(roster, 2.0);
//    System.out.println("-----------------");
//    showSmartStudents(roster, 2.0);
//    System.out.println("-----------------");
//    education.humans.UseAStudent.main(new String[0]);
    System.out.println("NEW SCHOOL EXAMPLE ENDS");
  }
}
