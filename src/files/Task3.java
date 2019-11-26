package files;

import java.io.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    public static void quest1() {
        try {
            FileReader inputFirstStream = null;
            FileWriter outputSecondStream = null;
            inputFirstStream = new FileReader("T1.txt");
            outputSecondStream = new FileWriter("T2.txt");
            int c;
            while ((c = inputFirstStream.read()) != -1) {
                outputSecondStream.write(c);
            }
            inputFirstStream.close();
            outputSecondStream.close();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
    public static void quest2() {
        try {

            FileWriter outputStream = null;
            outputStream = new FileWriter("A.txt");
            for (int i = 0; i < 512; i++) {
                outputStream.write(55);
            }
            outputStream.close();
            BufferedReader inb = new BufferedReader(new FileReader("A.txt"),128);
            BufferedWriter outb = new BufferedWriter(new FileWriter("B.txt"), 128);
            char [] buf = new char[128];
            int x;
            while ((x = inb.read(buf))!=-1) {
                outb.write(buf);
                outb.write(10);
            }
            inb.close();
            outb.close();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
    public static void quest3() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader
                    (new FileInputStream("AA.txt"), "Cp1251"));
//            BufferedReader in = new BufferedReader(new InputStreamReader
//                    (new FileInputStream("txt.txt"), "UTF-8"));
            System.out.println(Charset.defaultCharset().name());
            String temp;
            while ((temp = in.readLine()) != null) {
                System.out.println(temp);
            }
            in.close();
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
    }

    public static void main (String[]args) {
        Scanner in = new Scanner(System.in);
        System.out.println("0 - Exit\n1 - Task #1\n2 - Task #2\n3 - Task #3");
        while (true) {
            System.out.print("Select option: ");
            int option = in.nextInt();
            switch (option) {
                case 0:
                    return;
                case 1:
                    quest1();
                    break;
                case 2:
                    quest2();
                    break;
                case 3:
                    quest3();
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }
}
