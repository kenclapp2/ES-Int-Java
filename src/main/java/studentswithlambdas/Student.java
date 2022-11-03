package studentswithlambdas;

import java.util.List;

// final class prohibits subclassing!!!!
public final class Student {
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

  @Override
  public boolean equals(Object obj) {
//    if (obj instanceof Student) {
//      Student other = (Student)obj;

    if (this.getClass() == obj.getClass()) {
      Student other = (Student)obj;
      return other.name.equals(this.name)
          && other.gpa == this.gpa
          && other.courses.equals(this.courses);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = name != null ? name.hashCode() : 0;
    temp = Double.doubleToLongBits(gpa);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (courses != null ? courses.hashCode() : 0);
    return result;
  }
}

//class VIPStudent extends Student {
//  private int donationAmount;
//  public VIPStudent(String name, double gpa, List<String> courses,
//                    int donationAmount) {
//    super(name, gpa, courses); // oops, that's private
//  }
//
//  @Override
//  public boolean equals(Object obj) {
//    if (obj instanceof VIPStudent) {
//      // compare all four fields
//    }
//    return false;
//  }
//}
