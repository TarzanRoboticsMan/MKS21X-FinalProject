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
    val = val.toLowerCase();
    Node og = new Node(val);
    ArrayList<Node> output = new ArrayList<Node>();
    for (int x = 0; x < val.length(); x++) { //Going through all the possibilities one position at a time
      for (int idx = 97; idx < 123; idx++) { //Switching it to every possible letter
        String begin = val.substring(0, x);
        String end = val.substring(x + 1, val.length());
        String val2;
        val2 = begin + (char)idx + end; //Creating new word with changed letter
        if (dic.isWord(val2) && !val2.equals(val)) {
          Node input = new Node(val2, og);
          output.add(input); //Adding it to our ArrayList of words that are one away if it is a valid word
        }
      }
    }
    return output;
  }
  public ArrayList<Node> findOverlap(ArrayList<Node> list1, ArrayList<Node> list2) { //Looping through arraylists to find overlaps which means the ladder would be complete
    ArrayList<Node> output = new ArrayList<Node>();
    if (list1.size() >= list2.size()) { //So that it doesn't matter if you compare the shorter or longer one first
      for (int idx = 0; idx < list1.size(); idx++) {
        for (int x = 0; x < list2.size(); x++) {
          if (list1.get(idx).getValue().equals(list2.get(x).getValue())) { //Compares the value of the nodes not the references
            output.add(list1.get(idx));
          }
        }
      }
    }
    if (list1.size() < list2.size()) {
      for (int idx = 0; idx < list2.size(); idx++) {
        for (int x = 0; x < list1.size(); x++) {
          if (list2.get(idx).getValue().equals(list1.get(x).getValue())) {
            output.add(list2.get(idx));
          }
        }
      }
    }
    return output;
  }
  public Node findMatch(ArrayList<Node> list, String value) {
    for (int idx = 0; idx < list.size(); idx++) {
      if(list.get(idx).getValue().equals(value)) {
        return list.get(idx);
      }
    }
    return null;
  }
  public ArrayList<Node> findPaths(String val1, String val2) {
    ArrayList<Node> output = new ArrayList<Node>();
    Node start = new Node(val1);
    Node current = new Node();
    if (val1.equals(val2)) {
      output.add(start);
      return output;
    }
    ArrayList<Node> list = oneOff(val1);
    ArrayList<Node> checkList = list;
    System.out.println(list);
    System.out.println(checkList);
    int idx = 0;
    while (findMatch(checkList, val2) == null) {
      checkList = oneOff(list.get(idx).getValue());
      idx++;
//      if (idx == list.size()) {
//        idx = 0;
//        list = oneOff(checkList.get(idx).getValue());
//        checkList = list;
//      }
    }
    current = findMatch(checkList, val2);
    while (current != null) {
      output.add(current);
      current = current.prev();
    }
    return output;
  }
  public static void main(String[]args){
    WordLadder test = new WordLadder();
    Node one = new Node("apple");
    Node two = new Node("zoinks");
    Node three = new Node("3");
    Node four = new Node("4");
    Node five = new Node("2");
    ArrayList<Node> compare = new ArrayList<Node>();
    ArrayList<Node> compare2 = new ArrayList<Node>();
    compare.add(one); compare.add(two); compare.add(three);
    compare2.add(four); compare2.add(five); compare2.add(two); compare2.add(one);
    System.out.println(test.oneOff("apple").toString());
    System.out.println(test.oneOff("hello").toString());
    System.out.println(test.oneOff("xylophone").toString());
    System.out.println(test.oneOff("bad"));
    System.out.println(compare.toString());
    System.out.println(compare2.toString());
    System.out.println(test.findOverlap(compare, compare2).toString());
    System.out.println(test.findOverlap(compare2, compare).toString());
    System.out.println(test.oneOff("pie").toString());
    System.out.println(test.findPaths("pie", "pie"));
    System.out.println(test.findPaths("pie", "die"));
  }
}
