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
    private ItemID itemID;
    private Money price;
    private ProductDescription description;
        
    public ProductCatalog(){
        //...
    }
    
    public ProductDescription getProductDescription(ItemID ItemID){
        description = new ProductDescription(ItemID);
        return description;
    }
}
