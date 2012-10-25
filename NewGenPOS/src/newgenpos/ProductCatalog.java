/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newgenpos;

/**
 *
 * @author Mike
 */
public class ProductCatalog {
    private String description;
    private ItemID itemID;
    private Money price;
        
    public ProductCatalog(){
        //...
    }
    
    public String getProductDescription(ItemID ItemID){
        //...
        return description;
    }
}
