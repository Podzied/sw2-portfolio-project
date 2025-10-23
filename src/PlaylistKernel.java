/**
 * kernel interface for playlist component
 *
 * @author ayush saggar
 */
public interface PlaylistKernel {

    /**
     * adds a song to the playlist
     *
     * @param s
     *            the song to add
     * @updates this
     * @ensures this.length() = #this.length() + 1 and
     *          this.getSongAt(this.length() - 1) = s
     */
    void addSong(Song s);

    /**
     * removes a song from the playlist
     *
     * @param s
     *            the song to remove
     * @updates this
     * @ensures if #this.contains(s) then this.length() = #this.length() - 1 and
     *          this does not contain s, otherwise this = #this
     * @return true if the song was removed, false if it was not found
     */
    boolean removeSong(Song s);

    /**
     * removes all songs from the playlist
     *
     * @updates this
     * @ensures this.length() = 0
     */
    void clear();

    /**
     * reports the number of songs in the playlist
     *
     * @return the number of songs
     * @ensures length = this.length()
     */
    int length();

    /**
     * gets the song at the specified index
     *
     * @param index
     *            the index of the song to retrieve
     * @requires 0 <= index < this.length()
     * @return the song at the specified index
     * @ensures getSongAt = this.getSongAt(index)
     */
    Song getSongAt(int index);

    /**
     * reports whether the playlist contains the specified song
     *
     * @param song
     *            the song to check for
     * @return true if the playlist contains the song, false otherwise
     * @ensures contains = (song is in this)
     */
    boolean contains(Song song);

    /**
     * nested interface for song component
     */
    interface Song {

        /**
         * gets the title of the song
         *
         * @return the song title
         * @ensures getTitle = this.title
         */
        String getTitle();

        /**
         * gets the artist of the song
         *
         * @return the song artist
         * @ensures getArtist = this.artist
         */
        String getArtist();

        /**
         * gets the duration of the song in seconds
         *
         * @return the song duration in seconds
         * @ensures getDuration = this.duration
         */
        int getDuration();

        /**
         * reports whether this song is equal to the given song
         *
         * @param other
         *            the song to compare with
         * @return true if the songs are equal, false otherwise
         * @ensures equals = (this.title.equals(other.title) and
         *          this.artist.equals(other.artist) and this.duration =
         *          other.duration)
         */
        boolean equals(Song other);

        /**
         * returns a string representation of the song
         *
         * @return string representation in format "title by artist"
         * @ensures toString = this.title + " by " + this.artist
         */
        @Override
        String toString();
    }
}
