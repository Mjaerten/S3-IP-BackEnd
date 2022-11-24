package dev.EpixInc.Epix.Model;

import javax.persistence.*;

@Entity
public class Episodes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "EpisodeNumber")
    private Integer episodeNumber;

    @Column(name = "SeasonNumber")
    private Integer seasonNumber;

    @Column(name = "Description")
    private String description;

    @Column(name = "ImageURL")
    private String imageURL;

    @Column(name = "EpisodeURL")
    private String episodeURL;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getEpisodeURL() {
        return episodeURL;
    }

    public void setEpisodeURL(String episodeURL) {
        this.episodeURL = episodeURL;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
}
