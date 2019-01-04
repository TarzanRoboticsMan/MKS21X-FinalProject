import java.util.ArrayList;

public class Node {
  private String value;
  private ArrayList<Node> previous;

  public Node(String value) {
    this.value = value;
  }
  public String getValue() {
    return value;
  }
  public ArrayList<Node> getPrevious() {
    return previous;
  }
  public void setPrevious(String value){

  }
}
