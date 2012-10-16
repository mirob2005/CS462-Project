/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newgenpos;

import com.trolltech.qt.gui.QMainWindow;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mike
 */
public class Ui_NewGenPOSTest {
    
    public Ui_NewGenPOSTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Ui_NewGenPOS.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Ui_NewGenPOS.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setupUi method, of class Ui_NewGenPOS.
     */
    @Test
    public void testSetupUi() {
        System.out.println("setupUi");
        QMainWindow NewGenPOS = null;
        Ui_NewGenPOS instance = new Ui_NewGenPOS();
        instance.setupUi(NewGenPOS);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retranslateUi method, of class Ui_NewGenPOS.
     */
    @Test
    public void testRetranslateUi() {
        System.out.println("retranslateUi");
        QMainWindow NewGenPOS = null;
        Ui_NewGenPOS instance = new Ui_NewGenPOS();
        instance.retranslateUi(NewGenPOS);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of on_paidButton_clicked method, of class Ui_NewGenPOS.
     */
    @Test
    public void testOn_paidButton_clicked() {
        System.out.println("on_paidButton_clicked");
        Ui_NewGenPOS instance = new Ui_NewGenPOS();
        instance.on_paidButton_clicked();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearCart method, of class Ui_NewGenPOS.
     */
    @Test
    public void testClearCart() {
        System.out.println("clearCart");
        Ui_NewGenPOS instance = new Ui_NewGenPOS();
        instance.clearCart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of on_addItemButton_clicked method, of class Ui_NewGenPOS.
     */
    @Test
    public void testOn_addItemButton_clicked() {
        System.out.println("on_addItemButton_clicked");
        Ui_NewGenPOS instance = new Ui_NewGenPOS();
        instance.on_addItemButton_clicked();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearProductInput method, of class Ui_NewGenPOS.
     */
    @Test
    public void testClearProductInput() {
        System.out.println("clearProductInput");
        Ui_NewGenPOS instance = new Ui_NewGenPOS();
        instance.clearProductInput();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addItemToTable method, of class Ui_NewGenPOS.
     */
    @Test
    public void testAddItemToTable() {
        System.out.println("addItemToTable");
        String productID = "";
        int quantity = 0;
        Ui_NewGenPOS instance = new Ui_NewGenPOS();
        instance.addItemToTable(productID, quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayPrice method, of class Ui_NewGenPOS.
     */
    @Test
    public void testDisplayPrice() {
        System.out.println("displayPrice");
        Ui_NewGenPOS instance = new Ui_NewGenPOS();
        instance.displayPrice();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayDescription method, of class Ui_NewGenPOS.
     */
    @Test
    public void testDisplayDescription() {
        System.out.println("displayDescription");
        String productID = "";
        Ui_NewGenPOS instance = new Ui_NewGenPOS();
        instance.displayDescription(productID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
