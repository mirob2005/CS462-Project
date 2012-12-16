package newgenpos;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProductCatalog {    
    private ProductDescription description;   
    private DBFacade DBconnection;
    
    public ProductCatalog(){
        DBconnection = DBFacade.getDBconnection();
    }
    
    public ProductDescription getProductDescription(ItemID ItemID, int qty){
        try {                        
            String query = "select * from Inventory where itemID = "+ ItemID.getINT();
            ResultSet rs = DBconnection.selectItemsFromDB(query);

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
                    query = "UPDATE Inventory SET stock = "+updatedStock+" WHERE itemID = "+ItemID.getINT();
                    DBconnection.updateItemsInDB(query);
                    description = new ProductDescription(ItemID, ItemName, ItemPrice, updatedStock);    
                }         
            }  
        } catch (SQLException ex) {
            Logger.getLogger(ProductCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return description;
    }
    public int getSalesNumber()throws SQLException{
        int salesNumber = 0;        
        
        String query = "SELECT salesNumber FROM newgenpos.Sales order by salesNumber desc limit 1";
        ResultSet rs = DBconnection.selectItemsFromDB(query);
        
        if(rs.first() == false){
            salesNumber = 1;
        }
        else{
            salesNumber = rs.getInt("salesNumber");
            salesNumber++;
        }
        return salesNumber;
    }
}
