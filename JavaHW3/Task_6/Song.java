package JavaHW3.Task_6;

import java.util.Comparator;

/**
 * Created by Pavel
 */
public class Song
{
    private String name;
    private String artist;
    private Integer rating;

    public Song(String name, String artist, Integer rating)
    {
        this.name = name;
        this.artist = artist;
        this.rating = rating;
    }

    @Override
    public String toString()
    {
        return "||" + name + "||" + "\t\t" + "||" + artist + "||" + "\t\t" + "||" + rating + "||";
    }

    public String getName()
    {
        return name;
    }

    public String getArtist()
    {
        return artist;
    }

    public Integer getRating()
    {
        return rating;
    }
}
