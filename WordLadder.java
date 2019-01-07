import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordLadder{
  public static void main(String[]args){
    String filename = "prototypeDict.txt";
    try{
      File f = new File(filename);
      Scanner dict = new Scanner(f);

        //NOW read the file here...

    }catch(FileNotFoundException e){
      System.out.println("File not found: " + filename);
      //e.printStackTrace();
      System.exit(1);
    }
  }
}
