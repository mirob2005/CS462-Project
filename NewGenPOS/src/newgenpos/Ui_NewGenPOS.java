/********************************************************************************
** NewGenPOS Interface
********************************************************************************/
package newgenpos;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Ui_NewGenPOS implements com.trolltech.qt.QUiForm<QMainWindow>
{
    private ProductCatalog pc;
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
    private static QTableView cartTableView;
    private QLabel qtyInputLabel;
    private static QLineEdit qtyInput;   
    private QLabel itemDescrLabel;
    private QLabel cartLabel;
    private QLabel titleLabel;
    private static QLCDNumber totalDisplay;
    private QLabel totalLabel;
    private QPushButton creditButton;
    private QPushButton cashButton;
    private QPushButton checkButton;
    private QLabel label;
    private static QStandardItemModel model = new QStandardItemModel(0,4);


    public Ui_NewGenPOS() { 
        super();
        register = Main.getRegister();
        pc = register.getProductCatalog();
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
        itemDescrScrollArea.setGeometry(new QRect(20, 50, 450, 100));
        itemDescrScrollArea.setWidgetResizable(true);
        scrollAreaWidgetContents = new QWidget();
        scrollAreaWidgetContents.setObjectName("scrollAreaWidgetContents");
        scrollAreaWidgetContents.setGeometry(new QRect(0, 0, 450, 100));
        itemDescrTextEdit = new QTextEdit(scrollAreaWidgetContents);
        itemDescrTextEdit.setObjectName("itemDescrTextEdit");
        itemDescrTextEdit.setGeometry(new QRect(0, 0, 450, 150));
        
        QFont font14 = new QFont();
        font14.setFamily("Arial");
        font14.setPointSize(10);
        
        if(pc.connectionActive()){
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
        cartScrollArea.setGeometry(new QRect(20, 180, 450, 200));
        cartScrollArea.setWidgetResizable(true);
        scrollAreaWidgetContents_2 = new QWidget();
        scrollAreaWidgetContents_2.setObjectName("scrollAreaWidgetContents_2");
        scrollAreaWidgetContents_2.setGeometry(new QRect(0, 0, 450, 200));
        cartTableView = new QTableView(scrollAreaWidgetContents_2);
        cartTableView.setObjectName("cartTableView");
        cartTableView.setGeometry(new QRect(0, 0, 450, 200));
        
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
        cartLabel.setGeometry(new QRect(20, 150, 53, 30));
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
        creditButton = new QPushButton(centralwidget);
        creditButton.setObjectName("creditButton");
        creditButton.setGeometry(new QRect(150, 395, 100, 50));
        QFont font10 = new QFont();
        font10.setFamily("Arial");
        font10.setPointSize(12);
        font10.setBold(true);
        font10.setWeight(75);
        creditButton.setFont(font10);
        cashButton = new QPushButton(centralwidget);
        cashButton.setObjectName("cashButton");
        cashButton.setGeometry(new QRect(280, 395, 100, 50));
        QFont font11 = new QFont();
        font11.setFamily("Arial");
        font11.setPointSize(12);
        font11.setBold(true);
        font11.setWeight(75);
        cashButton.setFont(font11);
        checkButton = new QPushButton(centralwidget);
        checkButton.setObjectName("checkButton");
        checkButton.setGeometry(new QRect(410, 395, 100, 50));
        QFont font12 = new QFont();
        font12.setFamily("Arial");
        font12.setPointSize(12);
        font12.setBold(true);
        font12.setWeight(75);
        checkButton.setFont(font12);
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
        QWidget.setTabOrder(itemDescrTextEdit, productInput);
        QWidget.setTabOrder(productInput, qtyInput);
        QWidget.setTabOrder(qtyInput, addItemButton);
        QWidget.setTabOrder(addItemButton, creditButton);
        QWidget.setTabOrder(creditButton, cashButton);
        QWidget.setTabOrder(cashButton, checkButton);
        QWidget.setTabOrder(checkButton, cartTableView);        
        QWidget.setTabOrder(cartTableView, cartScrollArea);
        QWidget.setTabOrder(cartScrollArea, itemDescrScrollArea);
        QWidget.setTabOrder(itemDescrScrollArea, itemDescrTextEdit);        
        retranslateUi(NewGenPOS);

        //These send signals when these buttons are clicked        
        cashButton.clicked.connect(this,"on_cashButton_clicked()");
        creditButton.clicked.connect(this,"on_creditButton_clicked()");
        checkButton.clicked.connect(this,"on_checkButton_clicked()");
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
        creditButton.setText(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "Credit", null));
        cashButton.setText(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "Cash", null));
        checkButton.setText(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "Check", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("NewGenPOS", "Pay With:", null));
    } // retranslateUi
    
    private void on_cashButton_clicked(){        
        boolean success = register.makeCashPayment();
        if(success){
            successfulTransaction();
        }
    }
    private void on_creditButton_clicked(){  
        boolean success = register.makeCreditPayment();
        if(success){
            successfulTransaction();
        }
    }
    private void on_checkButton_clicked(){
        boolean success = register.makeCheckPayment();
        if(success){
            successfulTransaction();
        }
    }
    private void successfulTransaction(){
        register.createReceipt();
        register.endSale();
        register.makeNewSale();
    }
    public static void clearCart() {
        model.clear();
        model.setHorizontalHeaderItem(0, new QStandardItem("Product ID"));
        model.setHorizontalHeaderItem(1, new QStandardItem("Product Name"));
        model.setHorizontalHeaderItem(2, new QStandardItem("Price"));
        model.setHorizontalHeaderItem(3, new QStandardItem("Qty"));
        
        cartTableView.setModel(model);
        cartTableView.horizontalHeader().resizeSection(0,90);
        cartTableView.horizontalHeader().resizeSection(1,203);
        cartTableView.horizontalHeader().resizeSection(2,90);
        cartTableView.horizontalHeader().resizeSection(3,45);        
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
    public static void appendText(String text){
        itemDescrTextEdit.append(text);
    }
    public void on_addItemButton_clicked() throws SQLException{
        if(pc.connectionActive())
        {
            try{
                int productID = getProductInput();
                ItemID itemID = new ItemID(productID);
                if(itemID.valid())
                {
                    int quantity = getProductQty();
                    register.enterItem(itemID, quantity);   
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
    }
    public static void setDisplay(double value){
        totalDisplay.display(value);
    }
    public static void setDisplay(String value){
        totalDisplay.display(value);
    }
    public static void setDisplay(Money value){
        totalDisplay.display(value.getFormatted());
    }
    public static void displayDescription(SalesLineItem cart) {
        int qty = cart.getQty();
        ProductDescription desc = cart.getDescription();
        String description = desc.getDescription();
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

