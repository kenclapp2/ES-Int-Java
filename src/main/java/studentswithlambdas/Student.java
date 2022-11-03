package studentswithlambdas;

public class Student {
  private String name;
  private double gpa;
  private java.util.List<String> courses;

  private Student(String name, double gpa, java.util.List<String> courses) {
    this.name = name;
    this.gpa = gpa;
    this.courses = courses;
  }

  public static Student of(String name, double gpa, String ... courses) {
    return new Student(name, gpa, java.util.List.of(courses));
  }

  public String getName() {
    return name;
  }

  public double getGpa() {
    return gpa;
  }

  public java.util.List<String> getCourses() {
    return courses;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", gpa=" + gpa +
        ", courses=" + courses +
        '}';
  }
}
