/*
 * HW5, Tests Not Done, need to rewrite the register methods to not interact with the UI
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
public class RegisterTest {
    private int salesNumber = 1;
    private String address = "testAddress";
    private String name = "testName";
    private ProductCatalog catalog;
    private int storeID = 1;
    
    private Payment payment;
    private Register register;
    
    public RegisterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.register = new Register(salesNumber, this.catalog, this.storeID, this.address, this.name);        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of makeCashPayment method, of class Register.
     */
    @Test
    public void testMakeCashPayment() {
        System.out.println("Testing: makeCashPayment");
        Register instance = this.register;
        boolean expResult = true;
        boolean result = instance.makeCashPayment();
        assertEquals(expResult, result);
    }

    /**
     * Test of makeCreditPayment method, of class Register.
     */
    @Test
    public void testMakeCreditPayment() {
        System.out.println("makeCreditPayment");
        Register instance = null;
        boolean expResult = false;
        boolean result = instance.makeCreditPayment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeCheckPayment method, of class Register.
     */
    @Test
    public void testMakeCheckPayment() {
        System.out.println("makeCheckPayment");
        Register instance = null;
        boolean expResult = false;
        boolean result = instance.makeCheckPayment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
