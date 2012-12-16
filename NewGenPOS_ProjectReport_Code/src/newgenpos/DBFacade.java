/*
 * HW5.1 Facade Design Pattern AND Singleton
 */
package newgenpos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBFacade {
    private static Connection con = null;
    private static DBFacade instance = null; 
    
    private DBFacade() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost/NewGenPOS", "root", "cs462");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static synchronized DBFacade getDBconnection(){
        if(instance == null){
            try {
                instance = new DBFacade();
            } catch (SQLException ex) {
                Logger.getLogger(DBFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return instance;
    }  
    public ResultSet selectItemsFromDB(String sqlStmt) throws SQLException{
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sqlStmt);
        return rs;
    }
    public void insertItemsIntoDB(String sqlStmt) throws SQLException{
        Statement st = con.createStatement();
        st.executeUpdate(sqlStmt);
    }
    public void updateItemsInDB(String sqlStmt) throws SQLException{
        Statement st = con.createStatement();
        st.executeUpdate(sqlStmt);  
    }
    public static boolean connectionActive(){
        if(instance != null){
            return true;
        }
        else {
            return false;
        }     
    }    
}
