package files;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {
            // Упражнение 1
            File myFile1 = new File("MyFile1.txt");
            myFile1.createNewFile();
            myFile1.deleteOnExit();
            boolean exist1 = myFile1.exists();
            if (exist1) {
                System.out.println("txt-1 exists");
            }

            File myFile2 = new File("D:\\MyFile2.txt");
            myFile2.createNewFile();
            myFile2.deleteOnExit();
            boolean exist2 = myFile2.exists();
            if (exist2) {
                System.out.println("txt-2 exists");
            }

            File myFile3 = new File("D:\\Project\\MyFile3.txt");
            myFile3.createNewFile();
            myFile3.deleteOnExit();
            boolean exist3 = myFile3.exists();
            if (exist3) {
                System.out.println("txt-3 exists");
            }

            File myFile4 = new File("papka\\papka2\\papka3");
            myFile4.mkdirs();
            boolean exist4 = myFile4.exists();
            if (exist4) {
                System.out.println("file-4 exists");
            }

            // Упражнение 2
            if (myFile1.isFile()) {
                System.out.println(myFile1.getName() + " in " + myFile1.getAbsolutePath().substring(0,myFile1.getAbsolutePath().lastIndexOf('\\')));
            }

            if (myFile4.isDirectory()) {
                System.out.println(myFile4.getName());
            }

            if (exist1) {
                System.out.println("txt-1 exists");
            }

            System.out.println(myFile4.getAbsolutePath());
            System.out.println("Размер " + myFile3.getName() + " - " + myFile3.length() + " байт"); // файл

            // Упражнение 3
            File myFile5 = new File("C:\\Users\\Vova\\IdeaProjects\\Lb4\\new_folder");
            myFile5.mkdir();
            myFile5.deleteOnExit();
            System.out.println("Содержимое папки " + myFile5.getParentFile().getName() + ":");
            for (String file: myFile5.getParentFile().list()) {
                System.out.println(file);
            }

            System.out.println("Содержимое папки " + myFile5.getParentFile().getName() + ":");
            int directorys = 0;
            for (File file: myFile5.getParentFile().listFiles()) {
                System.out.println(file.getName());
                if (file.isDirectory()) {directorys++;}
            }

            System.out.println("Количество директорий: " + directorys);

            File myFile7 = new File("C:\\Users\\Vova\\IdeaProjects\\Lb4\\papka\\papka2");
            File myFile8 = new File("C:\\Users\\Vova\\IdeaProjects\\Lb4\\papka");
            myFile4.delete();
            myFile7.delete();
            myFile8.delete();

        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}
