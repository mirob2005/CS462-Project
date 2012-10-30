package newgenpos;

public class Store {
    private int storeID;
    private String address;
    private String name;
    private ProductCatalog catalog = new ProductCatalog();
    private Register register = new Register(catalog);
    
    public Store(int StoreID, String Address, String Name){
        this.storeID = StoreID;
        this.address = Address;
        this.name = Name;
    }
    
    public Register getRegister(){
        return register;
    }
    
    public void addCompleteSale(Sale SaleID){
        //...
    }
}
