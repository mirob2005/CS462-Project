/*
 * HW5, Testing on Cash, Credit, Check payment
 */
package newgenpos;

import com.trolltech.qt.gui.QDialog;
import java.util.Date;
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
    
    private String cardNumber;
    private Register register; 
    private Date time;
    private Money paymentAmount;
    private Money total = new Money(5.00);
    
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
/*
 * makeCashPayment, makeCreditPayment, and makeCheckPayment
 */
    public boolean makeCashPayment(){        
        boolean result = false;
        String input = "10.00";
        boolean success = checkAmount(input);
        if(success)
            result = true;
        else 
            result = false;
        return  result;     
    }
    public boolean makeCreditPayment(){
        boolean result = false;
        String inputAmount = "1000.00";
        String inputCardNumber = "1234123456785678";
        String inputYear = "13";
        String inputMonth = "09";
        String inputName = "Steve";
        boolean success;
            success = (checkAmount(inputAmount)&&checkCardNumber(inputCardNumber)&&
            checkEXP(inputMonth, inputYear)&&checkText(inputName));
        if(success)
            result = true;
        else
            result = false;
        return result;
    }
    private boolean makeCheckPayment() {
        boolean result = false;
        /*
         * inputAmount is actually less then total owed, so this case will fail
         */
        String inputAmount = "4.00";
        String inputName = "Steve";
        String inputAddr1 = "123 Fullerton St.";
        String inputAddr2 = "Fullerton, CA";
        String inputCheckNumber = "123";
        String inputLicense = "D1234321";
        String inputPhone = "7141234563";
        
        boolean success;
        success = (checkAmount(inputAmount)&&checkText(inputName)&&checkText(inputAddr1)&&
                    checkText(inputAddr2)&&checkCheckNumber(inputCheckNumber)&&
                    checkLicense(inputLicense)&&checkPhone(inputPhone));
        if(success)
            result = true;
        else
            result = false;
        return result;
    }
    /*
     * Supporting methods
     */
    private boolean checkCardNumber(String input){        
        if(input.length() != 16){
            return false;
        }
        try{
            //Checking for only numbers            
            long numberCheck = Long.parseLong(input);
        }
        catch(NumberFormatException e){
            return false;
        }
        this.cardNumber = "XXXXXXXXXXXX"+input.substring(12);
        return true;
    }
    private boolean checkEXP(String month, String year){
        int intMonth;
        int intYear;
        time = new Date();
        //Subtracts current year by 1900 by default, changing to 2000
        int currentYear = time.getYear()-100;
        //Ranges from 01 to 12 instead of 00 to 11
        int currentMonth = time.getMonth()+1;                
        
        if((month.length() != 2) || (year.length() != 2)){
            return false;
        }
        try{
            //Checking for only numbers
            intMonth = Integer.parseInt(month);
            intYear = Integer.parseInt(year);
        }
        catch(NumberFormatException e){
            return false;
        }
        if(intMonth<1 || intMonth > 12){
            return false;
        }
        if(intYear < currentYear || intYear > currentYear+10){
            return false;            
        }
        if(intYear == currentYear && intMonth < currentMonth){
            return false;             
        }
        return true;
    }
    private boolean checkText(String input){
        if(input.isEmpty()){
            return false;
        }
        else{
            return true;
        }
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
                return false;
            }
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    private boolean checkCheckNumber(String input){
        try{
            //Checking for only numbers
            long numberCheck = Long.parseLong(input);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;        
    }
    private boolean checkLicense(String input){
        if(input.length() != 8){
            return false;
        }
        return true;
    }
    private boolean checkPhone(String input){
        if(input.length() != 10){
            return false;
        }
        try{
            //Checking for only numbers
            long numberCheck = Long.parseLong(input);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
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

    @Test
    public void testMakeCreditPayment() {
        System.out.println("Testing Method: makeCreditPayment");
        boolean expResult = true;
        boolean result = makeCreditPayment();
        assertEquals(expResult, result);
        if(expResult == result)
        {
            System.out.println("Test case passed for makeCreditPayment");
        }
    }

    /**
     * Test of makeCheckPayment method, of class Register.
     */
    @Test
    public void testMakeCheckPayment() {
        System.out.println("Testing Method: makeCheckPayment");
        /*
         * inputAmount is actually less then total owed, so this case will fail
         */
        boolean expResult = false;
        boolean result = makeCheckPayment();
        assertEquals(expResult, result);
        if(expResult == result)
        {
            System.out.println("Test case passed for makeCreditPayment");
        }
    }
}
