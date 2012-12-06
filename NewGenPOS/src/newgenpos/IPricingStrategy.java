/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newgenpos;

public interface IPricingStrategy {
    Money calcTotal(Money subTotal);
    Money calcDiscount(Money subTotal);
}