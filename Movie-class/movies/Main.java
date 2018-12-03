package movies;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String title, rating;
    int year, runtime;
    Scanner in = new Scanner(System.in);
    System.out.print("Please enter movie title: ");
    title = in.next();
    System.out.println();
    System.out.print("Please enter movie rating: ");
    rating = in.next();
    System.out.println();
    System.out.print("Please enter movie year of production: ");
    year = in.nextInt();
    System.out.println();
    System.out.print("Please enter movie runtime in minutes: ");
    runtime = in.nextInt();
    System.out.println();
    Movie user_movie = new Movie(title, rating, year, runtime);
    System.out.println(user_movie.makeString());
  }
}
