package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class HighestRatings {

	public static void main(String[] args) {
	        List<String> foods = Arrays.asList("Biryani", "Butter Chicken", "Pasta", "Pizza", "Ravioli");
	        List<String> cuisines = Arrays.asList("Indian", "Indian", "Italian", "Italian", "Italian");
	        List<Integer> ratings = Arrays.asList(5, 4, 3, 5, 4);//5543

	        FoodRatings fr = new FoodRatings(foods, cuisines, ratings);

	        System.out.println(fr.highestRatings("Indian")); // Biryani
	        fr.changeRatings("Butter Chicken", 6);
	        System.out.println(fr.highestRatings("Indian")); // Butter Chicken
	        System.out.println(fr.highestRatings("Italian")); // Pizza
	    }

}

class FoodRatings{
	
	List<String> foods;
	List<String> cuisines;
	List<Integer> ratings;
	
	
	FoodRatings(List<String> foods, List<String> cuisines,  List<Integer> ratings){
		this.foods = foods;
		this.cuisines = cuisines;
		this.ratings = ratings;
	
	}
	
	public String highestRatings(String cuisine) {
		int maxRating = -1;
		String bestFood = "";
		
		for(int i=0;i<foods.size();i++) {
			if(cuisines.get(i).equalsIgnoreCase(cuisine)) {
				int rating = ratings.get(i);
				String food = foods.get(i);
				
				if(rating > maxRating || (rating == maxRating && food.compareTo(bestFood) < 0)) {
					maxRating = rating;
					bestFood = food;
				}
			}
		}return bestFood;
		
	}
	
	public void changeRatings(String food, int newRating) {
		
		for(int i=0;i<foods.size();i++) {
			if(foods.get(i).equalsIgnoreCase(food)) {
				ratings.set(i, newRating);
			}
		}
	}
}

class Pair{
	String first;
	String second;
	Pair(String f, String s){
		first = f;
		second = s;
	}
}