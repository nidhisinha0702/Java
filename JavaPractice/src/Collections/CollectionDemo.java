package Collections;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Vector;

public class CollectionDemo {

	public static void main(String[] args) {
		// Collection framework
		int arr[] = new int[] {1,2,3,4};
		Vector<Integer> v = new Vector();
		Hashtable<Integer, String> h = new Hashtable();
		ArrayList<Integer> al = new ArrayList<>();
		LinkedList<Integer> ll = new LinkedList<>();
		//adding elements into vector
		v.addElement(1);
		v.addElement(2);
		
		//adding element to hashtable
		h.put(1,  "geeks");
		h.put(2, "4geeks");
		
		System.out.println(arr[0]);
		System.out.println(v.elementAt(0));
		System.out.println(h.get(1));
		
		//adding elements to arraylist and linkedlist
		for(int i=1;i<=5;i++) {
			al.add(i);
			ll.add(i);
		}
		
		System.out.println(al);
		System.out.println(ll);
		
		//remove element at index at 3
		al.remove(3);
		ll.remove(3);
		
		//printing elements one by one
		for(int i =0;i<al.size();i++) {
			System.out.print(al.get(i)+" ");
			System.out.println(ll.get(i)+" ");
		}

	}

}
