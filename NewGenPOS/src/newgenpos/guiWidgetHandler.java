///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package newgenpos;
//
//import com.trolltech.qt.gui.QDialog;
//import java.util.List;
//import java.util.Observer;
//
///**
// *
// * @author Mike
// */
//public class guiWidgetHandler implements Observable{
//    private List<Observer> observersList;    
//    private boolean success = false;
//    
//    private QDialog dialog;    
//    
//    private Ui_CashDialog UICashdialog;
//    private Ui_CreditDialog UICreditdialog;
//    private Ui_CheckDialog UICheckdialog;
//    
//    public void cashButtonClicked(){
//        dialog = new QDialog();
//        UICashdialog = new Ui_CashDialog();
//        UICashdialog.setupUi(dialog);
//        dialog.setWindowTitle("Enter Cash Amount:");
//        dialog.show();
//        
//        
//        
//        if (dialog.exec() == QDialog.DialogCode.Accepted.value()) {
//            String input = UICashdialog.getInput();
////            widgetManager.notifyObservers();
////            success = register.checkAmount(input);
//        }
//        else {
//            Ui_NewGenPOS.setText("Payment Canceled!");            
//        }   
//                
//        if(success){
//            register.makeCashPayment();
//            successfulTransaction();
//        }        
//
//    }
//    
//    @Override
//    public void notifyObservers() {
//        for(int i=0; i<observersList.size(); i++) {
//            observersList.get(i).update(this.success, i);
//        }                            
//    }
//
//    @Override
//    public void registerObserver(Observer obs) {
//        observersList.add(obs);
//    }
//
//    @Override
//    public void unRegisterObservers(Observer obs) {
//        observersList.remove(obs);
//    }
//    
//}
