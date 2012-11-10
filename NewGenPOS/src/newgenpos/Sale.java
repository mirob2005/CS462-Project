package newgenpos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Sale {
    private boolean isComplete;
    private Date time;
    private Payment payment;
    private SalesLineItem item;
    private List<SalesLineItem> cart = new ArrayList<>();
    private Money subTotal;
    private Money total;
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

        Ui_NewGenPOS.displayTotal(this.total);        
    }
    
    public void makePayment(Money cashTendered){
        payment = new Payment(cashTendered);
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
}
