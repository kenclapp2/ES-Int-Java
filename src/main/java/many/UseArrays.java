package many;

//import java.util.Arrays;

public class UseArrays {
//  public static void doStuff(int x, String s, double [] values) {
  public static void doStuff(int x, String s, double ... values) {
    System.out.printf("You send x = %d and text %s and values %s\n",
        x, s, values);
  }
  public static void main(String[] args) {
    double [] numbers = {3.14, 2.7, 99.9, 100};
    doStuff(99, "Red baloons", numbers);
    doStuff(99, "Red baloons", new double []{3.14, 2.7, 99.9, 100});
    doStuff(99, "Red baloons", 3.14, 2.7, 99.9, 100);
  }
//  public static void main(String[] args) {
//    String[] names = new String[3]; // after creation, size is fixed
//    int count = 0;
//    names[count++] = "Fred"; // zero-based indexing
//    names[count++] = "Jim";
//    names[count++] = "Sheila";
//    System.out.println(count == names.length);
//    System.out.println("array has " + names.length + " elements "
//        + " which are " + Arrays.toString(names));
//
//    String [] newNames = new String[10];
//    System.arraycopy(names, 0, newNames, 0, names.length);
//    names = newNames;
//    names[count++] = "Albert";
//    System.out.println("array has " + names.length + " elements "
//        + " which are " + Arrays.toString(names));
//  }

//  public static void main(String[] args) {
//    String [] names = new String[3]; // after creation, size is fixed
//    names[0] = "Fred"; // zero-based indexing
//    names[2] = "Sheila";
//    System.out.println("array has " + names.length + " elements "
//    + " which are " + Arrays.toString(names));
//
////    String [] names2 = new String[]{"Alice", "Bob", "Clive"};
//    String [] names2 = {"Alice", "Bob", "Clive"};
//    System.out.println(Arrays.toString(names2));
//
//    System.out.println(names2);
//
//    int [] nums = {1, 3, 5, 7, 9};
//    System.out.println(nums);
//    System.out.println(Arrays.toString(nums));
//
//    var x = 2_000_000_000;
////    x = "Hello"; // NOPE this is type inferencing, NOT dynamic typing
//  }
}
