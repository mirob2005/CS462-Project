/*
 * HW5, Test Done!
 */
package newgenpos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mike
 */
public class MoneyTest {
    
    public MoneyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcTotal method, of class Money.
     */
    @Test
    public void test1CalcTotal() {
        System.out.println("Testing Method: Money.calcTotal");
        double tax = 1.08;
        Money subTotal = new Money(9.99);
        //The total should be $10.79
        Money expResult = new Money((9.99*1.08));
        Money result = subTotal.calcTotal(tax);
        System.out.println("Result was: "+result.getFormatted());
        System.out.println("Expected Result is: "+expResult.getFormatted());
        assert(result.checkEquals(expResult));
        System.out.println("Test 1 of Money.calcTotal passed!");
    }
    @Test
    public void test2CalcTotal() {
        System.out.println("Testing Method: Money.calcTotal");
        double tax = 1.08;
        Money subTotal = new Money(9.99);
        //The total should be $10.79
        Money expResult = new Money((9.99));
        Money result = subTotal.calcTotal(tax);
        System.out.println("Result was: "+result.getFormatted());
        System.out.println("Expected False Result is: "+expResult.getFormatted());
        assertFalse(result.checkEquals(expResult));
        System.out.println("Test 2 of Money.calcTotal passed!");
    }
}
