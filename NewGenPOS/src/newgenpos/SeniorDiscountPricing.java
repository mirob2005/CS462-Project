//HW5.1 Strategy Design Pattern
package newgenpos;

public class SeniorDiscountPricing implements IPricingStrategy{
    private double tax = 1.08;
    private double discount = 0.1;

    public SeniorDiscountPricing() {
    }

    @Override
    public Money calcTotal(Money subTotal) {
        Money discount = subTotal.calcTotal(this.discount);
        Money newSubTotal = subTotal.subtract(discount);
        Money total = newSubTotal.calcTotal(this.tax);
        return total;
    }

    @Override
    public Money calcDiscount(Money subTotal) {
        Money discount = subTotal.calcTotal(this.discount);
        return discount;
    }
}
