/*
 * HW5.1 - Adapter Design Pattern
 */
package newgenpos;

public class verifyCash{
    
    public boolean verifyAmount(Money payment, Money total){
            if(payment.checkTotal(total)){
                return true;
            }
            else{
                Ui_NewGenPOS.setText("Insufficient Funds!");
                return false;
            }
    }
}
