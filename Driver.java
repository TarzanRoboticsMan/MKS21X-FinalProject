public class Driver{
  public static void main(String[]args){

    if (args[0].equals("testIsWord")){ //for testing speed of isWord methods
      Dictionary dic = new Dictionary();
      int reps = Integer.parseInt(args[2]);

      if(Integer.parseInt(args[1])==1){
        for(int x=0;x<reps;x++){
          dic.isWord("Swamp");
        }
      }
      if(Integer.parseInt(args[1])==2){
        for(int x=0;x<reps;x++){
          dic.isWord2("Swamp");
        }
      }
    }

    if (args[0].equals("dictMisc")){
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
}
