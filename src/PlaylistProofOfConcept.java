import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * proof-of-concept for a music playlist component
 *
 * @author Ayush Saggar
 */
public class PlaylistProofOfConcept {

    // song class
    public static class Song {
        private String title;
        private String artist;
        private int duration;

        public Song(String title, String artist, int duration) {
            this.title = title;
            this.artist = artist;
            this.duration = duration;
        }

        public String getTitle() {
            return this.title;
        }

        public String getArtist() {
            return this.artist;
        }

        public int getDuration() {
            return this.duration;
        }

        @Override
        public String toString() {
            return this.title + " by " + this.artist;
        }
    }

    // representation
    private List<Song> songs;
    private String name;

    // constructor
    public PlaylistProofOfConcept(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    // kernel methods

    // adds a song to the playlist
    public void addSong(Song s) {
        this.songs.add(s);
    }

    // removes a song from the playlist
    public boolean removeSong(Song s) {
        return this.songs.remove(s);
    }

    // removes all songs
    public void clear() {
        this.songs.clear();
    }

    // returns number of songs
    public int length() {
        return this.songs.size();
    }

    // gets song at index
    public Song getSongAt(int index) {
        return this.songs.get(index);
    }

    // secondary methods

    // moves a song from one position to another
    public void moveSong(int from, int to) {
        Song song = this.getSongAt(from);
        this.songs.remove(from);
        this.songs.add(to, song);
    }

    // shuffles the playlist
    public void shuffle() {
        Random rand = new Random();
        for (int i = this.length() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Song temp = this.getSongAt(i);
            this.songs.set(i, this.getSongAt(j));
            this.songs.set(j, temp);
        }
    }

    // filters playlist by artist
    public PlaylistProofOfConcept filterByArtist(String artist) {
        PlaylistProofOfConcept filtered = new PlaylistProofOfConcept(
                this.name + " - " + artist);
        for (int i = 0; i < this.length(); i++) {
            Song song = this.getSongAt(i);
            if (song.getArtist().equals(artist)) {
                filtered.addSong(song);
            }
        }
        return filtered;
    }

    // finds songs by title (case-insensitive search)
    public PlaylistProofOfConcept findSongsByTitle(String title) {
        PlaylistProofOfConcept found = new PlaylistProofOfConcept(
                this.name + " - '" + title + "'");
        for (int i = 0; i < this.length(); i++) {
            Song song = this.getSongAt(i);
            if (song.getTitle().toLowerCase().contains(title.toLowerCase())) {
                found.addSong(song);
            }
        }
        return found;
    }

    // gets total duration in seconds
    public int getTotalDuration() {
        int total = 0;
        for (int i = 0; i < this.length(); i++) {
            total += this.getSongAt(i).getDuration();
        }
        return total;
    }

    // checks if playlist contains a specific song
    public boolean contains(Song song) {
        for (int i = 0; i < this.length(); i++) {
            if (this.getSongAt(i).equals(song)) {
                return true;
            }
        }
        return false;
    }

    // reverses the order of songs
    public void reverse() {
        for (int i = 0; i < this.length() / 2; i++) {
            int j = this.length() - 1 - i;
            Song temp = this.getSongAt(i);
            this.songs.set(i, this.getSongAt(j));
            this.songs.set(j, temp);
        }
    }

    // prints the playlist
    public void printPlaylist() {
        System.out.println("\n=== " + this.name + " ===");
        System.out.println("songs: " + this.length());
        for (int i = 0; i < this.length(); i++) {
            System.out.println((i + 1) + ". " + this.getSongAt(i));
        }
        System.out.println();
    }

    // main method
    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("music playlist proof-of-concept");
        System.out.println("=====================================");
        System.out.println("showing what this playlist component can do\n");

        // create a diverse playlist showing real-world usage
        PlaylistProofOfConcept workoutPlaylist = new PlaylistProofOfConcept(
                "workout mix");

        // add various songs showing different artists and genres
        Song song1 = new Song("blinding lights", "the weeknd", 200);
        Song song2 = new Song("starboy", "the weeknd", 230);
        Song song3 = new Song("save your tears", "the weeknd", 215);
        Song song4 = new Song("the hills", "the weeknd", 195);
        Song song5 = new Song("can't feel my face", "the weeknd", 213);
        Song song6 = new Song("die for you", "the weeknd", 260);

        // building the playlist
        System.out.println(">>> building playlist <<<");
        workoutPlaylist.addSong(song1);
        workoutPlaylist.addSong(song2);
        workoutPlaylist.addSong(song3);
        workoutPlaylist.addSong(song4);
        workoutPlaylist.addSong(song5);
        workoutPlaylist.addSong(song6);
        workoutPlaylist.printPlaylist();

        // demonstrate playlist management - reorganizing
        System.out.println(">>> playlist management <<<");
        System.out.println("moving 'save your tears' to the front...");
        workoutPlaylist.moveSong(3, 0);
        workoutPlaylist.printPlaylist();

        // finding specific songs
        System.out.println(">>> finding songs <<<");
        System.out.println("getting all the weeknd songs:");
        PlaylistProofOfConcept weekndSongs = workoutPlaylist
                .filterByArtist("the weeknd");
        weekndSongs.printPlaylist();

        System.out.println("searching for songs with 'feel' in the title:");
        PlaylistProofOfConcept feelSongs = workoutPlaylist
                .findSongsByTitle("feel");
        feelSongs.printPlaylist();

        // checking playlist info
        System.out.println(">>> playlist stats <<<");
        System.out.println("workout playlist info:");
        System.out.println("- total songs: " + workoutPlaylist.length());
        System.out.println("- total duration: "
                + workoutPlaylist.getTotalDuration() + " seconds ("
                + workoutPlaylist.getTotalDuration() / 60 + " minutes)");
        System.out.println("- contains 'blinding lights': "
                + workoutPlaylist.contains(song1));

        // mixing things up
        System.out.println(">>> changing order <<<");
        System.out.println("shuffling the playlist:");
        workoutPlaylist.shuffle();
        workoutPlaylist.printPlaylist();

        System.out.println("reversing for different mood:");
        workoutPlaylist.reverse();
        workoutPlaylist.printPlaylist();

        // removing songs
        System.out.println(">>> removing songs <<<");
        System.out.println("taking out a song that doesn't fit...");
        workoutPlaylist.removeSong(song6);
        workoutPlaylist.printPlaylist();

        // clearing playlists
        System.out.println(">>> clearing playlist <<<");
        System.out.println("emptying the weeknd playlist:");
        weekndSongs.clear();
        System.out.println(
                "weeknd playlist now has " + weekndSongs.length() + " songs");

        System.out.println("\n=====================================");
        System.out.println("done!");
        System.out.println("this playlist component can:");
        System.out.println("- add and remove songs");
        System.out.println("- move songs around");
        System.out.println("- shuffle and reverse");
        System.out.println("- find songs by artist or title");
        System.out.println("- check playlist info");
        System.out.println("basically everything you'd want in a playlist");
        System.out.println("=====================================");
    }
}
