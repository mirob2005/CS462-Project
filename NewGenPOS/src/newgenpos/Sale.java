package newgenpos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Sale {
    private boolean isComplete;
    private Date time;
    private SalesLineItem item;
    private List<SalesLineItem> cart = new ArrayList<>();
    private Payment payment;
    private Money subTotal;
    private Money total;
    private Money cashBack;
    private Money discount;
    private Pricing pricing;    
       
    public Sale(){
        this.isComplete = false;
        this.time = new Date();
        this.subTotal = new Money(0);
        this.total = new Money(0);
        this.pricing = new Pricing();        
    }
    
    public boolean isComplete(){
        return isComplete;
    }
    
    public void becomeComplete(){
        isComplete = true;
    }
    
    public void makeLineItem(ProductDescription desc, int qty){
        item = new SalesLineItem(desc, qty);
        Ui_NewGenPOS.addItemToTable(item);
        Ui_NewGenPOS.displayDescription(item);
        
        this.cart.add(item);
        this.calcSubTotal(item, qty);
        this.calcTotal();

        Ui_NewGenPOS.setDisplay(this.total);
    }
    
    public void makePayment(Payment paymentAmount){
        this.payment = paymentAmount;
        
        Money payment = this.payment.getAmount();
        this.cashBack = payment.subtract(this.total);              
    }
    public void calcSubTotal(SalesLineItem item, int qty){
         Money ItemPrice = item.getPrice();
        for(int i=0;i<qty;i++){
            this.subTotal = this.subTotal.add(ItemPrice);    
        }       
    }
    public void calcTotal(){
        this.total = this.pricing.calcTotal(this.subTotal);
        Ui_NewGenPOS.setDisplay(this.total);
    }
    public Money getDiscount(){
        this.discount = this.pricing.calcDiscount(subTotal);
        return this.discount;
    }
    public void setPricingStrategy(boolean discount){
        IPricingStrategy strategy;
        if(discount){
            strategy = new SeniorDiscountPricing();
        }        
        else {
            strategy = new StandardPricing();
        }
        this.pricing.setPricingStrategy(strategy);
    }
    public List<SalesLineItem> getCart(){
        return this.cart;
    }
    public Date getDate() {
        return this.time;
    }
    public Money getTotal(){
        return this.total;
    }
    public Money getSubTotal(){
        return this.subTotal;
    }
    public Money getCashBack(){
        return this.cashBack;
    }
    public Payment getPayment(){
        return this.payment;
    }
    //For Testing ONLY!
    public void setTotal(Money amount){
        this.total = amount;
    }            
}
