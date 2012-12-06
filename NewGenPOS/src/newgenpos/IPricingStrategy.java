//HW5.1 Strategy Design Pattern
package newgenpos;

public interface IPricingStrategy {
    Money calcTotal(Money subTotal);
    Money calcDiscount(Money subTotal);
}