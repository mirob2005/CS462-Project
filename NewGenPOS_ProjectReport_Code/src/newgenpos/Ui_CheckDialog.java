
package newgenpos;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_CheckDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    private QDialogButtonBox acceptanceBox;
    private QLabel checkInformationLabel;
    private QLabel nameLabel;
    private QLabel addr1Label;
    private QLineEdit nameInput;
    private QLabel addr2Label;
    private QLabel phoneLabel;
    private QLabel licenseLabel;
    private QLabel checkNumLabel;
    private QLineEdit addr2Input;
    private QLineEdit addr1Input;
    private QLineEdit phoneInput;
    private QLineEdit licenseInput;
    private QLineEdit checkNumInput;
    private QLineEdit amountInput;
    private QLabel amountLabel;

    public Ui_CheckDialog() { super(); }

    @Override
    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(475, 355).expandedTo(Dialog.minimumSizeHint()));
        QFont font = new QFont();
        font.setFamily("Arial");
        font.setPointSize(12);
        Dialog.setFont(font);
        acceptanceBox = new QDialogButtonBox(Dialog);
        acceptanceBox.setObjectName("acceptanceBox");
        acceptanceBox.setGeometry(new QRect(270, 310, 170, 30));
        acceptanceBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        acceptanceBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));
        checkInformationLabel = new QLabel(Dialog);
        checkInformationLabel.setObjectName("checkInformationLabel");
        checkInformationLabel.setGeometry(new QRect(40, 20, 400, 30));
        QFont font1 = new QFont();
        font1.setFamily("Arial");
        font1.setPointSize(18);
        checkInformationLabel.setFont(font1);
        checkInformationLabel.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        nameLabel = new QLabel(Dialog);
        nameLabel.setObjectName("nameLabel");
        nameLabel.setGeometry(new QRect(40, 70, 130, 30));
        addr1Label = new QLabel(Dialog);
        addr1Label.setObjectName("addr1Label");
        addr1Label.setGeometry(new QRect(40, 110, 130, 30));
        nameInput = new QLineEdit(Dialog);
        nameInput.setObjectName("nameInput");
        nameInput.setGeometry(new QRect(180, 70, 270, 30));
        addr2Label = new QLabel(Dialog);
        addr2Label.setObjectName("addr2Label");
        addr2Label.setGeometry(new QRect(40, 150, 130, 30));
        phoneLabel = new QLabel(Dialog);
        phoneLabel.setObjectName("phoneLabel");
        phoneLabel.setGeometry(new QRect(40, 190, 130, 30));
        licenseLabel = new QLabel(Dialog);
        licenseLabel.setObjectName("licenseLabel");
        licenseLabel.setGeometry(new QRect(40, 230, 130, 30));
        checkNumLabel = new QLabel(Dialog);
        checkNumLabel.setObjectName("checkNumLabel");
        checkNumLabel.setGeometry(new QRect(40, 270, 130, 30));
        addr2Input = new QLineEdit(Dialog);
        addr2Input.setObjectName("addr2Input");
        addr2Input.setGeometry(new QRect(180, 150, 270, 30));
        addr1Input = new QLineEdit(Dialog);
        addr1Input.setObjectName("addr1Input");
        addr1Input.setGeometry(new QRect(180, 110, 270, 30));
        phoneInput = new QLineEdit(Dialog);
        phoneInput.setObjectName("phoneInput");
        phoneInput.setGeometry(new QRect(180, 190, 135, 30));
        phoneInput.setMaxLength(10);
        licenseInput = new QLineEdit(Dialog);
        licenseInput.setObjectName("licenseInput");
        licenseInput.setGeometry(new QRect(180, 230, 135, 30));
        licenseInput.setMaxLength(8);
        checkNumInput = new QLineEdit(Dialog);
        checkNumInput.setObjectName("checkNumInput");
        checkNumInput.setGeometry(new QRect(180, 270, 75, 30));
        checkNumInput.setMaxLength(6);
        amountInput = new QLineEdit(Dialog);
        amountInput.setObjectName("amountInput");
        amountInput.setGeometry(new QRect(180, 310, 75, 30));
        amountLabel = new QLabel(Dialog);
        amountLabel.setObjectName("amountLabel");
        amountLabel.setGeometry(new QRect(40, 310, 130, 30));
        
        QDialog.setTabOrder(nameInput, addr1Input);
        QDialog.setTabOrder(addr1Input,addr2Input);
        QDialog.setTabOrder(addr2Input,phoneInput);
        QDialog.setTabOrder(phoneInput,licenseInput);
        QDialog.setTabOrder(licenseInput,checkNumInput);
        QDialog.setTabOrder(checkNumInput,amountInput);
        QDialog.setTabOrder(amountInput, acceptanceBox);
        QDialog.setTabOrder(acceptanceBox, nameInput );
        retranslateUi(Dialog);
        acceptanceBox.accepted.connect(Dialog, "accept()");
        acceptanceBox.rejected.connect(Dialog, "reject()");

        Dialog.connectSlotsByName();
    } // setupUi

    private void retranslateUi(QDialog Dialog)
    {
        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Dialog", null));
        checkInformationLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Enter Check Information:", null));
        nameLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Name:", null));
        addr1Label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Address:", null));
        addr2Label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "City, State Zip:", null));
        phoneLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Phone #:", null));
        licenseLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Driver's Lic #:", null));
        checkNumLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Check #:", null));
        amountLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Amount:", null));
    } // retranslateUi
    public String getAddr1(){
        return this.addr1Input.text();
    }
    public String getAddr2(){
        return this.addr2Input.text();
    }
    public String getAmount(){
        return this.amountInput.text();
    }
    public String getCheckNumber(){
        return this.checkNumInput.text();
    }
    public String getLicense(){
        return this.licenseInput.text();
    }
    public String getName(){
        return this.nameInput.text();
    }
    public String getPhone(){
        return this.phoneInput.text();
    }    
}

