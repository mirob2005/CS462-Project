package newgenpos;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
    public static Connection con = null;
    
    public static void main(String args[]) throws SQLException
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/NewGenPOS", "root", "cs462");

        } catch (Exception e) {
            System.out.println("Database Not Connected, Product IDs will not be found!");
        } 
        
        QApplication.initialize(args);

        QMainWindow mainWindow = new QMainWindow();
        Ui_NewGenPOS mainUIWindow = new Ui_NewGenPOS();
        mainUIWindow.setupUi(mainWindow);
        mainWindow.setWindowTitle("NewGenPOS");
        mainWindow.show(); 

        QApplication.exec();
    }
}
