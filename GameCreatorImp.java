import gameIF.GameCreator;
import gameIF.*;

public class GameCreatorImp implements GameCreator {

  public GameCreatorImp() {

  }

  @Override
  public Game createGame() {
    Game game = new GameImp(10, 7, 3, 4, 2);
    Block block1 = new Block();
    Block block2 = new Block();
    game.addEntity(block1, 2, 1);
    game.addEntity(block2, 8, 5);
    Merchant merchant = new Merchant();
    merchant.setItemQuantity("coins", 30);
    merchant.setItemQuantity("paper", 10);
    merchant.setItemQuantity("rock", 10);
    merchant.setItemQuantity("scissors", 10);
    merchant.setItemQuantity("sword", 1);
    game.addEntity(merchant, 3, 3);
    Player player = game.getPlayer();
    player.setItemQuantity("coins", 10);
    player.setItemQuantity("rock", 5);
    player.setItemQuantity("paper", 5);
    player.setItemQuantity("scissors", 5);
    Riddler riddler1 = new Riddler();
    riddler1.setItemQuantity("coins", 30);
    game.addEntity(riddler1, 1, 6);
    Gambler gambler1 = new Gambler();
    gambler1.setItemQuantity("rock", 5);
    gambler1.setItemQuantity("paper", 5);
    gambler1.setItemQuantity("scissors", 5);
    gambler1.setItemQuantity("coins", 30);
    game.addEntity(gambler1, 5,1);
    Monster monster = new Monster();
    game.addEntity(monster, 9, 6);
    System.out.println("Welcome Adventurer, to my small world. This used to be a quiet and peaceful land, but recently the nights have been plagued by a demonic creature. The people of this land have cried out for aid, and you have answered. THe beast slumbers in the far south east of this land, and you must find a weapon capable of slaying him. There are rumours that the merchant in these lands possesses a mighty sword capable of felling the demon. However, he will not part with it cheaply. You must gather enough coins to meet his asking price. There are different ways this can be achieved. You may play games of chance with the gambler to win his coins, or you may test your brain with some word puzzles from the riddler. Along the way you may encounter some mysterious stones that bear inscriptions from a by gone age. You must gather 45 coins to purchase the sword and then you must slay the monster. I wish you the best of luck adventurer in freeing this land.");
    return game;
  }

}