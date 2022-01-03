import gameIF.NPC;
import gameIF.Player;
import gameIF.Response;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class Gambler extends EntityImp implements NPC {
  private ArrayList<String> gambReq = new ArrayList<String>();
  private String[] rockPapSci;

  public Gambler() {
    super('Φ');
    gambReq.add("play game");
    rockPapSci = new String[] { "rock", "paper", "scissors" };
  }

  @Override
  public String getDescription() {
    return "I find my joy in the simple things. I like to play games of chance. If you defeat me in a game of rock paper scissors I will give you 5 coins. However, if I defeat you then I shall take 3 coins from you.";
  }

  @Override
  public ArrayList<String> getPossibleRequests() {
    return gambReq;
  }

  public Response performRequest(String request, Player player) {
    String[] reqStr = request.split("\\W+");
    if (reqStr[0].equals("play") && reqStr[1].equals("game")) {
      if (this.getItemQuantity("coins") >= 5 && this.getItemQuantity("rock") > 0 && this.getItemQuantity("paper") > 0
          && this.getItemQuantity("scissors") > 0 && player.getItemQuantity("coins") >= 3
          && player.getItemQuantity("rock") > 0 && player.getItemQuantity("paper") > 0
          && player.getItemQuantity("scissors") > 0) {
        int rand = new Random().nextInt(rockPapSci.length);
        Scanner scan = new Scanner(System.in);
        String gambChoice = rockPapSci[rand];
        System.out.println(
            "So you would like to play a game of chance then. Very well, we shall play rock paper scissors. But in this world, we play with physical items. So in order to play you must have a rock, some paper, and a pair of scissors. If you find yourself short of one of these items, I believe there is a merchant somewhere who can sell them to you.");
        System.out.print("What shall you choose adventruer: rock, paper, or scissors:");
        String playerChoice = scan.nextLine();
        List<String> list = Arrays.asList(rockPapSci);
        boolean contains = list.contains(playerChoice);
        if(contains == false){
          Response response = new ResponseImp(false, "It appears you have entered an invalid choice adventurer. No need to worry, you shall not lose any coins and may play again.");
          return response;
        }else if (playerChoice.equals(gambChoice)) {
          player.setItemQuantity(playerChoice, player.getItemQuantity(playerChoice) - 1);
          this.setItemQuantity(gambChoice, this.getItemQuantity(gambChoice) - 1);
          Response response = new ResponseImp(true,
              "It appears we both picked " + playerChoice + ". It seems neither of us shall lose any coins this time.");
          return response;
        } else if (playerChoice.equals("rock") && gambChoice.equals("paper")) {
          player.setItemQuantity(playerChoice, player.getItemQuantity(playerChoice) - 1);
          this.setItemQuantity(gambChoice, this.getItemQuantity(gambChoice) - 1);
          player.setItemQuantity("coins", player.getItemQuantity("coins") - 3);
          this.setItemQuantity("coins", this.getItemQuantity("coins") + 3);
          Response response = new ResponseImp(true,
              "Unlucky adventurer my choice was " + gambChoice + ". This game goes to me, as do 3 of your coins.");
          return response;
        } else if (playerChoice.equals("paper") && gambChoice.equals("scissors")) {
          player.setItemQuantity(playerChoice, player.getItemQuantity(playerChoice) - 1);
          this.setItemQuantity(gambChoice, this.getItemQuantity(gambChoice) - 1);
          player.setItemQuantity("coins", player.getItemQuantity("coins") - 3);
          this.setItemQuantity("coins", this.getItemQuantity("coins") + 3);
          Response response = new ResponseImp(true,
              "Unlucky adventurer my choice was " + gambChoice + ". This game goes to me, as do 3 of your coins.");
          return response;
        } else if (playerChoice.equals("scissors") && gambChoice.equals("rock")) {
          player.setItemQuantity(playerChoice, player.getItemQuantity(playerChoice) - 1);
          this.setItemQuantity(gambChoice, this.getItemQuantity(gambChoice) - 1);
          player.setItemQuantity("coins", player.getItemQuantity("coins") - 3);
          this.setItemQuantity("coins", this.getItemQuantity("coins") + 3);
          Response response = new ResponseImp(true,
              "Unlucky adventurer my choice was " + gambChoice + ". This game goes to me, as do 3 of your coins.");
          return response;
        } else {
          player.setItemQuantity(playerChoice, player.getItemQuantity(playerChoice) - 1);
          this.setItemQuantity(gambChoice, this.getItemQuantity(gambChoice) - 1);
          player.setItemQuantity("coins", player.getItemQuantity("coins") + 5);
          this.setItemQuantity("coins", this.getItemQuantity("coins") - 5);
          Response response = new ResponseImp(true, "Congratulations adventurer. This time my choice was " + gambChoice
              + ". Here are 5 of my coins. Would you like to try your luck again?");
          return response;
        }
      }else if (this.getItemQuantity("coins") < 5){
        Response response = new ResponseImp (true, "My apologies adventurer. I no longer have enough coins to make this wager. Best of luck on your adventures, I should to go home and rethink my life choices.");
        return response;
      }else if (player.getItemQuantity("coins") < 3){
        Response response = new ResponseImp(true, "You don't seem to have enough coins to play such a high stakes game adventurer. Come back if you find more coins and want to try your luck again.");
        return response;
      } else if (this.getItemQuantity("rock") == 0 || this.getItemQuantity("paper") == 0 || this.getItemQuantity("scissors") == 0){
        Response response = new ResponseImp(true, "I wish I could play another game adventurer, but I don't seem to have the necessary items. Best of luck on your quest.");
        return response;
      }else{
        Response response = new ResponseImp(true, "I see you are eager adventurer, but you do not have the items needed to play this game. If you were to find them, I would be happy to play again.");
        return response;
      }
    }else{
      Response response = new ResponseImp(false, "You have entered an invalid request, the gambler rather unperturbed continues to ecourage you to play a game.");
      return response;
    }

  }
}