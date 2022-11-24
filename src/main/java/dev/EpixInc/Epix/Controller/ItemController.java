package dev.EpixInc.Epix.Controller;


import dev.EpixInc.Epix.Enums.TypeOfItemEnum;
import dev.EpixInc.Epix.Model.*;
import dev.EpixInc.Epix.Repository.EpisodeRepository;
import dev.EpixInc.Epix.Repository.GenreRepository;
import dev.EpixInc.Epix.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin("http://localhost:3000")
public class ItemController {

    /*
    GetMapping starts with: /get/       (multiple objects so plural)
    PostMapping starts with: /post/     (One object so singular)
     */

    /*TO DO:
    - get movies AND series with the same genre -> maybe done
    - get a specific season of a series -> Done!
    - get movies and series seperated from each other with the same genre -> done
    - post an item (movie and/or series) -> DONE
     */

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private GenreRepository genreRepository;

    //gets all items
    @GetMapping("/get/items")
    List<Item> getItems(){
        return itemRepository.findAll();
    }

    //gets all movies
    @GetMapping("/get/movies")
    List<Item> getMovies(){
        return itemRepository.findByTypeOfItemEnum(TypeOfItemEnum.MOVIE);
    }

    //gets all series
    @GetMapping("/get/series")
    List<Item> getSeries(){
        return itemRepository.findByTypeOfItemEnum(TypeOfItemEnum.SERIES);
    }

    //gets all episodes of a season of a series
    @GetMapping("/get/series/season/{id}")
    List<Episodes> getSpecificSeason(@PathVariable Integer id) { return episodeRepository.findBySeasonNumber(id); }

    //gets all items with the same genre
    @GetMapping("/get/items/genre/{id}")
    List<Item> getItemsWithGenre(@PathVariable Long id)
    {
        List<Item> itemList = itemRepository.findAll();
        List<Item> itemList1 = sortItemOfGenre(itemList, id);

        return itemList1;
    }

    //gets all movies with same genre
    @GetMapping("/get/movies/genre/{id}")
    List<Item> getMoviesWithGenre(@PathVariable Long id)
    {
        List<Item> itemList = itemRepository.findByTypeOfItemEnum(TypeOfItemEnum.MOVIE);
        List<Item> itemList1 = sortItemOfGenre(itemList, id);

        return itemList1;
    }

    //gets all series with the same genre
    @GetMapping("/get/series/genre/{id}")
    List<Item> getSeriesWithGenre(@PathVariable Long id)
    {
        List<Item> itemList = itemRepository.findByTypeOfItemEnum(TypeOfItemEnum.SERIES);
        List<Item> itemList1 = sortItemOfGenre(itemList, id);

        return itemList1;
    }

    //sorts items to return all items with the given genre
    List<Item> sortItemOfGenre(List<Item> itemList, Long GenreID)
    {
        List<Item> itemList1 = new ArrayList<Item>();

        Genre genre = genreRepository.findById(GenreID)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("id", GenreID, "Cannot find the genre"));

        for (Item item : itemList)
        {
            for (GenreItems genreItems : item.getGenreList())
            {
                if (genreItems.getGenre() == genre)
                {
                    itemList1.add(item);
                }
            }
        }

        return itemList1;
    }

    //posts an item but with 2 mappings. Movies item posts with list of null, series has a list full of episodes.
    //cant posts episodes in the list.
    @PostMapping("/post/series")
    Item postSeries(@RequestBody Item newItem)
    {
        List<Episodes> episodesList = new ArrayList<>();
        List<Episodes> episodesList1 = new ArrayList<>();
        List<SeriesEpisode> seriesEpisodeList1 = new ArrayList<>();
        List<SeriesEpisode> seriesEpisodeList = (List<SeriesEpisode>) newItem.getListOfSeriesEpisode();
        for (SeriesEpisode se : seriesEpisodeList){
            episodesList.add(se.getEpisodes());
        }
        //posts all the episodes of the series to the database
        for (Episodes e : episodesList){
            episodeRepository.save(e);
            SeriesEpisode seriesEpisode = new SeriesEpisode();
            seriesEpisode.setEpisodes(e);
            seriesEpisodeList1.add(seriesEpisode);
        }

        newItem.setListOfSeriesEpisode(seriesEpisodeList1);

        return itemRepository.save(newItem);
    }

    @PostMapping("/post/movie")
    Item postMovie(@RequestBody Item newItem)
    {
        return itemRepository.save(newItem);
    }
}
