/*
 * HW5.1 - Adapter Design Pattern
 */

package newgenpos;

public class verifyPaymentAdapter implements IVerifyPayment{
    private boolean success;
    private verifyCash cash = new verifyCash();
    private verifyCheck check = new verifyCheck();
    private verifyCredit credit = new verifyCredit();
    
    //Cash Payment
    @Override
    public boolean verifyPayment(Money payment, Money total) {
        success = cash.verifyAmount(payment, total);
        return success;
    }

    //Check Payment
    @Override
    public boolean verifyPayment(Money payment, Money total, String name, 
        String addr1, String addr2, String checkNum, String license, String phone) {
        
        success = cash.verifyAmount(payment, total)&&check.verifyText(name)&&
                check.verifyText(addr1)&&check.verifyText(addr2)&&
                check.verifyCheckNumber(checkNum)&&check.verifyLicense(license)
                &&check.verifyPhone(phone);
        return success;
    }
            
    //Credit Payment
    @Override
    public boolean verifyPayment(Money payment, Money total, String name, 
        String cardNumber, String month, String year) {
        
        success = cash.verifyAmount(payment, total)&&check.verifyText(name)&&
                credit.verifyCardNumber(cardNumber)&&
                credit.verifyEXP(month, year);        
        return success;
    }
}
