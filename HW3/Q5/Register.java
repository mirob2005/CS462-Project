package newgenpos;

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
    public void enterItem(ItemID ItemID, int qty){
        description = catalog.getProductDescription(ItemID);
        currentSale.makeLineItem(description, qty);
    }
    public void makeNewSale(){
        currentSale = new Sale();
    }
    public void makePayment(Money cashTendered){
        currentSale.makePayment(cashTendered);
    }
}
