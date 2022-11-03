package exceptions;

import java.io.*;
import java.sql.SQLException;

public class TryWithResources {
  public static void main(String[] args) {
    try ( // stuff declared / initialized in these PARENS
          // will be closed in reverse order of mention
          // "resources" must implement AutoCloseable...
        Reader in = new FileReader("a.txt");
        BufferedReader br = new BufferedReader(in);
    ) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println("> " + line);
      }
      if (Math.random() > 0.5) {
        throw new SQLException("DB busted!");
      }
    } catch (FileNotFoundException e) {
      System.err.println("File wasn't found, ouch!");
      e.printStackTrace();
    }
//    If we simply catch "Exception" we will catch BOTH
//    IO, and SQL exceptions BUT we also catch a bunch of
//    other stuff!!! Including all the "program bug" unchecked
//    exceptions such as array index issues...
//     catch (Exception e) {
//      e.printStackTrace();

// use "multi-catch" to handle several non-parent/child
// type exceptions the same way without code duplication
    catch (IOException | SQLException e) {
      e.printStackTrace();
    }

//    } catch (IOException ioe) {
//      ioe.printStackTrace();
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
    // auto-generated finally created for us
  }
}
