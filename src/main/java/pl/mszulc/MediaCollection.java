package pl.mszulc;

import java.util.Collection;

public interface MediaCollection {

    /**
     * Dupa
     * @param media description for media
     */
    void addMedia(Media media);
    void removeMedia(Long ean);
    void removeMedia(Media media);

    Collection<Media> getMediaPaged(int pageNumber, int numberOfMediaOnPage);
    Collection<Media> getMediaPagedSortedByTitle(int pageNumber, int numberOfMediaOnPage);

    boolean containsItem(Long ean);


}
