package files;

import java.io.Serializable;

public class Song implements Serializable {
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
        return name;
    }

    public int getVoices() {
        return voices;
    }
}
