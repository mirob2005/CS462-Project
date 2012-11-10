/********************************************************************************
** NewGenPOS Interface
********************************************************************************/
package newgenpos;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.net.*;


public class Ui_NewGenPOS implements com.trolltech.qt.QUiForm<QMainWindow>
{
    private QDialog dialog;
    private Ui_Dialog UIdialog;
    private Connection con = ProductCatalog.con;
    private static Register register;
    
    private QWidget centralwidget;
    private QPushButton addItemButton;
    private static QLineEdit productInput;
    private QLabel productInputLabel;
    private QFrame line;
    private QScrollArea itemDescrScrollArea;
    private QWidget scrollAreaWidgetContents;
    private static QTextEdit itemDescrTextEdit;
    private QScrollArea cartScrollArea;
    private QWidget scrollAreaWidgetContents_2;
    private QTableView cartTableView;
    private QLabel qtyInputLabel;
    private static QLineEdit qtyInput;
    private QToolButton paidButton;
    private QLabel itemDescrLabel;
    private QLabel cartLabel;
    private QLabel titleLabel;
    private static QLCDNumber totalDisplay;
    private QLabel totalLabel;
    private QPushButton pushButton;
    private QPushButton pushButton_2;
    private QPushButton pushButton_3;
    private QLabel label;
    private List<Double> priceList = new ArrayList<>();
    private static QStandardItemModel model = new QStandardItemModel(0,4);


    public Ui_NewGenPOS() { 
        super();
        register = Main.getRegister();
        register.makeNewSale();
    }
       
    


    @Override
    public void setupUi(QMainWindow NewGenPOS)
    {
        NewGenPOS.setObjectName("NewGenPOS");
        NewGenPOS.resize(new QSize(680, 540).expandedTo(NewGenPOS.minimumSizeHint()));
        centralwidget = new QWidget(NewGenPOS);
        centralwidget.setObjectName("centralwidget");
        
        
        addItemButton = new QPushButton(centralwidget);
        addItemButton.setObjectName("addItemButton");
        addItemButton.setGeometry(new QRect(560, 490, 100, 30));
        QFont font = new QFont();
        font.setFamily("Arial");
        font.setPointSize(12);
        font.setBold(true);
        font.setWeight(75);
        addItemButton.setFont(font);
        
        QFont font3 = new QFont();
        font3.setFamily("Arial");
        font3.setPointSize(12);
        productInput = new QLineEdit(centralwidget);
        productInput.setObjectName("productInput");
        productInput.setGeometry(new QRect(20, 490, 80, 30));
        productInput.setFont(font3);
        productInput.setMaxLength(6);
        
        productInputLabel = new QLabel(centralwidget);
        productInputLabel.setObjectName("productInputLabel");
        productInputLabel.setGeometry(new QRect(20, 460, 225, 30));
        QFont font1 = new QFont();
        font1.setFamily("Arial");
        font1.setPointSize(12);
        font1.setBold(true);
        font1.setWeight(75);
        productInputLabel.setFont(font1);
        line = new QFrame(centralwidget);
        line.setObjectName("line");
        line.setGeometry(new QRect(0, 450, 680, 20));
        line.setFrameShape(QFrame.Shape.HLine);
        line.setFrameShadow(QFrame.Shadow.Sunken);
        
        
        itemDescrScrollArea = new QScrollArea(centralwidget);
        itemDescrScrollArea.setObjectName("itemDescrScrollArea");
        itemDescrScrollArea.setGeometry(new QRect(20, 50, 450, 150));
        itemDescrScrollArea.setWidgetResizable(true);
        scrollAreaWidgetContents = new QWidget();
        scrollAreaWidgetContents.setObjectName("scrollAreaWidgetContents");
        scrollAreaWidgetContents.setGeometry(new QRect(0, 0, 448, 148));
        itemDescrTextEdit = new QTextEdit(scrollAreaWidgetContents);
        itemDescrTextEdit.setObjectName("itemDescrTextEdit");
        itemDescrTextEdit.setGeometry(new QRect(0, 0, 450, 150));
        
        QFont font14 = new QFont();
        font14.setFamily("Arial");
        font14.setPointSize(10);
        
        if(con != null){
             setText("Inventory Loaded Successfully!");
        }
        else{
            setText("ERROR: Inventory NOT Loaded Successfully!");
        }
            
        appendText("Add Item to Cart to See Product Description!");
    
        itemDescrScrollArea.setWidget(scrollAreaWidgetContents);
        itemDescrTextEdit.setFont(font14);
        itemDescrTextEdit.setReadOnly(true);
        
        
        cartScrollArea = new QScrollArea(centralwidget);
        cartScrollArea.setObjectName("cartScrollArea");
        cartScrollArea.setGeometry(new QRect(20, 230, 450, 150));
        cartScrollArea.setWidgetResizable(true);
        scrollAreaWidgetContents_2 = new QWidget();
        scrollAreaWidgetContents_2.setObjectName("scrollAreaWidgetContents_2");
        scrollAreaWidgetContents_2.setGeometry(new QRect(0, 0, 448, 148));
        cartTableView = new QTableView(scrollAreaWidgetContents_2);
        cartTableView.setObjectName("cartTableView");
        cartTableView.setGeometry(new QRect(0, 0, 450, 150));
        
        clearCart();
        
        //Prevent Editing of Cells
        cartTableView.setEditTriggers(QAbstractItemView.EditTrigger.NoEditTriggers);
        cartScrollArea.setWidget(scrollAreaWidgetContents_2);
        
        qtyInputLabel = new QLabel(centralwidget);
        qtyInputLabel.setObjectName("qtyInputLabel");
        qtyInputLabel.setGeometry(new QRect(510, 460, 40, 30));
        QFont font2 = new QFont();
        font2.setFamily("Arial");
        font2.setPointSize(12);
        font2.setBold(true);
        font2.setWeight(75);
        qtyInputLabel.setFont(font2);
        qtyInput = new QLineEdit(centralwidget);
        qtyInput.setObjectName("qtyInput");
        qtyInput.setGeometry(new QRect(500, 490, 50, 30));

        qtyInput.setFont(font3);
        qtyInput.setMaxLength(2);
        
        
        
        paidButton = new QToolButton(centralwidget);
        paidButton.setObjectName("paidButton");
        paidButton.setGeometry(new QRect(540, 395, 100, 50));
        QFont font4 = new QFont();
        font4.setFamily("Arial");
        font4.setPointSize(12);
        font4.setBold(true);
        font4.setWeight(75);
        paidButton.setFont(font4);
        
        itemDescrLabel = new QLabel(centralwidget);
        itemDescrLabel.setObjectName("itemDescrLabel");
        itemDescrLabel.setGeometry(new QRect(20, 20, 175, 30));
        QFont font5 = new QFont();
        font5.setFamily("Arial");
        font5.setPointSize(12);
        font5.setBold(true);
        font5.setWeight(75);
        itemDescrLabel.setFont(font5);
        cartLabel = new QLabel(centralwidget);
        cartLabel.setObjectName("cartLabel");
        cartLabel.setGeometry(new QRect(20, 200, 53, 30));
        QFont font6 = new QFont();
        font6.setFamily("Arial");
        font6.setPointSize(12);
        font6.setBold(true);
        font6.setWeight(75);
        cartLabel.setFont(font6);
        titleLabel = new QLabel(centralwidget);
        titleLabel.setObjectName("titleLabel");
        titleLabel.setGeometry(new QRect(525, 50, 100, 150));
        QFont font7 = new QFont();
        font7.setFamily("Arial");
        font7.setPointSize(18);
        font7.setBold(true);
        font7.setWeight(75);
        titleLabel.setFont(font7);
        
        totalDisplay = new QLCDNumber(10,centralwidget);
        totalDisplay.setObjectName("totalDisplay");
        totalDisplay.setGeometry(new QRect(500, 270, 150, 100));
        QFont font8 = new QFont();
        font8.setFamily("Arial");
        font8.setPointSize(10);
        font8.setBold(true);
        font8.setWeight(75);
        totalDisplay.setFont(font8);
        totalDisplay.setSegmentStyle(QLCDNumber.SegmentStyle.Filled);

        
        totalLabel = new QLabel(centralwidget);
        totalLabel.setObjectName("totalLabel");
        totalLabel.setGeometry(new QRect(500, 240, 150, 30));
        QFont font9 = new QFont();
        font9.setFamily("Arial");
        font9.setPointSize(12);
        font9.setBold(true);
        font9.setWeight(75);
        totalLabel.setFont(font9);
        pushButton = new QPushButton(centralwidget);
        pushButton.setObjectName("pushButton");
        pushButton.setGeometry(new QRect(150, 395, 100, 50));
        QFont font10 = new QFont();
        font10.setFamily("Arial");
        font10.setPointSize(12);
        font10.setBold(true);
        font10.setWeight(75);
        pushButton.setFont(font10);
        pushButton_2 = new QPushButton(centralwidget);
        pushButton_2.setObjectName("pushButton_2");
        pushButton_2.setGeometry(new QRect(280, 395, 100, 50));
        QFont font11 = new QFont();
        font11.setFamily("Arial");
        font11.setPointSize(12);
        font11.setBold(true);
        font11.setWeight(75);
        pushButton_2.setFont(font11);
        pushButton_3 = new QPushButton(centralwidget);
        pushButton_3.setObjectName("pushButton_3");
        pushButton_3.setGeometry(new QRect(410, 395, 100, 50));
        QFont font12 = new QFont();
        font12.setFamily("Arial");
        font12.setPointSize(12);
        font12.setBold(true);
        font12.setWeight(75);
        pushButton_3.setFont(font12);
        label = new QLabel(centralwidget);
        label.setObjectName("label");
        label.setGeometry(new QRect(20, 395, 100, 50));
        QFont font13 = new QFont();
        font13.setFamily("Arial");
        font13.setPointSize(12);
        font13.setBold(true);
        font13.setWeight(75);
        label.setFont(font13);
        NewGenPOS.setCentralWidget(centralwidget);
        QWidget.setTabOrder(cartTableView, cartScrollArea);
        QWidget.setTabOrder(cartScrollArea, itemDescrScrollArea);
        QWidget.setTabOrder(itemDescrScrollArea, itemDescrTextEdit);
        QWidget.setTabOrder(itemDescrTextEdit, pushButton);
        QWidget.setTabOrder(pushButton, pushButton_2);
        QWidget.setTabOrder(pushButton_2, pushButton_3);
        QWidget.setTabOrder(pushButton_3, paidButton);
        QWidget.setTabOrder(paidButton, productInput);
        QWidget.setTabOrder(productInput, qtyInput);
        QWidget.setTabOrder(qtyInput, addItemButton);
        retranslateUi(NewGenPOS);


        //These send signals when these buttons are clicked
        paidButton.clicked.connect(this, "on_paidButton_clicked()");
        addItemButton.clicked.connect(this, "on_addItemButton_clicked()");
        

        
        NewGenPOS.connectSlotsByName();
    } // setupUi

    private void retranslateUi(QMainWindow NewGenPOS)
    {
        NewGenPOS.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "MainWindow", null));
        addItemButton.setText(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "Add Item", null));
        productInputLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "Enter Product ID Here:", null));
        qtyInputLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "Qty", null));
        qtyInput.setText(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "1", null));
        paidButton.setText(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "PAID", null));
        itemDescrLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "Item Description", null));
        cartLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "Cart", null));
        titleLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Arial'; font-size:18pt; font-weight:600; font-style:normal;\">\n"+
"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-style:italic;\">New</span></p>\n"+
"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-style:italic;\">Gen</span></p>\n"+
"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-style:italic;\">POS</span></p></body></html>", null));
        totalLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'Arial'; font-size:12pt; font-weight:600; font-style:normal;\">\n"+
"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\">Total Owed:</p></body></html>", null));
        pushButton.setText(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "Credit", null));
        pushButton_2.setText(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "Cash", null));
        pushButton_3.setText(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "Check", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "Pay With:", null));
    } // retranslateUi
    
    public void on_paidButton_clicked() {
        showReceipt();
        register.endSale();
        setText("Thank You for Shopping!"); 
        totalDisplay.display(0);
        clearProductInput();
        clearCart();
        register.makeNewSale();
    }
    public void showReceipt(){
        dialog = new QDialog();
        UIdialog = new Ui_Dialog();
        UIdialog.setupUi(dialog);
        dialog.setWindowTitle("Receipt");
        dialog.show();
                
        UIdialog.setText("NewGenPOS Sale\nDate\tTime\n---------------------------\n");        
        String receipt = "";
        for(int i=0; i< model.rowCount(); i++){
            for(int j=0; j<model.columnCount(); j++){
                Object index = model.data(i,j);
                receipt += index.toString();
                receipt += "\t";
            }
             UIdialog.appendText(receipt);
             receipt = "";
        }          
        UIdialog.appendText("\nSubtotal\t...");  
        UIdialog.appendText("Tax\t...");  
        UIdialog.appendText("Total\t...");  
        UIdialog.appendText("\nPayment Method\t...");  
    }
    public void clearCart() {
        model.clear();
        model.setHorizontalHeaderItem(0, new QStandardItem("Product ID"));
        model.setHorizontalHeaderItem(1, new QStandardItem("Product Name"));
        model.setHorizontalHeaderItem(2, new QStandardItem("Price"));
        model.setHorizontalHeaderItem(3, new QStandardItem("Qty"));
        
        cartTableView.setModel(model);
        cartTableView.horizontalHeader().resizeSection(0,100);
        cartTableView.horizontalHeader().resizeSection(1,195);
        cartTableView.horizontalHeader().resizeSection(2,90);
        cartTableView.horizontalHeader().resizeSection(3,45);
        
        
        priceList.clear();
    }
    public int getProductInput(){
        int productID = Integer.parseInt(productInput.text());
        return productID;
    }
    public int getProductQty(){
        int quantity = Integer.parseInt(qtyInput.text());
        return quantity;
    }
    public static void setText(String text){
        itemDescrTextEdit.setPlainText(text);
    }
    public void appendText(String text){
        itemDescrTextEdit.append(text);
    }
    public void on_addItemButton_clicked() throws SQLException{
        if(con != null)
        {
            try{
                int productID = getProductInput();
                ItemID itemID = new ItemID(productID);
                if(itemID.valid())
                {

                    int quantity = getProductQty();
                    //START HERE
                    register.enterItem(itemID, quantity);   
                    
//                    Statement st = con.createStatement();
//
//                    ResultSet rs = st.executeQuery("select * from Inventory where itemID = "+ itemID.getINT());
//
//                    if(rs.first() == false)
//                    {
//                        setText("Product with ID of \"" + productID + "\" DOES NOT exist. Please try again.");   
//                    }
//                    else
//                    {   
//                     
//                        String description = rs.getString("description");
//                        double price = Double.parseDouble(rs.getString("price"));
//                        int currentStock = rs.getInt("stock");
//
//                        int updatedStock = currentStock - quantity;                    
//                        if(updatedStock <0){
//                            if(quantity == 1)
//                            {
//                                setText("No "+description+"'s are left. Please chose another item.");
//                            }
//                            else
//                            {
//                                setText("Only "+currentStock+" "+description+"'s are left. Please reduce quantity requested.");
//                            }
//                            updatedStock = currentStock;
//                        }
//                        else{
//                            //Update table with currentStock - quantity with check that stock >=0 afterwards
//                            st.executeUpdate("UPDATE Inventory SET stock = "+updatedStock+" WHERE itemID = "+productID);  
//                            
//
//
//                            addItemToTable(productID, quantity, description, price, updatedStock);            
//                        }
//                    }
                }
                else{
                    setText("Product ID is invalid, must be 6 numbers ranging between 100000 and 999999");
                }
            }
            catch(NumberFormatException e){
                setText("Product ID and Quantity values must contain ONLY numbers! Try Again!");
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else{
            setText("Inventory is NOT loaded, no products can be found!");
        }
            
        clearProductInput();
    }
    public static void clearProductInput() {
        productInput.setText("");
        qtyInput.setText("1");
    }
    public void addItemToTable(int productID, int quantity, String description, double price, int updatedStock) {
        
        for(int i=0; i < quantity; i++) {
            priceList.add(price);
        }
        
        String priceString = "$";
        DecimalFormat twoDecimals = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));
        priceString += (twoDecimals.format(priceList.get((priceList.size()-1))));
        
        String quantityString = Integer.toString(quantity);
        String productIDString = Integer.toString(productID);
        
        List newRow = new ArrayList();
        newRow.add(new QStandardItem(productIDString));
        newRow.add(new QStandardItem(description));
        newRow.add(new QStandardItem(priceString));
        newRow.add(new QStandardItem(quantityString));
        model.appendRow(newRow);
        
        displayPrice();
        displayDescription(productID, quantity, description, priceString, updatedStock);
              
    }
    public static void addItemToTable(SalesLineItem cart){
        ProductDescription desc = cart.getDescription();
        int qty = cart.getQty();
        ItemID ID = desc.getItemID();
        
        String quantityString = Integer.toString(qty);
        String productIDString = Integer.toString(ID.getINT());
        
        List newRow = new ArrayList();
        newRow.add(new QStandardItem(productIDString));
        newRow.add(new QStandardItem(cart.getDescription().getDescription()));
        newRow.add(new QStandardItem(cart.getPrice().getFormatted()));
        newRow.add(new QStandardItem(quantityString));
        model.appendRow(newRow);

//        displayDescription(productID, quantity, description, priceString, updatedStock);
    }
    double RoundTo2Decimals(double val) {
        DecimalFormat df2 = new DecimalFormat("###.##");
        return Double.valueOf(df2.format(val));
    }
    public void displayPrice() {
        double totalPrice = 0;
        
        for(int i =0; i < priceList.size(); i++) {
             totalPrice += priceList.get(i);
        }
        
        //Calculate Tax
        totalPrice = totalPrice*1.08;
        totalPrice = RoundTo2Decimals(totalPrice);

        
        totalDisplay.display(totalPrice);      
    }
    public static void displayTotal(Money total){
        totalDisplay.display(total.getFormatted());
    }
    public void displayDescription(int productID, int qty, String description, String priceString, int updatedStock) {
        if(qty==1)
        {
            setText(""+qty+" "+ description+", product ID "+ productID +" was successfully added to cart at "+priceString+" each. There are "+updatedStock+" left");    
        }
        else
        {
            setText(""+qty+" "+ description+"'s, product ID "+ productID +" was successfully added to cart at "+priceString+" each. There are "+updatedStock+" left");    
        }
    }
    public static void displayDescription(SalesLineItem cart) {
        int qty = cart.getQty();
        ProductDescription desc = cart.getDescription();
        String description = desc.getDecsription();
        ItemID itemID = desc.getItemID();  
        Money price = desc.getPrice();
        int updatedStock = desc.getStock();
        
        if(qty==1)
        {
            setText(""+qty+" "+ description+", product ID "+ itemID.getINT() +" was successfully added to cart at "+price.getFormatted()+" each. There are "+updatedStock+" left");    
        }
        else
        {
            setText(""+qty+" "+ description+"'s, product ID "+ itemID.getINT() +" was successfully added to cart at "+price.getFormatted()+" each. There are "+updatedStock+" left");    
        }
    }
}

