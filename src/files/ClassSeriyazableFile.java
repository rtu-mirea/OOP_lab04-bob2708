package files;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ClassSeriyazableFile {
    private String path;
    private List <Song> songList = new LinkedList<>();
    ClassSeriyazableFile (String path) {
        this.path = path;
    }
    public void save (Song song) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(song);
            objectOutputStream.close();
        } catch (IOException ex) {
            System.out.println("error 1");
        }
    }
    public Song load () {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Song song = (Song) objectInputStream.readObject();
            objectInputStream.close();
            return song;
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("error 2");
        }
        return null;
    }
    public void saveList() {
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\vova2\\Desktop\\2 курс\\ООП\\OOP_lab04-bob2708-master\\lastTaskList.txt");
            for (Song song : songList) {
                fileWriter.write(song.getName()+'\n'+song.getVoices()+'\n');
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("error 3");
        }
    }
    public List loadList() {
        try {
            File file = new File("C:\\Users\\vova2\\Desktop\\2 курс\\ООП\\OOP_lab04-bob2708-master\\lastTask.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                Song song = new Song(line,Integer.parseInt(bufferedReader.readLine()));
                songList.add(song);
            }
        } catch (IOException e) {
            System.out.println("error 4");
        }
        return songList;
    }
    public void printList() {
        for (Song song : songList) {
            System.out.println(song.getName() + " " + song.getVoices());
        }
    }
}
