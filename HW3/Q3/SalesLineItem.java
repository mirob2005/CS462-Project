package newgenpos;

public class SalesLineItem {
    private int quantity;
    private ProductDescription description;
    private Money subtotal;
    
    public SalesLineItem(ProductDescription desc, int qty) {
        this.quantity = qty;
        this.description = desc;
    }
    public Money getSubtotal(){
        //...
        return subtotal;    
    }
    
}
