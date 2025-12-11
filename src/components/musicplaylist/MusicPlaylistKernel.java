package components.musicplaylist;

import components.standard.Standard;

/**
 * musicplaylist kernel with primary methods
 *
 * @author Ayush Saggar
 *
 * @mathmodel type MusicPlaylistKernel is modeled by string of Song
 * @initially <pre>
 * ():
 *   ensures
 *     this = <>
 * </pre>
 * @iterator <pre>
 * for (Song s : this) yields s
 * </pre>
 */
public interface MusicPlaylistKernel extends Standard<MusicPlaylist>,
        Iterable<Song> {

    /**
     * adds song to end of this
     *
     * @param s
     *            song to add
     * @updates this
     * @requires s /= null
     * @ensures this = #this * <s>
     */
    void addSong(Song s);

    /**
     * removes and returns song at index
     *
     * @param index
     *            position to remove from
     * @return the removed song
     * @updates this
     * @requires 0 <= index < |this|
     * @ensures <pre>
     * removeSong = #this[index] and
     * this = #this[0, index) * #this[index+1, |#this|)
     * </pre>
     */
    Song removeSong(int index);

    /**
     * reports number of songs
     *
     * @return number of songs
     * @ensures length = |this|
     */
    int length();

    /**
     * returns song at index without removing
     *
     * @param index
     *            position of song
     * @return song at index
     * @requires 0 <= index < |this|
     * @ensures getSongAt = this[index]
     */
    Song getSongAt(int index);

}
