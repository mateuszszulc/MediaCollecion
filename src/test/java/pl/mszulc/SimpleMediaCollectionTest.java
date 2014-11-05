package pl.mszulc;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SimpleMediaCollectionTest {

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddMedia() throws Exception {
        MediaCollection mc = new SimpleMediaCollection();
        mc.addMedia(new Media());
    }

    @Test
    public void testRemoveMedia() throws Exception {

    }

    @Test
    public void testRemoveMedia1() throws Exception {

    }
}