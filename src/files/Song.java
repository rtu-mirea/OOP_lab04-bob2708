package files;

import java.io.Serializable;

public class Song implements Serializable {
    //private static final long serialVersionUID = 1L;
    private String name;
    private int voices;

    Song () {
        this.name = "no_name";
        this.voices = 0;
    }

    Song (String name, int voices) {
        this.name = name;
        this.voices = voices;
    }

    public String getName() {
        //System.out.println(name);
        return name;
    }

    public int getVoices() {
        return voices;
    }
}
