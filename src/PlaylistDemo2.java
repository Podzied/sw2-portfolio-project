import components.musicplaylist.MusicPlaylist;
import components.musicplaylist.MusicPlaylist1L;
import components.musicplaylist.Song;

/**
 * demo showing playlist as part of a simple music library organizer
 *
 * @author Ayush Saggar
 */
public final class PlaylistDemo2 {

    private PlaylistDemo2() {
    }

    /**
     * simple music library that holds all songs and can create playlists
     */
    private static class MusicLibrary {
        private MusicPlaylist allSongs;

        MusicLibrary() {
            this.allSongs = new MusicPlaylist1L();
        }

        void addToLibrary(Song s) {
            this.allSongs.addSong(s);
        }

        int totalSongs() {
            return this.allSongs.length();
        }

        // create playlist of songs by one artist
        MusicPlaylist getArtistPlaylist(String artist) {
            return this.allSongs.filterByArtist(artist);
        }

        // get songs longer than given duration
        MusicPlaylist getLongSongs(int minSeconds) {
            MusicPlaylist result = new MusicPlaylist1L();
            for (int i = 0; i < this.allSongs.length(); i++) {
                Song s = this.allSongs.getSongAt(i);
                if (s.duration() >= minSeconds) {
                    result.addSong(new Song(s.title(), s.artist(), s.duration()));
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        // create library and add songs
        MusicLibrary library = new MusicLibrary();

        library.addToLibrary(new Song("Blinding Lights", "The Weeknd", 200));
        library.addToLibrary(new Song("Starboy", "The Weeknd", 230));
        library.addToLibrary(new Song("Save Your Tears", "The Weeknd", 216));
        library.addToLibrary(new Song("Shape of You", "Ed Sheeran", 234));
        library.addToLibrary(new Song("Perfect", "Ed Sheeran", 263));
        library.addToLibrary(new Song("Bad Guy", "Billie Eilish", 194));
        library.addToLibrary(new Song("Bohemian Rhapsody", "Queen", 355));

        System.out.println("Library has " + library.totalSongs() + " songs\n");

        // create artist playlist
        System.out.println("The Weeknd playlist:");
        MusicPlaylist weeknd = library.getArtistPlaylist("The Weeknd");
        for (int i = 0; i < weeknd.length(); i++) {
            System.out.println("  " + weeknd.getSongAt(i));
        }

        // get long songs (4+ minutes)
        System.out.println("\nSongs over 4 minutes:");
        MusicPlaylist longSongs = library.getLongSongs(240);
        for (int i = 0; i < longSongs.length(); i++) {
            System.out.println("  " + longSongs.getSongAt(i));
        }
    }

}
