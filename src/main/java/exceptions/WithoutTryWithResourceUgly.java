package exceptions;

import java.io.*;

public class WithoutTryWithResourceUgly {
  public static void main(String[] args) {
    // InputStream, OutputStream abstract base classes
    // used for 8 bit (probably therefore binary) data IO
    // Reader, Writer, are 16 bit Unicode base types
    // used for character IO. Internally, Java uses
    // unicode

    try {
      // Gang of Four "Decorator" pattern
      Reader in = new FileReader("a.txt");
      BufferedReader br = new BufferedReader(in);
//      int ch;
//      while ((ch = in.read()) != -1) {
//        System.out.print((char)ch);
//      }

      String line;
      while ((line = br.readLine()) != null) {
        System.out.println("> " + line);
      }

      // close here might not happen if exceptions arise
      // during the body of the try!!!
//      br.close();
//      in.close();

      // Not permitted to catch a *checked* exception
      // that isn't possible
//    } catch (SQLException e) {
//      e.printStackTrace();
    } catch (FileNotFoundException e) {
//      throw new RuntimeException(e);
      e.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    } finally {
      // close and clean up...
      // BUT!!!
      // these are out of scope.
      // if we make the scope wider, we end up with a whole bunch more problems
      // uninitialzed? or null?
      // AND ANYWAY close methods typically are declared to throw
      // IOException
//      br.close();
//      in.close();

    }
  }
}
