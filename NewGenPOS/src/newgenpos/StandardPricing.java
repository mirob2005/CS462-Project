//HW5.1 Strategy Design Pattern
package newgenpos;

public class StandardPricing implements IPricingStrategy{
    private double tax = 1.08;

    public StandardPricing() {
    }

    @Override
    public Money calcTotal(Money subTotal) {
        Money total = subTotal.calcTotal(tax);
        return total;
    }

    @Override
    public Money calcDiscount(Money subTotal) {
        return new Money(0);
    }
}