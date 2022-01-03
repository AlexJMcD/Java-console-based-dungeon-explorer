import gameIF.NPC;
import gameIF.Player;
import gameIF.Response;
import java.util.Scanner;

import java.util.ArrayList;

public class Merchant extends EntityImp implements NPC {
  private ArrayList<String> merRequests = new ArrayList<String>();

  public Merchant() {
    super('£');
    merRequests.add("buy [rock|paper|scissors|sword]");
    merRequests.add("sell [rock|paper|scissors]");
  }

  @Override
  public String getDescription() {
    return "I am a humble merchant selling my wares. I possess items that will allow you to play games of chance, and I possess a weapon capable of slaying them demon that haunts this place.";
  }

  @Override
  public ArrayList<String> getPossibleRequests() {
    return merRequests;
  }

  @Override
  public Response performRequest(String request, Player player) {
    String[] reqStr = new String[2];
    reqStr = request.split("\\W+");
    Scanner scan = new Scanner(System.in);
    if (reqStr[0].equals("buy") && reqStr[1].equals("sword")) {
      if (this.getItemQuantity("sword") != 0 && player.getItemQuantity("coins") >= 45) {
        this.setItemQuantity("sword", 0);
        player.setItemQuantity("sword", 1);
        Response response = new ResponseImp(true,
            "Ah you intend to slay the demon, I wish you the best of luck adventurer. We all wish to be free of its ever present menace.");
        return response;
      } else if (this.getItemQuantity("sword") == 0) {
        Response response = new ResponseImp(true,
            "You have already purchased the weapon adventurer. Did you perhaps hit youself on the head with it?");
        return response;
      } else {
        Response response = new ResponseImp(true,
            "My apologies adventurer, you do not appear to have sufficient coins to purchase this sword. Perhaps come back later when you have accrued more wealth.");
        return response;
      }

    } else if (reqStr[0].equals("buy")) {
      if (reqStr[1].equals("rock") || reqStr.equals("paper") || reqStr.equals("scissors")) {
        if (reqStr[1].equals("scissors")) {
          System.out.print("How many " + reqStr[1] + " would you like to purchase? They cost 1 coin each:");
          int quantity = scan.nextInt();
          if (player.getItemQuantity("coins") >= quantity && this.getItemQuantity(reqStr[1]) >= quantity) {
            player.setItemQuantity("coins", player.getItemQuantity("coins") - quantity);
            player.setItemQuantity(reqStr[1], player.getItemQuantity(reqStr[1]) + quantity);
            this.setItemQuantity("coins", this.getItemQuantity("coins") + quantity);
            this.setItemQuantity(reqStr[1], this.getItemQuantity(reqStr[1]) - quantity);
            Response response = new ResponseImp(true,
                "You have a deal adventurer. I am happy to supply you these goods at this fair price.");
            return response;
          } else if (player.getItemQuantity("coins") < quantity) {
            Response response = new ResponseImp(false,
                "My apologies adventurer. It appears you do not have sufficient coins to make this trade.");
            return response;
          } else {
            Response response = new ResponseImp(false,
                "The merchant is not carrying sufficient items to make this trade. He looks embarressed at his lack of mercantile skill.");
            return response;
          }
        } else {
          System.out.print("How many " + reqStr[1] + "s would you like to purchase? They cost 1 coin each:");
          int quantity = scan.nextInt();
          if (player.getItemQuantity("coins") >= quantity && this.getItemQuantity(reqStr[1]) >= quantity) {
            player.setItemQuantity("coins", player.getItemQuantity("coins") - quantity);
            player.setItemQuantity(reqStr[1], player.getItemQuantity(reqStr[1]) + quantity);
            this.setItemQuantity("coins", this.getItemQuantity("coins") + quantity);
            this.setItemQuantity(reqStr[1], this.getItemQuantity(reqStr[1]) - quantity);
            Response response = new ResponseImp(true,
                "You have a deal adventurer. I am happy to supply you these goods at this fair price.");
            return response;
          } else if (player.getItemQuantity("coins") < quantity) {
            Response response = new ResponseImp(false,
                "My apologies adventurer. It appears you do not have sufficient coins to make this trade.");
            return response;
          } else {
            Response response = new ResponseImp(false,
                "The merchant is not carrying sufficient items to make this trade. He looks embarressed at his lack of mercantile skill.");
            return response;
          }
        }
      }else {
        Response response = new ResponseImp(false, "You have not entered the name of an item which the merchant carries. For a moment the merchant believes he is mistaken and subtley checks his wares.");
        return response;
      }
    } else if (reqStr[0].equals("sell")) {
      if (reqStr[1].equals("rock") || reqStr.equals("paper") || reqStr.equals("scissors")) {
        if (reqStr[1].equals("scissors")) {
          System.out.print("How many " + reqStr[1] + " would you like to sell? I shall pay 1 coin each for them:");
          int quantity = scan.nextInt();
          if (this.getItemQuantity("coins") >= quantity && player.getItemQuantity(reqStr[1]) >= quantity) {
            this.setItemQuantity("coins", this.getItemQuantity("coins") - quantity);
            this.setItemQuantity(reqStr[1], this.getItemQuantity(reqStr[1]) + quantity);
            player.setItemQuantity("coins", player.getItemQuantity("coins") + quantity);
            player.setItemQuantity(reqStr[1], player.getItemQuantity(reqStr[1]) - quantity);
            Response response = new ResponseImp(true,
                "You have a deal adventurer. I am happy to purchase these goods at this fair price.");
            return response;
          } else if (this.getItemQuantity("coins") < quantity) {
            Response response = new ResponseImp(false,
                "My apologies adventurer. It appears I do not have sufficient coins to make this trade.");
            return response;
          } else {
            Response response = new ResponseImp(false,
                "You are not carrying sufficient coins. The merchant is disappointed in your lack of mercantile grace.");
            return response;
          }
        } else {
          System.out.print("How many " + reqStr[1] + "s would you like to sell? They cost 1 coin each:");
          int quantity = scan.nextInt();
          if (this.getItemQuantity("coins") >= quantity && player.getItemQuantity(reqStr[1]) >= quantity) {
            this.setItemQuantity("coins", this.getItemQuantity("coins") - quantity);
            this.setItemQuantity(reqStr[1], this.getItemQuantity(reqStr[1]) + quantity);
            player.setItemQuantity("coins", player.getItemQuantity("coins") + quantity);
            player.setItemQuantity(reqStr[1], player.getItemQuantity(reqStr[1]) - quantity);
            Response response = new ResponseImp(true,
                "You have a deal adventurer. I am happy to purchase these goods at this fair price.");
            return response;
          } else if (this.getItemQuantity("coins") < quantity) {
            Response response = new ResponseImp(false,
                "My apologies adventurer. It appears I do not have sufficient coins to make this trade.");
            return response;
          } else {
            Response response = new ResponseImp(false,
                "You are not carrying sufficient coins. The merchant is disappointed in your lack of mercantile grace.");
            return response;
          }
        }
      }else {
        Response response = new ResponseImp(false, "You have not entered the name of an item which you possess. The merchant waits for you to reveal this item. You look very foolish.");
        return response;
      }
    } else {
      Response response = new ResponseImp(false,
          "The merchant is confused by your words and lack of mercantile grace.");
      return response;
    }

  }
}
