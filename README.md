# MKS21X-FinalProject
Final Project Name: WordLadder
Group Name: Socha Word Olympic Team


Instructions:
  Our project is a word ladder in which you input two words of the same length and a path between the two words is displayed in which one letter of the first word is changed between each step, with each intermediate step being a valid word.
  Instructions for demo:
    Currently for our demo, we have it so that only one word can be inputted and it then displays every valid word that is one letter off.
    - Once you open the terminal, it should say "Please input a word"
    - If you mess up while typing your word, simply hit the tab button to restart
    - Once you finish typing your word, hit enter to see all words that are one letter different
    - Then either hit tab to do it again, or hit escape to exit the program

Coby, 1/4:
  Wrote prototype dictionary and scanner in WordLadder.java to test scanning through words. Spent a bunch of time studying javadocs for scanner and patterns


Izzy, 1/5:
  I wrote the basic code for the Node class in which we will store our words and their previous words to maintain their "path". I also downloaded a word list text file to use as our dictionary. I wrote the constructor for the dictionary class, creating the ArrayList of words based off of code Coby wrote earlier and then wrote the code to develop the table of contents, allowing us to more quickly access words based off of their first letter so we don't have to loop through the entire file every time.


Izzy, 1/6:
  Didn't do a lot today, mostly tried to figure out how to get lanterna and the TerminalDemo provided in class to work on windows, finally got it to work thanks to Ethan Morgan who helped a lot by providing the other version of lanterna and a rewritten form of TerminalDemo.java. Then just edited Dictionary.java to fix the code that created the table of contents and fixed a typo in wordLadder.


Izzy, 1/7:
  Got a working dictionary class that quickly stores all the words in an ArrayList and then can accurately tell whether or not a word is a real word or not using isWord. I also added a main method for testing to ensure everything works.

Coby, 1/7:
  Figured out how to use scanner (findWithinHorizon) to search through dictionary, began coding driver to compare times with our homebrew word finding algorithm.

Coby, 1/8:
Determined maximum words for one first letter of the dict. It's 7265, for the letter S. Continued working on driver, using terminal input to test all of our different things we need to test. Began changing oneOff to return nodes instead of strings.


Izzy, 1/8:
Started writing oneOff, Coby helped find and issue with isWord that was throwing it off and helped fix it so that it works with letters that start with z. Wrote oneOff such that it takes in a String right now rather than a Node, wrote a driver to test oneOff also.


Coby, 1/9
  Finished driver! Determined that the findWithinHorizon driver is significantly faster, by a factor of 2 both for the word "swamp" (near end of largest letter category), and for the word "sswamp" (not in the dictionary).

Izzy, 1/9:
  Wrote oneOff to work with an Array of Nodes rather than just strings, wrote a tooString for Node, ran testing on various isWord functions that Coby was working on.

Coby, 1/10
  Realized how idiotic I am: left a constructor for dict in Dictionary constructor when I made the private dict field for isWord2. Because of this, java always thought I was referencing the local-to-method object and never assigned dict the field, thus my nullPointerException.
  Retested times.
  Our isWord:
  1k - 0.6s   10k - 1.0s   100k - 5.5s  1M - 48.4s
  isWord2:
  1k - 0.6s   10k - 0.6s   100k - 0.6s  1M - 0.7s   
  Further;    10M - 1.4s   100M - 7.4s  1B - 69.4s

Izzy, 1/10:
  Wrote findOverlap for future use and added test cases in the main to make sure it works with Array<Node>.

Izzy, 1/13:
  Created demo.java which uses lanterna to take user inputted words and then display all the words that are one letter off from the one they inputted. Will change to display word path once we finish writing that code, however.

Izzy, 1/14:
  Edited demo.java to display instructions and to give the user the ability to delete letters if they accidentally type a wrong letter rather than having to restart like before. Fixed isWord so that program doesn't throw an error and break when characters that aren't letters are inputted.

Izzy, 1/16:
  Attempted to write code that would find a path between two words but only changing one word rather than both and meeting in the middle by adding a findMatch method. Also changed Node class by adding a constructor in which you can input a previous and changing the previous to a Node.

Izzy, 1/20:
  Almost completed findPath code from one direction, everything works except it doesn't display it correctly because the new previous for each node isn't stored for some reason.

Izzy 1/21:
  I got findPath to work going from one direction by fixing oneOff to not instantiate a new Node each time that has a null previous. I got user input through lanterna working. I realized our dictionary didn't have plural words, found a dictionary that was twice as big to use for our program. I then got our findPaths to work bi-directionally, greatly reducing the time it takes our program to run.
