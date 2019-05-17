package pl.edu.agh.mwo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * @author Kamil Rojek
 */
public class PhotoTest {

    @DataProvider
    public static Object[][] dprov_comments() {
        return new Object[][]{
                {"Comment", "Comment"},
                {"", ""},
                {null, ""},
                {"Comment 123123 asd 123)()(**", "Comment 123123 asd 123)()(**"}
        };
    }

    @Test(dataProvider = "dprov_comments")
    public void testPhotoCreation_withComments_returnPhotoWithComment(String comment, String expectedComment) {
        //Arrange
        Photo photo = new Photo.Builder().addComment(comment).takePhoto();

        //Assert
        assertEquals(photo.getComment(), expectedComment, "Expected: " + expectedComment + " Got: " + photo.getComment());
    }

    @DataProvider
    public static Object[][] dprov_authors() {
        return new Object[][]{
                {"Author", "Author"},
                {"", ""},
                {null, ""},
                {"Author 123123 asd 123)()(**", "Author 123123 asd 123)()(**"}
        };
    }

    @Test(dataProvider = "dprov_comments")
    public void testPhotoCreation_withAuthors_returnPhotoWithComment(String author, String expectedComment) {
        //Arrange
        Photo photo = new Photo.Builder().setAuthor(author).takePhoto();

        //Assert
        assertEquals(photo.getAuthor(), expectedComment, "Expected: " + expectedComment + " Got: " + photo.getComment());
    }

    @Test
    public void testPhotoCreation_withAllParameters_returnPhoto(){
        //Arrange
        Photo photo = new Photo.Builder().addComment("Gonna be 5").setAuthor("Kamil").setCurrentDate().takePhoto();

        //Assert
        assertNotNull(photo.getDate());
        assertNotNull(photo.toString());
        assertNotNull(photo);
    }

}