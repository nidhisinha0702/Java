package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorExample {

	public static void main(String[] args) {
		// WAP to demonstrate comparator
		 ArrayList<Movies> m = new ArrayList<>();
	        m.add(new Movies("Force Awakens", 8.3, 2015));
	        m.add(new Movies("Star Wars", 8.7, 1977));
	        m.add(new Movies("Empire Strikes Back", 8.8, 1980));

	        // Sort movies by rating and display all
	        Collections.sort(m, new Rating());
	        System.out.println("Movies sorted by rating:");
	        for (Movies m1 : m) {
	            System.out.println(m1.getR() + " " + m1.getN() + " " + m1.getY());
	        }

	        // Sort movies by name and display all
	        Collections.sort(m, new NameCompare());
	        System.out.println("\nMovies sorted by name:");
	        for (Movies m1 : m) {
	            System.out.println(m1.getN() + " " + m1.getR() + " " + m1.getY());
	        }

	}

}

class Movies{
	private String name;
	private double rating;
	private int year;
	
	//Constructor
	public Movies(String name, double rating, int year) {
		this.name = name;
		this.rating = rating;
		this.year = year;
	}
	
	// Getter methods 
    public String getN() { 
      return name; 
    } 
    public double getR() { 
      return rating; 
    } 
    public int getY() { 
      return year; 
    }    
}

class Rating implements Comparator<Movies>{
	
	//sort rating in descending order
	public int compare(Movies m1, Movies m2) {
		return Double.compare(m2.getR(), m1.getR());
	}
}

class NameCompare implements Comparator<Movies>{
	
	//sort name alphabetically
	public int compare(Movies m1, Movies m2) {
		return m1.getN().compareTo(m2.getN());
	}
}
