package newgenpos;

import com.trolltech.qt.gui.QDialog;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class Register {
    private ProductCatalog catalog;
    private Sale currentSale;
    private int currentSalesNumber;
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
    
    private verifyPaymentAdapter adapter = new verifyPaymentAdapter();
    
    private static Register theInstance = null;
    
    private Register(int salesNumber, ProductCatalog pc, int id, String addr, String name){
        this.catalog = pc;
        this.storeID = id;
        this.storeAddr = addr;
        this.storeName = name;
        this.currentSalesNumber = salesNumber;
    }
    //HW5.1 Singleton Design Pattern
    public static Register getRegister(int salesNumber, ProductCatalog pc, int id, String addr, String name){
        if(theInstance == null){
            theInstance = new Register(salesNumber, pc, id, addr, name);
        }
        return theInstance;     
    }
    
    public void endSale(){
        currentSale.becomeComplete();
        Ui_NewGenPOS.setText("Thank You for Shopping!");         
        Ui_NewGenPOS.clearProductInput();
        Ui_NewGenPOS.clearCart();
        Ui_NewGenPOS.clearDiscount();
        Ui_NewGenPOS.setDisplay(0);
        this.currentSalesNumber = this.currentSalesNumber+1;
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
        this.header.add("Sale #"+this.currentSalesNumber);
        this.header.add("-----------------------------------------------\n");
        
        for(int i =0; i<cart.size();i++){
            SalesLineItem item = cart.get(i);
            ProductDescription product = item.getDescription();
            this.itemList.add(item.getQty()+"\t"+product.getDescription()+"\t"+product.getPrice().getFormatted());
        }
        
        Money subTotal = currentSale.getSubTotal();
        Money discount = currentSale.getDiscount();
        this.total = currentSale.getTotal();
        
        Money newSubTotal = subTotal.subtract(discount);
        Money tax = this.total.subtract(newSubTotal);
        
        this.footer.add("\nSubtotal\t"+subTotal.getFormatted());
        this.footer.add("\nDiscount\t-"+discount.getFormatted());
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
        this.footer.add("Amount Back\t\t"+cashBack.getFormatted());
        
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
    public void makePayment(int paymentMethod){
        PaymentFactory factoryObj = new PaymentFactory(paymentMethod);
        Payment payment = factoryObj.getPayment(this.paymentAmount);        
        currentSale.makePayment(payment);
    }
    //Cash Payment
    public boolean makeCashPayment(int paymentMethod, String input){        
        try{
            Double paymentInput = Double.parseDouble(input);
            this.paymentAmount = new Money(paymentInput);            
            this.total = currentSale.getTotal();
        }
        catch(NumberFormatException e){
            Ui_NewGenPOS.setText("Payment amount must contain ONLY numbers and must NOT be blank! Try Again!");
            return false;
        }
        if(this.total.checkEquals(new Money(0))){
            Ui_NewGenPOS.setText("Cart is empty, add item and try again!");
            return false;
        }            

        //Ensure payment is >= the total
        boolean success = adapter.verifyPayment(this.paymentAmount, this.total);
        if(success){
            this.makePayment(paymentMethod);
        }
        return success;
     
    }
    //Credit Payment
    public boolean makeCreditPayment(int paymentMethod, String inputAmount, String inputCardNumber,
            String inputYear, String inputMonth, String inputName){            
        try{
            Double paymentInput = Double.parseDouble(inputAmount);
            this.paymentAmount = new Money(paymentInput);
            this.total = currentSale.getTotal();
        }
        catch(NumberFormatException e){
            Ui_NewGenPOS.setText("Payment amount must contain ONLY numbers and must NOT be blank! Try Again!");
            return false;
        }

        if(this.total.checkEquals(new Money(0))){
            Ui_NewGenPOS.setText("Cart is empty, add item and try again!");
            return false;
        }

        boolean success;
        success = adapter.verifyPayment(this.paymentAmount, this.total, inputName, 
                inputCardNumber, inputMonth, inputYear);

        if(success){            
            this.makePayment(paymentMethod);
            this.customerName = inputName;
            this.cardNumber = "XXXXXXXXXXXX"+inputCardNumber.substring(12);
        }            
        return success;

    }
    //Check Payment
    public boolean makeCheckPayment(int paymentMethod, String inputAmount, String inputName,
                    String inputAddr1, String inputAddr2, String inputCheckNumber,
                    String inputLicense, String inputPhone){        
        try{
            Double paymentInput = Double.parseDouble(inputAmount);
            this.paymentAmount = new Money(paymentInput);            
            this.total = currentSale.getTotal();
        }
        catch(NumberFormatException e){
            Ui_NewGenPOS.setText("Payment amount must contain ONLY numbers and must NOT be blank! Try Again!");
            return false;
        }
        if(this.total.checkEquals(new Money(0))){
            Ui_NewGenPOS.setText("Cart is empty, add item and try again!");
            return false;
        }

        boolean success;
        success = adapter.verifyPayment(this.paymentAmount, this.total, inputName, inputAddr1, inputAddr2,
                inputCheckNumber, inputLicense, inputPhone);

        if(success){            
            this.makePayment(paymentMethod);
            this.customerName = inputName;
            this.checkNumber = inputCheckNumber;
        }            
        return success;
    }
    public ProductCatalog getProductCatalog(){
        return this.catalog;
    }
    public void recordSale(){
        String paymentMethod = "";
        String cartList = "";

        Payment payment = currentSale.getPayment();
        if(payment.isCash()){
            paymentMethod = "CASH";
        }
        if(payment.isCredit()){
            paymentMethod = "CREDIT: "+this.customerName+", CARD#"+this.cardNumber;
        }
        if(payment.isCheck()){
            paymentMethod = "CHECK: "+this.customerName+", CHECK#"+this.checkNumber;
        }

        for(int i =0; i<cart.size();i++){
            SalesLineItem item = cart.get(i);
            ProductDescription product = item.getDescription();
            int qty = item.getQty();
            String qtyString = "";
            if(qty<10){
                qtyString += "0"+qty;
            }
            else{
                qtyString += qty;
            }
            ItemID currentItemID = product.getItemID();
            String currentItemString = ""+currentItemID.getINT();
            cartList+=qtyString+currentItemString+",";
        }            
        String totalString = this.total.getFormatted();
        totalString = totalString.substring(1);
        double totalAmount = Double.parseDouble(totalString);
        String insert = "INSERT INTO Sales (salesNumber, date, total, paymentMethod, items) VALUES ("
                +this.currentSalesNumber+", '"+currentSale.getDate()+ "', "+ totalAmount+", '"
                +paymentMethod+"', '"+cartList+"')";

        DBFacade DBconnection = DBFacade.getDBconnection();
        try {
            DBconnection.insertItemsIntoDB(insert);
    
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //For Testing ONLY!
    public Sale getCurrentSale(){
        return this.currentSale;
    }
}
