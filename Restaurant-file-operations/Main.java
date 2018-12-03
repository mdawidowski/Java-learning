import java.io.*;
import java.util.Scanner;

public class Main{
  public static void main(String[] args) {
    String meal;
    double price;
    File food = new File("food.txt");

    try {
      PrintWriter write = new PrintWriter("output.txt");
      Scanner input = new Scanner(food);
      Scanner ask = new Scanner(System.in);
      while(input.hasNextLine()){
        meal = input.nextLine();
        System.out.println("Enter price for " + meal + ": ");
        price = ask.nextDouble();
        write.println(meal + "\t" + price);

      }
      write.close();
    } catch (Exception e){
        System.out.println("Error was found: " + e.toString());
    }
  }
}
