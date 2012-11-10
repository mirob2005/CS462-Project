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
    //Receipt Sections
    List<String> header;
    List<String> itemList;
    List<String> footer;
    private QDialog dialog;
    private Ui_Dialog UIdialog;
    
    
    public Register(ProductCatalog pc, int id, String addr, String name){
        this.catalog = pc;
        this.storeID = id;
        this.storeAddr = addr;
        this.storeName = name;
    }
    public void endSale(){
        currentSale.becomeComplete();
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
        Money total = currentSale.getTotal();
        
        Money tax = total.subtract(subTotal);        
        
        this.footer.add("\nSubtotal\t"+subTotal.getFormatted());        
        this.footer.add("Tax\t"+tax.getFormatted());
        this.footer.add("Total\t"+total.getFormatted());
        
        this.footer.add("-----------------------------------------------\n");
        
        Payment payment = currentSale.getPayment();
        if(payment.isCash()){
            this.footer.add("Payment Method\tCASH");
        }
        if(payment.isCredit()){
            this.footer.add("Payment Method\tCREDIT");
        }
        if(payment.isCheck()){
            this.footer.add("Payment Method\tCHECK");
        }
        Money cashBack = currentSale.getCashBack(); 
        this.footer.add("Amount Back\t"+cashBack.getFormatted());
        
        this.printReceipt();
    }
    public void printReceipt(){
        dialog = new QDialog();
        UIdialog = new Ui_Dialog();
        UIdialog.setupUi(dialog);
        dialog.setWindowTitle("Receipt");
        dialog.show();
        
        UIdialog.setText("");
        for(int i=0; i<this.header.size();i++){
            UIdialog.appendText(this.header.get(i));
        }
        for(int i=0; i<this.itemList.size();i++){
            UIdialog.appendText(this.itemList.get(i));
        }
        for(int i=0; i<this.footer.size();i++){
            UIdialog.appendText(this.footer.get(i));
        }       
    }
    public void makeNewSale(){
        currentSale = new Sale();
    }
    public void makePayment(Payment paymentAmount){
        currentSale.makePayment(paymentAmount);
    }
    public ProductCatalog getProductCatalog(){
        return this.catalog;
    }
}
