/*
 * HW5, Test Done
 */
package newgenpos;

import java.util.Date;
import java.util.List;
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
public class SaleTest {
    private ProductDescription testProductDesc;
    private ItemID testProductItemID;
    private String testProductName = "testProduct";
    private Money testProductPrice;
    private int testProductStock;
    
    public SaleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.testProductItemID = new ItemID(111111);
        this.testProductPrice = new Money(9.99);
        this.testProductStock = 99;
        this.testProductDesc = new ProductDescription(this.testProductItemID,
        this.testProductName, this.testProductPrice, this.testProductStock);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcSubTotal method, of class Sale.
     */
    @Test
    public void test1CalcSubTotal() {
        System.out.println("Testing Method: Sale.calcSubTotal");
        int qty = 5;
        SalesLineItem item = new SalesLineItem(this.testProductDesc,qty);        
        Sale instance = new Sale();
        instance.calcSubTotal(item, qty);
        //Subtotal should be $49.95
        Money expectedTotal = new Money(49.95);
        assert(instance.getSubTotal().checkEquals(expectedTotal));
        System.out.println("Test 1 of Sale.calcSubTotal passed!");
        
    }
    @Test
    public void test2CalcSubTotal() {
        System.out.println("Testing Method: Sale.calcSubTotal");
        int qty = 5;
        SalesLineItem item = new SalesLineItem(this.testProductDesc,qty);        
        Sale instance = new Sale();
        instance.calcSubTotal(item, qty);
        //Subtotal should be $49.95, this is wrong
        Money expectedFalseTotal = new Money(49.99);
        assertFalse(instance.getSubTotal().checkEquals(expectedFalseTotal));
        System.out.println("Test 2 of Sale.calcSubTotal passed!");
    }    
}
