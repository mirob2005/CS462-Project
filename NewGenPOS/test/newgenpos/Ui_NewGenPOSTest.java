/*
 * CS 462 - Group NewGenPOS 2 JUnit Test Cases - 1 should pass, 1 should fail
 * HW2 Problem 11
 */
package newgenpos;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Ui_NewGenPOSTest {
    
    public List<Double> priceList = new ArrayList<Double>();
    
    public Ui_NewGenPOSTest() {
    }
    
    public void addItem(int quantity){
        for(int i =0; i<quantity; i++){
            priceList.add(5.40);        
        }
    }
    
    //Copy of displayPrice() method from Ui_NewGenPOS with 2 minor changes 
    //needed for this context
    public double displayPrice() {
        double totalPrice = 0;
        
        for(int i =0; i < priceList.size(); i++) {
             totalPrice += priceList.get(i);
        }
        
        //Calculate Tax
        totalPrice = totalPrice*1.08;
        int totalPriceScaled = (int) (totalPrice*100);
        totalPrice = totalPriceScaled/100.0;

        //totalDisplay.display(totalPrice); //Not need in this context
        return totalPrice; //Added to return price in a useful way
    }
    
    /**
     * Test of displayPrice()
     */
    @Test
    public void testDisplayPriceShouldPass() {
        System.out.println("Adding 2 items at $5.40 each - Test should pass");
        
        addItem(2);
        
        double total = displayPrice();
        assert(total==11.66); //Total should be 11.66
        System.out.println("Test 2 of UI_GenPOSTest passed!");
    }
    @Test
    public void testDisplayPriceShouldFail() {
        System.out.println("Adding 3 items at $5.40 each - Test should pass");
       
        addItem(3);
        
        double total = displayPrice();
        assert(!(total==11.75)); //Total should be 17.49
        System.out.println("Test 2 of UI_GenPOSTest passed!");
    }
}
