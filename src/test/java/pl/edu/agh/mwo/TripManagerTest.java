package pl.edu.agh.mwo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Kamil Rojek
 */
public class TripManagerTest {
    TripManager tripManager;
    Trip trip;

    @BeforeMethod
    public void setUp() {
        tripManager = new TripManager();
        trip = new Trip("nazwa", "opis");
    }

    @Test
    public void testAdd() throws TripAlreadyExistsException {
        assertEquals(0, tripManager.getTrips().size());
        tripManager.add(trip);
        assertEquals(1, tripManager.getTrips().size());
    }

    @Test(expectedExceptions = TripAlreadyExistsException.class)
    public void testAddTripTwice() throws TripAlreadyExistsException {
        assertEquals(0, tripManager.getTrips().size());
        tripManager.add(trip);
        assertEquals(1, tripManager.getTrips().size());
        tripManager.add(trip);
    }

    @Test
    public void testRemoveTrip() throws Exception {
        tripManager.add(trip);
        assertEquals(1, tripManager.getTrips().size());
        tripManager.remove(trip.getName());
        assertEquals(0, tripManager.getTrips().size());
    }

    @Test
    public void testFindTrip_whenKeyIsPartOfTripName_returnTrip() throws TripAlreadyExistsException {
        //Arrange
        Trip tripPoland = new Trip("Polska", "Polska jest spoko");
        Trip tripJapan = new Trip("Japonia", "Japonia też jest spoko");

        //Act
        tripManager.add(tripPoland);
        tripManager.add(tripJapan);
        Trip result = tripManager.findTrip("Japonia");

        //Assert
        assertEquals(result.getName(), "Japonia");
    }

    @Test
    public void testFindTrip_whenKeyIsPartOfTripDesc_returnTrip() throws TripAlreadyExistsException {
        //Arrange
        Trip tripPoland = new Trip("Polska", "Stolicą Polski jest Warszawa");
        Trip tripJapan = new Trip("Japonia", "Stolicą Japoni jest Tokio");

        //Act
        tripManager.add(tripPoland);
        tripManager.add(tripJapan);
        Trip result = tripManager.findTrip("Tokio");

        //Assert
        assertEquals(result.getName(), "Japonia");
    }

    @Test
    public void testFindTrip_whenKeyIsPartOfPhotoComment_returnTrip() throws TripAlreadyExistsException {
        //Arrange
        Photo firstPhoto = new Photo.Builder().addComment("Zdjęcie nad polskim jeziorem.").takePhoto();
        Photo secondPhoto = new Photo.Builder().addComment("Widoki na mazury.").takePhoto();
        Photo photoFromJapan = new Photo.Builder().addComment("W japoni jest pyszny Ramen.").takePhoto();

        Trip tripPoland = new Trip("Polska", "Stolicą Polski jest Warszawa");
        Trip tripJapan = new Trip("Japonia", "Stolicą Japoni jest Tokio");

        //Act
        tripPoland.addPhotoToTripAlbum(firstPhoto);
        tripPoland.addPhotoToTripAlbum(secondPhoto);
        tripJapan.addPhotoToTripAlbum(photoFromJapan);

        tripManager.add(tripPoland);
        tripManager.add(tripJapan);

        Trip result = tripManager.findTrip("mazury");

        //Assert
        assertEquals(result.getName(), "Polska");
    }

    @Test
    public void testFindTrip_whenKeyCannotBeFound_returnNull() throws TripAlreadyExistsException {
        //Arrange
        Trip tripPoland = new Trip("Polska", "Stolicą Polski jest Warszawa");
        Trip tripJapan = new Trip("Japonia", "Stolicą Japoni jest Tokio");

        //Act
        tripManager.add(tripPoland);
        tripManager.add(tripJapan);

        Trip result = tripManager.findTrip("mazury");

        //Assert
        assertNull(result);
    }

    @Test
    public void testFindTrip_whenKeyIsNull_returnNull() throws TripAlreadyExistsException {
        //Arrange
        Trip tripPoland = new Trip("Polska", "Stolicą Polski jest Warszawa");
        Trip tripJapan = new Trip("Japonia", "Stolicą Japoni jest Tokio");

        //Act
        tripManager.add(tripPoland);
        tripManager.add(tripJapan);

        Trip result = tripManager.findTrip(null);

        //Assert
        assertNull(result);
    }
}