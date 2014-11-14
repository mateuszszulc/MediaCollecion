package pl.mszulc;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class SimpleMediaCollectionTest {

    @Test
    public void testAddMedia() throws Exception {
        MediaCollection mc = new SimpleMediaCollection();

        List<String> titles = Arrays.asList("Esdf","Fdupa","Casdf","Alama","Dsdf","Basf");

        for (int i = 0 ; i < titles.size() ; i++) {
            Media m1 = new Media();
            m1.setEan((long) i);
            m1.setTitle(titles.get(i));
            mc.addMedia(m1);
        }

        //mc.getMediaPaged(1,10);
        mc.getMediaPagedSortedByTitle(1,10);
        mc.addMedia(new Media());
    }
}