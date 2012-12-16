package newgenpos;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_CreditDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    private QDialogButtonBox acceptanceBox;
    private QLabel creditInformationLabel;
    private QLabel cardNumberLabel;
    private QLabel expLabel;
    private QLabel nameLabel;
    private QLineEdit cardNumberInput;
    private QLineEdit monthInput;
    private QLineEdit yearInput;
    private QLineEdit nameInput;
    private QLabel monthLabel;
    private QLabel yearLabel;
    private QLineEdit amountInput;
    private QLabel amountLabel;

    public Ui_CreditDialog() { super(); }

    @Override
    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(500, 240).expandedTo(Dialog.minimumSizeHint()));
        QFont font = new QFont();
        font.setFamily("Arial");
        font.setPointSize(12);
        Dialog.setFont(font);
        acceptanceBox = new QDialogButtonBox(Dialog);
        acceptanceBox.setObjectName("acceptanceBox");
        acceptanceBox.setGeometry(new QRect(300, 200, 170, 30));
        acceptanceBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        acceptanceBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));
        creditInformationLabel = new QLabel(Dialog);
        creditInformationLabel.setObjectName("creditInformationLabel");
        creditInformationLabel.setGeometry(new QRect(40, 20, 400, 30));
        QFont font1 = new QFont();
        font1.setFamily("Arial");
        font1.setPointSize(18);
        creditInformationLabel.setFont(font1);
        creditInformationLabel.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        cardNumberLabel = new QLabel(Dialog);
        cardNumberLabel.setObjectName("cardNumberLabel");
        cardNumberLabel.setGeometry(new QRect(40, 110, 130, 30));
        nameLabel = new QLabel(Dialog);
        nameLabel.setObjectName("nameLabel");
        nameLabel.setGeometry(new QRect(40, 70, 130, 30));        
        expLabel = new QLabel(Dialog);
        expLabel.setObjectName("expLabel");
        expLabel.setGeometry(new QRect(40, 150, 130, 30));
        cardNumberInput = new QLineEdit(Dialog);
        cardNumberInput.setObjectName("cardNumberInput");
        cardNumberInput.setGeometry(new QRect(180, 110, 275, 30));
        cardNumberInput.setMaxLength(16);
        nameInput = new QLineEdit(Dialog);
        nameInput.setObjectName("nameInput");
        nameInput.setGeometry(new QRect(180, 70, 275, 30));        
        monthInput = new QLineEdit(Dialog);
        monthInput.setObjectName("monthInput");
        monthInput.setGeometry(new QRect(250, 150, 50, 30));
        monthInput.setMaxLength(2);
        yearInput = new QLineEdit(Dialog);
        yearInput.setObjectName("yearInput");
        yearInput.setGeometry(new QRect(390, 150, 50, 30));
        yearInput.setMaxLength(2);
        monthLabel = new QLabel(Dialog);
        monthLabel.setObjectName("monthLabel");
        monthLabel.setGeometry(new QRect(180, 150, 60, 30));
        yearLabel = new QLabel(Dialog);
        yearLabel.setObjectName("yearLabel");
        yearLabel.setGeometry(new QRect(330, 150, 50, 30));
        amountInput = new QLineEdit(Dialog);
        amountInput.setObjectName("amountInput");
        amountInput.setGeometry(new QRect(180, 190, 75, 30));
        amountLabel = new QLabel(Dialog);
        amountLabel.setObjectName("amountLabel");
        amountLabel.setGeometry(new QRect(40, 190, 130, 30));                       
        
        QDialog.setTabOrder(cardNumberInput, monthInput);
        QDialog.setTabOrder(monthInput, yearInput);
        QDialog.setTabOrder(yearInput, amountInput);
        QDialog.setTabOrder(amountInput, acceptanceBox);
        QDialog.setTabOrder(acceptanceBox, nameInput);
        QDialog.setTabOrder(nameInput, cardNumberInput);
        retranslateUi(Dialog);
        acceptanceBox.accepted.connect(Dialog, "accept()");
        acceptanceBox.rejected.connect(Dialog, "reject()");

        Dialog.connectSlotsByName();
    } // setupUi

    private void retranslateUi(QDialog Dialog)
    {
        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Dialog", null));
        creditInformationLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Enter Credit Card Information:", null));
        cardNumberLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Card Number:", null));
        nameLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Full Name:", null));
        expLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Exp:", null));
        monthLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Month", null));
        yearLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Year", null));
        amountLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Amount:", null));
    } // retranslateUi
    public String getAmount(){
        return this.amountInput.text();
    }
    public String getCardNumber(){
        return this.cardNumberInput.text();
    }
    public String getName(){
        return this.nameInput.text();
    }    
    public String getMonth(){
        return this.monthInput.text();
    }
    public String getYear(){
        return this.yearInput.text();
    }
}

