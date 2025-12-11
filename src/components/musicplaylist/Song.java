package components.musicplaylist;

/**
 * represents a song with title artist and duration
 *
 * @author Ayush Saggar
 */
public final class Song {

    private final String title;
    private final String artist;
    private final int durationSeconds;

    /**
     * creates a new song
     *
     * @param title
     *            song title
     * @param artist
     *            artist name
     * @param durationSeconds
     *            length in seconds
     * @requires title /= null and artist /= null and durationSeconds >= 0
     */
    public Song(String title, String artist, int durationSeconds) {
        assert title != null : "Violation of: title is not null";
        assert artist != null : "Violation of: artist is not null";
        assert durationSeconds >= 0 : "Violation of: durationSeconds >= 0";

        this.title = title;
        this.artist = artist;
        this.durationSeconds = durationSeconds;
    }

    /**
     * @return song title
     */
    public String title() {
        return this.title;
    }

    /**
     * @return artist name
     */
    public String artist() {
        return this.artist;
    }

    /**
     * @return duration in seconds
     */
    public int duration() {
        return this.durationSeconds;
    }

    @Override
    public String toString() {
        int minutes = this.durationSeconds / 60;
        int seconds = this.durationSeconds % 60;
        return String.format("\"%s\" by %s (%d:%02d)", this.title, this.artist,
                minutes, seconds);
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
        final int prime = 31;
        int result = 1;
        result = prime * result + this.title.hashCode();
        result = prime * result + this.artist.hashCode();
        result = prime * result + this.durationSeconds;
        return result;
    }
}
