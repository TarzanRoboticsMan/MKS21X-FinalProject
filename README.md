# MKS21X-FinalProject
Final Project Name: WordLadder
Group Name: Socha Word Olympic Team


Coby, 1/4:
  Wrote prototype dictionary and scanner in WordLadder.java to test scanning through words. Spent a bunch of time studying javadocs for scanner and patterns


Izzy, 1/5:
  I wrote the basic code for the Node class in which we will store our words and their previous words to maintain their "path". I also downloaded a word list text file to use as our dictionary. I wrote the constructor for the dictionary class, creating the ArrayList of words based off of code Coby wrote earlier and then wrote the code to develop the table of contents, allowing us to more quickly access words based off of their first letter so we don't have to loop through the entire file everytime.


Izzy, 1/6:
  Didn't do a lot today, mostly tried to figure out how to get lanterna and the TerminalDemo provided in class to work on windows, finally got it to work thanks to Ethan Morgan who helped a lot by providing the other version of lanterna and a rewritten form of TerminalDemo.java. Then just edited Dictionary.java to fix the code that created the table of contents and fixed a typo in wordLadder.


Izzy, 1/7:
  Got a working dictionary class that quickly stores all the words in an ArrayList and then can accurately tell whether or not a word is a real word or not using isWord. I also added a main method for testing to ensure everything works.

Coby, 1/7:
  Figured out how to use scanner (findWithinHorizon) to search through dictionary, began coding driver to compare times with our homebrew word finding algorithm.

Coby, 1/8:
  Determined maximum words for one first letter of the dict. It's 7265, for the letter S. Continued working on driver, using terminal input to test all of our different things we need to test. Began changing oneOff to return nodes instead of strings.

Coby, 1/9
  Finished driver! Determined that the findWithinHorizon driver is significantly faster, by a factor of 2 both for the word "swamp" (near end of largest letter category), and for the word "sswamp" (not in the dictionary).

Coby, 1/10
  Realized how idiotic I am: left a constructor for dict in Dictionary constructor when I made the private dict field for isWord2. Because of this, java always thought I was referencing the local-to-method object and never assigned dict the field, thus my nullPointerException.
  Retested times.
  Our isWord:
  1k - 0.6s   10k - 1.0s   100k - 5.5s  1M - 48.4s
  isWord2:
  1k - 0.6s   10k - 0.6s   100k - 0.6s  1M - 0.7s   
  Further;    10M - 1.4s   100M - 7.4s  1B - 69.4s
