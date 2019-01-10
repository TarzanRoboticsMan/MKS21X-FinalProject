public class Driver{
  public static void main(String[]args){
    if (args[0].equals("testIsWord")){ //for testing speed of isWord methods
      Dictionary dic = new Dictionary();
      int reps = Integer.parseInt(args[2]);
      if(Integer.parseInt(args[1])==1){ //time java Driver testIsWord 1 10000
        for(int x=0;x<reps;x++){
          dic.isWord("swamp");
        }
      }
      if(Integer.parseInt(args[1])==2){ //time java Driver testIsWord 2 10000
        for(int x=0;x<reps;x++){
          dic.isWord2("swamp");
        }
      }
    }

    if (args[0].equals("dictMisc")){
      Dictionary dic = new Dictionary();
      for (int idx = 0; idx < 20; idx++) {
        System.out.println(dic.retrieve().get(idx));
      }
      if(Integer.parseInt(args[1])==1){
        System.out.println(dic.retrieve().get(3839));
        System.out.println(dic.isWord("apple") + "(Should print true)");
        System.out.println(dic.isWord("APPLE") + "(Should print true)");
        System.out.println(dic.isWord("deaedfs") + "(Should print false)");
        System.out.println(dic.isWord("xylophone") + "(Should print true)");
        int xprev = 0; //Following code tests out how many words per letter
        /*for(int x : dic.tableOfContents){
          System.out.print(x-xprev+" ");
          xprev=x;
        }*/ //This chunk of code must be in dict class
      }
      if(Integer.parseInt(args[1])==2){
        System.out.println(dic.retrieve().get(3839));
        System.out.println(dic.isWord2("apple") + "(Should print true)");
        System.out.println(dic.isWord2("APPLE") + "(Should print true)");
        System.out.println(dic.isWord2("deaedfs") + "(Should print false)");
        System.out.println(dic.isWord2("xylophone") + "(Should print true)");
      }
    }
  }
}
