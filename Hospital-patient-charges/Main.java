import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int new_patient, overnight;
    double totalCharges;

    System.out.println("Welcome in hospital charges calculator");
    do {
      totalCharges = 0;
      System.out.println("Do you stay for the night? 1 for Yes/0 for No");
      overnight = in.nextInt();
      if (overnight == 1) {
        totalCharges += overnightCharges();
      }
      totalCharges += medication();
      totalCharges += labService();

      System.out.println("Your total charges are :" + totalCharges);
      System.out.println("Do you want to calculate charges for another patient? 1 for Yes/0 for No");
      new_patient = in.nextInt();
    } while (new_patient == 1);

  }

  public static double overnightCharges(){
    Scanner in = new Scanner(System.in);
    System.out.println("Please insert overnight charges: ");
    double charges = in.nextDouble();
    return charges;
  }

  public static double medication(){
    Scanner in = new Scanner(System.in);
    System.out.println("Please insert medication charges: ");
    double charges = in.nextDouble();
    return charges;
  }

  public static double labService(){
    Scanner in = new Scanner(System.in);
    System.out.println("Please insert lab service charges: ");
    double charges = in.nextDouble();
    return charges;
  }
}
