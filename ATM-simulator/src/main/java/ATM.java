import java.io.*;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) throws IOException {
        File account = new File("src/account_balance.txt");
        Scanner fileReader = new Scanner(account);
        String chosenOption = "";
        int balance = 0, chosenAmount = 0;
        Scanner scanner = new Scanner(System.in);
        while (!chosenOption.equals("4")){
            System.out.println("Welcome in ATM simulator");
            System.out.println("Select an option by pressing the number:");
            System.out.println("1. Check account balance");
            System.out.println("2. Withdraw money");
            System.out.println("3. Deposit money");
            System.out.println("4. Exit");
            chosenOption = scanner.next();

            switch (chosenOption){
                case "1":
                    System.out.println("Your account balance:");
                    if (fileReader.hasNext()){
                        balance = Integer.parseInt(fileReader.next());
                    }
                    System.out.println(balance);
                    break;

                case "2":
                    FileWriter fileWriter = new FileWriter(account);
                    PrintWriter writer = new PrintWriter(fileWriter);
                    System.out.println("Enter amount of money you want to withdraw");
                    chosenAmount = scanner.nextInt();
                    if (fileReader.hasNext()){
                        balance = Integer.parseInt(fileReader.next());
                    }
                    balance -= chosenAmount;
                    writer.println(balance);
                    writer.close();
                    break;

                case "3":
                    FileWriter fileWriter2 = new FileWriter(account);
                    PrintWriter writer2 = new PrintWriter(fileWriter2);
                    System.out.println("Enter amount of money you want to deposit");
                    chosenAmount = scanner.nextInt();
                    if (fileReader.hasNext()){
                        balance = Integer.parseInt(fileReader.next());
                    }
                    balance += chosenAmount;
                    writer2.println(balance);
                    writer2.close();
                    break;

                case "4":
                    break;

                default:
                    System.out.println("You have chosen wrong option!");
                    break;
            }

        }
        fileReader.close();
    }
}