package education.humans;

public class Student {
  private String name;
  private double gpa;
  /* many courses... each is String ??? */
  // IF (but ONLY if) we provide zero "constructors" (really initializers)
  // THEN Java creates one for us. That "default" constructor takes no
  // arguments and leaves the object full of zeroes (new does the zeroing).
//  public Student() {
//    // nothing interesting here.
//  }
    Student(String n, double gpa) {
//    if (! Student.isValid()...)
    if (! isValid(n, gpa)) {
      throw new IllegalArgumentException("Bad student values");
    }
    name = n; // equivalent to this.name = n;
    this.gpa = gpa;
  }

  public static Student of(String name, double gpa) {
      if (gpa > 3.5) {
        return new VIPStudent(name, gpa);
      } else {
        return new Student(name, gpa);
      }
  }

  public String getName(/*Student this*/) {
    return this.name;
  }

  public void setName(/*Student this, */String name) {
    if (!isValid(name, this.gpa)) {
      throw new IllegalArgumentException("Bad name");
    }
    this.name = name;
  }

  public double getGpa(/*Student this*/) {
    return this.gpa;
  }

  public void setGpa(/*Student this, */double gpa) {
    if (!isValid(this.name, gpa)) {
      throw new IllegalArgumentException("Bad gpa");
    }
    this.gpa = gpa;
  }


  // concept-wide behavior!!!
  public static boolean isValid(String name, double gpa) {
    // evaluates left to right, || is "or" and if the lhs is true
    // skips evaluation of rhs, && is "and" and if lhs is false
    // skips eval of rhs
    return name != null && name.length() != 0
        && gpa >= 0 && gpa <= 5.0;
  }
}

class VIPStudent extends Student {
  /*public */VIPStudent(String name, double gpa) {
    super(name, gpa * 1.1);
  }

  public void setGpa(double gpa) {
    super.setGpa(gpa * 1.1);
  }

  public int getDonation() {
    return 10_000;
  }
}

//class Date {
//  private int day, month, year;
//
//  set day of month(d)_{
//    if (d with month and year is ok)
//      change day to d.
//  }
//}
