package interfaces;

import java.util.ArrayList;
import java.util.List;

interface Nameable {
  // everything in an interface is public, unless expressly
  // marked private, attempting to mark as something else is an error
  String getName(); // abstract method

  // Since Java 8 interfaces can contain:
  // static methods with implementations both public or private

  static String getUppercaseName(Nameable n) {
    return n.getName().toUpperCase();
  }

  private void debugMe() {
    System.out.println(this.getName());
  }

  // default methods are public instance methods used as "fallback"
  // they mandate an implementation will exist for the class that
  // claims to implement this inteface, but if (but only if) none
  // is found in the class hierarchy, then use this one instead
  default String getFancyName() {
    System.out.println("using default method...");
    return "Mr/Mrs/Ms/Mx" + this.getName();
  }
}

class Person /*extends Object */implements Nameable {
  private String name;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString() {
    return "Person with name: " + name;
  }
}

class Automobile implements Nameable {
  private String vehibleName;

  public Automobile(String name) {
    this.vehibleName = name;
  }

  public String getName() {
    return vehibleName;
  }

  public void setName(String vehibleName) {
    this.vehibleName = vehibleName;
  }

  public String getFancyName() {
    return "Lovely car: " + vehibleName;
  }

  @Override
  public String toString() {
    return "I'm an automobile, my owner calls me " + vehibleName;
  }
}

public class Example {
  public static void main(String[] args) {
    Person p = new Person("Fred");
    Automobile a = new Automobile("Myrtle");
    System.out.println(p.getName());
    System.out.println(a.getName());

    ArrayList<Nameable> namedThings = new ArrayList<>();
    namedThings.add(p);
    namedThings.add(a);

    System.out.println(namedThings.get(0).getFancyName());
    System.out.println(namedThings.get(1).getFancyName());

    System.out.println("-----------------");
    for (Nameable n : namedThings) {
      System.out.println(n);
    }
  }
}

/*
prepareStatement(CheckingAccount ca)
prepareStatement(SavingsAccount ca)
prepareStatement(MortgageAccount ca)

instead:
interface TransactionHistory {
  ArrayList<Transaction> getTransactionHistory();
}
class CheckingAccount implements TransacionHistory, AnotherCapability {}
class SavingAccount implements TransacionHistory {}

// this method accepts any of our accounts
prepareStatement(TransactionHistory th) {}
 */
// look up Arrays.asList and / or List.of