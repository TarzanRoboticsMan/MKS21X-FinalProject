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
  Determined maximum words for one first letter of the dict. It's 7265, for the letter S


Izzy, 1/8:
  Started writing oneOff, Coby helped find and issue with isWord that was throwing it off and helped fix it so that it works with letters that start with z. Wrote oneOff such that it takes in a String right now rather than a Node, wrote a driver to test oneOff also.
