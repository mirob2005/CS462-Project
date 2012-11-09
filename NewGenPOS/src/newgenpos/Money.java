package newgenpos;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


class Money {
    private double price;
    
    public Money(double ItemPrice){
        this.price = ItemPrice;
    }
    public Money calcTotal(double tax){
        Money total = new Money(this.price*tax);
        return total;
    }
    public Money mutliply(Money Price, int qty){
        double total = Price.price*qty;
        Money amount = new Money(total);
        return amount;
    }
    public String getFormatted(){
        String priceString = "$";
        DecimalFormat twoDecimals = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));
        priceString += (twoDecimals.format(this.price));        
        return priceString;
    }
}
