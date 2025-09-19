package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAttendies {

	public static void main(String[] args) {
		//Pair of email and attendance, group them based on required or optional
		List<Pair<String,String>> attendees = List.of(Pair.of("alice@example.com", "require"), Pair.of("bob@example.com", "optional"), Pair.of("carol@example.com", "required"));
		
		HashMap<String, List<String>> grouped = new HashMap<>();
		
		for(Pair<String, String> attendee: attendees) {
			String email = attendee.email;
			String status = attendee.attendance;
			
			grouped.computeIfAbsent(status, i-> new ArrayList<>()).add(email);
		}
		
		System.out.println(grouped);
	}

	static class Pair<K,V>{
		K email;
		V attendance;
		
		Pair(K email, V attendance){
			this.email = email;
			this.attendance = attendance;
		}
		
		static <K,V> Pair<K,V> of(K key, V value){
			return new Pair<>(key, value);
		}
	}
}
