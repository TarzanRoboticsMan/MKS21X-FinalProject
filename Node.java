import java.util.ArrayList;

public class Node {
  private String value;
  private ArrayList<Node> previous; //List of previouses as multiple paths might lead to the same word

  public Node(String value) {
    this.value = value;
  }
  public String getValue() {
    return value;
  }
  public ArrayList<Node> getPrevious() {
    return previous;
  }
  public void setPrevious(Node str){
    previous.add(str);
  }
  public String toString(){
    return value;
  }
}
