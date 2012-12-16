/*
 * HW5.1 Observer Pattern
 */
package newgenpos;

import com.trolltech.qt.gui.QDialog;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class guiWidgetHandler{
    private QDialog dialog;    

    private Ui_CashDialog UICashdialog;
    private Ui_CreditDialog UICreditdialog;
    private Ui_CheckDialog UICheckdialog;
    
    private boolean success;
    private Register register;
    
    //Cash = 0, Credit = 1, Check = 2
    private int paymentMethod;
    
    public void on_cashButton_clicked(Register inRegister) {
        dialog = new QDialog();
        UICashdialog = new Ui_CashDialog();
        UICashdialog.setupUi(dialog);
        dialog.setWindowTitle("Enter Cash Amount:");
        dialog.show();
        
        this.register = inRegister;

        if (dialog.exec() == QDialog.DialogCode.Accepted.value()) {
            String input = UICashdialog.getInput();
            paymentMethod = 0;
            this.success = this.register.makeCashPayment(paymentMethod, input);
        }
        else {
            Ui_NewGenPOS.setText("Payment Canceled!");
            success = false;
        }
        if(success){
            successfulTransaction();
        }
    }
    public void on_creditButton_clicked(Register inRegister) {
        dialog = new QDialog();
        UICreditdialog = new Ui_CreditDialog();
        UICreditdialog.setupUi(dialog);
        dialog.setWindowTitle("Enter Credit Information:");
        dialog.show();
        
        this.register = inRegister;

        if (dialog.exec() == QDialog.DialogCode.Accepted.value()) {
            String inputAmount = UICreditdialog.getAmount();
            String inputCardNumber = UICreditdialog.getCardNumber();
            String inputYear = UICreditdialog.getYear();
            String inputMonth = UICreditdialog.getMonth();
            String inputName = UICreditdialog.getName();
            paymentMethod = 1;
            this.success = this.register.makeCreditPayment(paymentMethod, inputAmount, 
                    inputCardNumber,inputYear, inputMonth, inputName);
        }
        else {
            Ui_NewGenPOS.setText("Payment Canceled!");
            this.success = false;
        }
        if(success){
            successfulTransaction();
        }        
    }
    public void on_checkButton_clicked(Register inRegister) {
        dialog = new QDialog();
        UICheckdialog = new Ui_CheckDialog();
        UICheckdialog.setupUi(dialog);
        dialog.setWindowTitle("Enter Check Information:");
        dialog.show();
        
        this.register = inRegister;
        
        if (dialog.exec() == QDialog.DialogCode.Accepted.value()) {
            String inputAmount = UICheckdialog.getAmount();
            String inputName = UICheckdialog.getName();
            String inputAddr1 = UICheckdialog.getAddr1();
            String inputAddr2 = UICheckdialog.getAddr2();
            String inputCheckNumber = UICheckdialog.getCheckNumber();
            String inputLicense = UICheckdialog.getLicense();
            String inputPhone = UICheckdialog.getPhone();
            paymentMethod = 2;
            this.success = this.register.makeCheckPayment(paymentMethod, inputAmount, inputName,
                    inputAddr1, inputAddr2, inputCheckNumber, inputLicense,
                    inputPhone);
        }
        else {
            Ui_NewGenPOS.setText("Payment Canceled!");
            this.success = false;
        }                
        if(success) {
            successfulTransaction();
        }
    }    
    private void successfulTransaction(){
        this.register.createReceipt();               
        this.register.recordSale();
        this.register.endSale();
        this.register.makeNewSale();
    }
    public void on_discount_clicked(Register inRegister, boolean discount){
        this.register = inRegister;
        Sale currentSale = this.register.getCurrentSale();
        currentSale.setPricingStrategy(discount);
        currentSale.calcTotal();
    }
}