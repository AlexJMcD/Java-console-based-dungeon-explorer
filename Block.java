import gameIF.NPC;
import gameIF.Player;
import gameIF.Response;
import java.util.Random;

import java.util.ArrayList;

public class Block extends EntityImp implements NPC {
  private ArrayList<String> blockReq = new ArrayList<String>();
  private String[] possInscriptions;
  private String[] blockInscriptions;

  public Block() {
    super('#');
    blockReq.add("read [up|down|left|right]");
    blockReq.add("kick block");
    possInscriptions = new String[] { "Vivamus, Moriendum Est", "Flectere si nequeo superos, Acheronta movebo",
        "Condemnant quo non intellegunt", "Audentes fortuna iuvat", "Non fortuna homines aestimabo, sed moribus",
       "Pars magna bonitatis est velle fieri bonum", "Homo sum humani a me nihil alienum puto", "Animus risu novatur",
      "Amicus certus in re incerta cernitur", "Caeca invidia est", "Crudelius est quam mori semper timere mortem",
        "Mea mihi conscientia pluris est quam omnium sermo", "Nimium ne crede colori", "Timendi causa est nescire",
        "Copia ciborum, subtilitas impeditur", "Veritas numquam perit", "Nemo malus felix",
        "Ignis aurum proat, miseria fortes viros", "Labor omnia vincit", "Qui totum vult totum perdit",
        "Quam bene vivas refert, non quam diu", "Noli foras ire, in teipsum reddi; in interiore homine habitat veritas",
        "Si vis amari, ama", "Nemo mortalium omnibus horis sapit", "Omne quod movetur ab alio movetur",
       "Multi famam, conscientiam, pauci verentur", "Leve fit, quod bene fertur, onus",
        "Fata volentem ducunt, nolentem trahunt", "Imperare sibi maximum imperium est",
       "Perfer et obdura, dolor hic tibi proderit olim",
        "Multo autem ad rem magis pertinet quallis tibi vide aris quam allis", "Vitiis nemo sine nascitur",
        "Ad astra per aspera." };
    blockInscriptions = new String[4];
    for (int i = 0; i < blockInscriptions.length; i++) {
      int rand = new Random().nextInt(possInscriptions.length);
      blockInscriptions[i] = possInscriptions[rand];
    }

  }

  @Override
  public String getDescription() {
    return "A cuboid block that stands vertically. There appear to be inscriptions carved upon its surface, although they appear worn and ancient. What interesting secrets could this block hold?";
  }


  @Override
  public ArrayList<String> getPossibleRequests() {
    return blockReq;
  }



  @Override
  public Response performRequest(String request, Player player) {
    String[] reqStr = request.split("\\W+");
    if (reqStr[0].equals("read")) {
      if (reqStr[1].equals("up")) {
        Response response = new ResponseImp(true, "The inscription reads: " + blockInscriptions[0]);
        return response;
      } else if (reqStr[1].equals("down")) {
        Response response = new ResponseImp(true, "The inscription reads: " + blockInscriptions[1]);
        return response;
      } else if (reqStr[1].equals("left")) {
        Response response = new ResponseImp(true, "The inscription reads: " + blockInscriptions[2]);
        return response;
      } else if (reqStr[1].equals("right")) {
        Response response = new ResponseImp(true, "The inscription reads: " + blockInscriptions[3]);
        return response;
      }else {
      Response response = new ResponseImp(false, "You have entered an invalid request.");
      return response;
      } 
    }else if(reqStr[0].equals("kick")){
        Response response = new ResponseImp(true, "You successfully kick the block. Your foot hurts and you feel that those who built this place would not approve of your actions.");
        return response;
    }else {
      Response response = new ResponseImp(false, "You have entered an invalid request. The block remains motionless, but for a second you sense a slight feeling of confusion eminating from it.");
      return response;
    }
  }
}
