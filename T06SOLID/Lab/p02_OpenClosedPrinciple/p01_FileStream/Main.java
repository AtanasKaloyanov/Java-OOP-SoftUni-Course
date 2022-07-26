package T06SOLID.Lab.p02_OpenClosedPrinciple.p01_FileStream;

public class Main {
    public static void main(String[] args) {

        File music = new MusicFile("Omen", 5, 100, "The Prodigy", "Invaders Must Die");
        Progress musicProgress = new Progress(music);
        System.out.println(musicProgress.getCurrentPercent());

        File movie = new MovieFile("Equilibrium", 1024, 100);
        Progress movieProgress = new Progress(movie);
        System.out.println(movieProgress.getCurrentPercent());

    }
}

