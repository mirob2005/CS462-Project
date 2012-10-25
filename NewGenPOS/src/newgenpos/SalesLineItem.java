package newgenpos;

public class SalesLineItem {
    private int quantity;
    private ProductCatalog description;
    private Money subtotal;
    
    public SalesLineItem(ProductCatalog desc, int qty) {
        this.quantity = qty;
        this.description = desc;
    }
    public Money getSubtotal(){
        //...
        return subtotal;    
    }
    
}
