package newgenpos;

import java.sql.*;


public class ProductCatalog {
    private static Connection con = null;
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
        ResultSet rs = st.executeQuery("select * from Inventory where itemID = "+ ItemID.getINT());
        
        if(rs.first() == false)
        {
            Ui_NewGenPOS.setText("Product with ID of \"" + ItemID.getINT() + "\" DOES NOT exist. Please try again.");
            description = null;
        }
        else
        {                   
            String ItemName = rs.getString("description");
            double price = rs.getDouble("price");
            Money ItemPrice = new Money(price);
            int currentStock = rs.getInt("stock");

            int updatedStock = currentStock - qty;                    
            if(updatedStock <0){
                if(qty == 1)
                {
                    Ui_NewGenPOS.setText("No "+ItemName+"'s are left. Please chose another item.");
                }
                else
                {
                    Ui_NewGenPOS.setText("Only "+currentStock+" "+ItemName+"'s are left. Please reduce quantity requested.");
                }            
                description = null;
            }
            else
            {
                st.executeUpdate("UPDATE Inventory SET stock = "+updatedStock+" WHERE itemID = "+ItemID.getINT());  
                description = new ProductDescription(ItemID, ItemName, ItemPrice, updatedStock);    
            }         
        }
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
