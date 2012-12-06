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
    public Money calcDiscount(Money subTotal){
        return currentStrat.calcDiscount(subTotal);
    }
}
