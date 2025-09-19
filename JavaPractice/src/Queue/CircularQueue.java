package Queue;

public class CircularQueue {

	int arr[], currSize, cap;
	int f, r;
	
	CircularQueue(int size){
		cap = size;
		arr = new int[cap];
		currSize = 0;
		f = 0;
		r = -1;
	}
	
	public void push(int data) {
		if(currSize == cap) {
			System.out.println("full");
			return;
		}
		
		r = (r + 1) % cap;
		arr[r] = data;
		currSize++;
	}
	
	public void pop() {
		if(empty()) {
			System.out.println("Empty");
			return;
		}
		f = (f + 1) % cap;
		currSize--;
	}
	
	public int front() {
		if(empty()) {
			System.out.println("Empty");
			return -1;
		}
		return arr[f];
	}
	
	public boolean empty() {
		return currSize == 0;
	}
	
	public void printArr() {
		for(int i=0;i<cap;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		CircularQueue cq = new CircularQueue(3);
		
		cq.push(1);
		cq.push(2);
		cq.push(3);
		
		
		cq.pop();
		cq.push(4);
		
		cq.printArr();
	}

}
