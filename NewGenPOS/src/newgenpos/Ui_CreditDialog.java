package newgenpos;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_CreditDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDialogButtonBox acceptanceBox;
    public QLabel creditInformationLabel;
    public QLabel cardNumberLabel;
    public QLabel expLabel;
    public QLineEdit cardNumberInput;
    public QLineEdit monthInput;
    public QLineEdit yearInput;
    public QLabel monthLabel;
    public QLabel yearLabel;
    public QLineEdit amountInput;
    public QLabel amountLabel;

    public Ui_CreditDialog() { super(); }

    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(500, 200).expandedTo(Dialog.minimumSizeHint()));
        QFont font = new QFont();
        font.setFamily("Arial");
        font.setPointSize(12);
        Dialog.setFont(font);
        acceptanceBox = new QDialogButtonBox(Dialog);
        acceptanceBox.setObjectName("acceptanceBox");
        acceptanceBox.setGeometry(new QRect(300, 160, 170, 30));
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
        cardNumberLabel.setGeometry(new QRect(40, 70, 130, 30));
        expLabel = new QLabel(Dialog);
        expLabel.setObjectName("expLabel");
        expLabel.setGeometry(new QRect(40, 110, 130, 30));
        cardNumberInput = new QLineEdit(Dialog);
        cardNumberInput.setObjectName("cardNumberInput");
        cardNumberInput.setGeometry(new QRect(180, 70, 275, 30));
        cardNumberInput.setMaxLength(16);
        monthInput = new QLineEdit(Dialog);
        monthInput.setObjectName("monthInput");
        monthInput.setGeometry(new QRect(250, 110, 50, 30));
        monthInput.setMaxLength(2);
        yearInput = new QLineEdit(Dialog);
        yearInput.setObjectName("yearInput");
        yearInput.setGeometry(new QRect(390, 110, 50, 30));
        yearInput.setMaxLength(2);
        monthLabel = new QLabel(Dialog);
        monthLabel.setObjectName("monthLabel");
        monthLabel.setGeometry(new QRect(180, 110, 60, 30));
        yearLabel = new QLabel(Dialog);
        yearLabel.setObjectName("yearLabel");
        yearLabel.setGeometry(new QRect(330, 110, 50, 30));
        amountInput = new QLineEdit(Dialog);
        amountInput.setObjectName("amountInput");
        amountInput.setGeometry(new QRect(180, 150, 75, 30));
        amountLabel = new QLabel(Dialog);
        amountLabel.setObjectName("amountLabel");
        amountLabel.setGeometry(new QRect(40, 150, 130, 30));
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
        expLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Exp:", null));
        monthLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Month", null));
        yearLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Year", null));
        amountLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Amount:", null));
    } // retranslateUi
    public QLineEdit getAmount(){
        return this.amountInput;
    }
    public QLineEdit getCardNumber(){
        return this.cardNumberInput;
    }
    public QLineEdit getMonth(){
        return this.monthInput;
    }
    public QLineEdit getYear(){
        return this.yearInput;
    }
}

