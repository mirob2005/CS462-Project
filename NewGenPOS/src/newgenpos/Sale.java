package newgenpos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Sale {
    private boolean isComplete = false;
    private Date time = new Date();
    private Payment payment;
    private List<SalesLineItem> lineItem = new ArrayList();
    private Money total;
       
    public Sale(){
        //...
    }
    
    public boolean isComplete(){
        return isComplete;
    }
    
    public void becomeComplete(){
        isComplete = true;
    }
    
    public void makeLineItem(ProductCatalog desc, int qty){
        //...
    }
    
    public void makePayment(Money cashTendered){
        //...
    }
    
    public Money getTotal(){
        //...
        return total;
    }
}
