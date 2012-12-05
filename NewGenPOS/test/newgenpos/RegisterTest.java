/*
 * HW5.2 Tests of Register.makeCashPayment, Register.makeCreditPayment, Register.makeCheckPayment
 */
package newgenpos;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegisterTest {  
    private int salesNumber = 1;
    private String address = "testAddress";
    private String name = "testName";
    private ProductCatalog catalog;    
    private int storeID = 1;                
    
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
       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of makeCashPayment method, of class Register.
     */
    @Test
    public void test1MakeCashPayment() {
        Register instance = Register.getRegister(salesNumber, catalog, storeID, address, name);                        
        instance.makeNewSale();
        Sale currentSale = instance.getCurrentSale(); 
        System.out.println("Testing Method: Register.makeCashPayment");
        String input = "10.00";
        
        currentSale.setTotal(new Money(1.99));
        boolean expResult = true;
        boolean result = instance.makeCashPayment(0, input);
        assertEquals(expResult, result);
        System.out.println("Test 1 of Register.makeCashPayment passed!");
    }
    @Test
    public void test2MakeCashPayment() {
        Register instance = Register.getRegister(salesNumber, catalog, storeID, address, name);                        
        instance.makeNewSale();
        Sale currentSale = instance.getCurrentSale(); 
        
        System.out.println("Testing Method: Register.makeCashPayment");
        //Insufficient Funds!
        String input = "1.00";
        
        currentSale.setTotal(new Money(1.99));
        boolean expResult = false;
        boolean result;
        try{
            result = instance.makeCashPayment(0, input);
        }catch(NullPointerException e){ //Catch gui unavailable error
            result = false;
        }
        assertEquals(expResult, result);
        System.out.println("Test 2 of Register.makeCashPayment passed!");
    }    

    /**
     * Test of makeCreditPayment method, of class Register.
     */
    @Test
    public void test1MakeCreditPayment() {
        Register instance = Register.getRegister(salesNumber, catalog, storeID, address, name);                        
        instance.makeNewSale();
        Sale currentSale = instance.getCurrentSale(); 
        
        System.out.println("Testing Method: Register.makeCreditPayment");
        String inputAmount = "2";
        String inputCardNumber = "2222222222222222";
        String inputYear = "12";
        String inputMonth = "12";
        String inputName = "Name";
        
        currentSale.setTotal(new Money(1.99));
        boolean expResult = true;
        boolean result;
        try{
            result = instance.makeCreditPayment(1, inputAmount, inputCardNumber, inputYear, inputMonth, inputName);
        }catch(NullPointerException e){ //Catch gui unavailable error
            result = false;
        }
        assertEquals(expResult, result);
        System.out.println("Test 1 of Register.makeCreditPayment passed!");
    }
    @Test
    public void test2MakeCreditPayment() {
        Register instance = Register.getRegister(salesNumber, catalog, storeID, address, name);                        
        instance.makeNewSale();
        Sale currentSale = instance.getCurrentSale(); 
        
        System.out.println("Testing Method: Register.makeCreditPayment");
        String inputAmount = "2";
        //Card Number is too short
        String inputCardNumber = "22222222222222";
        String inputYear = "12";
        String inputMonth = "12";
        String inputName = "Name";
        
        currentSale.setTotal(new Money(1.99));
        boolean expResult = false;
        boolean result;
        try{
            result = instance.makeCreditPayment(1, inputAmount, inputCardNumber, inputYear, inputMonth, inputName);
        }catch(NullPointerException e){ //Catch gui unavailable error
            result = false;
        }
        assertEquals(expResult, result);
        System.out.println("Test 2 of Register.makeCreditPayment passed!");
    }    
    @Test
    public void test3MakeCreditPayment() {
        Register instance = Register.getRegister(salesNumber, catalog, storeID, address, name);                        
        instance.makeNewSale();
        Sale currentSale = instance.getCurrentSale(); 
        
        System.out.println("Testing Method: Register.makeCreditPayment");
        //Insufficient Funds!
        String inputAmount = "1";        
        String inputCardNumber = "2222222222222222";
        String inputYear = "12";
        String inputMonth = "12";
        String inputName = "Name";
        
        currentSale.setTotal(new Money(1.99));
        boolean expResult = false;
        boolean result;
        try{
            result = instance.makeCreditPayment(1, inputAmount, inputCardNumber, inputYear, inputMonth, inputName);
        }catch(NullPointerException e){ //Catch gui unavailable error
            result = false;
        }        
        assertEquals(expResult, result);
        System.out.println("Test 3 of Register.makeCreditPayment passed!");
    }    
    @Test
    public void test4MakeCreditPayment() {
        Register instance = Register.getRegister(salesNumber, catalog, storeID, address, name);                        
        instance.makeNewSale();
        Sale currentSale = instance.getCurrentSale(); 
        
        System.out.println("Testing Method: Register.makeCreditPayment");        
        String inputAmount = "2";        
        String inputCardNumber = "2222222222222222";
        //Expired Card!
        String inputYear = "11";
        String inputMonth = "12";
        String inputName = "Name";
        
        currentSale.setTotal(new Money(1.99));
        boolean expResult = false;
        boolean result;
        try{
            result = instance.makeCreditPayment(1, inputAmount, inputCardNumber, inputYear, inputMonth, inputName);
        }catch(NullPointerException e){ //Catch gui unavailable error
            result = false;
        }        
        assertEquals(expResult, result);
        System.out.println("Test 4 of Register.makeCreditPayment passed!");
    }    
    @Test
    public void test5MakeCreditPayment() {
        Register instance = Register.getRegister(salesNumber, catalog, storeID, address, name);                        
        instance.makeNewSale();
        Sale currentSale = instance.getCurrentSale(); 
        
        System.out.println("Testing Method: Register.makeCreditPayment");        
        String inputAmount = "2";        
        String inputCardNumber = "2222222222222222";        
        String inputYear = "12";
        //Month not between 01-12
        String inputMonth = "2";
        String inputName = "Name";
        
        currentSale.setTotal(new Money(1.99));
        boolean expResult = false;
        boolean result;
        try{
            result = instance.makeCreditPayment(1, inputAmount, inputCardNumber, inputYear, inputMonth, inputName);
        }catch(NullPointerException e){ //Catch gui unavailable error
            result = false;
        }        
        assertEquals(expResult, result);
        System.out.println("Test 5 of Register.makeCreditPayment passed!");
    }
    @Test
    public void test6MakeCreditPayment() {
        Register instance = Register.getRegister(salesNumber, catalog, storeID, address, name);                        
        instance.makeNewSale();
        Sale currentSale = instance.getCurrentSale(); 
        
        System.out.println("Testing Method: Register.makeCreditPayment");        
        String inputAmount = "2";        
        String inputCardNumber = "2222222222222222";        
        String inputYear = "12";        
        String inputMonth = "12";
        //Blank Name!
        String inputName = "";
        
        currentSale.setTotal(new Money(1.99));
        boolean expResult = false;
        boolean result;
        try{
            result = instance.makeCreditPayment(1, inputAmount, inputCardNumber, inputYear, inputMonth, inputName);
        }catch(NullPointerException e){ //Catch gui unavailable error
            result = false;
        }        
        assertEquals(expResult, result);
        System.out.println("Test 6 of Register.makeCreditPayment passed!");
    }   
    @Test
    public void test7MakeCreditPayment() {
        Register instance = Register.getRegister(salesNumber, catalog, storeID, address, name);                        
        instance.makeNewSale();
        Sale currentSale = instance.getCurrentSale(); 
        
        System.out.println("Testing Method: Register.makeCreditPayment");        
        String inputAmount = "2";        
        String inputCardNumber = "2222222222222222";        
        //Year not between 01-12
        String inputYear = "2";        
        String inputMonth = "12";        
        String inputName = "Name";
        
        currentSale.setTotal(new Money(1.99));
        boolean expResult = false;
        boolean result;
        try{
            result = instance.makeCreditPayment(1, inputAmount, inputCardNumber, inputYear, inputMonth, inputName);
        }catch(NullPointerException e){ //Catch gui unavailable error
            result = false;
        }        
        assertEquals(expResult, result);
        System.out.println("Test 7 of Register.makeCreditPayment passed!");
    }       
    @Test
    public void test8MakeCreditPayment() {
        Register instance = Register.getRegister(salesNumber, catalog, storeID, address, name);                        
        instance.makeNewSale();
        Sale currentSale = instance.getCurrentSale(); 
        
        System.out.println("Testing Method: Register.makeCreditPayment");        
        String inputAmount = "2";        
        String inputCardNumber = "2222222222222222";                
        String inputYear = "12";        
        //Card is expired!
        String inputMonth = "10";        
        String inputName = "Name";
        
        currentSale.setTotal(new Money(1.99));
        boolean expResult = false;
        boolean result;
        try{
            result = instance.makeCreditPayment(1, inputAmount, inputCardNumber, inputYear, inputMonth, inputName);
        }catch(NullPointerException e){ //Catch gui unavailable error
            result = false;
        }        
        assertEquals(expResult, result);
        System.out.println("Test 8 of Register.makeCreditPayment passed!");
    }     

    /**
     * Test of makeCheckPayment method, of class Register.
     */
    @Test
    public void test1MakeCheckPayment() {
        Register instance = Register.getRegister(salesNumber, catalog, storeID, address, name);                        
        instance.makeNewSale();
        Sale currentSale = instance.getCurrentSale(); 
        
        System.out.println("Testing Method: Register.makeCheckPayment");
        String inputAmount = "2";
        String inputName = "Name";
        String inputAddr1 = "Addr1";
        String inputAddr2 = "Addr2";
        String inputCheckNumber = "1";
        String inputLicense = "22222222";
        String inputPhone = "7145552727";
        
        currentSale.setTotal(new Money(1.99));
        boolean expResult = true;
        boolean result;
        try{
            result = instance.makeCheckPayment(2, inputAmount, inputName, inputAddr1, inputAddr2, inputCheckNumber, inputLicense, inputPhone);
        }catch(NullPointerException e){ //Catch gui unavailable error
            result = false;
        }        
        assertEquals(expResult, result);
        System.out.println("Test 1 of Register.makeCheckPayment passed!");
    }
    @Test
    public void test2MakeCheckPayment() {
        Register instance = Register.getRegister(salesNumber, catalog, storeID, address, name);                        
        instance.makeNewSale();
        Sale currentSale = instance.getCurrentSale(); 
        
        System.out.println("Testing Method: Register.makeCheckPayment");
        String inputAmount = "2";
        //Name is blank!
        String inputName = "";
        String inputAddr1 = "Addr1";
        String inputAddr2 = "Addr2";
        String inputCheckNumber = "1";
        String inputLicense = "22222222";
        String inputPhone = "7145552727";
        
        currentSale.setTotal(new Money(1.99));
        boolean expResult = false;
        boolean result;
        try{
            result = instance.makeCheckPayment(2, inputAmount, inputName, inputAddr1, inputAddr2, inputCheckNumber, inputLicense, inputPhone);
        }catch(NullPointerException e){ //Catch gui unavailable error
            result = false;
        }        
        assertEquals(expResult, result);
        System.out.println("Test 2 of Register.makeCheckPayment passed!");
    }
    @Test
    public void test3MakeCheckPayment() {
        Register instance = Register.getRegister(salesNumber, catalog, storeID, address, name);                        
        instance.makeNewSale();
        Sale currentSale = instance.getCurrentSale(); 
        
        System.out.println("Testing Method: Register.makeCheckPayment");
        String inputAmount = "2";
        String inputName = "Name";
        //Address is blank!
        String inputAddr1 = "";
        String inputAddr2 = "";
        String inputCheckNumber = "1";
        String inputLicense = "22222222";
        String inputPhone = "7145552727";
        
        currentSale.setTotal(new Money(1.99));
        boolean expResult = false;
        boolean result;
        try{
            result = instance.makeCheckPayment(2, inputAmount, inputName, inputAddr1, inputAddr2, inputCheckNumber, inputLicense, inputPhone);
        }catch(NullPointerException e){ //Catch gui unavailable error
            result = false;
        }        
        assertEquals(expResult, result);
        System.out.println("Test 3 of Register.makeCheckPayment passed!");
    }
    @Test
    public void test4MakeCheckPayment() {
        Register instance = Register.getRegister(salesNumber, catalog, storeID, address, name);                        
        instance.makeNewSale();
        Sale currentSale = instance.getCurrentSale(); 
        
        System.out.println("Testing Method: Register.makeCheckPayment");
        String inputAmount = "2";
        String inputName = "Name";
        String inputAddr1 = "Addr1";
        String inputAddr2 = "Addr2";
        //invalid entry of check number
        String inputCheckNumber = "-11";
        String inputLicense = "22222222";
        String inputPhone = "7145552727";
        
        currentSale.setTotal(new Money(1.99));
        boolean expResult = false;
        boolean result;
        try{
            result = instance.makeCheckPayment(2, inputAmount, inputName, inputAddr1, inputAddr2, inputCheckNumber, inputLicense, inputPhone);
        }catch(NullPointerException e){ //Catch gui unavailable error
            result = false;
        }        
        assertEquals(expResult, result);
        System.out.println("Test 4 of Register.makeCheckPayment passed!");
    }
    @Test
    public void test5MakeCheckPayment() {
        Register instance = Register.getRegister(salesNumber, catalog, storeID, address, name);                        
        instance.makeNewSale();
        Sale currentSale = instance.getCurrentSale(); 
        
        System.out.println("Testing Method: Register.makeCheckPayment");
        String inputAmount = "2";
        String inputName = "Name";
        String inputAddr1 = "Addr1";
        String inputAddr2 = "Addr2";
        String inputCheckNumber = "1";
        //invalid entry of License number
        String inputLicense = "asdf";
        String inputPhone = "7145552727";
        
        currentSale.setTotal(new Money(1.99));
        boolean expResult = false;
        boolean result;
        try{
            result = instance.makeCheckPayment(2, inputAmount, inputName, inputAddr1, inputAddr2, inputCheckNumber, inputLicense, inputPhone);
        }catch(NullPointerException e){ //Catch gui unavailable error
            result = false;
        }        
        assertEquals(expResult, result);
        System.out.println("Test 5 of Register.makeCheckPayment passed!");
    }
    @Test
    public void test6MakeCheckPayment() {
        Register instance = Register.getRegister(salesNumber, catalog, storeID, address, name);                        
        instance.makeNewSale();
        Sale currentSale = instance.getCurrentSale(); 
        
        System.out.println("Testing Method: Register.makeCheckPayment");
        String inputAmount = "2";
        String inputName = "Name";
        String inputAddr1 = "Addr1";
        String inputAddr2 = "Addr2";
        String inputCheckNumber = "1";
        String inputLicense = "22222222";
        //invalid entry of phone number
        String inputPhone = "14sg46gha";
        
        currentSale.setTotal(new Money(1.99));
        boolean expResult = false;
        boolean result;
        try{
            result = instance.makeCheckPayment(2, inputAmount, inputName, inputAddr1, inputAddr2, inputCheckNumber, inputLicense, inputPhone);
        }catch(NullPointerException e){ //Catch gui unavailable error
            result = false;
        }        
        assertEquals(expResult, result);
        System.out.println("Test 6 of Register.makeCheckPayment passed!");
    }
    @Test
    public void test7MakeCheckPayment() {
        Register instance = Register.getRegister(salesNumber, catalog, storeID, address, name);                        
        instance.makeNewSale();
        Sale currentSale = instance.getCurrentSale(); 
        
        System.out.println("Testing Method: Register.makeCheckPayment");
        //insufficient funds!
        String inputAmount = "1";
        String inputName = "Name";
        String inputAddr1 = "Addr1";
        String inputAddr2 = "Addr2";
        String inputCheckNumber = "1";
        String inputLicense = "22222222";
        String inputPhone = "7145552727";
        
        currentSale.setTotal(new Money(1.99));
        boolean expResult = false;
        boolean result;
        try{
            result = instance.makeCheckPayment(2, inputAmount, inputName, inputAddr1, inputAddr2, inputCheckNumber, inputLicense, inputPhone);
        }catch(NullPointerException e){ //Catch gui unavailable error
            result = false;
        }        
        assertEquals(expResult, result);
        System.out.println("Test 7 of Register.makeCheckPayment passed!");
    }
}
