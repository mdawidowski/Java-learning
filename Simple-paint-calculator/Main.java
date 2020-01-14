import java.util.Scanner;

public class Main{

  public static void main(String[] args) {
    double houseLength, houseWidth, houseHeight;
    int numberOfWindows;
    int numberOfDoors;
    Scanner in = new Scanner(System.in);

    // get informations about size of building and calculate building surface
    System.out.print("Please enter house length: ");
    houseLength = in.nextDouble();
    System.out.println();
    System.out.print("Please enter house width: ");
    houseWidth = in.nextDouble();
    System.out.println();
    System.out.print("Please enter house height: ");
    houseHeight = in.nextDouble();
    System.out.println();
    double buildingSurface = (houseLength * houseHeight) * 2 + (houseWidth * houseHeight) * 2;

    // get informations about number of doors and their size and calculate doors surface
    System.out.print("Please enter number of doors: ");
    numberOfDoors = in.nextInt();
    System.out.println();
    double doorsSurface = 0, doorWidth, doorHeight;
    for(int i = 0; i < numberOfDoors; i++){
      System.out.print("Please enter width of door number " + (i + 1) + ": ");
      doorWidth = in.nextDouble();
      System.out.println();
      System.out.print("Please enter height of door number " + (i + 1) + ": ");
      doorHeight = in.nextDouble();
      System.out.println();
      doorsSurface += doorWidth * doorHeight;
    }
    // get informations about number of windows and their size and calculate windows surface
    System.out.print("Please enter number of windows: ");
    numberOfWindows = in.nextInt();
    System.out.println();
    double windowsSurface = 0, windowWidth, windowHeight;
    for(int i = 0; i < numberOfWindows; i++){
      System.out.print("Please enter width of windows number " + (i + 1) + ": ");
      windowWidth = in.nextDouble();
      System.out.println();
      System.out.print("Please enter height of window number " + (i + 1) + ": ");
      windowHeight = in.nextDouble();
      System.out.println();
      windowsSurface += windowWidth * windowHeight;
    }

    // calculate surface to paint
    double realPaintingSurface = buildingSurface - doorsSurface - windowsSurface;
    System.out.println("Surface to paint is " + realPaintingSurface);

    // calculate how many litres is needed
    double metersPerLiter;
    System.out.print("Please enter paint performance: ");
    metersPerLiter = in.nextDouble();
    System.out.println();
    double neededPaint = realPaintingSurface / metersPerLiter;
    System.out.println("You will need about " + neededPaint + " litres of paint.");
    // close Scanner
    in.close();
  }
}
