package pl.mszulc;
import com.google.common.collect.Maps;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//put, sublist, add, Comparatory.
public class SimpleMediaCollection implements MediaCollection {
    private final Map<Long, Media> mediaStorage = Maps.newHashMap();

    @Override
    public void addMedia(Media media) {
        mediaStorage.put(media.getEan(), media);
    }

    @Override
    public void removeMedia(Long ean) {
        mediaStorage.remove(ean);
    }

    @Override
    public Media getMedia(Long ean) {
        return mediaStorage.get(ean);
    }

    @Override
    public Collection<Media> getMediaPaged(int pageNumber, int itemsOnPage) throws IllegalArgumentException {
        int totalItems =  mediaStorage.size();
        int fromIndex = (pageNumber-1) * itemsOnPage;
        assertPagingParameters(pageNumber, itemsOnPage, fromIndex, totalItems);


        Function<String, String> a = s -> s;
        Function<String, String> b = s -> s;
        Function<String, String> c = a.andThen(b);



        return  mediaStorage.values().stream()
                .skip(fromIndex)
                .limit(itemsOnPage)
                .collect(toList());

    }


    private Function<Stream<Media>, Stream<Media>> identity() {
        return s -> s;
    }

    private Function<Stream<Media>, Stream<Media>> skipLimit(int skip, int limit) {
        return s -> s;
    }

    @Override
    public Collection<Media> getMediaPagedSortedByTitle(int pageNumber, int itemsOnPage) throws IllegalArgumentException {
        int totalItems = mediaStorage.size();
        int fromIndex = (pageNumber-1) * itemsOnPage;
        assertPagingParameters(pageNumber, itemsOnPage, fromIndex, totalItems);

        Comparator<Media> byTitle = (e1, e2) -> e1.getTitle().compareTo(e2.getTitle());
        return mediaStorage.values()
                .stream()
                .sorted(byTitle)
                .skip(fromIndex)
                .limit(itemsOnPage)
                .collect(toList());
    }

    private void commentedStuff() {
        int fromIndex = 0;
        int itemsOnPage = 0;
        Stream sortedStream = sorted();
        List<Media> res1 = sorted().skip(fromIndex).limit(itemsOnPage).collect(toList());
        //List<Media> res2 = sorted().

        Function<Stream<Media>, Stream<Media>> identity = s -> s;
        Function<Stream<Media>, Stream<Media>> skipLimit = s -> s.skip(intProvider()).limit(itemsOnPage);

    }

    private int intProvider() {
        return 0;
    }

    //private Function<Stream<Media>, Stream<Media>> fun1() {
    //
    //}

    private List<Media> ahha(Function<Stream<Media>, Stream<Media>> streamOperation) {
        Stream<Media> s = mediaStorage.values().stream();
        s = streamOperation.apply(s);
        return s.collect(toList());
    }

    private Stream<Media> sorted() {
        Comparator<Media> byTitle = (e1, e2) -> e1.getTitle().compareTo(e2.getTitle());
        return mediaStorage.values().stream().sorted(byTitle);
    }

    private Stream<Media> unsorted() {
        return mediaStorage.values().stream();
    }

    private Stream skipLimitCollect(Stream s, int skip, int limit) {
        return s.skip(skip).limit(limit);
    }

    @Override
    public boolean containsItem(Long ean) {
        return mediaStorage.containsKey(ean);
    }



    private void assertPagingParameters(int pageNumber, int itemsOnPage, int fromIndex, int totalItems) {
        //totalItems = 20,   //2                10  -> from 10 to 19, czyli 10 && x < 20
        //totalItems = 20,   //3                10  -> from 20 to 29, czyli 0,
        //totalItems = 20,   //2                10  -> from
        //totalItems = 20,   //2                10  -> from
        assertBiggerThan(pageNumber, 0, "PageNumber should be bigger than 0");
        assertBiggerThan(itemsOnPage, 0, "ItemsOnPage should be bigger than 0");
        if (fromIndex >= totalItems) throw new IllegalArgumentException("No items...");
    }

    private void assertBiggerThan(int assertedValue, int smallerVal, String msg) {
        if (assertedValue <= smallerVal) throw new IllegalArgumentException(msg);
    }
}
