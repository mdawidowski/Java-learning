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
            text = text.toLowerCase();
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

  public int readparams(){
    File key = new File("parameter.txt");
    String text = new String("");
    int param = 0;
    try {
      RandomAccessFile input = new RandomAccessFile(key, "r");
      try {
          text = input.readLine();
          input.close();
          param = Integer.parseInt(text);
      } catch (IOException e) {
        System.out.println("Error reading file");
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    return param;
  }

  public void write(char[] text){
    File crypto = new File("crypto.txt");
    try {
      Writer writer = new OutputStreamWriter(new FileOutputStream(crypto), "UTF-8");
      BufferedWriter fout = new BufferedWriter(writer);
      fout.write(text);
      fout.close();
    } catch (IOException e) {}
  }

  public void writeparams(String param){
    File key = new File("parameter.txt");
    try {
      Writer writer = new OutputStreamWriter(new FileOutputStream(key), "UTF-8");
      BufferedWriter fout = new BufferedWriter(writer);
      fout.write(param);
      fout.close();
    } catch (IOException e) {}
  }

  private char[] encrypt(char[] source, int offset){
		char[] destination = new char[source.length];
    int temp;
    for (int i = 0; i < source.length; ++i){
			temp = source[i] + offset;
      if(source[i] == 32){
        destination[i] = (char)(32);
      }else if(source[i] == 10){
        destination[i] = (char)(10);
      }else if(temp < 127 && temp > 31){
        destination[i] = (char)(temp);
      }else if (temp > 126){
        destination[i] = (char)(temp - 94);
      }else{
        destination[i] = (char)(temp + 94);
      }
		}
		return destination;
	}

  public static void main(String[] args) {
    Caesar start = new Caesar();
    System.out.println("Caesar Cipher - choose option");
    System.out.println("1. Encrypting text from file");
    System.out.println("2. Encrypting text from keyboard");
    System.out.println("3. Decrypting text from file");
    System.out.println("4. Decrypting text from keyboard");
    System.out.println("5. Change parameters");
    System.out.println("6. Exit");
    Scanner input = new Scanner(System.in);
    Scanner scan = new Scanner(System.in);
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
            char[] textchar = text.toCharArray();
            int key = start.readparams();
            char[] crypted = start.encrypt(textchar, key);
            start.write(crypted);
            System.out.println("Encrypted code has been saved in crypto.txt");
            break;

        case 2:
            text = scan.nextLine();
            text = text.replaceAll("\\d", "");
            text = text.toLowerCase();
            textchar = text.toCharArray();
            key = start.readparams();
            crypted = start.encrypt(textchar, key);
            start.write(crypted);
            System.out.println("Encrypted code has been saved in crypto.txt");
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
            System.out.println("Your current parameter is " + key + ". Changing parameter can cause problems with decrypting previously crypted messages");
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
