import gameIF.*;

import java.util.ArrayList;

public class GameImp implements Game {
  private int width;
  private int height;
  private int playerX;
  private int playerY;
  private int orientation;
  private Player player;
  private Entity[][] gameBoard;

  public GameImp(int width, int height, int playerX, int playerY, int orientation) {
    this.width = width;
    this.height = height;
    this.playerX = playerX;
    this.playerY = playerY;
    this.orientation = orientation;
    this.gameBoard = new Entity[height][width];
    this.player = new PlayerImp(orientation);
    gameBoard[playerY][playerX] = player;

  }

  @Override
  public Response requestFacing(String request) {
    Response response = getFacingNPC().performRequest(request, player);

    return response;
  }

  @Override
  public Entity getEntityAt(int column, int row) {
    Entity entity;
    entity = (gameBoard[row][column]);
    return entity;
  }

  @Override
  public boolean addEntity(Entity entity, int column, int row) {

    if (column > (width - 1) || column < 0 || row > (height - 1) || row < 0) {
      return false;
    } else if (gameBoard[row][column] == null) {
      gameBoard[row][column] = entity;
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Response step() {
    Response pathBlocked = new ResponseImp(false,
        "Alas by some cruel twist of fate your path has been blocked. Do you have the strength to overcome this morale crushing development.");
    Response edge = new ResponseImp(false,
        "You have reached the edge of this world. Beyond here lies only the abyss of errors.");
    if (orientation == 0) {
      if (playerY != 0 && getEntityAt(playerX, playerY - 1) == null) {
        gameBoard[playerY - 1][playerX] = player;
        gameBoard[playerY][playerX] = null;
        playerY = playerY - 1;
        Response response = new ResponseImp(true,
            "You have successfully take a step upwards and into the unkown. Who knows what dangerous and exciting fate may lie before you.");

        return response;
      } else if (playerY == 0) {

        return edge;
      } else {

        return pathBlocked;
      }

    } else if (orientation == 1) {
      if (playerX < width - 1 && getEntityAt(playerX + 1, playerY) == null) {
        gameBoard[playerY][playerX + 1] = player;
        gameBoard[playerY][playerX] = null;
        playerX = playerX + 1;
        Response response = new ResponseImp(true,
            "You have successfully take a step to the right. Will this lead to fortune or despair?");

        return response;

      } else if (playerX == width - 1) {

        return edge;
      } else {

        return pathBlocked;
      }
    } else if (orientation == 2) {
      if (playerY < height - 1 && getEntityAt(playerX, playerY + 1) == null) {
        gameBoard[playerY + 1][playerX] = player;
        gameBoard[playerY][playerX] = null;
        playerY = playerY + 1;
        Response response = new ResponseImp(true,
            "You have successfully take a step downwards and into the unkown. There may yet be many dangers lurking in the depths.");

        return response;
      } else if (playerY == height - 1) {

        return edge;
      } else {

        return pathBlocked;
      }
    } else if (orientation == 3) {
      if (playerX != 0 && getEntityAt(playerX - 1, playerY) == null) {
        gameBoard[playerY][playerX - 1] = player;
        gameBoard[playerY][playerX] = null;
        playerX = playerX - 1;
        Response response = new ResponseImp(true,
            "You have successfully take a step to the left. May the Divines lead you on the correct path.");

        return response;
      } else if (playerX == 0) {

        return edge;
      } else {

        return pathBlocked;
      }
    } else {

      return pathBlocked;
    }

  }

  @Override
  public void turn(int orientation) {
    player.setOrientation(orientation);
    this.orientation = orientation;

  }

  @Override
  public int getPlayerX() {
    return playerX;
  }

  @Override
  public int getPlayerY() {
    return playerY;
  }

  @Override
  public Player getPlayer() {
    return player;
  }

  @Override
  public NPC getFacingNPC() {
    if (orientation == 0 && getEntityAt(playerX, playerY - 1) != null) {
      NPC npc = (NPC) getEntityAt(playerX, playerY - 1);
      return npc;
    } else if (orientation == 1 && getEntityAt(playerX + 1, playerY) != null) {
      NPC npc = (NPC) getEntityAt(playerX + 1, playerY);
      return npc;
    } else if (orientation == 2 && getEntityAt(playerX, playerY + 1) != null) {
      NPC npc = (NPC) getEntityAt(playerX, playerY + 1);
      return npc;
    } else if (orientation == 3 && getEntityAt(playerX - 1, playerY) != null) {
      NPC npc = (NPC) getEntityAt(playerX - 1, playerY);
      return npc;
    } else {
      return null;
    }
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }
}
