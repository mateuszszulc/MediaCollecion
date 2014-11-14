package pl.mszulc;

public class Media /*implements Comparable<Media>*/ {


    //public int compareTo(Media o) {
    //    String oString = o.getTitle();
    //    return title.compareTo(oString);
    //    //return oString.compareTo(title);
    //}

    public enum MediaType {
        CD, DVD
    }

    private Long ean;
    private String title;
    private MediaType mediaType;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getEan() {
        return ean;
    }

    public void setEan(Long ean) {
        this.ean = ean;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;

        Media media = (Media) o;

        if (!ean.equals(media.ean)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ean.hashCode();
    }


}
