import gameIF.NPC;
import gameIF.Player;
import gameIF.Response;
import java.util.ArrayList;
import java.util.Random;

public class Monster extends EntityImp implements NPC {
  private ArrayList<String> monsRequests = new ArrayList<String>();

  public Monster() {
    super('Ω');
    monsRequests.add("slay monster");

  }

  @Override
  public String getDescription() {
    return "A dark shape looms out of the blackness. It is humanoid in shape, yet its features resmeble a sneering demon of dark mythology. Its eyes are black and of an indescribable depth. Long claws extend from its gangly arms, with an edge that could lacerate steel. As it peels back its lips, it exposes its long blade like fangs. It looks ready to devour a lost adventurer.";
  }

  @Override
  public ArrayList<String> getPossibleRequests() {
    return monsRequests;
  }

  public Response performRequest(String request, Player player) {
    String[] reqStr = request.split("\\W+");
    if (reqStr[0].equals("slay") && reqStr[1].equals("monster") && player.getItemNames().contains("sword")) {
      Response response = new ResponseImp(true,
          "You draw your blad and in obe fell swoop, you stike the monster down. Congratulations adventurer, you have rid this place of evil, and restored hope to the people of this realm. Thank you for playing this game, I hope it was enjoyable and did not result in any errors. I wish you a splendid day adventurer.\nA.");
      return response;
    } else if (reqStr[0].equals("slay") && reqStr[1].equals("monster")) {
      Response response = new ResponseImp(false,
          "You successfully approach the monster, but you have no blade with which to fight it. You quickly decide this is a foolhardy plan and retreat. However, you vow to return once you have aquired a weapon.");
      return response;

    } else {
      Response response = new ResponseImp(false,
          "You have entered an invalid request. Be careful, the monster may not wait for you to correctly type you intent.");
      return response;
    }
  }

}