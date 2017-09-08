import java.io.*;
import java.util.*;

public class Caesar {

  public String read(){
    String text = new String("");
    String info = new String("");
    File plain = new File("plain.txt");
    StringBuilder sB1 = new StringBuilder(info);
    try {
      RandomAccessFile input = new RandomAccessFile(plain, "r");
      try {
        while (text != null){
          text = input.readLine();
          if (text != null){
            text = text.replaceAll("\\d", "");
            sB1.append(text);
            sB1.append("\n");
          }
        }
        input.close();
        info = sB1.toString();
      } catch (IOException e) {
        System.out.println("Error reading file");
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    return info;
  }

  public String readparams(){
    File key = new File("parameter.txt");
    String text = new String("");
    try {
      RandomAccessFile input = new RandomAccessFile(key, "r");
      try {
          text = input.readLine();
          input.close();
      } catch (IOException e) {
        System.out.println("Error reading file");
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    return text;
  }

  public void writeparams(String param) {
    File key = new File("parameter.txt");
    try {
      Writer writer = new OutputStreamWriter(new FileOutputStream(key), "UTF-8");
      BufferedWriter fout = new BufferedWriter(writer);
      fout.write(param);
      fout.close();
    } catch (IOException e) {}
  }

  public String crypt(String inputString, String passString) {
    return null;
  }


  public static void main(String[] args) {
    Caesar start = new Caesar();
    System.out.println("Caesar Cipher - choose option");
    System.out.println("1. Crypting text from file");
    System.out.println("2. Crypting text from keyboard");
    System.out.println("3. Decrypting text from file");
    System.out.println("4. Decrypting text from keyboard");
    System.out.println("5. Change parameters");
    System.out.println("6. Exit");
    Scanner input = new Scanner(System.in);
    int liczba = 0;
      try {
        while (liczba <= 0 || liczba > 6) {
          liczba =  input.nextInt();
          if (liczba <= 0 || liczba > 6) {
            System.out.println("Wrong number, select again");
          }
        }
      }
      catch(InputMismatchException e) {
      System.out.println("Wrong sign");
      }
      switch (liczba) {
        case 1:
            String text = start.read();
            String key = start.readparams();
            String crypted = start.crypt(text, key);
            System.out.println(crypted);
            break;

        case 2:
            key = start.readparams();
            break;

        case 3:
            text = start.read();
            key = start.readparams();
            break;

        case 4:
            key = start.readparams();
            break;

        case 5:
            key = start.readparams();
            System.out.println("Your current parameter is " + key);
            System.out.print("Set new parameter: ");
            Scanner param = new Scanner(System.in);
            String parameter = param.nextLine();
            start.writeparams(parameter);
            break;

        case 6:
            System.exit(0);
      }
  }
}
