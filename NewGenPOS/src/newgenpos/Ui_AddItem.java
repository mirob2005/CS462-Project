package newgenpos;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ui_AddItem implements com.trolltech.qt.QUiForm<QDialog>
{
    private QDialogButtonBox buttonBox;
    private QScrollArea scrollArea;
    private QWidget scrollAreaWidgetContents;
    private QTableView matrix;
    private static QLineEdit input;
    private static QLineEdit qtyInput;
    private QLabel enterItemLabel;
    private QLabel qtyLabel;
    private QLabel headerLabel;
    private static QStandardItemModel model = new QStandardItemModel(0,4);

    public Ui_AddItem() { super(); }

    @Override
    public void setupUi(QDialog AddItem)
    {
        AddItem.setObjectName("AddItem");
        AddItem.resize(new QSize(459, 510).expandedTo(AddItem.minimumSizeHint()));
        buttonBox = new QDialogButtonBox(AddItem);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(280, 460, 160, 30));
        buttonBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));
        scrollArea = new QScrollArea(AddItem);
        scrollArea.setObjectName("scrollArea");
        scrollArea.setGeometry(new QRect(20, 50, 420, 370));
        scrollArea.setWidgetResizable(true);
        scrollAreaWidgetContents = new QWidget();
        scrollAreaWidgetContents.setObjectName("scrollAreaWidgetContents");
        scrollAreaWidgetContents.setGeometry(new QRect(0, 0, 418, 368));
        matrix = new QTableView(scrollAreaWidgetContents);
        matrix.setObjectName("matrix");
        matrix.setGeometry(new QRect(0, 0, 420, 370));
        
        model.clear();
        model.setHorizontalHeaderItem(0, new QStandardItem("ItemID"));
        model.setHorizontalHeaderItem(1, new QStandardItem("Product Name"));
        model.setHorizontalHeaderItem(2, new QStandardItem("Price"));
        model.setHorizontalHeaderItem(3, new QStandardItem("Stock"));
        
        matrix.setModel(model);
        matrix.horizontalHeader().resizeSection(0,65);
        matrix.horizontalHeader().resizeSection(1,200);
        matrix.horizontalHeader().resizeSection(2,90);
        matrix.horizontalHeader().resizeSection(3,45);
        
        matrix.setEditTriggers(QAbstractItemView.EditTrigger.NoEditTriggers);                
        
        fillTable();
            
        scrollArea.setWidget(scrollAreaWidgetContents);
   
        QFont font3 = new QFont();
        font3.setFamily("Arial");
        font3.setPointSize(12);           
        
        
        input = new QLineEdit(AddItem);
        input.setObjectName("input");
        input.setGeometry(new QRect(50, 460, 80, 30));
        input.setMaxLength(6);
        input.setFont(font3);
        
        qtyInput = new QLineEdit(AddItem);
        qtyInput.setObjectName("qtyInput");
        qtyInput.setGeometry(new QRect(215, 460, 50, 30));
        qtyInput.setFont(font3);
        qtyInput.setMaxLength(2);        
        
        QFont font = new QFont();
        font.setFamily("Arial");
        font.setPointSize(12);        
        
        enterItemLabel = new QLabel(AddItem);
        enterItemLabel.setObjectName("enterItemLabel");
        enterItemLabel.setGeometry(new QRect(20, 430, 250, 30));
        enterItemLabel.setFont(font);
        
        qtyLabel = new QLabel(AddItem);
        qtyLabel.setObjectName("qtyLabel");
        qtyLabel.setGeometry(new QRect(190, 430, 100, 30));
        qtyLabel.setFont(font);
        

        
        headerLabel = new QLabel(AddItem);
        headerLabel.setObjectName("headerLabel");
        headerLabel.setGeometry(new QRect(120, 10, 220, 30));
        QFont font1 = new QFont();
        font1.setFamily("Arial");
        font1.setPointSize(18);
        headerLabel.setFont(font1);
        QWidget.setTabOrder(input, buttonBox);
        QWidget.setTabOrder(buttonBox, scrollArea);
        QWidget.setTabOrder(scrollArea, matrix);
        retranslateUi(AddItem);
        buttonBox.accepted.connect(AddItem, "accept()");
        buttonBox.rejected.connect(AddItem, "reject()");

        AddItem.connectSlotsByName();
    } // setupUi

    private void retranslateUi(QDialog AddItem)
    {
        AddItem.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("AddItem", "Dialog", null));
        enterItemLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("AddItem", "Enter Product ID:", null));
        qtyLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("AddItem", "Enter QTY:", null));
        headerLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("AddItem", "All Merchandise", null));
        qtyInput.setText(com.trolltech.qt.core.QCoreApplication.translate("AddItem", "1", null));
    } // retranslateUi
    private void fillTable(){
        try {
            String query = "SELECT * FROM Inventory";
            DBFacade DBconnection = DBFacade.getDBconnection();
            ResultSet rs = DBconnection.selectItemsFromDB(query);

            while(rs.next()) {
                List newRow = new ArrayList();
                newRow.add(new QStandardItem(rs.getString("itemID")));
                newRow.add(new QStandardItem(rs.getString("description")));
                newRow.add(new QStandardItem(rs.getString("price")));
                newRow.add(new QStandardItem(rs.getString("stock")));
                model.appendRow(newRow);
            }     
        } catch (SQLException ex) {
            Logger.getLogger(Ui_AddItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getProductID(){
        return input.text();
    }
    public String getQTY(){
        return qtyInput.text();
    }
    public static void clearInput(){
        input.setText("");
        qtyInput.setText("1");        
    }
}

