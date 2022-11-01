package verify;

record Message(String msg) {
}

public class Verify {
  public static void main(String[] args) {
    var m = new Message("Hello world!");
    switch (m) {
      case Message(String txt)when txt.length() > 3 -> System.out.println(txt);
      default -> throw new IllegalArgumentException();
    }
  }
}