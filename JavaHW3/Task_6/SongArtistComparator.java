package JavaHW3.Task_6;

import java.util.Comparator;

/**
 * Created by Pavel
 */
public class SongArtistComparator implements Comparator<Song>
{
    @Override
    public int compare(Song o1, Song o2)
    {
        return o1.getArtist().compareTo(o2.getArtist());
    }
}
