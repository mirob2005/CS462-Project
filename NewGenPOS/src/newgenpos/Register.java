package newgenpos;

import com.trolltech.qt.gui.QDialog;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Register {
    private ProductCatalog catalog;
    private Sale currentSale;
    private ProductDescription description;
    private List<SalesLineItem> cart;
    private int storeID;
    private String storeAddr;
    private String storeName;
    private Money paymentAmount;
    private Money total;
    private String cardNumber;
    private String checkNumber;
    private String customerName;
    //Receipt Sections
    List<String> header;
    List<String> itemList;
    List<String> footer;
    private QDialog dialog;
    private Ui_ReceiptDialog UIReceiptdialog;
    //Payment Dialogs
    private Ui_CashDialog UICashdialog;
    private Ui_CreditDialog UICreditdialog;
    private Ui_CheckDialog UICheckdialog;
    
    
    public Register(ProductCatalog pc, int id, String addr, String name){
        this.catalog = pc;
        this.storeID = id;
        this.storeAddr = addr;
        this.storeName = name;
    }
    public void endSale(){
        currentSale.becomeComplete();
        Ui_NewGenPOS.setText("Thank You for Shopping!"); 
        Ui_NewGenPOS.setDisplay(0);
        Ui_NewGenPOS.clearProductInput();
        Ui_NewGenPOS.clearCart();        
    }
    public void enterItem(ItemID ItemID, int qty)throws SQLException{
        description = catalog.getProductDescription(ItemID, qty);
        //No such ItemID or out of stock returns description = null
        if(description == null){
            Ui_NewGenPOS.clearProductInput();
        }
        else
        {
            currentSale.makeLineItem(description, qty);    
        }        
    }
    public void createReceipt(){
        this.header = new ArrayList<>();
        this.itemList = new ArrayList<>();
        this.footer = new ArrayList<>(); 
        this.cart = currentSale.getCart();
        
        this.header.add("Welcome to "+this.storeName+"! Store #"+this.storeID);
        this.header.add(this.storeAddr);
        this.header.add("-----------------------------------------------");
        this.header.add("Sale made at "+ currentSale.getDate());
        this.header.add("Sale #__");
        this.header.add("-----------------------------------------------\n");
        
        for(int i =0; i<cart.size();i++){
            SalesLineItem item = cart.get(i);
            ProductDescription product = item.getDescription();
            itemList.add(item.getQty()+"\t"+product.getDescription()+"\t"+product.getPrice().getFormatted());
        }
        
        Money subTotal = currentSale.getSubTotal();
        this.total = currentSale.getTotal();
        
        Money tax = this.total.subtract(subTotal);        
        
        this.footer.add("\nSubtotal\t"+subTotal.getFormatted());        
        this.footer.add("Tax\t"+tax.getFormatted());
        this.footer.add("Total\t"+this.total.getFormatted());
        
        this.footer.add("-----------------------------------------------\n");
        
        Payment payment = currentSale.getPayment();
        if(payment.isCash()){
            this.footer.add("Payment Method\tCASH");
        }
        if(payment.isCredit()){
            this.footer.add("Payment Method\tCREDIT");
            this.footer.add("Name:\t"+this.customerName+"\n");
            this.footer.add("Card#:\t"+this.cardNumber);            
        }
        if(payment.isCheck()){
            this.footer.add("Payment Method\tCHECK");
            this.footer.add("Name:\t"+this.customerName);
            this.footer.add("Check#\t"+this.checkNumber+"\n");
        }
        this.footer.add("Payment Amount\t"+this.paymentAmount.getFormatted());
        Money cashBack = currentSale.getCashBack(); 
        this.footer.add("Amount Back\t"+cashBack.getFormatted());
        
        this.printReceipt();
    }
    private void printReceipt(){
        dialog = new QDialog();
        UIReceiptdialog = new Ui_ReceiptDialog();
        UIReceiptdialog.setupUi(dialog);
        dialog.setWindowTitle("Receipt");
        dialog.show();
        
        UIReceiptdialog.setText("");
        for(int i=0; i<this.header.size();i++){
            UIReceiptdialog.appendText(this.header.get(i));
        }
        for(int i=0; i<this.itemList.size();i++){
            UIReceiptdialog.appendText(this.itemList.get(i));
        }
        for(int i=0; i<this.footer.size();i++){
            UIReceiptdialog.appendText(this.footer.get(i));
        }       
    }
    public void makeNewSale(){
        currentSale = new Sale();
    }
    public void makePayment(Payment paymentAmount){
        currentSale.makePayment(paymentAmount);
    }
    public boolean makeCashPayment(){        
        dialog = new QDialog();
        UICashdialog = new Ui_CashDialog();
        UICashdialog.setupUi(dialog);
        dialog.setWindowTitle("Enter Cash Amount:");
        dialog.show();

        if (dialog.exec() == QDialog.DialogCode.Accepted.value()) {
            String input = UICashdialog.getInput();
            boolean success = checkAmount(input);
            if(success){
                Payment payment = new CashPayment(this.paymentAmount);
                this.makePayment(payment);
            }
            return success;
        }
        else {
            Ui_NewGenPOS.setText("Payment Canceled!");
            return false;
        }        
    }
    public boolean makeCreditPayment(){
        dialog = new QDialog();
        UICreditdialog = new Ui_CreditDialog();
        UICreditdialog.setupUi(dialog);
        dialog.setWindowTitle("Enter Credit Information:");
        dialog.show();

        if (dialog.exec() == QDialog.DialogCode.Accepted.value()) {
            String inputAmount = UICreditdialog.getAmount();
            String inputCardNumber = UICreditdialog.getCardNumber();
            String inputYear = UICreditdialog.getYear();
            String inputMonth = UICreditdialog.getMonth();
            String inputName = UICreditdialog.getName();
                        
            boolean success;
            success = (checkAmount(inputAmount)&&checkCardNumber(inputCardNumber)&&
            checkEXP(inputMonth, inputYear)&&checkText(inputName));
            
            if(success){
                Payment payment = new CreditPayment(this.paymentAmount);
                this.makePayment(payment);
                this.customerName = inputName;
            }            
            return success;
        }
        else {
            Ui_NewGenPOS.setText("Payment Canceled!");
            return false;
        }
    }
    public boolean makeCheckPayment(){
        dialog = new QDialog();
        UICheckdialog = new Ui_CheckDialog();
        UICheckdialog.setupUi(dialog);
        dialog.setWindowTitle("Enter Check Information:");
        dialog.show();

        if (dialog.exec() == QDialog.DialogCode.Accepted.value()) {
            String inputAmount = UICheckdialog.getAmount();
            String inputName = UICheckdialog.getName();
            String inputAddr1 = UICheckdialog.getAddr1();
            String inputAddr2 = UICheckdialog.getAddr2();
            String inputCheckNumber = UICheckdialog.getCheckNumber();
            String inputLicense = UICheckdialog.getLicense();
            String inputPhone = UICheckdialog.getPhone();
                                    
            boolean success;
            success = (checkAmount(inputAmount)&&checkText(inputName)&&checkText(inputAddr1)&&
                    checkText(inputAddr2)&&checkCheckNumber(inputCheckNumber)&&
                    checkLicense(inputLicense)&&checkPhone(inputPhone));
            
            if(success){
                Payment payment = new CheckPayment(this.paymentAmount);
                this.makePayment(payment);
                this.customerName = inputName;
                this.checkNumber = inputCheckNumber;
            }            
            return success;
        }
        else {
            Ui_NewGenPOS.setText("Payment Canceled!");
            return false;
        }        
    }
    public ProductCatalog getProductCatalog(){
        return this.catalog;
    }
    private boolean checkAmount(String input){
        try{
            Double paymentInput = Double.parseDouble(input);
            this.paymentAmount = new Money(paymentInput);
            //Ensure payment is >= the total
            this.total = currentSale.getTotal();
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
    private boolean checkCardNumber(String input){        
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
        this.cardNumber = "XXXXXXXXXXXX"+input.substring(12);
        return true;
    }
    private boolean checkEXP(String month, String year){
        if((month.length() != 2) || (year.length() != 2)){
            Ui_NewGenPOS.setText("Year/Month EXP values must range from 01 to 12! Try Again!");
            return false;
        }
        try{
            //Checking for only numbers
            int intCheck = Integer.parseInt(month);
            intCheck = Integer.parseInt(year);
        }
        catch(NumberFormatException e){
            Ui_NewGenPOS.setText("Year/Month EXP values must contain ONLY numbers! Try Again!");
            return false;
        }
        return true;
    }
    private boolean checkText(String input){
        if(input.isEmpty()){
            Ui_NewGenPOS.setText("All fields must be non-empty!");
            return false;
        }
        else{
            return true;
        }
    }
    private boolean checkCheckNumber(String input){
        try{
            //Checking for only numbers
            long numberCheck = Long.parseLong(input);
        }
        catch(NumberFormatException e){
            Ui_NewGenPOS.setText("Check number must contain ONLY numbers and must NOT be blank! Try Again!");
            return false;
        }
        return true;        
    }
    private boolean checkLicense(String input){
        if(input.length() != 8){
            Ui_NewGenPOS.setText("License must be 8 characters long! Try Again!");
            return false;
        }
        return true;
    }
    private boolean checkPhone(String input){
        if(input.length() != 10){
            Ui_NewGenPOS.setText("Phone number must be 10 numbers long! Try Again!");
            return false;
        }
        try{
            //Checking for only numbers
            long numberCheck = Long.parseLong(input);
        }
        catch(NumberFormatException e){
            Ui_NewGenPOS.setText("Phone number must contain ONLY numbers! Try Again!");
            return false;
        }
        return true;
    }
}
