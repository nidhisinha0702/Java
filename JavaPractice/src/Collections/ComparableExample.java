package Collections;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableExample {

	public static void main(String[] args) {
		// Comparable example
		ArrayList<Movie> l = new ArrayList<>();
		l.add(new Movie("Star Wars",8.7,1977));
		l.add(new Movie("Empire Strikes Back",8.8,1980));
		l.add(new Movie("Return of the Jedi",8.7,1983));
		
		Collections.sort(l);
		
		System.out.println("Movies after sorting by year:");
		for(Movie m:l) {
			System.out.println(m.getName() + " "+m.getRating()+" "+m.getYear());
		}
	}

}

class Movie implements Comparable<Movie>{
	private String name;
	private double rating;
	private int year;
	
	//Constructor
	public Movie(String name, double rating, int year) {
		this.name = name;
		this.rating = rating;
		this.year = year;
	}
	
	public int compareTo(Movie m) {
		return this.year - m.year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}
