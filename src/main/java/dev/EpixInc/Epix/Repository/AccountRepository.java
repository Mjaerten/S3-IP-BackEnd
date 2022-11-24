package dev.EpixInc.Epix.Repository;

import dev.EpixInc.Epix.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
