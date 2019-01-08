import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Dictionary{
  private ArrayList<String> wordList = new ArrayList<String>();
  private int[] tableOfContents;

  public Dictionary(){
    try{
      File f = new File("wordList.txt");
      Scanner dict = new Scanner(f);
      while (dict.hasNext()) {
        wordList.add(dict.next().toLowerCase()); //Loops through and adds words from dictionary to an ArrayList
      }
    }catch(FileNotFoundException e){
      System.out.println("File not found: wordList.txt");
      System.exit(1);
    }
    tableOfContents = new int[26]; //Creating a list of the indexes at which the a words start, b words, c words, etx. to quickly access words
    int x = 1;
    tableOfContents[0] = 0;
    for(int idx = 1; idx < wordList.size(); idx++) {
      if(wordList.get(idx).charAt(0) != (wordList.get(idx - 1).charAt(0))){
        tableOfContents[x] = idx + 1;
        x++;
      }
    }
  }
  public boolean isWord(String value){
    value = value.toLowerCase();
    for (int idx = tableOfContents[value.charAt(0) - 97]; idx < tableOfContents[value.charAt(0) - 96]; idx ++) { //Loops through wordList but only between the words that share the same first letter
      if (wordList.get(idx).equals(value)) {
        return true;
      }
    }
    return false;
  }
  public ArrayList<String> retrieve() { //To access wordList while testing
    return wordList;
  }
  public static void main(String args[]) { //Driver for testing code
    Dictionary dic = new Dictionary();
    for (int idx = 0; idx < 20; idx++) {
      System.out.println(dic.retrieve().get(idx));
    }
    boolean check1 = dic.isWord("apple");
    boolean check2 = dic.isWord("APPLE");
    boolean check3 = dic.isWord("deaedfs");
    boolean check4 = dic.isWord("xylophone");
    System.out.println(dic.retrieve().get(3839));
    System.out.println(check1 + "(Should print true)");
    System.out.println(check2 + "(Should print true)");
    System.out.println(check3 + "(Should print false)");
    System.out.println(check4 + "(Should print true)");
    int xprev = 0; //Following code tests out how many words per letter
    for(int x : dic.tableOfContents){
      System.out.print(x-xprev+" ");
      xprev=x;
    }
  }
}
