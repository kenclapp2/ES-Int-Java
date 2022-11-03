package studentswithlambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EqualStudents {
  public static void main(String[] args) {
    Student s1 = Student.of("Fred", 3.2, "Math");
    Student s2 = Student.of("Fred", 3.2, "Math");
    System.out.println("student s1 == s2 " + (s1 == s2));
    System.out.println("student s1.equals(s2) " + (s1.equals(s2)));

    String st1 = "Hello";
    String st2 = "He";
    String st3 = st2 + "llo";
    System.out.println("st1 == st3 " + (st1 == st3 ));
    System.out.println("st1.equals(st3) " + (st1.equals(st3)));

    StringBuilder sb1 = new StringBuilder("Hello");
    StringBuilder sb2 = new StringBuilder("Hello");
    System.out.println("sb1 == sb2 " + (sb1 == sb2));
    System.out.println("sb1.equals(sb2) " + (sb1.equals(sb2)));

    List<String> names = new ArrayList<>(List.of("Fred", "Jim", "Sheila"));
    System.out.println(Collections.binarySearch(names, "Fred"));
    System.out.println(Collections.binarySearch(names, "Albert"));
    System.out.println(Collections.binarySearch(names, "Harry"));

    names.set(1, "Aardvark");
    System.out.println(Collections.binarySearch(names, "Fred"));
  }
}
