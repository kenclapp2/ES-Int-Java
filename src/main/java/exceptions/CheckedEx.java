package exceptions;

import java.sql.SQLException;

public class CheckedEx {
  public static void mightBreak() throws SQLException {
//    try {
      if (Math.random() > 0.5) {
        throw new SQLException("Database busted!");
      }
//    } catch (SQLException sqle) {
//    } catch (Exception sqle) {
//      sqle.printStackTrace();
//    }
  }

  public static void main(String[] args) {
    try {
      mightBreak();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
