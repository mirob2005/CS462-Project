class Payment {
        
    private double paymentTotal;

    public Payment(double total) {
        paymentTotal = total;
    }
    public void submitPayment(){
        System.out.println("Total Due: "+ this.paymentTotal + ". ");
    }
}

class CashPayment extends Payment {

    public CashPayment(double total){
        super(total);
    }

    public void submitPayment() {
        super.submitPayment();
        System.out.println("The method of payment chosen is cash.\n");
    }
}

class CreditPayment extends Payment{

    public CreditPayment(double total){
        super(total);
    }
    
    public void submitPayment(){
        super.submitPayment();
        System.out.println("The method of payment chosen is credit.\n");
    }
}

class CheckPayment extends Payment{

    public CheckPayment(double total){
        super(total);
    }

    public void submitPayment(){
        super.submitPayment();
        System.out.println("The method of payment chosen is check.\n");
    }
}

public class TestPolymorphism {
  public static void main(String[] args){
    Payment transaction01,transaction02,transaction03;

    transaction01 = new CashPayment(19.99);
    transaction02 = new CreditPayment(24.01);
    transaction03 = new CheckPayment(496.95);

    transaction01.submitPayment();
    transaction02.submitPayment();
    transaction03.submitPayment();
  }
}

/*
 * Test Result:
Total Due: 19.99. 
The method of payment chosen is cash.

Total Due: 24.01. 
The method of payment chosen is credit.

Total Due: 496.95. 
The method of payment chosen is check.
 */