/*
 * HW5.1 - Adapter Design Pattern
 */
package newgenpos;

public interface IVerifyPayment {
    public boolean verifyPayment(Money payment, Money total);
    public boolean verifyPayment(Money payment, Money total, String name, 
            String addr1, String addr2, String checkNum, String license, 
            String phone);
    public boolean verifyPayment(Money payment, Money total, String name, 
            String cardNumber, String month, String year);
}