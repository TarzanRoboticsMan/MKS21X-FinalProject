import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Dictionary{
  private ArrayList<String> wordList = new ArrayList<String>();
  private int[] tableOfContents;
  public Scanner dict; //Her name is Scandra

  public Dictionary(){
    try{
      File f = new File("wordList.txt");
      dict = new Scanner(f);
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

  public boolean isWord2(String value){
    return (dict.findWithinHorizon(value,0) != null);
  }
  public ArrayList<String> retrieve() { //To access wordList while testing
    return wordList;
  }
}
