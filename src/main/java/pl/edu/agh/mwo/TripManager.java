package pl.edu.agh.mwo;
import java.util.*;

class TripManager {
	private HashMap<String,Trip> tripList;
	
	TripManager() {
		tripList = new HashMap<>();
	}
	
	void add(Trip trip) throws TripAlreadyExistsException {
		if (tripAlreadyExist(trip))
			throw new TripAlreadyExistsException();
		tripList.put(trip.getName(),trip);
	}

	HashMap<String,Trip> getTrips() {
		return tripList;
	}

	Trip findTrip(String keyWord) { //todo dokończyć
		if (keyWord == null || keyWord.isEmpty())
			return null;
	}

	void remove(String name) {
		tripList.remove(name);
	}

	private boolean tripAlreadyExist(Trip trip) {
		return tripList.containsKey(trip.getName());
	}

}
