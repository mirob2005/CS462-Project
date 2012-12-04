/*
 * HW5, Testing on Cash, Credit, Check payment
 */
package newgenpos;

import com.trolltech.qt.gui.QDialog;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Willy 2
 */
public class RegisterTest {
    private int salesNumber = 1;
    private String address = "testAddress";
    private String name = "testName";
    private ProductCatalog catalog;
    private int storeID = 1;
    String input;
    
    private Register register; 
    private Money paymentAmount;
    private Money total = new Money(5.00);
    private Sale currentSale;
    
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

    public boolean makeCashPayment(){        
        boolean result = false;
        input = "10.00";
        boolean success = checkAmount(input);
        if(success)
            result = true;
        else 
            result = false;
        return  result;     
    }
    private boolean checkAmount(String input){
        try{
            Double paymentInput = Double.parseDouble(input);
            this.paymentAmount = new Money(paymentInput);
            //Ensure payment is >= the total
            if(this.paymentAmount.checkTotal(this.total)){
                return true;
            }
            else{
                Ui_NewGenPOS.setText("Insufficient Funds!");
                return false;
            }
        }
        catch(NumberFormatException e){
            Ui_NewGenPOS.setText("Payment amount must contain ONLY numbers and must NOT be blank! Try Again!");
            return false;
        }
    }
    
    @Test
    public void testMakeCashPayment() {
        System.out.println("Testing Method: makeCashPayment");
        boolean expResult = true;
        boolean result = makeCashPayment();
        assertEquals(expResult, result);
        if(expResult == result)
        {
            System.out.println("Test case passed for makeCashPayment");
        }
    }

    

    /**
     * Test of makeCreditPayment method, of class Register.
     
    @Test
    public void testMakeCreditPayment() {
        System.out.println("Testing Method: makeCreditPayment");
        Register instance = this.register;
        boolean expResult = false;
        boolean result = instance.makeCreditPayment();
        assertEquals(expResult, result);
    }

    /**
     * Test of makeCheckPayment method, of class Register.
     
    @Test
    public void testMakeCheckPayment() {
        System.out.println("Testing Method: makeCheckPayment");
        Register instance = this.register;
        boolean expResult = false;
        boolean result = instance.makeCheckPayment();
        assertEquals(expResult, result);
    }*/

}
