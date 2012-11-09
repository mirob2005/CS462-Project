package newgenpos;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;
import java.sql.SQLException;



public class Main { 
    private static int storeID = 1;
    private static String storeAddress = "CSUF";
    private static String storeName = "NewGen";
    
    
    public static void main(String args[]) throws SQLException{       
        QApplication.initialize(args);
  
        try{
            Store myStore = new Store(storeID, storeAddress, storeName);
        }
        catch(Exception e){
            System.out.println("Database Not Connected, Product IDs will not be found!");
        }

        QMainWindow mainWindow = new QMainWindow();
        Ui_NewGenPOS mainUIWindow = new Ui_NewGenPOS();
        mainUIWindow.setupUi(mainWindow);
        mainWindow.setWindowTitle("NewGenPOS");
        mainWindow.show(); 

        QApplication.exec();
    }
}
