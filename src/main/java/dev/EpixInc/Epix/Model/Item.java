package dev.EpixInc.Epix.Model;

import dev.EpixInc.Epix.Enums.TypeOfItemEnum;

import javax.persistence.*;
import java.util.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Item_Enum")
    private TypeOfItemEnum typeOfItemEnum;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "TrailerURL")
    private String trailerURL;

    @Column(name = "ImageURL")
    private String imageURL;

    @Column(name = "MovieURL", nullable = true)
    private String movieURL;

    @Column(name = "PlayImageURL")
    private String PlayImageURL;

    @ElementCollection
    @JoinTable(name = "SeriesEpisode")
    private Collection<SeriesEpisode> listOfSeriesEpisode = new ArrayList<SeriesEpisode>();

    @ElementCollection
    @JoinTable(name = "GenreItems")
    private Collection<GenreItems> genreList = new ArrayList<GenreItems>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeOfItemEnum getTypeOfItemEnum() {
        return typeOfItemEnum;
    }

    public void setTypeOfItemEnum(TypeOfItemEnum typeOfItemEnum) {
        this.typeOfItemEnum = typeOfItemEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrailerURL() {
        return trailerURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getMovieURL() {
        return movieURL;
    }

    public void setMovieURL(String movieURL) {
        this.movieURL = movieURL;
    }

    public Collection<SeriesEpisode> getListOfSeriesEpisode() {
        return listOfSeriesEpisode;
    }

    public void setListOfSeriesEpisode(Collection<SeriesEpisode> listOfSeriesEpisode) {
        this.listOfSeriesEpisode = listOfSeriesEpisode;
    }

    public Collection<GenreItems> getGenreList() {
        return genreList;
    }

    public void setGenreList(Collection<GenreItems> genreList) {
        this.genreList = genreList;
    }

    public String getPlayImageURL() {
        return PlayImageURL;
    }

    public void setPlayImageURL(String playImageURL) {
        PlayImageURL = playImageURL;
    }
}
