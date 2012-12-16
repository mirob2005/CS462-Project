
package newgenpos;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_ReceiptDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    private QScrollArea receiptScrollArea;
    private QWidget scrollAreaWidgetContents;
    private QTextEdit receiptTextEdit;
    private QLabel label;

    public Ui_ReceiptDialog() { super(); }

    @Override
    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(640, 480).expandedTo(Dialog.minimumSizeHint()));
        receiptScrollArea = new QScrollArea(Dialog);
        receiptScrollArea.setObjectName("receiptScrollArea");
        receiptScrollArea.setGeometry(new QRect(20, 60, 600, 400));
        receiptScrollArea.setWidgetResizable(true);
        scrollAreaWidgetContents = new QWidget();
        scrollAreaWidgetContents.setObjectName("scrollAreaWidgetContents");
        scrollAreaWidgetContents.setGeometry(new QRect(0, 0, 600, 400));
        
        QFont font1 = new QFont();
        font1.setFamily("Arial");
        font1.setPointSize(10);
        receiptTextEdit = new QTextEdit(scrollAreaWidgetContents);
        receiptTextEdit.setObjectName("receiptTextEdit");
        receiptTextEdit.setGeometry(new QRect(0, 0, 600, 400));
        receiptTextEdit.setFont(font1);
        receiptTextEdit.setReadOnly(true);
        
        receiptScrollArea.setWidget(scrollAreaWidgetContents);
        label = new QLabel(Dialog);
        label.setObjectName("label");
        label.setGeometry(new QRect(270, 20, 100, 30));
        QFont font = new QFont();
        font.setFamily("Arial");
        font.setPointSize(18);
        label.setFont(font);
        retranslateUi(Dialog);
        
        Dialog.connectSlotsByName();
    } // setupUi

    private void retranslateUi(QDialog Dialog)
    {
        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Dialog", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Receipt", null));
    } // retranslateUi
    
    public void setText(String text){
        receiptTextEdit.setText(text);
    }
    public void appendText(String text){
        receiptTextEdit.append(text);
    }
    
}

