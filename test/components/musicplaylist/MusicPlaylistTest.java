package components.musicplaylist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * junit tests for MusicPlaylist secondary methods
 *
 * @author Ayush Saggar
 */
public class MusicPlaylistTest {

    // test contains

    @Test
    public void testContainsTrue() {
        MusicPlaylist p = new MusicPlaylist1L();
        Song s = new Song("Test", "Artist", 180);
        p.addSong(s);
        assertTrue(p.contains(s));
    }

    @Test
    public void testContainsFalse() {
        MusicPlaylist p = new MusicPlaylist1L();
        p.addSong(new Song("Other", "Artist", 180));
        Song s = new Song("Test", "Artist", 180);
        assertFalse(p.contains(s));
    }

    @Test
    public void testContainsEmpty() {
        MusicPlaylist p = new MusicPlaylist1L();
        Song s = new Song("Test", "Artist", 180);
        assertFalse(p.contains(s));
    }

    // test indexOf

    @Test
    public void testIndexOfFound() {
        MusicPlaylist p = new MusicPlaylist1L();
        Song s1 = new Song("A", "X", 100);
        Song s2 = new Song("B", "Y", 200);
        p.addSong(s1);
        p.addSong(s2);
        assertEquals(1, p.indexOf(s2));
    }

    @Test
    public void testIndexOfNotFound() {
        MusicPlaylist p = new MusicPlaylist1L();
        p.addSong(new Song("A", "X", 100));
        Song s = new Song("B", "Y", 200);
        assertEquals(-1, p.indexOf(s));
    }

    // test getTotalDuration

    @Test
    public void testGetTotalDurationEmpty() {
        MusicPlaylist p = new MusicPlaylist1L();
        assertEquals(0, p.getTotalDuration());
    }

    @Test
    public void testGetTotalDurationMultiple() {
        MusicPlaylist p = new MusicPlaylist1L();
        p.addSong(new Song("A", "X", 100));
        p.addSong(new Song("B", "Y", 200));
        p.addSong(new Song("C", "Z", 50));
        assertEquals(350, p.getTotalDuration());
    }

    // test filterByArtist

    @Test
    public void testFilterByArtistFound() {
        MusicPlaylist p = new MusicPlaylist1L();
        p.addSong(new Song("Song1", "Drake", 200));
        p.addSong(new Song("Song2", "Kendrick", 180));
        p.addSong(new Song("Song3", "Drake", 220));
        MusicPlaylist filtered = p.filterByArtist("Drake");
        assertEquals(2, filtered.length());
        // original unchanged
        assertEquals(3, p.length());
    }

    @Test
    public void testFilterByArtistNone() {
        MusicPlaylist p = new MusicPlaylist1L();
        p.addSong(new Song("Song1", "Drake", 200));
        MusicPlaylist filtered = p.filterByArtist("Kendrick");
        assertEquals(0, filtered.length());
    }

    @Test
    public void testFilterByArtistCaseInsensitive() {
        MusicPlaylist p = new MusicPlaylist1L();
        p.addSong(new Song("Song1", "Drake", 200));
        MusicPlaylist filtered = p.filterByArtist("drake");
        assertEquals(1, filtered.length());
    }

    // test removeByArtist

    @Test
    public void testRemoveByArtist() {
        MusicPlaylist p = new MusicPlaylist1L();
        p.addSong(new Song("Song1", "Drake", 200));
        p.addSong(new Song("Song2", "Kendrick", 180));
        p.addSong(new Song("Song3", "Drake", 220));
        p.removeByArtist("Drake");
        assertEquals(1, p.length());
        assertEquals("Kendrick", p.getSongAt(0).artist());
    }

    @Test
    public void testRemoveByArtistNone() {
        MusicPlaylist p = new MusicPlaylist1L();
        p.addSong(new Song("Song1", "Drake", 200));
        p.removeByArtist("Kendrick");
        assertEquals(1, p.length());
    }

    // test moveSong

    @Test
    public void testMoveSongForward() {
        MusicPlaylist p = new MusicPlaylist1L();
        p.addSong(new Song("A", "X", 100));
        p.addSong(new Song("B", "Y", 200));
        p.addSong(new Song("C", "Z", 300));
        p.moveSong(0, 2);
        assertEquals("B", p.getSongAt(0).title());
        assertEquals("A", p.getSongAt(2).title());
    }

    @Test
    public void testMoveSongBackward() {
        MusicPlaylist p = new MusicPlaylist1L();
        p.addSong(new Song("A", "X", 100));
        p.addSong(new Song("B", "Y", 200));
        p.addSong(new Song("C", "Z", 300));
        p.moveSong(2, 0);
        assertEquals("C", p.getSongAt(0).title());
    }

    // test append

    @Test
    public void testAppend() {
        MusicPlaylist p1 = new MusicPlaylist1L();
        MusicPlaylist p2 = new MusicPlaylist1L();
        p1.addSong(new Song("A", "X", 100));
        p2.addSong(new Song("B", "Y", 200));
        p2.addSong(new Song("C", "Z", 300));
        p1.append(p2);
        assertEquals(3, p1.length());
        assertEquals(0, p2.length());
        assertEquals("C", p1.getSongAt(2).title());
    }

    // test equals

    @Test
    public void testEqualsTrue() {
        MusicPlaylist p1 = new MusicPlaylist1L();
        MusicPlaylist p2 = new MusicPlaylist1L();
        p1.addSong(new Song("A", "X", 100));
        p2.addSong(new Song("A", "X", 100));
        assertTrue(p1.equals(p2));
    }

    @Test
    public void testEqualsFalse() {
        MusicPlaylist p1 = new MusicPlaylist1L();
        MusicPlaylist p2 = new MusicPlaylist1L();
        p1.addSong(new Song("A", "X", 100));
        p2.addSong(new Song("B", "Y", 200));
        assertFalse(p1.equals(p2));
    }

    @Test
    public void testEqualsDifferentLength() {
        MusicPlaylist p1 = new MusicPlaylist1L();
        MusicPlaylist p2 = new MusicPlaylist1L();
        p1.addSong(new Song("A", "X", 100));
        assertFalse(p1.equals(p2));
    }

    // test toString

    @Test
    public void testToStringEmpty() {
        MusicPlaylist p = new MusicPlaylist1L();
        assertEquals("<>", p.toString());
    }

    @Test
    public void testToStringOne() {
        MusicPlaylist p = new MusicPlaylist1L();
        p.addSong(new Song("Test", "Artist", 60));
        String result = p.toString();
        assertTrue(result.contains("Test"));
        assertTrue(result.contains("Artist"));
    }

}
