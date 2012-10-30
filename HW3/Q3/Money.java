package newgenpos;


class Money {
    private double price;
    private double total;
    
    public Money(double price){
        this.price = price;
    }
    public Money calcTotal(double tax){
        total = this.total *tax;
        return this;
    }
}
