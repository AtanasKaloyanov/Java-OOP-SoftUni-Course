package T06SOLID.Lab.p02_OpenClosedPrinciple.p01_FileStream;

public class MusicFile extends File {

    private String artist;
    private String album;

    public MusicFile(String name, int length, int sent, String artist, String album) {
        super(name, length, sent);
        this.artist = artist;
        this.album = album;
    }



}
