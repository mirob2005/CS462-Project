package newgenpos;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;
import java.sql.SQLException;

public class Main { 
    private static int storeID = 1;
    private static String storeAddress = "800 North State College Boulevard, Fullerton, CA 92831";
    private static String storeName = "CSUF NewGen Store";
    private static Store myStore;
    private static Register register;
    
    
    public static void main(String args[]) throws SQLException{       
        QApplication.initialize(args);
  
        try{
            myStore = new Store(storeID, storeAddress, storeName);
            register = myStore.getRegister();
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
    public static Register getRegister(){
        return register;
    }
}
