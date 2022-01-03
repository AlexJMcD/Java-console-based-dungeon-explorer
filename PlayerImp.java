import gameIF.Player;
import java.util.HashMap;
public class PlayerImp extends EntityImp implements Player {
    private int orientation;
    private HashMap<Integer, Character> orientMap = new HashMap<>();
    public PlayerImp(int orientation) {
      super('*');
      orientMap.put(0, '↑');
      orientMap.put(1, '→');
      orientMap.put(2, '↓');
      orientMap.put(3, '←');
      this.orientation = orientation;
      
    }

    @Override
    public int getOrientation() {
      return orientation;
    }

    @Override
    public void setOrientation(int newOrientation) {
      //Put a correct implementation here
      orientation = newOrientation;
    }

    @Override
    public char getCode() {
      return orientMap.get(orientation);
    }
}
