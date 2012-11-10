package newgenpos;

class ProductDescription {
    private String description;
    private Money price;
    private ItemID itemID;
    private int stockRemaining;
    
    public ProductDescription(ItemID ID, String Name, Money Price, int Stock){
        this.itemID = ID;
        this.description = Name;
        this.price = Price;
        this.stockRemaining = Stock;
    }
    public ItemID getItemID(){
        return this.itemID;
    }
    public String getDescription(){
        return this.description;
    }
    public Money getPrice(){
        return this.price;
    }
    public int getStock(){
        return this.stockRemaining;
    }   
}
