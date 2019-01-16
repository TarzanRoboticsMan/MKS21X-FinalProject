import java.util.ArrayList;

public class Node {
  private String value;
  private String previous; //List of previouses as multiple paths might lead to the same word

  public Node(String value) {
    this.value = value;
    previous = null;
  }
  public Node(String value, Node prev) {
    this.value = value;
    previous = prev;
  }
  public String getValue() {
    return value;
  }
  public String getPrevious() {
    return previous;
  }
  public void setPrevious(String str){
    previous = str;
  }
  public String toString(){
    return value;
  }
}
