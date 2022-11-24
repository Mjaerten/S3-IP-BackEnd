package dev.EpixInc.Epix.Repository;

import dev.EpixInc.Epix.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
