package newgenpos;

import java.util.Date;

class Sale {
    private boolean isComplete;
    private Date time;
    private Payment payment;
    private SalesLineItem cart;
    private Money subTotal;
    private Money total;
    private double tax;
       
    public Sale(){
        isComplete = false;
        time = new Date();
    }
    
    public boolean isComplete(){
        return isComplete;
    }
    
    public void becomeComplete(){
        isComplete = true;
    }
    
    public void makeLineItem(ProductDescription desc, int qty){
        cart = new SalesLineItem(desc, qty);
    }
    
    public void makePayment(Money cashTendered){
        payment = new Payment(cashTendered);
    }
    
    public Money getTotal(){
        subTotal = cart.getSubtotal();
        total = subTotal.calcTotal(tax);
         
        return total;
    }
}
