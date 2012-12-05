/*
 * HW5.1 - Adapter Design Pattern
 */
package newgenpos;

import java.util.Date;

public class verifyCredit {
    
    public boolean verifyCardNumber(String input) {
        if(input.length() != 16){
            Ui_NewGenPOS.setText("Card Number must be 16 numbers long! Try Again!");
            return false;
        }
        try{
            //Checking for only numbers            
            long numberCheck = Long.parseLong(input);
        }
        catch(NumberFormatException e){
            Ui_NewGenPOS.setText("Card Number must contain ONLY numbers! Try Again!");
            return false;
        }
        
        return true;
    }   
    
    public boolean verifyEXP(String month, String year) {
        int intMonth;
        int intYear;
        Date time = new Date();
        //Subtracts current year by 1900 by default, changing to 2000
        int currentYear = time.getYear()-100;
        //Ranges from 01 to 12 instead of 00 to 11
        int currentMonth = time.getMonth()+1;                
        
        if((month.length() != 2) || (year.length() != 2)){
            Ui_NewGenPOS.setText("Year/Month EXP values must range from 01 to 12! Try Again!");
            return false;
        }
        try{
            //Checking for only numbers
            intMonth = Integer.parseInt(month);
            intYear = Integer.parseInt(year);
        }
        catch(NumberFormatException e){
            Ui_NewGenPOS.setText("Year/Month EXP values must contain ONLY numbers! Try Again!");
            return false;
        }
        if(intMonth<1 || intMonth > 12){
            Ui_NewGenPOS.setText("Month EXP values must range from 01 to 12! Try Again!");
            return false;
        }
        if(intYear < currentYear || intYear > currentYear+10){
            Ui_NewGenPOS.setText("Card is invalid! Try Again!");
            return false;            
        }
        if(intYear == currentYear && intMonth < currentMonth){
            Ui_NewGenPOS.setText("Card is invalid! Try Again!");
            return false;             
        }
        return true;
    }
}
