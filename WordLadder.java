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
  public boolean findOverlap(ArrayList<Node> list1, ArrayList<Node> list2) { //Looping through arraylists to find overlaps which means the ladder would be complete
    ArrayList<Node> output = new ArrayList<Node>();
    if (list1.size() > list2.size()) {
      for (int idx = 0; idx < list1.size(); idx++) {
        for (int x = 0; x < list2.size(); idx++) {
          if (list1.get(idx).equals(list2.get(x))) {
            return true;
          }
        }
      }
    }
    if (list2.size() > list1.size()) {
      for (int idx = 0; idx < list2.size(); idx++) {
        for (int x = 0; x < list1.size(); idx++) {
          if (list2.get(idx).equals(list1.get(x))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  public static void main(String[]args){
    WordLadder test = new WordLadder();
    System.out.println(test.oneOff("apple").toString());
    System.out.println(test.oneOff("hello").toString());
    System.out.println(test.oneOff("xylophone").toString());
    System.out.println(test.oneOff("bad"));
  }
}
