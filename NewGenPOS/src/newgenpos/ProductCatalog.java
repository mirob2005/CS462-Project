package newgenpos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ProductCatalog {
    //CHange to private when able
    public static Connection con = null;
    private ItemID itemID;
    private Money price;
    private ProductDescription description;
        
    public ProductCatalog() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/NewGenPOS", "root", "cs462");

        } catch (Exception e) {
            System.out.println("Database Not Connected, Product IDs will not be found!");
        } 
    }
    
    public ProductDescription getProductDescription(ItemID ItemID){
        description = new ProductDescription(ItemID);
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
