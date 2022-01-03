import gameIF.Entity;
import java.util.HashMap;

import java.util.ArrayList;

public class EntityImp implements Entity {
  private char code;
  private HashMap<String, Integer> items = new HashMap<>();
  
    public EntityImp(char code) {
      this.code = code;
    }

    @Override
    public char getCode() {
      return code;
    }

    @Override
    public ArrayList<String> getItemNames(){
      ArrayList<String> itemNames = new ArrayList<String>();
        for (String strKey : items.keySet()){
          itemNames.add(strKey);
        }
        return itemNames;
    }
      

    @Override
    public int getItemQuantity(String name) {
      return items.get(name);
    }

    @Override
    public void setItemQuantity(String name, int quantity) {
      if (items.containsKey(name) == false){
        items.put(name, quantity);
      }else {
        items.replace(name, quantity);
      }
    }
}
