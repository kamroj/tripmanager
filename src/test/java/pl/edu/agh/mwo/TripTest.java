package pl.edu.agh.mwo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Kamil Rojek
 */
public class TripTest {
    private Trip trip;

    @BeforeMethod
    private void setUp() {
        trip = new Trip("nazwa", "opis");
    }

    @Test
    public void testConstructor() {
        //Assert
        assertEquals("nazwa", trip.getName());
        assertEquals("opis", trip.getDescription());
    }

    @Test
    public void testSetName_whenNameIsSetToKamil_returnKamil(){
        //Act
        trip.setName("Kamil");

        //Assert
        assertEquals(trip.getName(), "Kamil");
    }

    @Test
    public void testSetDescription_whenDescriptionIsSetToDefaultDesc_returnDefaultDesc(){
        //Arrange
        final String desc = "DEFAULT DESC";

        //Act
        trip.setDescription(desc);

        //Assert
        assertEquals(trip.getDescription(), desc);
    }
}