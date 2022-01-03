import java.util.Scanner;
import gameIF.*;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Game game = setupGame();
    boolean finished = false;
    while (!finished) {
      System.out.print("Next request: ");
      String requestStr = scanner.nextLine();
      String rqStr = requestStr;
      requestStr = requestStr.trim();
      String[] requestSplit = requestStr.split("\\W+");
      if (requestSplit.length > 0) {
        String verb = requestSplit[0];
        if (verb.equals("show")) {
          if (requestSplit.length > 1) {
            String noun = requestSplit[1];
            if (noun.equals("map")) {
              printMap(game);
            } else if (noun.equals("player")) {
              ArrayList<String> items = game.getPlayer().getItemNames();
              for (int i = 0; i <= items.size() - 1; i++) {
                System.out.println(items.get(i) + ":" + game.getPlayer().getItemQuantity(items.get(i)));
              }
            } else if (noun.equals("facing")) {
              if (game.getFacingNPC() == null) {
                System.out.println("There is nothing in front of you adventurer. You speak into the darkness.");
              } else {
                System.out.println(game.getFacingNPC().getDescription());
                ArrayList<String> items = game.getFacingNPC().getItemNames();
                for (int i = 0; i <= items.size() - 1; i++) {
                  System.out.println(items.get(i) + ":" + game.getFacingNPC().getItemQuantity(items.get(i)));
                }
              }
            } else if (noun.equals("requests")) {
              System.out.println(
                  "Does your memory fail you adventurer? Let me remind you of the actions you may take.\nturn[up|down|left|right]\nshow[map|player|facing|requests]");
              if (game.getFacingNPC() != null) {
                ArrayList<String> requests = game.getFacingNPC().getPossibleRequests();
                for (int i = 0; i < requests.size(); i++) {
                  System.out.println(requests.get(i));
                }
              }
            }
          }
        } else if (verb.equals("turn")) {
          if (requestSplit.length > 1) {
            ResponseImp response = new ResponseImp(true,
                "Congratulations, you have successfully turned. Let's hope your new direction takes you on a safe path.");

            String noun = requestSplit[1];
            if (noun.equals("up")) {
              game.turn(0);
              System.out.println(response.getStatus());
              System.out.println(response.getMessage());
            } else if (noun.equals("right")) {
              game.turn(1);
              System.out.println(response.getStatus());
              System.out.println(response.getMessage());
            } else if (noun.equals("down")) {
              game.turn(2);
              System.out.println(response.getStatus());
              System.out.println(response.getMessage());
            } else if (noun.equals("left")) {
              game.turn(3);
              System.out.println(response.getStatus());
              System.out.println(response.getMessage());
            }
          }
        } else if (verb.equals("step")) {
          Response response = game.step();
          System.out.println(response.getStatus() + "\n" + response.getMessage());

        } else if (verb.equals("quit")) {
          finished = verb.equals("quit");
        } else if (verb.equals("slay")) {
          Response response = game.requestFacing(rqStr);
          if (response.getStatus() == true) {
            finished = true;
          }

        } else if (game.getFacingNPC() == null) {
          System.out.println("You have entered an invalid command adventurer.");
        } else {
          Response response = game.requestFacing(rqStr);
          System.out.println(response.getStatus() + "\n" + response.getMessage());
        }

      }
    }
  }

  public static void printMap(Game game) {
    for (int col = 0; col < game.getHeight(); col++) {
      for (int row = 0; row < game.getWidth(); row++) {
        if (game.getEntityAt(row, col) != null) {
          System.out.print((game.getEntityAt(row, col)).getCode());
        } else {
          System.out.print(".");
        }

      }
      System.out.println();
    }
    System.out.println("TODO: Complete implementation of printMap");
  }

  public static Game setupGame() {
    GameCreatorImp game = new GameCreatorImp();
    return game.createGame();
  }

}