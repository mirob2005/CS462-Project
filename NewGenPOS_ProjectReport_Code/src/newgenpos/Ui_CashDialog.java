
package newgenpos;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_CashDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    private QDialogButtonBox acceptanceBox;
    private QLabel cashAmounLabel;
    private QLineEdit cashAmountInput;         

    public Ui_CashDialog() { 
        super();        
    }

    @Override
    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(350, 125).expandedTo(Dialog.minimumSizeHint()));
        acceptanceBox = new QDialogButtonBox(Dialog);
        acceptanceBox.setObjectName("acceptanceBox");
        acceptanceBox.setGeometry(new QRect(160, 70, 170, 30));
        acceptanceBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        acceptanceBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));
        cashAmounLabel = new QLabel(Dialog);
        cashAmounLabel.setObjectName("cashAmounLabel");
        cashAmounLabel.setGeometry(new QRect(40, 20, 270, 30));
        QFont font = new QFont();
        font.setFamily("Arial");
        font.setPointSize(18);
        cashAmounLabel.setFont(font);
        cashAmounLabel.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        cashAmountInput = new QLineEdit(Dialog);
        cashAmountInput.setObjectName("cashAmountInput");
        cashAmountInput.setGeometry(new QRect(40, 70, 100, 30));
        retranslateUi(Dialog);
        acceptanceBox.accepted.connect(Dialog, "accept()");
        acceptanceBox.rejected.connect(Dialog, "reject()");

        Dialog.connectSlotsByName();
    } // setupUi

    private void retranslateUi(QDialog Dialog)
    {
        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Dialog", null));
        cashAmounLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Enter Cash Amount:", null));
    } // retranslateUi
    
    public String getInput(){
        return this.cashAmountInput.text();
    }
}

