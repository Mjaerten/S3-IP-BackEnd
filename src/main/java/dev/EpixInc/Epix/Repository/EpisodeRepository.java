package dev.EpixInc.Epix.Repository;

import dev.EpixInc.Epix.Model.Episodes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface EpisodeRepository extends JpaRepository<Episodes, Long> {

    List<Episodes> findBySeasonNumber(Integer seasonNumber);
}
