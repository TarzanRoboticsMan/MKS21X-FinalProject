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

  public WordLadder(){}
  public WordLadder(int x){
    dic = new Dictionary(x);
  }


  public ArrayList<Node> oneOff(Node val) {
  //  val = val.toLowerCase();
    ArrayList<Node> output = new ArrayList<Node>();
    for (int x = 0; x < val.getValue().length(); x++) { //Going through all the possibilities one position at a time
      for (int idx = 97; idx < 123; idx++) { //Switching it to every possible letter
        String begin = val.getValue().substring(0, x);
        String end = val.getValue().substring(x + 1, val.getValue().length());
        String val2;
        val2 = begin + (char)idx + end; //Creating new word with changed letter
        if (dic.isWord(val2) && !val2.equals(val.getValue())) {
          Node input = new Node(val2, val);
          output.add(input); //Adding it to our ArrayList of words that are one away if it is a valid word
        }
      }
    }
    return output;
  }
  public Node findOverlap(ArrayList<Node> list1, ArrayList<Node> list2, int list) { //Looping through arraylists to find overlaps which means the ladder would be complete
    if (list1.size() >= list2.size()) { //So that it doesn't matter if you compare the shorter or longer one first
      for (int idx = 0; idx < list1.size(); idx++) {
        for (int x = 0; x < list2.size(); x++) {
          if (list1.get(idx).getValue().equals(list2.get(x).getValue())) { //Compares the value of the nodes not the references
            if (list == 1) return list1.get(idx);
            if (list== 2) return list2.get(x);
          }
        }
      }
    }
    if (list1.size() < list2.size()) {
      for (int idx = 0; idx < list2.size(); idx++) {
        for (int x = 0; x < list1.size(); x++) {
          if (list2.get(idx).getValue().equals(list1.get(x).getValue())) {
            if (list == 1) return list1.get(x);
            if (list == 2) return list2.get(idx);
          }
        }
      }
    }
    return null;
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
    if (val1.equals(val2)) {
      output.add(start);
      return output;
    }
    ArrayList<Node> list = oneOff(start);
    ArrayList<Node> checkList = list;
    int idx = 0;
    while (findMatch(checkList, val2) == null) {
      checkList = oneOff(list.get(idx)); //Loops through each value and checks words that are oneOff, creating a tree essentially
      for (int x = 0; x < checkList.size(); x++) {
        int ogSize = list.size();
        if (!list.contains(checkList.get(x))) {
          list.add(checkList.get(x)); //Creates one large list in order to then check it's oneOff later
        }
        if (list.size() == ogSize) {
          return output;
        }
      }
      idx++;
    }
    Node current = findMatch(checkList, val2);
    while (current != null) {
      output.add(current);
      current = current.prev();
    }
    return output;
  }
  public ArrayList<Node> findPaths2(String val1, String val2) {
    ArrayList<Node> output1 = new ArrayList<Node>();
    ArrayList<Node> output2 = new ArrayList<Node>();
    Node start = new Node(val1);
    Node end = new Node(val2);
    if (val1.equals(val2)) {
      output1.add(start);
       return output1;
    }
    ArrayList<Node> list = oneOff(start);
    ArrayList<Node> list2 = oneOff(end);
    ArrayList<Node> checkList = list;
    ArrayList<Node> checkList2 = list2;
    int idx = 0;
    while (findOverlap(list, list2, 1) == null) {
      checkList = oneOff(list.get(idx)); //Loops through each value and checks words that are oneOff, creating a tree essentially
      for (int x = 0; x < checkList.size(); x++) {
        if (!list.contains(checkList.get(x))) {
          list.add(checkList.get(x)); //Creates one large list in order to then check it's oneOff later
        }
      }
      checkList2 = oneOff(list2.get(idx)); //Loops through each value and checks words that are oneOff, creating a tree essentially
      for (int x = 0; x < checkList2.size(); x++) {
        if (!list2.contains(checkList2.get(x))) {
          list2.add(checkList2.get(x)); //Creates one large list in order to then check it's oneOff later
        }
      }
      idx++;
    }
    Node current = findOverlap(list, list2, 1); //Creating first half of word ladder from tree that came off first word
    while (current != null) {
      output1.add(current);
      current = current.prev();
    }
    Node current2 = findOverlap(list, list2, 2); //Creating first half of word ladder from tree that came off first word
    while (current2 != null) {
      output2.add(current2);
      current2 = current2.prev();
    }
    for (int i = 0; i < output1.size(); i++) {
      output2.add(output1.get(i));
    }
    return output2;
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
    System.out.println(test.oneOff(one).toString());
//    System.out.println(test.oneOff("hello").toString());
//    System.out.println(test.oneOff("xylophone").toString());
//    System.out.println(test.oneOff("bad"));
    System.out.println(compare.toString());
    System.out.println(compare2.toString());
//    System.out.println(test.findOverlap(compare, compare2).toString());
//    System.out.println(test.findOverlap(compare2, compare).toString());
//    System.out.println(test.oneOff("pie").toString());
//    System.out.println(test.findPaths("pie", "pie"));
//    System.out.println(test.findPaths("pie", "die"));
//    System.out.println(test.findPaths("bank", "rink"));
//    System.out.println(test.findPaths("fall", "bull"));
//    System.out.println(test.findPaths("bile", "wink"));
//    System.out.println(test.findPaths("bank", "wink"));
//    System.out.println(test.findPaths("bank", "fail"));
//    System.out.println(test.findPaths("bam", "pie"));
//    System.out.println(test.findPaths("happy", "apple"));
//    System.out.println(test.findPaths("shut", "hook"));
//    System.out.println(test.findPaths("ear", "hut"));
    System.out.println(test.findPaths2("pie", "die"));
    System.out.println(test.findPaths2("bank", "rink"));
    System.out.println(test.findPaths2("fall", "bull"));
    System.out.println(test.findPaths2("bile", "wink"));
  }
}
