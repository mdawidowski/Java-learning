import java.util.Scanner;
import java.util.ArrayList;

public class Main{
  public static void main(String[] args) {
      ArrayList<String> list = new ArrayList<String>();
      boolean exists = false;
      Scanner in = new Scanner(System.in);
      list.add("bread");
      list.add("cheese");
      list.add("cookies");
      list.add("cucumber");
      list.add("orange");
      System.out.println("List of products:");
      System.out.println(list);
      System.out.print("Enter new product name or quit to exit: ");
      String product = in.next();
      while(product.equalsIgnoreCase("quit") == false){
        for (int i = 0; i < list.size();  i++) {
          if (product.equalsIgnoreCase(list.get(i))) {
            exists = true;
            System.out.println("This product is already on the list!");
          }
        }
        if (exists == false) {
          list.add(product);
        }
        System.out.println(list);
        System.out.println("Enter new product name or quit to exit: ");
        product = in.next();
      }
  }
}
