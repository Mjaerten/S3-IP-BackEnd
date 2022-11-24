package dev.EpixInc.Epix.Repository;

import dev.EpixInc.Epix.Enums.TypeOfItemEnum;
import dev.EpixInc.Epix.Model.Genre;
import dev.EpixInc.Epix.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByTypeOfItemEnum(TypeOfItemEnum typeOfItemEnum);

}
