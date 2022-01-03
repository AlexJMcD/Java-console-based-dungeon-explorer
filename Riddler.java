import gameIF.NPC;
import gameIF.Player;
import gameIF.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Riddler extends EntityImp implements NPC {
  private ArrayList<String> riddReq = new ArrayList<String>();
  private HashMap<String, String> possRiddles;
  private HashMap<String, String> ownedRiddles;
  private boolean solved1;
  private boolean solved2;
  private boolean solved3;
  private boolean revealed1;
  private boolean revealed2;
  private boolean revealed3;

  public Riddler() {
    super('Σ');
    riddReq.add("tell 1st riddle");
    riddReq.add("tell 2nd riddle");
    riddReq.add("tell 3rd riddle");
    riddReq.add("reveal 1st riddle");
    riddReq.add("reveal 2nd riddle");
    riddReq.add("reveal 3rd riddle");
    possRiddles = new HashMap<String, String>() {
      {
        put("I have many holes but am strong as steel. What am I?", "chain");
        put("What has 13 hearts, but no other organs?", "deck of cards");
        put("What can run but never walks, has a mouth but never talks, has a head but never weeps, has a bed but never sleeps?",
            "river");
        put("I am always hungry and will die if not fed, but whatever I touch will soon turn red. What am I?", "fire");
        put("If you drop me I’m sure to crack, but give me a smile and I’ll always smile back. What am I?", "mirror");
        put("What has many keys, but can't even open a single door?", "piano");
        put("The person who makes it has no need of it; the person who buys it has no use for it. The person who uses it can neither see nor feel it. What is it?",
            "coffin");
        put("What has roots that nobody sees? Is taller than trees. Up up up it goes, yet never grows.", "mountain");
        put(" What belongs to you, but other people use it more than you?", "name");
        put("I turn once, what is out will not get in. I turn again, what is in will not get out. What am I?", "key");
      }
    };
    ownedRiddles = new HashMap<String, String>();
    for (int i = 0; i < 3; i++) {
      int rand = new Random().nextInt(10);
      Object randKey = possRiddles.keySet().toArray()[rand];
      String riddKey = randKey.toString();
      String riddValue = possRiddles.get(riddKey);
      ownedRiddles.put(riddKey, riddValue);
    }
    solved1 = false;
    solved2 = false;
    solved3 = false;
    revealed1 = false;
    revealed2 = false;
    revealed3 = false;
  }

  @Override
  public String getDescription() {
    return "I am a simple man who likes to test the minds of those I meet. You may call me the Riddler. If you correctly solve my puzzles, I shall reward you with gold. If you find that my riddles leave you vexed, you may ask for the answer, however, you will lose the chance to attain my riches.";
  }

  @Override
  public ArrayList<String> getPossibleRequests() {
    return riddReq;
  }

  public Response performRequest(String request, Player player) {
    String[] reqStr = request.split("\\W+");
    if (reqStr[0].equals("tell")) {
      if (reqStr[1].equals("1st") && solved1 != true && revealed1 != true) {
        Object key = ownedRiddles.keySet().toArray()[0];
        String keyNum = key.toString();
        System.out.println(keyNum);
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your answer adventurer?");
        String answer = scan.nextLine();
        if (answer.equals(ownedRiddles.get(key))) {
          setItemQuantity("coins", getItemQuantity("coins") - 10);
          player.setItemQuantity("coins", player.getItemQuantity("coins") + 10);
          solved1 = true;
          Response response = new ResponseImp(true,
              "Congratulations adventurer, that is correct. As promised I shall share some of my treasure with you. I shall give you the princely sum of ten coins.");
              return response;
        } else {
          Response response = new ResponseImp(false,
              "Unfortunately adventurer that is not the correct answer. Feel free to try again should your brain have a sudden flash of realisation.");
              return response;
        }

      } else if (reqStr[1].equals("2nd") && solved2 != true && revealed2 != true) {
        Object key = ownedRiddles.keySet().toArray()[1];
        String keyNum = key.toString();
        System.out.println(keyNum);
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your answer adventurer?");
        String answer = scan.nextLine();
        if (answer.equals(ownedRiddles.get(key))) {
          setItemQuantity("coins", getItemQuantity("coins") - 10);
          player.setItemQuantity("coins", player.getItemQuantity("coins") + 10);
          solved2 = true;
          Response response = new ResponseImp(true,
              "Congratulations adventurer, that is correct. As promised I shall share some of my treasure with you. I shall give you the princely sum of ten coins.");
              return response;
        } else {
          Response response = new ResponseImp(false,
              "Unfortunately adventurer that is not the correct answer. Feel free to try again should your brain have a sudden flash of realisation.");
              return response;
        }

      } else if (reqStr[1].equals("3rd") && solved3 != true && revealed3 != true) {
        Object key = ownedRiddles.keySet().toArray()[2];
        String keyNum = key.toString();
        System.out.println(keyNum);
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your answer adventurer?");
        String answer = scan.nextLine();
        if (answer.equals(ownedRiddles.get(key))) {
          setItemQuantity("coins", getItemQuantity("coins") - 10);
          player.setItemQuantity("coins", player.getItemQuantity("coins") + 10);
          solved3 = true;
          Response response = new ResponseImp(true,
              "Congratulations adventurer, that is correct. As promised I shall share some of my treasure with you. I shall give you the princely sum of ten coins.");
              return response;
        } else {
          Response response = new ResponseImp(false,
              "Unfortunately adventurer that is not the correct answer. Feel free to try again should your brain have a sudden flash of realisation.");
              return response;
        }

      } else if (solved1 == true && solved2 == true && solved3 == true) {
        Response response = new ResponseImp(false,
            "You have solved all my riddles adventurer. My congratulations to you, and good luck on your quest.");
        return response;
      } else if (solved1 == false || solved2 == false || solved3 == false || revealed1 == true || revealed2 == true || revealed3 == true) {
        Response response = new ResponseImp(false,
            "You have already solved this riddle adventurer, or I have already revealed the answer to you. Perhaps you should test your skill with another.");
        return response;
      } else {
        Response response = new ResponseImp(false,
            "You have entered an invalid request. This perplexes the riddler, as he is not used to being the confused one.");
        return response;
      }

    } else if (reqStr[0].equals("reveal")) {
      if (reqStr[1].equals("1st") && solved1 != true) {
        Object key = ownedRiddles.keySet().toArray()[0];
        String keyNum = key.toString();
        revealed1 = true;
        Response response = new ResponseImp(true,
            "Has this conundrum proved too great a challange for you adventurer? Very well, I shall reveal the answer. The answer to this puzzeling probelm is: "
                + ownedRiddles.get(keyNum));
        return response;

      } else if (reqStr[1].equals("2nd") && solved2 != true) {
        Object key = ownedRiddles.keySet().toArray()[1];
        String keyNum = key.toString();
        revealed2 = true;
        Response response = new ResponseImp(true,
            "Has this conundrum proved too great a challange for you adventurer? Very well, I shall reveal the answer. The answer to this puzzeling probelm is: "
                + ownedRiddles.get(keyNum));
        return response;

      } else if (reqStr[1].equals("3rd") && solved3 != true) {
        Object key = ownedRiddles.keySet().toArray()[1];
        String keyNum = key.toString();
        revealed3 = true;
        Response response = new ResponseImp(true,
            "Has this conundrum proved too great a challange for you adventurer? Very well, I shall reveal the answer. The answer to this puzzeling probelm is: "
                + ownedRiddles.get(keyNum));
        return response;
      } else {
      Response response = new ResponseImp(false,
          "You have entered an invalid request. This perplexes the riddler, as he is not used to being the confused one.");
      return response;

    } 
    }else {
      Response response = new ResponseImp(false,
          "You have entered an invalid request. This perplexes the riddler, as he is not used to being the confused one.");
      return response;
    }

  }

}