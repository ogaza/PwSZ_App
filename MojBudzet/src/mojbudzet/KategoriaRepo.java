package mojbudzet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KategoriaRepo {

    public static void pobierzWszystkie() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/mojbudzet";
        String user = "root";
        String password = "";

        try {

            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * from Kategoria");

            while (rs.next()) {
                
                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(KategoriaRepo.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {

            try {

                if (rs != null) {
                    rs.close();
                }

                if (st != null) {
                    st.close();
                }

                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(KategoriaRepo.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }

}
