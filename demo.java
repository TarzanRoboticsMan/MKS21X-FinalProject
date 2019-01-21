import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import java.io.IOException;
import java.awt.Color;
import java.util.ArrayList;

/*  Mr. K's TerminalDemo edited for lanterna 3 by Ethan
*/

public class demo {

	public static void putString(int x, int y, Screen screen, String str) {
    int n = 1;
		for (int i = 0; i < str.length(); ++i) {
      if (i < 75) { //So that words don't get cut off at the end of the screen
        screen.setCharacter(x+i, y, new TextCharacter(str.charAt(i)));
      }
      else {
        screen.setCharacter(x+ (i - 80 * n), y + n, new TextCharacter(str.charAt(i))); //Starts words on next line
      }
		}
	}

	public static void main(String[] args) throws IOException {

		Screen screen = new DefaultTerminalFactory().createScreen();
		screen.startScreen();
    int idx = 1;
    WordLadder test = new WordLadder();
    Dictionary dict = new Dictionary();
    String input = "";
    putString(1, 1, screen, "Please input word two words of the same length separated by a space: ");
    putString(1, 20, screen, "Press enter once finished, press tab to restart.");
		boolean running = true;
		while (running) {

			KeyStroke key = screen.pollInput();
			if (key != null) {
				if      (key.getKeyType() == KeyType.Escape)     running = false; //Allows user to exit
				else if (key.getKeyType() == KeyType.Character) {
          putString(idx, 2, screen, Character.toString(key.getCharacter()));
          idx++;
          input += Character.toString(key.getCharacter()); //Builds String to use for later out of user input
        }
        else if (key.getKeyType() == KeyType.Backspace && input.length()>0) {
          input = input.substring(0, input.length() - 1);
          idx--;
          putString(idx, 2, screen, " ");
        }
        else if (key.getKeyType() == KeyType.Enter && input.length() > 0) {
          screen.clear();
					int countSpaces = 0;
					String word1 = "";
					String word2 = "";
					for (int x = 1; x < input.length(); idx++) {
						if (input.substring(x - 1, x).equals(" ")) {
							word1 = input.substring(0, x);
							word2 = input.substring(x + 1);
							countSpaces ++;
						}
					}
					if (countSpaces != 1) {
						putString(1, 1, screen, "You did not input the correct number of words, please press tab and try again.");
					}
          else if (!dict.isWord(word1)) {
            putString(1, 1, screen, "Your first word is not a valid word, please press tab and try again."); //Ensures user puts in a valid word
          }
					else if (!dict.isWord(word2)) {
            putString(1, 1, screen, "Your second word is not a valid word, please press tab and try again."); //Ensures user puts in a valid word
          }
          else {
            putString(1, 1, screen, test.findPaths(word1, word2).toString().substring(1, test.findPaths(word1, word2).toString().length() - 1));
          }
        }
        else if (key.getKeyType() == KeyType.Tab) { //Allows user to input more words
          screen.clear();
          idx = 1;
          input = "";
          putString(1, 1, screen, "Please input word two words of the same length separated by a space: ");
          putString(1, 20, screen, "Press enter once finished, press tab to restart.");
        }


			}
			screen.doResizeIfNecessary();
			screen.refresh();
		}
		screen.stopScreen();
	}
}
