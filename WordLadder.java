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
    for (int x = 0; x < val.length(); x++) { //Going through all the possibilities one position at a time
      for (int idx = 97; idx < 123; idx++) { //Switching it to every possible letter
        String begin = val.substring(0, x);
        String end = val.substring(x + 1, val.length());
        String val2;
        val2 = begin + (char)idx + end; //Creating new word with changed letter
        if (dic.isWord(val2) && !val2.equals(val)) {
          Node input = new Node(val2);
          output.add(input); //Adding it to our ArrayList of words that are one away if it is a valid word
        }
      }
    }
    return output;
  }
  public static void main(String[]args){
    WordLadder test = new WordLadder();
    System.out.println(test.oneOff("apple").toString());
    System.out.println(test.oneOff("hello").toString());
    System.out.println(test.oneOff("xylophone").toString());
    System.out.println(test.oneOff("bad"));
  }
}
