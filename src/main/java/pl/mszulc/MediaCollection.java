package pl.mszulc;

import java.util.Collection;

public interface MediaCollection {

    void addMedia(Media media);
    void removeMedia(Long ean);
    Media getMedia(Long ean);

    Collection<Media> getMediaPaged(int pageNumber, int numberOfMediaOnPage);
    Collection<Media> getMediaPagedSortedByTitle(int pageNumber, int numberOfMediaOnPage);

    boolean containsItem(Long ean);
}
