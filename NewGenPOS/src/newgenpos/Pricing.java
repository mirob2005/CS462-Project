/*
 * HW5.1 Strategy
 */
package newgenpos;

public class Pricing {
    private IPricingStrategy currentStrat;
    
    public Pricing(){
        setPricingStrategy(new StandardPricing());
    }
    public void setPricingStrategy(IPricingStrategy strat){
        currentStrat = strat;
    }
    public Money calcTotal(Money subTotal){
        return currentStrat.calcTotal(subTotal);        
    }

    
    public interface IPricingStrategy {
        Money calcTotal(Money subTotal);
    }
    
    public static class StandardPricing implements IPricingStrategy{
        private double tax = 1.08;

        public StandardPricing() {
        }

        @Override
        public Money calcTotal(Money subTotal) {
            Money total = subTotal.calcTotal(tax);
            return total;
        }
    }
    public static class SeniorDiscountPricing implements IPricingStrategy{
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
    }

    
}
