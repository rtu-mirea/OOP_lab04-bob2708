package files;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    private static List<BankCard> cards = new ArrayList<>();

    public static void input() {
        try {
            String temp = "";
            Scanner in = new Scanner(System.in);
            System.out.print("How many cards do you want to add? - ");
            int cardsCount = 0 + in.nextInt();
            for (; cardsCount > 0; cardsCount--) {
                in.nextLine();
                System.out.print("Your full name: ");
                String fio = "" + in.nextLine();
                System.out.print("Card name: ");
                String name = "" + in.nextLine();
                System.out.print("Card number: ");
                int number = 0 + in.nextInt();
                System.out.print("Card validity: ");
                int validity = 0 + in.nextInt();
                if (validity > 31 || validity < 1) {
                    System.out.println("Wrong date!");
                    return;
                }
                System.out.print("Your code: ");
                int code = 0 + in.nextInt();
                System.out.print("Sum of money: ");
                int sum = 0 + in.nextInt();

                for (BankCard bankCard : cards) {
                    if (bankCard.getNumber() == number) {
                        System.out.println("Cards with same numbers is already exists!");
                        return;
                    }
                }
                temp += name + "/" + number + "/" + validity + "/" + fio + "/" + code + "/" + sum + "\n";
            }
                char[] temp_ch = temp.toCharArray();
                FileOutputStream outStream = new FileOutputStream(inFile());
                for (char ch : temp_ch) {
                    outStream.write(ch);
                }
                outStream.close();
        } catch (IOException ex) {
            ex.getMessage();
        } catch (Exception e) {
            System.out.println("Input Error!");
        }
    }

    public static void output() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Card name: ");
            String target = in.nextLine();
            FileInputStream inputStream = new FileInputStream(inFile());
            String temp = "";
            int c;
            System.out.println("Cards with name " + target + ":");
            while ((c = inputStream.read()) != -1) {
                if (c == '\n') {
                    String[] temp_arr = temp.split("/");
                    if (temp_arr[0].equals(target)) {
                        System.out.printf("number - %s, validity - %s, fio - %s, code - %s, sum - %s\n",
                                temp_arr[1],temp_arr[2], temp_arr[3],temp_arr[4],temp_arr[5]);
                        BankCard bankCard = new BankCard(temp_arr[0], Integer.parseInt(temp_arr[1]), Integer.parseInt(temp_arr[2]),
                                temp_arr[3], Integer.parseInt(temp_arr[4]), Integer.parseInt(temp_arr[5]));
                        cards.add(bankCard);
                    }
                    temp = "";
                } else {
                    temp += (char) c;
                }
            }
            inputStream.close();

        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public static File inFile() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Input file name: ");
            String name = in.nextLine();
            File input = new File(name + ".txt");
            if (input.exists()) {
                System.out.println("File exists");
            }
            if (input.createNewFile()) {
                System.out.println("Success!");
            }
            return input;
        } catch (IOException ex) {
            System.out.print("Wrong name! Don't use these symbols: \\ | / * : < > ? \" ");
        }
        return null;
    }

    public static void randomAccess() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("randAccess.txt", "rw");
            for (BankCard bankCard : cards) {
                String temp = bankCard.getParams();
                randomAccessFile.writeBytes(temp);
            }
            boolean found = true;
            while(true) {
                randomAccessFile.seek(0);
                String temp = "";
                Date date = new Date();
                long length = 0;
                while ((temp = randomAccessFile.readLine()) != null) {
                    if (Integer.parseInt(temp.split("/")[2]) <= date.getDate()) {
                        length = temp.length() + 1;
                        break;
                    }
                }
                if (length == 0) {
                    break;
                }
                byte[] buffer = new byte[4096];
                // the file pointer is set at the end of the target line
                int read = -1;
                while ((read = randomAccessFile.read(buffer)) > -1) {
                    // go back
                    randomAccessFile.seek(randomAccessFile.getFilePointer() - read - length);
                    randomAccessFile.write(buffer, 0, read);
                    // go ahead by length
                    randomAccessFile.seek(randomAccessFile.getFilePointer() + length);
                }
                randomAccessFile.setLength(randomAccessFile.length() - length);
            }
            randomAccessFile.close();

        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public static void main (String[]args) {
            Scanner in = new Scanner(System.in);
            System.out.println("0 - Exit\n1 - Input\n2 - Output\n3 - RandomAccess");
            while (true) {
                System.out.print("Select option: ");
                int option = in.nextInt();
                switch (option) {
                    case 0:
                        return;
                    case 1:
                        input();
                        break;
                    case 2:
                        output();
                        break;
                    case 3:
                        randomAccess();
                        Date date = new Date();
                        System.out.println("today is: " + date.getDate());
                        System.out.println("Done!");
                        break;
                    default:
                        System.out.println("Wrong input!");
                }
            }
        }
}
