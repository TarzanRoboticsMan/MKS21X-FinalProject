import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class WordLadder{
  private String start;
  private String end;
  public ArrayList<Node> starts;
  public ArrayList<Node> ends;
  private Dictionary dic = new Dictionary();

  public ArrayList<Node> oneOff(String val) {
    ArrayList<Node> output = new ArrayList<Node>();
    for (int x = 0; x < val.length(); x++) {
      for (int idx = 97; idx < 123; idx++) {
        String begin = val.substring(0, x);
        char mid = val.charAt(x) + idx;
        String end = val.substring(x + 1);
        val = begin + mid + end;
      }
    }
  }


  public static void main(String[]args){
    String filename = "wordList.txt";
    try{
      File f = new File(filename);
      Scanner dict = new Scanner(f);

      System.out.println(dict.findInLine("Shoes"));
      System.out.println(dict.findWithinHorizon("Shoes", 0));

    }catch(FileNotFoundException e){
      System.out.println("File not found: " + filename);
      //e.printStackTrace();
      System.exit(1);
    }
  }
}
