package newgenpos;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.net.*;


public class ProductCatalog {
    //CHange to private when able
    public static Connection con = null;
    private ProductDescription description;
        
    public ProductCatalog() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/NewGenPOS", "root", "cs462");

        } catch (Exception e) {
            System.out.println("Database Not Connected, Product IDs will not be found!");
        } 
    }
    
    public ProductDescription getProductDescription(ItemID ItemID, int qty)throws SQLException{
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Inventory where itemID = "+ ItemID.itemID());
        
        String ItemName = rs.getString("description");
        double price = rs.getDouble("price");
        Money ItemPrice = new Money(price);
        int ItemStock = rs.getInt("stock") - qty;
        
        description = new ProductDescription(ItemID, ItemName, ItemPrice, ItemStock);
        return description;
    }
    
    public boolean connectionActive(){
        if(con != null){
            return true;
        }
        else {
            return false;
        }     
    }
}
