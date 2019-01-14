import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import java.io.IOException;
import java.awt.Color;

/*  Mr. K's TerminalDemo edited for lanterna 3 by Ethan
*/

public class demo {

	public static void putString(int x, int y, Screen screen, String str) {
		for (int i = 0; i < str.length(); ++i) {
			screen.setCharacter(x+i, y, new TextCharacter(str.charAt(i)));
		}
	}

	public static void main(String[] args) throws IOException {

		int x = 10;
		int y = 10;

		Screen screen = new DefaultTerminalFactory().createScreen();
		screen.startScreen();
    int idx = 20;
    WordLadder test = new WordLadder();
    Dictionary dict = new Dictionary();
    String input = "";
    putString(1, 1, screen, "Please input word: ");
		while (true) {

			KeyStroke key = screen.pollInput();
			if (key != null) {
				screen.setCharacter(x, y, new TextCharacter(' '));
				if      (key.getKeyType() == KeyType.Escape)     break;
				else if (key.getKeyType() == KeyType.Character) {
          putString(idx, 1, screen, Character.toString(key.getCharacter()));
          idx++;
          input += Character.toString(key.getCharacter());
        }
        else if (key.getKeyType() == KeyType.Enter && input.length() > 0) {
          screen.clear();
          if (!dict.isWord(input)) {
            putString(1, 1, screen, "Not a valid word, please press tab and try again.");
          }
          else {
            Node attempt = new Node(input);
          }
        }
        else if (key.getKeyType() == KeyType.Tab) {
          screen.clear();
          idx = 20;
          input = "";
          putString(1, 1, screen, "Please input word: ");
        }


			}
			screen.doResizeIfNecessary();
			screen.refresh();
		}
		screen.stopScreen();
	}
}
