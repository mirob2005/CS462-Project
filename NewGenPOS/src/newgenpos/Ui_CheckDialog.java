/********************************************************************************
** Form generated from reading ui file 'checkDialog.jui'
**
** Created: Sat Nov 10 13:51:17 2012
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_Dialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDialogButtonBox acceptanceBox;
    public QLabel checkInformationLabel;
    public QLabel nameLabel;
    public QLabel addr1Label;
    public QPlainTextEdit nameInput;
    public QLabel addr2Label;
    public QLabel phoneLabel;
    public QLabel licenseLabel;
    public QLabel checkNumLabel;
    public QPlainTextEdit addr2Input;
    public QPlainTextEdit addr1Input;
    public QPlainTextEdit phoneInput;
    public QPlainTextEdit licenseInput;
    public QPlainTextEdit checkNumInput;
    public QPlainTextEdit amountInput;
    public QLabel amountLabel;

    public Ui_Dialog() { super(); }

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
        nameInput = new QPlainTextEdit(Dialog);
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
        addr2Input = new QPlainTextEdit(Dialog);
        addr2Input.setObjectName("addr2Input");
        addr2Input.setGeometry(new QRect(180, 150, 270, 30));
        addr1Input = new QPlainTextEdit(Dialog);
        addr1Input.setObjectName("addr1Input");
        addr1Input.setGeometry(new QRect(180, 110, 270, 30));
        phoneInput = new QPlainTextEdit(Dialog);
        phoneInput.setObjectName("phoneInput");
        phoneInput.setGeometry(new QRect(180, 190, 135, 30));
        licenseInput = new QPlainTextEdit(Dialog);
        licenseInput.setObjectName("licenseInput");
        licenseInput.setGeometry(new QRect(180, 230, 135, 30));
        checkNumInput = new QPlainTextEdit(Dialog);
        checkNumInput.setObjectName("checkNumInput");
        checkNumInput.setGeometry(new QRect(180, 270, 75, 30));
        amountInput = new QPlainTextEdit(Dialog);
        amountInput.setObjectName("amountInput");
        amountInput.setGeometry(new QRect(180, 310, 75, 30));
        amountLabel = new QLabel(Dialog);
        amountLabel.setObjectName("amountLabel");
        amountLabel.setGeometry(new QRect(40, 310, 130, 30));
        retranslateUi(Dialog);
        acceptanceBox.accepted.connect(Dialog, "accept()");
        acceptanceBox.rejected.connect(Dialog, "reject()");

        Dialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Dialog)
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

}

