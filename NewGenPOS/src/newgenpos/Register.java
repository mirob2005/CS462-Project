package newgenpos;

class Register {
    private ProductCatalog catalog;
    private Sale currentSale;
    
    public Register(ProductCatalog pc){
        this.catalog = pc;
    }
    public void endSale(){
        //...
    }
    public void enterItem(ItemID ItemID, int qty){
        //...
    }
    public void makeNewSale(){
        //...
    }
    public void makePayment(Money cashTendered){
        //...
    }
}
