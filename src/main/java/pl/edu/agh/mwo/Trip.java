package pl.edu.agh.mwo;

import java.util.ArrayList;
import java.util.List;

class Trip {
	private String name;
	private String description;
	private List<Photo> tripAlbum;
	
	Trip(String name, String description) {
		this.name = name;
		this.description = description;
		tripAlbum = new ArrayList<>();
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getDescription() {
		return description;
	}

	void setDescription(String description) {
		this.description = description;
	}

	void addPhoto(Photo photo) {
		tripAlbum.add(photo);
	}

	List<Photo> getPhotos() {
		return tripAlbum;
	}
}
