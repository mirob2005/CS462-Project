package newgenpos;

class ItemID {
    private int itemID;
    
    public ItemID(int ItemID){
        if(ItemID >= 100000 && ItemID <= 999999){
            this.itemID = ItemID;
        }
        else{
            this.itemID = 0;
        }        
    }
    public boolean valid(){
        if(itemID != 0){
            return true;
        }
        else{
            return false;
        }
    }
    public int getINT()
    {
        return this.itemID;
    }   
}
