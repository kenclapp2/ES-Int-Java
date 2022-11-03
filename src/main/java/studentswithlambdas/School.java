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

    // Sorting a list MUTATES the original list
    System.out.println("before sorting");
    showAllStudents(roster);
//    roster.sort((s1, s2) -> { return s2.getName().compareTo(s1.getName()); } );
    roster.sort((s1, s2) -> s2.getName().compareTo(s1.getName()));
    System.out.println("after sorting");
    showAllStudents(roster);
    roster.sort(
        (s1, s2) -> {
          System.out.println("comparing " + s1 + " with " + s2);
          return Double.compare(s1.getGpa(), s2.getGpa());
        }
    );
    System.out.println("after sorting by gpa");
    showAllStudents(roster);

    System.out.println("descending length -------------");
//    roster.sort((s1, s2) -> s2.getName().length() - s1.getName().length());
    roster.sort((s1, s2) -> Integer.compare(
        s2.getName().length(), s1.getName().length()));
    System.out.println(roster);
    System.out.println("-------------");

    /*
    order by:
    ascending grade
    descending length of name
    ascending number of courses

    if done :) look at these methods
    Iterable forEach -- use it to print an entire list
      (Consumer, one argument, returns void... a lot like println :)
    List replaceAll -- use it to change a list of String
      to upper case (note it does mutate the original data)
    List removeIf -- use it to remove "long Strings" from
      your list of strings above
     */
    List<String> names =
        new ArrayList<>(List.of("Fred", "Jim", "Sheila", "Albert", "Susan"));
    System.out.println(names);

    names.forEach(x -> System.out.println(x));
    System.out.println("----------------------");
    names =
        new ArrayList<>(List.of("Fred", "Jim", "Sheila", "Albert", "Susan"));
    System.out.println(names);
    names.replaceAll(x -> x.toUpperCase());
    names.forEach(x -> System.out.println(x));
    System.out.println("----------------------");

    names =
        new ArrayList<>(List.of("Fred", "Jim", "Sheila", "Albert", "Susan"));
    System.out.println(names);
    names.removeIf(
        (String s) -> {
          System.out.println("testing " + s + " to see if I like it...");
          boolean like = s.length() > 4;
          System.out.println("... " + (like ? "I do!" : "I don't :("));
          return like;
        }
    );
    System.out.println(names);
  }
}




