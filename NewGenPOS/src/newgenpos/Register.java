package newgenpos;

import java.sql.SQLException;

class Register {
    private ProductCatalog catalog;
    private Sale currentSale;
    private ProductDescription description;
    
    public Register(ProductCatalog pc){
        this.catalog = pc;
    }
    public void endSale(){
        currentSale.becomeComplete();
    }
    public void enterItem(ItemID ItemID, int qty)throws SQLException{
        description = catalog.getProductDescription(ItemID, qty);
        //No such ItemID or out of stock returns description = null
        if(description == null){
            Ui_NewGenPOS.clearProductInput();
        }
        else
        {
            currentSale.makeLineItem(description, qty);    
        }        
    }
    public void makeNewSale(){
        currentSale = new Sale();
    }
    public void makePayment(Money cashTendered){
        currentSale.makePayment(cashTendered);
    }
    public ProductCatalog getProductCatalog(){
        return this.catalog;
    }
}
