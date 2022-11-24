package dev.EpixInc.Epix.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;

@Embeddable
public class CurrentlyWatching {

    @ManyToOne
    @JoinColumn(name = "movie_ID")
    private Item items;

    @ManyToOne
    @JoinColumn(name = "episode_ID")
    private Episodes episodes;

    @Column(name = "playtime")
    private Time playTime;

    public Item getItems() {
        return items;
    }

    public void setItems(Item items) {
        this.items = items;
    }

    public Episodes getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Episodes episodes) {
        this.episodes = episodes;
    }

    public Time getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Time playTime) {
        this.playTime = playTime;
    }
}
