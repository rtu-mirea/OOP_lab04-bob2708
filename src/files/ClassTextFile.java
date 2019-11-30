package files;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ClassTextFile {
    private String path;

    public ClassTextFile(String path) {
        File file = new File(path);
        if (file.isFile()) {
            this.path = path;
        } else {
            this.path = "";
        }
    }

    public Song read() {
        try {
            if (path != "") {
                File file = new File(path);
                Scanner scanner = new Scanner(file);
                String name = "";
                int voices;
                name = scanner.nextLine();
                voices = scanner.nextInt();
                System.out.print(name + " - ");
                System.out.println(voices);
                Song song = new Song(name,voices);
                scanner.close();
                return song;
            }
            return null;
        } catch (IOException e) {
            System.out.println("error 0");
        }
        return null;
    }

    public static void main(String[] args) {
        ClassTextFile classTextFile = new ClassTextFile("C:\\Users\\vova2\\Desktop\\2 курс\\ООП\\OOP_lab04-bob2708-master\\lastTask.txt");
        ClassSeriyazableFile classSeriyazableFile = new ClassSeriyazableFile("C:\\Users\\vova2\\Desktop\\2 курс\\ООП\\OOP_lab04-bob2708-master\\lastTaskSeri.txt");
        classSeriyazableFile.save(classTextFile.read());
        Song song = classSeriyazableFile.load();
        song.getName();
        classSeriyazableFile.loadList();
        classSeriyazableFile.saveList();
        classSeriyazableFile.printList();
    }
}
