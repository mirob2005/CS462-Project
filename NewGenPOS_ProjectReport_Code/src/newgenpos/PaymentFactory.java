/*
 * HW5.1 Factory Design Pattern
 */
package newgenpos;


public class PaymentFactory {
    private int paymentMethod;
    public PaymentFactory(int method){
        this.paymentMethod = method;
    }
    public Payment getPayment(Money amount) { //Factory Method
        if(this.paymentMethod == 1){
            return new CreditPayment(amount);
        }
        else if(this.paymentMethod == 2){
            return new CheckPayment(amount);
        }
        else {
            return new CashPayment(amount);
        }
    }
}
