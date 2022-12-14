package dev.EpixInc.Epix.Model;

import javax.persistence.*;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;

    @Column(name = "Genre")
    private String genreName;

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genre) {
        this.genreName = genre;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
