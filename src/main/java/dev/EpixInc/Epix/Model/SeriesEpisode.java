package dev.EpixInc.Epix.Model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class SeriesEpisode {

    @ManyToOne
    @JoinColumn(name = "EpisodeId")
    private Episodes episodes;

    public Episodes getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Episodes episodes) {
        this.episodes = episodes;
    }
}
