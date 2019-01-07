import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int first, second;
        System.out.print("Enter first number ");
        first = in.nextInt();
        System.out.print("Enter first number ");
        second = in.nextInt();
        int result = new Calculate().add(first, second);
        System.out.println("Sum " + first + " and " + second + " is " + result);
    }
}
