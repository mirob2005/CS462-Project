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
    public Money add(Money amountToAdd){
        Money result = new Money(this.price+amountToAdd.price);
        return result;
    }
    public Money subtract(Money amountToSubtract){
        Money result = new Money(this.price-amountToSubtract.price);
        return result;       
    }
    public String getFormatted(){
        String priceString = "$";
        DecimalFormat twoDecimals = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));
        priceString += (twoDecimals.format(this.price));        
        return priceString;
    }
    public boolean checkTotal(Money total){
        if(this.price >= total.price){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkEquals(Money amount){
        if(this.price == amount.price){
            return true;
        }
        else{
            return false;
        }
    }
}
