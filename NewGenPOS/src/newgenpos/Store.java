package newgenpos;

import java.sql.SQLException;

public class Store {
    private int storeID;
    private String address;
    private String name;
    private ProductCatalog catalog;
    private Register register;
    
    public Store(int StoreID, String Address, String Name)throws SQLException{
        this.storeID = StoreID;
        this.address = Address;
        this.name = Name;
        
        try{
            catalog = new ProductCatalog();
        } catch (Exception e) {
            System.out.println("Database Not Connected, Product IDs will not be found!");
        }
        int salesNumber = 1;
        try{
            salesNumber = catalog.getSalesNumber();
        } catch (Exception e) {
            System.out.println("Database Not Connected, Sales cannot be recorded!");
        }         
        register = Register.getRegister(salesNumber, this.catalog, this.storeID, this.address, this.name);        
    }
    
    public Register getRegister(){
        return register;
    }
}
