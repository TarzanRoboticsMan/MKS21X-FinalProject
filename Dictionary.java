import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Dictionary{
  private ArrayList<String> wordList;
  private int[] tableOfContents;

  public Dictionary(){
    try{
      File f = new File("wordlist.txt");
      Scanner dict = new Scanner(f);
      while (dict.hasNext()) {
        wordList.add(dict.next());
      }
    }catch(FileNotFoundException e){
      System.out.println("File not found: wordlist.txt");
      System.exit(1);
    }
    tableOfContents = new int[26]; //Creating a list of the indexes at which the a words start, b words, c words, etx. to quickly access words
    int x = 1;
    tableOfContents[0] = 0;
    for(int idx = 1; idx < wordList.size(); idx++) {
      if(wordList.get(idx).charAt(0) != (wordList.get(idx - 1).charAt(0))){
        tableOfContents[x] = idx;
        x++;
      }
    }
  }
  public boolean isWord(String value){
    value = value.toLowerCase();
    for (int idx = value.charAt(0) - 97; idx < tableOfContents[value.charAt(0) - 96]; idx ++) { //Loops through wordList but only between the words that share the same first letter
      if (wordList.get(idx) == value) {
        return true;
      }
    }
    return false;
  }
}