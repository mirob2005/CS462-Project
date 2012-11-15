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
    private double tax = 1.08;
       
    public Sale(){
        this.isComplete = false;
        this.time = new Date();
        this.subTotal = new Money(0);
        this.total = new Money(0);
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
        this.total = this.subTotal.calcTotal(tax);            
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
}
