/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newgenpos;

/**
 *
 * @author Mike
 */
class ProductDescription {
    private String description;
    private Money price;
    private ItemID itemID;
    
    public ProductDescription(ItemID itemID){
        this.itemID = itemID;
        //Look up price & description
    }
    
    
}
