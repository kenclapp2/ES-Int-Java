package many;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UseArrayList {

  public static void showAllElements(Iterable<String> ls) {
//    for (int idx = 0; idx < ls.size(); idx++) {
//      System.out.println(ls.get(idx));
//    }
    for (String s : ls) {
      System.out.println("> " + s);
    }
  }

  public static void main(String[] args) {
//    ArrayList<String> al = new ArrayList<String>(List.of(/*99, */"Welcome"));
//    var al = new ArrayList<String>(List.of(/*99, */"Welcome"));
//    ArrayList<String> al = new ArrayList<>(List.of(/*99, */"Welcome"));
//    LinkedList<String> al = new LinkedList<>(List.of(/*99, */"Welcome"));
    List<String> al = new LinkedList<>(List.of(/*99, */"Welcome"));
    System.out.println("number of elements in al is " + al.size());
    al.add("Hello"); // NOT using []
    al.add("Goodbye");
    showAllElements(al);
    System.out.println("number of elements in al is " + al.size());
    System.out.println("first element is " + al.get(0)); // zero based again
    al.set(1, "Au revoir");
    System.out.println(al);

//    al.add(99);
//    al.add(LocalDate.now());
//    System.out.println(al);
//    String itemZero = (String)al.get(0);
    String itemZero = al.get(0);
  }
}
