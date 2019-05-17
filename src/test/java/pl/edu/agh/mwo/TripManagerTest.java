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
}