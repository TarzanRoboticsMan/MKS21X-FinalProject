import java.util.ArrayList;

public class Node {
  private String value;
  private Node previous; 

  public Node(String value) {
    this.value = value;
    previous = null;
  }
  public Node(String value, Node prev) {
    this.value = value;
    previous = prev;
  }
  public Node(){

  }
  public String getValue() {
    return value;
  }
  public Node prev() {
    return previous;
  }
  public void setPrev(Node str){
    previous = str;
  }
  public String toString(){
    return value;
  }
}
