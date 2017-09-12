import java.io.*;
import java.util.*;

public class Caesar {

  public String read(int status){
    String text = new String("");
    String info = new String("");
    String temp = new String("");
    if(status == 1){
      temp = "plain.txt";
    } else {
      temp = "crypto.txt";
    }
    File plain = new File(temp);
    try {
      RandomAccessFile input = new RandomAccessFile(plain, "r");
      StringBuilder sB1 = new StringBuilder(info);
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

  public void write(char[] text, int status){
    String temp = new String("");
    if(status == 1){
      temp = "crypto.txt";
    } else {
      temp = "decrypt.txt";
    }

    File crypto = new File(temp);
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

  private char[] decrypt(char[] source, int offset){
    char[] destination = new char[source.length];
    int temp;
    for (int i = 0; i < source.length; ++i){
      temp = source[i] - offset;
      if(source[i] == 32){
        destination[i] = (char)(32);
      }else if(source[i] == 10){
        destination[i] = (char)(10);
      }else if(temp < 127 && temp > 31){
        destination[i] = (char)(temp);
      }else if (temp > 126){
        destination[i] = (char)(temp + 94);
      }else{
        destination[i] = (char)(temp - 94);
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
    int liczba = 0, status = 0;
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
            status = 1;
            String text = start.read(status);
            char[] textchar = text.toCharArray();
            int key = start.readparams();
            char[] crypted = start.encrypt(textchar, key);
            start.write(crypted, status);
            System.out.println("Encrypted code has been saved in crypto.txt");
            break;

        case 2:
            status = 1;
            text = scan.nextLine();
            text = text.replaceAll("\\d", "");
            text = text.toLowerCase();
            textchar = text.toCharArray();
            key = start.readparams();
            crypted = start.encrypt(textchar, key);
            start.write(crypted, status);
            System.out.println("Encrypted code has been saved in crypto.txt");
            break;

        case 3:
            status = 2;
            text = start.read(status);
            text = text.replaceAll("\\d", "");
            text = text.toLowerCase();
            textchar = text.toCharArray();
            key = start.readparams();
            char[] encrypted = start.decrypt(textchar, key);
            start.write(encrypted, status);
            System.out.println("Decrypted code has been saved in decrypt.txt");
            break;

        case 4:
            status = 2;
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
