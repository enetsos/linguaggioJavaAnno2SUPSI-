package a2021_2022.test_1.solutions;


import java.util.ArrayList;
import java.util.List;

abstract class Media {
    private final String title;

    public Media(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract void play();
}

abstract class DigitalMedia extends Media {
    final private int numTracks;
    private int currentTrack;

    public DigitalMedia(String title, int numTracks) {
        super(title);
        this.numTracks = numTracks;
    }

    public void play() {
        System.out.println("Playing track " + currentTrack + " of album " + getTitle());
    }

    public void setTrack(int track) {
        currentTrack = track;
    }

    public int getNumTracks() {
        return numTracks;
    }
}

class CD extends DigitalMedia {
    CD(String title, int numTracks) {
        super(title, numTracks);
    }
}

class SuperAudioCD extends DigitalMedia {
    SuperAudioCD(String title, int numTracks) {
        super(title, numTracks);
    }
}

abstract class Vinyl extends Media {
    private enum Side {A, B}

    private final int rpm;
    private Side currentSide = Side.A;

    public Vinyl(String title, int rpm) {
        super(title);
        this.rpm = rpm;
    }

    public void play() {
        System.out.println("Playing side " + currentSide + " of vinyl " + getTitle() + " at " + rpm + " RPM");
    }

    public void flipSide() {
        if (Side.A.equals(currentSide))
            currentSide = Side.B;
        else
            currentSide = Side.A;
    }
}

class Vinyl33 extends Vinyl {
    Vinyl33(String title) {
        super(title, 33);
    }
}

class Vinyl45 extends Vinyl {
    Vinyl45(String title) {
        super(title, 45);
    }
}

abstract class JukeBox {
    public abstract void playAll();
}

class DigitalJukeBox<T extends DigitalMedia> extends JukeBox {
    private final List<T> digitalMedias;

    DigitalJukeBox(List<T> digitalMedias) {
        this.digitalMedias = digitalMedias;
    }

    public void playAll() {
        for (T currentMedia : digitalMedias) {
            final int numTracks = currentMedia.getNumTracks();
            for (int currentTrack = 0; currentTrack < numTracks; currentTrack++) {
                currentMedia.setTrack(currentTrack);
                currentMedia.play();
            }
        }
    }
}

class AnalogJukeBox<T extends Vinyl> extends JukeBox {
    private final List<T> vinyls;

    public AnalogJukeBox(List<T> vinyls) {
        this.vinyls = vinyls;
    }

    public void playAll() {
        for (T currentVinyl : vinyls) {
            currentVinyl.play();
            currentVinyl.flipSide();
            currentVinyl.play();
        }
    }
}

public class JukeBoxExample {
    public static void main(String[] args) {
        List<CD> cds = new ArrayList<>();
        cds.add(new CD("Californication", 15));
        cds.add(new CD("Ten", 11));
        DigitalJukeBox<CD> cdJukeBox = new DigitalJukeBox<>(cds);
        cdJukeBox.playAll();

        List<SuperAudioCD> saCds = new ArrayList<>();
        saCds.add(new SuperAudioCD("Random Access Memory", 13));
        saCds.add(new SuperAudioCD("The Resistance", 11));
        DigitalJukeBox<SuperAudioCD> saCdJukebox = new DigitalJukeBox<>(saCds);
        saCdJukebox.playAll();

        List<Vinyl33> vinyls33 = new ArrayList<>();
        vinyls33.add(new Vinyl33("The Dark Side of the Moon"));
        vinyls33.add(new Vinyl33("Speak and Spell"));
        AnalogJukeBox<Vinyl33> vinyl33Jukebox = new AnalogJukeBox<>(vinyls33);
        vinyl33Jukebox.playAll();

        List<Vinyl45> vinyls45 = new ArrayList<>();
        vinyls45.add(new Vinyl45("La Isla Bonita"));
        vinyls45.add(new Vinyl45("Billie Jean"));
        AnalogJukeBox<Vinyl45> vinyl45Jukebox = new AnalogJukeBox<>(vinyls45);
        vinyl45Jukebox.playAll();
    }
}
