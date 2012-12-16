package newgenpos;

public class SalesLineItem {
    private int quantity;
    private ProductDescription description;
    private Money price;
    
    public SalesLineItem(ProductDescription desc, int qty) {
        this.quantity = qty;
        this.description = desc;
        this.price = this.description.getPrice();
    }
    public Money getPrice(){
        return price;
    }
    public ProductDescription getDescription(){
        return this.description;
    }
    public int getQty(){
        return this.quantity;
    }
}
