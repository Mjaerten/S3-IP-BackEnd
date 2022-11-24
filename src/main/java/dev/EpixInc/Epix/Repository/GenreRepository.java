package dev.EpixInc.Epix.Repository;

import dev.EpixInc.Epix.Model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
