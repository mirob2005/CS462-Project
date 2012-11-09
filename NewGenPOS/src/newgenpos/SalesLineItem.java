package newgenpos;

public class SalesLineItem {
    private int quantity;
    private ProductDescription description;
    private Money price;
    private Money subtotal;
    
    public SalesLineItem(ProductDescription desc, int qty) {
        this.quantity = qty;
        this.description = desc;
        this.price = this.description.getPrice();
    }
    public Money getSubtotal(){
        this.subtotal = this.price.mutliply(this.price, this.quantity);
        return this.subtotal;    
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
