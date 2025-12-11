import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * proof of concept for music playlist component
 *
 * @author Ayush Saggar
 */
public class MusicPlaylistProof {

    // representation
    private List<Song> songs;
    private String name;

    /**
     * song with title artist and duration
     */
    public static class Song {
        private String title;
        private String artist;
        private int durationSeconds;

        public Song(String title, String artist, int durationSeconds) {
            this.title = title;
            this.artist = artist;
            this.durationSeconds = durationSeconds;
        }

        public String getTitle() {
            return this.title;
        }

        public String getArtist() {
            return this.artist;
        }

        public int getDuration() {
            return this.durationSeconds;
        }

        @Override
        public String toString() {
            int minutes = this.durationSeconds / 60;
            int seconds = this.durationSeconds % 60;
            return String.format("\"%s\" by %s (%d:%02d)", this.title,
                    this.artist, minutes, seconds);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }
            Song other = (Song) obj;
            return this.title.equals(other.title)
                    && this.artist.equals(other.artist)
                    && this.durationSeconds == other.durationSeconds;
        }

        @Override
        public int hashCode() {
            return this.title.hashCode() + this.artist.hashCode()
                    + this.durationSeconds;
        }
    }

    // constructors

    public MusicPlaylistProof() {
        this.songs = new ArrayList<>();
        this.name = "My Playlist";
    }

    public MusicPlaylistProof(String name) {
        this.songs = new ArrayList<>();
        this.name = name;
    }

    // kernel methods

    public void addSong(Song s) {
        this.songs.add(s);
    }

    public Song removeSong(int index) {
        return this.songs.remove(index);
    }

    public int length() {
        return this.songs.size();
    }

    public Song getSongAt(int index) {
        return this.songs.get(index);
    }

    public String getName() {
        return this.name;
    }

    // secondary methods

    public void moveSong(int fromIndex, int toIndex) {
        Song s = this.removeSong(fromIndex);
        if (toIndex > fromIndex) {
            toIndex--;
        }
        List<Song> temp = new ArrayList<>();

        while (this.length() > toIndex) {
            temp.add(0, this.removeSong(this.length() - 1));
        }

        this.addSong(s);

        for (Song song : temp) {
            this.addSong(song);
        }
    }

    public void shuffle() {
        List<Song> temp = new ArrayList<>();
        while (this.length() > 0) {
            temp.add(this.removeSong(0));
        }
        Collections.shuffle(temp);
        for (Song s : temp) {
            this.addSong(s);
        }
    }

    public MusicPlaylistProof filterByArtist(String artist) {
        MusicPlaylistProof filtered = new MusicPlaylistProof(
                this.name + " - " + artist);
        for (int i = 0; i < this.length(); i++) {
            Song s = this.getSongAt(i);
            if (s.getArtist().equalsIgnoreCase(artist)) {
                filtered.addSong(s);
            }
        }
        return filtered;
    }

    public int getTotalDuration() {
        int total = 0;
        for (int i = 0; i < this.length(); i++) {
            total += this.getSongAt(i).getDuration();
        }
        return total;
    }

    public boolean contains(Song s) {
        for (int i = 0; i < this.length(); i++) {
            if (this.getSongAt(i).equals(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Playlist: ").append(this.name).append("\n");
        sb.append("----------------------------------------\n");
        for (int i = 0; i < this.length(); i++) {
            sb.append(String.format("%d. %s%n", i + 1, this.getSongAt(i)));
        }
        int totalMinutes = this.getTotalDuration() / 60;
        int totalSeconds = this.getTotalDuration() % 60;
        sb.append("----------------------------------------\n");
        sb.append(String.format("Total: %d songs, %d:%02d%n", this.length(),
                totalMinutes, totalSeconds));
        return sb.toString();
    }

    // main

    public static void main(String[] args) {
        System.out.println("=== Music Playlist Proof of Concept ===\n");

        MusicPlaylistProof myPlaylist = new MusicPlaylistProof(
                "My Favorite Songs");

        // add some songs
        System.out.println("Adding songs to playlist...\n");
        myPlaylist.addSong(new Song("Blinding Lights", "The Weeknd", 200));
        myPlaylist.addSong(new Song("Shape of You", "Ed Sheeran", 234));
        myPlaylist.addSong(new Song("Starboy", "The Weeknd", 230));
        myPlaylist.addSong(new Song("Perfect", "Ed Sheeran", 263));
        myPlaylist.addSong(new Song("Levitating", "Dua Lipa", 203));
        myPlaylist.addSong(new Song("Save Your Tears", "The Weeknd", 216));

        System.out.println(myPlaylist);

        // kernel method demos
        System.out.println("--- Kernel Method Demos ---\n");

        System.out.println("Number of songs: " + myPlaylist.length());
        System.out.println("Song at index 2: " + myPlaylist.getSongAt(2));

        Song removed = myPlaylist.removeSong(4);
        System.out.println("Removed: " + removed);
        System.out.println("New length: " + myPlaylist.length());

        // secondary method demos
        System.out.println("\n--- Secondary Method Demos ---\n");

        System.out.println("Moving Starboy to top...");
        myPlaylist.moveSong(2, 0);
        System.out.println(myPlaylist);

        System.out.println("Filtering by The Weeknd...");
        MusicPlaylistProof weekndPlaylist = myPlaylist
                .filterByArtist("The Weeknd");
        System.out.println(weekndPlaylist);

        Song searchSong = new Song("Shape of You", "Ed Sheeran", 234);
        System.out.println("Contains Shape of You? "
                + myPlaylist.contains(searchSong));

        Song notInPlaylist = new Song("Hello", "Adele", 295);
        System.out.println(
                "Contains Hello by Adele? " + myPlaylist.contains(notInPlaylist));

        int totalSec = myPlaylist.getTotalDuration();
        System.out.println(String.format("\nTotal duration: %d:%02d",
                totalSec / 60, totalSec % 60));

        System.out.println("\nShuffling...");
        myPlaylist.shuffle();
        System.out.println(myPlaylist);

        System.out.println("=== Done ===");
    }
}
