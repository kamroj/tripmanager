package pl.edu.agh.mwo;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Kamil Rojek
 */
public class AlbumTest {

    @Test
    public void testCreationEmptyAlbum_returnAlbum(){
        //Arrange
        Album album = new Album();

        //Act
        List<Photo> photos = album.getPhotos();

        //Assert
        Assert.assertTrue(photos.isEmpty());
    }

    @Test
    public void testAddingPhotosToAlbym_returnPhotos(){
        //Arrange
        Album album = new Album();
        Photo photo = new Photo.Builder().takePhoto();

        //Act
        album.addPhoto(photo);
        List<Photo> photos = album.getPhotos();

        //Assert
        Assert.assertEquals(photos.get(0), photo);
    }
}
