package pl.mszulc;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.*;

public class SimpleMediaCollection implements MediaCollection {
    private final Map<Long, Media> mediaStorage = Maps.newHashMap();
    private final List<Media> mediaList = Lists.newArrayList();
    private final Set<Media> mediaSet = Sets.newHashSet();

    @Override
    public void addMedia(Media media) {
        mediaStorage.put(media.getEan(), media);
        mediaSet.add(media);
        mediaList.add(media);
        SortedMap sm;
        SortedSet ss;
        //put, sublist, add, Comparatory.
    }

    @Override
    public void removeMedia(Long ean) {

    }

    @Override
    public void removeMedia(Media media) {

    }

    @Override
    public Collection<Media> getMediaPaged(int pageNumber, int numberOfMediaOnPage) {
        return null;
    }

    @Override
    public Collection<Media> getMediaPagedSortedByTitle(int pageNumber, int numberOfMediaOnPage) {
        return null;
    }

    @Override
    public boolean containsItem(Long ean) {
        return false;
    }
}
