package newgenpos;

class Payment {        
    private Money amount;    

    public Payment(Money Amount) {
        this.amount = Amount;        
    }
    public Money getAmount(){
        return this.amount;
    }
    public boolean isCash(){
        return false;
    }
    public boolean isCredit(){
        return false;
    }
    public boolean isCheck(){
        return false;
    }
}
class CashPayment extends Payment {
    public CashPayment(Money Amount){
        super(Amount);
    }
    public boolean isCash(){
        return true;
    }
    public boolean isCredit(){
        return false;
    }
    public boolean isCheck(){
        return false;
    }
}
class CreditPayment extends Payment{
    public CreditPayment(Money Amount){
        super(Amount);
    }
    public boolean isCash(){
        return false;
    }
    public boolean isCredit(){
        return true;
    }
    public boolean isCheck(){
        return false;
    }
}
class CheckPayment extends Payment{
    public CheckPayment(Money Amount){
        super(Amount);
    }
    public boolean isCash(){
        return false;
    }
    public boolean isCredit(){
        return false;
    }
    public boolean isCheck(){
        return true;
    }
}
